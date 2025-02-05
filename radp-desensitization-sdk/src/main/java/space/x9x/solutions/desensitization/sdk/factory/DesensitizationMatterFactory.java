package space.x9x.solutions.desensitization.sdk.factory;

import space.x9x.solutions.desensitization.sdk.service.IDesensitizationRuleService;

/**
 * @author x9x
 * @since 2024-12-06 15:53
 */
public interface DesensitizationMatterFactory {

    IDesensitizationRuleService getRuleService(DesensitizationConfig config);
}
