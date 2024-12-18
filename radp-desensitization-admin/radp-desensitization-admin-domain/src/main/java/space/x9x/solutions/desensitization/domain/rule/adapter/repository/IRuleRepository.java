package space.x9x.solutions.desensitization.domain.rule.adapter.repository;

import space.x9x.solutions.desensitization.domain.rule.model.aggregate.DesensitizationRuleAggregate;

import java.util.List;

/**
 * @author x9x
 * @since 2024-12-03 15:37
 */
public interface IRuleRepository {

    List<DesensitizationRuleAggregate> queryRules(String systemId);

    DesensitizationRuleAggregate queryRule(String systemId, String ruleKey);
}
