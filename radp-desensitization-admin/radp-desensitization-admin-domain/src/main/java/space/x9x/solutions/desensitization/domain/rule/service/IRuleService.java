package space.x9x.solutions.desensitization.domain.rule.service;

import space.x9x.solutions.desensitization.domain.rule.model.aggregate.DesensitizationRuleAggregate;

import java.util.List;

/**
 * @author x9x
 * @since 2024-12-03 15:36
 */
public interface IRuleService {

    List<DesensitizationRuleAggregate> queryRules(String systemId);

    DesensitizationRuleAggregate queryRule(String systemId, String ruleKey);

    void addRule(DesensitizationRuleAggregate ruleAggregate);
}
