package space.x9x.solutions.desensitization.infrastructure.dao.mysql;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import space.x9x.solutions.desensitization.infrastructure.dao.po.DesensitizationRuleConfigPO;

import java.util.List;

/**
 * @author x9x
 * @since 2024-12-03 15:35
 */
@Mapper
public interface IRuleConfigMapper extends BaseMapper<DesensitizationRuleConfigPO> {

    default DesensitizationRuleConfigPO selectRuleByRuleKey(String ruleKey) {
        return selectOne(new LambdaQueryWrapper<DesensitizationRuleConfigPO>()
                .eq(DesensitizationRuleConfigPO::getRuleKey, ruleKey));
    }

    default List<DesensitizationRuleConfigPO> selectListBySystemId(String systemId) {
        return selectList(new LambdaQueryWrapper<DesensitizationRuleConfigPO>()
                .eq(DesensitizationRuleConfigPO::getSystemId, systemId));
    }

    default DesensitizationRuleConfigPO selectBySystemIdAndRuleKey(String systemId, String ruleKey) {
        return selectOne(new LambdaQueryWrapper<DesensitizationRuleConfigPO>()
                .eq(DesensitizationRuleConfigPO::getSystemId, systemId)
                .eq(DesensitizationRuleConfigPO::getRuleKey, ruleKey));
    }
}
