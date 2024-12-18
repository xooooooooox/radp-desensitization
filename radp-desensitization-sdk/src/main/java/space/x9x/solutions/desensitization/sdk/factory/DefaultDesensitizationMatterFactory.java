package space.x9x.solutions.desensitization.sdk.factory;

import space.x9x.solutions.desensitization.sdk.service.DefaultDesensitizationRuleService;
import space.x9x.solutions.desensitization.sdk.service.IDesensitizationRuleService;

/**
 * @author x9x
 * @since 2024-12-06 16:06
 */
public class DefaultDesensitizationMatterFactory implements DesensitizationMatterFactory {

    @Override
    public IDesensitizationRuleService getRuleService(DesensitizationConfig config) {
        return new DefaultDesensitizationRuleService(config);
    }
}
