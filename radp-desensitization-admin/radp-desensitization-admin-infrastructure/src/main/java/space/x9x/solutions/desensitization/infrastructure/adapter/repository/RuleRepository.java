package space.x9x.solutions.desensitization.infrastructure.adapter.repository;

import space.x9x.radp.commons.json.JacksonUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import space.x9x.solutions.desensitization.domain.rule.adapter.repository.IRuleRepository;
import space.x9x.solutions.desensitization.domain.rule.model.aggregate.DesensitizationRuleAggregate;
import space.x9x.solutions.desensitization.domain.rule.model.valobj.RegexRule;
import space.x9x.solutions.desensitization.domain.rule.model.valobj.Rule;
import space.x9x.solutions.desensitization.domain.rule.model.valobj.RuleType;
import space.x9x.solutions.desensitization.domain.rule.model.valobj.SlideRule;
import space.x9x.solutions.desensitization.infrastructure.dao.mysql.IRuleConfigMapper;
import space.x9x.solutions.desensitization.infrastructure.dao.po.DesensitizationRuleConfigPO;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author x9x
 * @since 2024-12-03 17:16
 */
@RequiredArgsConstructor
@Repository
public class RuleRepository implements IRuleRepository {

    private final IRuleConfigMapper ruleConfigMapper;

    @Override
    public List<DesensitizationRuleAggregate> queryRules(String systemId) {
        List<DesensitizationRuleConfigPO> poList = ruleConfigMapper.selectListBySystemId(systemId);

        // poList -> aggregateList
        return poList.stream()
                .map(po -> DesensitizationRuleAggregate.builder()
                        .systemId(po.getSystemId())
                        .ruleId(po.getRuleId())
                        .ruleKey(po.getRuleKey())
                        .ruleType(RuleType.valueOf(po.getRuleType()))
                        .ruleDesc(po.getRuleDesc())
                        .rule(buildRuleData(po.getRuleType(), po.getRuleValue())) // 根据 ruleType, 构建对应的脱敏规则数据
                        .disable(po.getDisable())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public DesensitizationRuleAggregate queryRule(String systemId, String ruleKey) {
        DesensitizationRuleConfigPO po = ruleConfigMapper.selectBySystemIdAndRuleKey(systemId, ruleKey);

        // po -> aggregate
        return DesensitizationRuleAggregate.builder()
                .systemId(po.getSystemId())
                .ruleId(po.getRuleId())
                .ruleKey(po.getRuleKey())
                .ruleType(RuleType.valueOf(po.getRuleType()))
                .ruleDesc(po.getRuleDesc())
                .rule(buildRuleData(po.getRuleType(), po.getRuleValue()))
                .disable(po.getDisable())
                .build();
    }


    private Rule buildRuleData(RuleType ruleType, String ruleValue) {
        Rule rule;
        switch (ruleType) {
            case SLIDER:
                rule = JacksonUtils.parseObject(ruleValue, SlideRule.class);
                break;
            case REGEX:
                rule = JacksonUtils.parseObject(ruleValue, RegexRule.class);
                break;
            default:
                throw new IllegalArgumentException("Unsupported ruleType: " + ruleType.getCode());
        }
        return rule;
    }

    private Rule buildRuleData(String ruleType, String ruleValue) {
        return buildRuleData(RuleType.valueOf(ruleType), ruleValue);
    }
}
