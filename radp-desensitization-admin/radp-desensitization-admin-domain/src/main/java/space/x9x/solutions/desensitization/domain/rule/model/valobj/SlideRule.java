package space.x9x.solutions.desensitization.domain.rule.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author x9x
 * @since 2024-12-10 13:46
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SlideRule implements Rule {

    private int prefixKeep;
    private int suffixKeep;
    private String replacer;
}
