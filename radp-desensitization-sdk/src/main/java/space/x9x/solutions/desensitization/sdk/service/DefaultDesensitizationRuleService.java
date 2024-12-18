package space.x9x.solutions.desensitization.sdk.service;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import lombok.extern.slf4j.Slf4j;
import retrofit2.Response;
import space.x9x.solutions.desensitization.api.dto.DesensitizationRuleRespDTO;
import space.x9x.solutions.desensitization.sdk.adapter.IDesensitizationApi;
import space.x9x.solutions.desensitization.sdk.adapter.IRuleConvertor;
import space.x9x.solutions.desensitization.sdk.adapter.RetrofitClientProvider;
import space.x9x.solutions.desensitization.sdk.factory.DesensitizationConfig;
import space.x9x.solutions.desensitization.sdk.model.DesensitizationRule;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author x9x
 * @since 2024-12-06 14:00
 */
@Slf4j
public class DefaultDesensitizationRuleService implements IDesensitizationRuleService {

    private String systemId;
    private IDesensitizationApi api;

    private LoadingCache<String, DesensitizationRule> ruleCache;

    public DefaultDesensitizationRuleService() {

    }

    public DefaultDesensitizationRuleService(DesensitizationConfig config) {
        this.systemId = config.getSystemId();
        this.api = RetrofitClientProvider.getInstance(config.getConfigAddress()).create(IDesensitizationApi.class);
        // Simple manual cache with a reasonable expiration policy.
        this.ruleCache = CacheBuilder.newBuilder()
                .refreshAfterWrite(config.getRefreshAfterWrite(), TimeUnit.SECONDS)
                .expireAfterWrite(config.getExpireAfterWrite(), TimeUnit.SECONDS)
                .build(new CacheLoader<String, DesensitizationRule>() {

                    @Override
                    public DesensitizationRule load(String ruleKey) {
                        return loadRuleByRuleKey(ruleKey);
                    }

                    @Override
                    public ListenableFuture<DesensitizationRule> reload(String ruleKey, DesensitizationRule oldValue) throws Exception {
                        log.debug("刷新本地脱敏规则缓存");
                        return MoreExecutors.listeningDecorator(Executors.newSingleThreadExecutor())
                                .submit(() -> loadRuleByRuleKey(ruleKey));
                    }
                });

        // Preload or lazy load: Here we show a lazy approach where loadRules is called explicitly.
    }

    /**
     * Loads all rules from the remote API and returns the one matching the given ruleKey.
     */
    protected DesensitizationRule loadRuleByRuleKey(String ruleKey) {
        log.info("SDK 以[定时获取模式]运行: {} {}", "loadRuleByRuleKey", ruleKey);
        List<DesensitizationRule> allRules;
        try {
            allRules = loadAllRulesFromRemote();
            for (DesensitizationRule rule : allRules) {
                if (ruleKey.equals(rule.getRuleKey())) {
                    return rule;
                }
            }
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            return null;
        }
        return null;
    }

    /**
     * Fetches rules from the external API and caches them locally.
     */
    protected List<DesensitizationRule> loadAllRulesFromRemote() throws IOException {
        log.info("SDK 以[定时获取模式]运行: {}", "loadAllRulesFromRemote");
        Response<List<DesensitizationRuleRespDTO>> response = api.getRules(systemId).execute();
        if (!response.isSuccessful() || response.body() == null) {
            throw new IOException("Failed to load rules: " + response.message());
        }
        return IRuleConvertor.INSTANCE.convert(response.body());
    }

    @Override
    public DesensitizationRule getRuleByRuleKey(String ruleKey) {
        try {
            return ruleCache.get(ruleKey);
        } catch (ExecutionException e) {
            log.error("获取脱敏规则失败: {}", e.getMessage(), e);
            return null;
        }
    }

    /**
     * force refresh if needed
     *
     * @param id ruleId
     */
    public void refreshRule(String id) {
        ruleCache.refresh(id);
    }
}
