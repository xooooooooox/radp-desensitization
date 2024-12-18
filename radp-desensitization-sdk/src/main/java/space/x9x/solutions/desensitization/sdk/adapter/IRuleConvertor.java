package space.x9x.solutions.desensitization.sdk.adapter;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import space.x9x.solutions.desensitization.api.dto.DesensitizationRuleRespDTO;
import space.x9x.solutions.desensitization.sdk.model.DesensitizationRule;

import java.util.List;

/**
 * @author x9x
 * @since 2024-12-06 11:22
 */
@Mapper
public interface IRuleConvertor {

    IRuleConvertor INSTANCE = Mappers.getMapper(IRuleConvertor.class);

    DesensitizationRule convert(DesensitizationRuleRespDTO dto);

    List<DesensitizationRule> convert(List<DesensitizationRuleRespDTO> dtos);
}
