package space.x9x.solutions.desensitization.sdk.context;

import space.x9x.solutions.desensitization.sdk.service.IDesensitizationRuleService;
import space.x9x.solutions.desensitization.sdk.service.OfflineDesensitizationRuleService;

/**
 * @author x9x
 * @since 2024-12-06 16:41
 */
public class DesensitizationContext {

    private static IDesensitizationRuleService ruleService;

    private DesensitizationContext() {
        // private constructor to prevent instantiation
    }

    public static IDesensitizationRuleService getRuleService() {

        if (ruleService == null) {
            ruleService = new OfflineDesensitizationRuleService();
        }
        return ruleService;
    }

    /**
     * 在外部（例如Spring Boot Starter的auto-configuration类中）设置远程规则服务
     */
    public static void setRuleService(IDesensitizationRuleService service) {
        if (service == null) {
            throw new IllegalArgumentException("DesensitizationRuleService cannot be null");
        }
        ruleService = service;
    }
}
