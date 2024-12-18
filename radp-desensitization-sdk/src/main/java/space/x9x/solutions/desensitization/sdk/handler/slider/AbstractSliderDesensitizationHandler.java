package space.x9x.solutions.desensitization.sdk.handler.slider;


import space.x9x.radp.spring.framework.expression.SpringExpressionUtils;
import space.x9x.solutions.desensitization.sdk.handler.AbstractDesensitizationHandler;
import space.x9x.solutions.desensitization.sdk.util.DesensitizationUtil;

import java.lang.annotation.Annotation;

/**
 * 滑动脱敏处理器抽象类，已实现通用的方法
 *
 * @author x9x
 * @since 2024-10-23 15:58
 */
public abstract class AbstractSliderDesensitizationHandler<T extends Annotation>
        extends AbstractDesensitizationHandler<T> {

    @Override
    protected String applyAnnotationRule(String origin, T annotation) {
        // 1. 判断是否禁用脱敏
        Object disable = SpringExpressionUtils.parseExpression(getDisable(annotation));
        if (Boolean.FALSE.equals(disable)) {
            return origin;
        }

        // 2. 执行脱敏
        int prefixKeep = getInnerPrefixKeep(annotation);
        int suffixKeep = getInnerSuffixKeep(annotation);
        String replacer = getInnerReplacer(annotation);

        return DesensitizationUtil.applySlider(origin, prefixKeep, suffixKeep, replacer);
    }


    /**
     * 前缀保留长度
     *
     * @param annotation 注解信息
     * @return 前缀保留长度
     */
    abstract Integer getInnerPrefixKeep(T annotation);

    /**
     * 后缀保留长度
     *
     * @param annotation 注解信息
     * @return 后缀保留长度
     */
    abstract Integer getInnerSuffixKeep(T annotation);

    /**
     * 替换符
     *
     * @param annotation 注解信息
     * @return 替换符
     */
    abstract String getInnerReplacer(T annotation);
}
