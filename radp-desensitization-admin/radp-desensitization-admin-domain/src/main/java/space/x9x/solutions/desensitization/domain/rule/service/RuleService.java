package space.x9x.solutions.desensitization.domain.rule.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import space.x9x.solutions.desensitization.domain.rule.adapter.repository.IRuleRepository;
import space.x9x.solutions.desensitization.domain.rule.model.aggregate.DesensitizationRuleAggregate;

import java.util.List;

/**
 * @author x9x
 * @since 2024-12-03 17:15
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class RuleService implements IRuleService{

    private final IRuleRepository ruleRepository;


    @Override
    public List<DesensitizationRuleAggregate> queryRules(String systemId) {
        return ruleRepository.queryRules(systemId);
    }

    @Override
    public DesensitizationRuleAggregate queryRule(String systemId, String ruleKey) {
        return ruleRepository.queryRule(systemId, ruleKey);
    }

    @Override
    public void addRule(DesensitizationRuleAggregate ruleAggregate) {

    }
}
