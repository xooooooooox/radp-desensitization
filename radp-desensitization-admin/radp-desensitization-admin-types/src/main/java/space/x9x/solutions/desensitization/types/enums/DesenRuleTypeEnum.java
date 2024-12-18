package space.x9x.solutions.desensitization.types.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author x9x
 * @since 2024-12-03 11:06
 */
@AllArgsConstructor
@Getter
public enum DesenRuleTypeEnum {

    REGEX("0", "正则脱敏"),
    SLIDER("1", "滑块脱敏"),

    ;
    private final String code;
    private final String desc;
}
