package space.x9x.solutions.desensitization.sdk.service;

import lombok.extern.slf4j.Slf4j;
import space.x9x.solutions.desensitization.sdk.model.DesensitizationRule;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * @author x9x
 * @since 2024-12-06 16:28
 */
@Slf4j
public class OfflineDesensitizationRuleService extends DefaultDesensitizationRuleService {

    public OfflineDesensitizationRuleService() {
        super();
    }

    @Override
    protected DesensitizationRule loadRuleByRuleKey(String ruleKey) {
        log.info("SDK 以[离线模式]运行: {} {}", "loadRuleByRuleKey", ruleKey);
        return null;
    }

    @Override
    protected List<DesensitizationRule> loadAllRulesFromRemote() throws IOException {
        log.info("SDK 以[离线模式]运行: {}", "loadAllRulesFromRemote");
        return Collections.emptyList();
    }
}
