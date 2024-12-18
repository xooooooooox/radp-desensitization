package space.x9x.solutions.desensitization.sdk.annotation.slider;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import space.x9x.solutions.desensitization.sdk.annotation.DesensitizeBy;
import space.x9x.solutions.desensitization.sdk.handler.slider.DefaultDesensitizationHandler;

import java.lang.annotation.*;

/**
 * 滑动脱敏注解
 *
 * @author x9x
 * @since 2024-10-23 15:58
 */
@Documented
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@JacksonAnnotationsInside
@DesensitizeBy(handler = DefaultDesensitizationHandler.class)
public @interface SliderDesensitize {

    String ruleKey() default "sliderDesensitize";

    /**
     * 后缀保留长度
     */
    int suffixKeep() default 0;

    /**
     * 替换规则，会将前缀后缀保留后，全部替换成 replacer
     *
     * 例如：prefixKeep = 1; suffixKeep = 2; replacer = "*";
     * 原始字符串  123456
     * 脱敏后     1***56
     */
    String replacer() default "*";

    /**
     * 前缀保留长度
     */
    int prefixKeep() default 0;

    /**
     * 是否禁用脱敏
     *
     * 支持 Spring EL 表达式，如果返回 true 则跳过脱敏
     */
    String disable() default "";

}
