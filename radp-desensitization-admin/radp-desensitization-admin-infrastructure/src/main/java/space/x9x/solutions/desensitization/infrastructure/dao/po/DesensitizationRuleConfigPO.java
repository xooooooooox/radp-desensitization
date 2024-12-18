package space.x9x.solutions.desensitization.infrastructure.dao.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import space.x9x.radp.spring.data.mybatis.autofill.BasePO;
import lombok.*;

/**
 * @author x9x
 * @since 2024-12-03 15:29
 */
@TableName("desensitization_rule_config")
@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DesensitizationRuleConfigPO extends BasePO<DesensitizationRuleConfigPO> {


    @TableId
    private Long id;

    /**
     * 系统编号
     */
    private String systemId;

    /**
     * 脱敏编号
     */
    private String ruleId;

    /**
     * 脱敏类型
     */
    private String ruleType;

    /**
     * 脱敏规则
     */
    private String ruleKey;

    /**
     * 脱敏规则
     */
    private String ruleValue;

    /**
     * 脱敏规则描述
     */
    private String ruleDesc;

    /**
     * 是否禁用脱敏,支持SpEL表达式
     */
    private String disable;

}
