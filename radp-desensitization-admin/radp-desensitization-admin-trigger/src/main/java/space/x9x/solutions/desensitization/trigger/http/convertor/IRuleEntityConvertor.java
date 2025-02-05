package space.x9x.solutions.desensitization.trigger.http.convertor;

import space.x9x.radp.spring.framework.domain.BaseConvertor;
import org.mapstruct.*;
import space.x9x.solutions.desensitization.api.dto.DesensitizationRuleRespDTO;
import space.x9x.solutions.desensitization.domain.rule.model.aggregate.DesensitizationRuleAggregate;
import space.x9x.solutions.desensitization.domain.rule.model.valobj.RegexRule;
import space.x9x.solutions.desensitization.domain.rule.model.valobj.SlideRule;

import java.util.List;

/**
 * @author x9x
 * @since 2024-12-10 20:55
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface IRuleEntityConvertor extends BaseConvertor<DesensitizationRuleAggregate, DesensitizationRuleRespDTO> {

    @Mapping(target = "suffixKeep", ignore = true)
    @Mapping(target = "replacer", ignore = true)
    @Mapping(target = "regex", ignore = true)
    @Mapping(target = "prefixKeep", ignore = true)
    @Mapping(target = "id", source = "ruleId")
    @Mapping(target = "type", source = "ruleType")
    @Mapping(target = "ruleKey", source = "ruleKey")
    @Mapping(target = "disable", source = "disable")
    @Override
    DesensitizationRuleRespDTO sourceToTarget(DesensitizationRuleAggregate aggregate);

    @Override
    List<DesensitizationRuleRespDTO> sourceToTarget(List<DesensitizationRuleAggregate> list);

    @AfterMapping
    default void afterMapping(DesensitizationRuleAggregate aggregate, @MappingTarget DesensitizationRuleRespDTO dto) {
        switch (aggregate.getRuleType()) {
            case REGEX:
                RegexRule regexRule = aggregate.getRule();
                dto.setRegex(regexRule.getRegex());
                dto.setReplacer(regexRule.getReplacer());
                break;
            case SLIDER:
                SlideRule slideRule = aggregate.getRule();
                dto.setPrefixKeep(slideRule.getPrefixKeep());
                dto.setSuffixKeep(slideRule.getSuffixKeep());
                dto.setReplacer(slideRule.getReplacer());
                break;
            default:
                break;
        }
    }
}
