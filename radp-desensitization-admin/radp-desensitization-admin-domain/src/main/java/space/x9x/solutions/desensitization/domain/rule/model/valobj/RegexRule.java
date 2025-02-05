package space.x9x.solutions.desensitization.domain.rule.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author x9x
 * @since 2024-12-10 13:51
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RegexRule implements Rule {

    private String regex;
    private String replacer;
}
