package space.x9x.solutions.desensitization.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * @author x9x
 * @since 2024-12-03 11:01
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DesensitizationRuleRespDTO {

    private String id;
    private String type;
    private String ruleKey;
    private String disable;
    private String replacer;

    private String regex;

    private Integer prefixKeep;
    private Integer suffixKeep;
}
