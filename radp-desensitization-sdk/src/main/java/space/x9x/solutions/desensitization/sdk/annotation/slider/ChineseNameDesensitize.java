package space.x9x.solutions.desensitization.sdk.annotation.slider;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import space.x9x.solutions.desensitization.sdk.annotation.DesensitizeBy;
import space.x9x.solutions.desensitization.sdk.handler.slider.ChineseNameDesensitization;

import java.lang.annotation.*;

/**
 * 中文名
 *
 * @author x9x
 * @since 2024-10-23 15:58
 */
@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@JacksonAnnotationsInside
@DesensitizeBy(handler = ChineseNameDesensitization.class)
public @interface ChineseNameDesensitize {

    String ruleKey() default "chineseNameDesensitize";

    /**
     * 前缀保留长度
     */
    int prefixKeep() default 1;

    /**
     * 后缀保留长度
     */
    int suffixKeep() default 0;

    /**
     * 替换规则，中文名;比如：刘子豪脱敏之后为刘**
     */
    String replacer() default "*";

    /**
     * 是否禁用脱敏
     *
     * 支持 Spring EL 表达式，如果返回 true 则跳过脱敏
     */
    String disable() default "";

}
