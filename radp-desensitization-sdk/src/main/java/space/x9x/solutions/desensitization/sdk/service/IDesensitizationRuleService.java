package space.x9x.solutions.desensitization.sdk.service;

import space.x9x.solutions.desensitization.sdk.model.DesensitizationRule;

/**
 * @author x9x
 * @since 2024-12-06 17:00
 */
public interface IDesensitizationRuleService {

    DesensitizationRule getRuleByRuleKey(String ruleKey);
}
