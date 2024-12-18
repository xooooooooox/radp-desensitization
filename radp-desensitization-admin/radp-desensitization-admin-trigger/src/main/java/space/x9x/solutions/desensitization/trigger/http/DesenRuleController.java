package space.x9x.solutions.desensitization.trigger.http;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import space.x9x.solutions.desensitization.api.IDesensitizeApiService;
import space.x9x.solutions.desensitization.api.dto.DesensitizationRuleRespDTO;
import space.x9x.solutions.desensitization.domain.rule.model.aggregate.DesensitizationRuleAggregate;
import space.x9x.solutions.desensitization.domain.rule.service.IRuleService;
import space.x9x.solutions.desensitization.trigger.http.convertor.IRuleEntityConvertor;

import java.util.List;

/**
 * @author x9x
 * @since 2024-12-03 14:08
 */
@Slf4j
@RestController
@RequestMapping("/api/desensitization")
@RequiredArgsConstructor
public class DesenRuleController implements IDesensitizeApiService {

    private final IRuleService ruleService;
    private final IRuleEntityConvertor convertor;

    @GetMapping("/rule")
    @Override
    public DesensitizationRuleRespDTO getRule(@RequestParam("system_id") String systemId, @RequestParam("rule_key") String ruleKey) {

        DesensitizationRuleAggregate ruleAggregate = ruleService.queryRule(systemId, ruleKey);
        return convertor.sourceToTarget(ruleAggregate);
    }

    @GetMapping("/rules")
    @Override
    public List<DesensitizationRuleRespDTO> getRules(@RequestParam("system_id") String systemId) {
        List<DesensitizationRuleAggregate> ruleAggregates = ruleService.queryRules(systemId);

        return convertor.sourceToTarget(ruleAggregates);
    }
}
