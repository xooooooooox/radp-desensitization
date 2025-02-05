package space.x9x.solutions.desensitization.domain.rule.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author x9x
 * @since 2024-12-10 13:37
 */
@Getter
@AllArgsConstructor
public enum RuleType {

    REGEX("0", RegexRule.class),
    SLIDER("1", SlideRule.class),
    ;

    private final String code;
    private final Class<? extends Rule> ruleClass;

    public boolean contains(String name) {
        for (RuleType ruleType : values()) {
            if (ruleType.name().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
