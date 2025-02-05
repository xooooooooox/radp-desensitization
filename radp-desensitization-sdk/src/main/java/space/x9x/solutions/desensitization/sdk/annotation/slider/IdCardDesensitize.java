package space.x9x.solutions.desensitization.sdk.annotation.slider;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import space.x9x.solutions.desensitization.sdk.annotation.DesensitizeBy;
import space.x9x.solutions.desensitization.sdk.handler.slider.IdCardDesensitization;

import java.lang.annotation.*;

/**
 * 身份证
 *
 * @author x9x
 * @since 2024-10-23 15:58
 */
@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@JacksonAnnotationsInside
@DesensitizeBy(handler = IdCardDesensitization.class)
public @interface IdCardDesensitize {

    String ruleKey() default "idCardDesensitize";

    /**
     * 前缀保留长度
     */
    int prefixKeep() default 6;

    /**
     * 后缀保留长度
     */
    int suffixKeep() default 2;

    /**
     * 替换规则，身份证号码;比如：530321199204074611 脱敏之后为 530321**********11
     */
    String replacer() default "*";

    /**
     * 是否禁用脱敏
     *
     * 支持 Spring EL 表达式，如果返回 true 则跳过脱敏
     */
    String disable() default "";

}
