package space.x9x.solutions.desensitization.sdk.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author x9x
 * @since 2024-12-06 10:02
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class DesensitizationRule {

    private String id;
    private String type;
    private String ruleKey;
    private String disable;
    private String replacer;

    private String regex;

    private Integer prefixKeep;
    private Integer suffixKeep;
}
