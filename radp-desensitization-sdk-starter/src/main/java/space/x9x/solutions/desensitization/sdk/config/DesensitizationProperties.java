package space.x9x.solutions.desensitization.sdk.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import space.x9x.solutions.desensitization.sdk.factory.DesensitizationConfig;

/**
 * @author x9x
 * @since 2024-12-06 21:31
 */
@ConfigurationProperties(prefix = DesensitizationProperties.PREFIX, ignoreInvalidFields = true)
@Data
public class DesensitizationProperties {

    public static final String PREFIX = "radp.desensitization";

    /**
     * 是否启用自动拉取远程脱敏规则
     */
    private RunMode mode = RunMode.OFFLINE;

    @NestedConfigurationProperty
    private DesensitizationConfig config = new DesensitizationConfig();

    @Getter
    @AllArgsConstructor
    public enum RunMode {
        OFFLINE,
        FETCH;
    }
}
