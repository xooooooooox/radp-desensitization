package space.x9x.solutions.desensitization.sdk.handler.regex;


import space.x9x.radp.spring.framework.expression.SpringExpressionUtils;
import space.x9x.solutions.desensitization.sdk.handler.AbstractDesensitizationHandler;
import space.x9x.solutions.desensitization.sdk.util.DesensitizationUtil;

import java.lang.annotation.Annotation;

/**
 * 正则表达式脱敏处理器抽象类，已实现通用的方法
 *
 * @author x9x
 * @since 2024-10-23 14:23
 */
public abstract class AbstractRegexDesensitizationHandler<T extends Annotation>
        extends AbstractDesensitizationHandler<T> {

    @Override
    protected String applyAnnotationRule(String origin, T annotation) {
        // 1. 判断是否禁用脱敏
        Object disable = SpringExpressionUtils.parseExpression(getDisable(annotation));
        if (Boolean.TRUE.equals(disable)) {
            return origin;
        }

        // 2. 执行脱敏
        String regex = getInnerRegex(annotation);
        String replacer = getInnerReplacer(annotation);
        return DesensitizationUtil.applyRegex(origin, regex, replacer);
    }


    /**
     * 获取注解上的 regex 参数
     *
     * @param annotation 注解信息
     * @return 正则表达式
     */
    abstract String getInnerRegex(T annotation);

    /**
     * 获取注解上的 replacer 参数
     *
     * @param annotation 注解信息
     * @return 待替换的字符串
     */
    abstract String getInnerReplacer(T annotation);

}
