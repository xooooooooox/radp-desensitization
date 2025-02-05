package space.x9x.solutions.desensitization.domain.rule.model.aggregate;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import space.x9x.solutions.desensitization.domain.rule.model.valobj.Rule;
import space.x9x.solutions.desensitization.domain.rule.model.valobj.RuleType;
import space.x9x.solutions.desensitization.domain.rule.model.valobj.SlideRule;

/**
 * @author x9x
 * @since 2024-12-10 13:37
 */
@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class DesensitizationRuleAggregate {

    private final String ruleId;
    private final String systemId;
    private final RuleType ruleType;
    private final String ruleKey;
    private final String ruleDesc;
    private final Rule rule;
    private final String disable;

    public <T extends Rule> T getRule(Class<T> ruleClazz) {
        if (ruleClazz.isInstance(rule)) {
            return ruleClazz.cast(rule);
        }
        throw new IllegalStateException(String.format("Current Rule is of type %s, cannot cast to %s", rule.getClass().getSimpleName(), ruleClazz.getSimpleName()));
    }

    @SuppressWarnings("unchecked")
    public <T extends Rule> T getRule() {
        Class<? extends Rule> expectedClazz = ruleType.getRuleClass();
        if (expectedClazz.isInstance(rule)) {
            return (T) rule;
        }
        throw new IllegalStateException(String.format("Current Rule is of type %s, cannot cast to %s", rule.getClass().getSimpleName(), expectedClazz.getSimpleName()));
    }
}
