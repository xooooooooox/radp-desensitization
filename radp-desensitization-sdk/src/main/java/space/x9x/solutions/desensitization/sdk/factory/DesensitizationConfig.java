package space.x9x.solutions.desensitization.sdk.factory;

import lombok.Data;

import java.util.concurrent.TimeUnit;

/**
 * @author x9x
 * @since 2024-12-06 21:31
 */
@Data
public class DesensitizationConfig {

    /**
     * 系统编号
     */
    private String systemId;

    /**
     * 脱敏规则配置中心API baseurl
     */
    private String configAddress = "http://localhost:8888";

    /**
     * 本地缓存刷新时间(多久去远程拉取最新规则), 单位: 秒
     */
    private long refreshAfterWrite = TimeUnit.MINUTES.toSeconds(60);

    /**
     * 本地缓存过期时间, 单位: 秒
     */
    private long expireAfterWrite = TimeUnit.HOURS.toSeconds(24);
}
