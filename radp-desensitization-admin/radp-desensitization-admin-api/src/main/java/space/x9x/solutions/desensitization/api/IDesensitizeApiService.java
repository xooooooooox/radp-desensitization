package space.x9x.solutions.desensitization.api;

import space.x9x.solutions.desensitization.api.dto.DesensitizationRuleRespDTO;

import java.util.List;

/**
 * @author x9x
 * @since 2024-12-03 14:06
 */
public interface IDesensitizeApiService {

    DesensitizationRuleRespDTO getRule(String systemId, String ruleKey);

    List<DesensitizationRuleRespDTO> getRules(String systemId);
}
