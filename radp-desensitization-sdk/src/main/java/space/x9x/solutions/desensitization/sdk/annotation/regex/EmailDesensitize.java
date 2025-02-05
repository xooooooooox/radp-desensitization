package space.x9x.solutions.desensitization.sdk.annotation.regex;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import space.x9x.solutions.desensitization.sdk.annotation.DesensitizeBy;
import space.x9x.solutions.desensitization.sdk.handler.regex.EmailDesensitizationHandler;

import java.lang.annotation.*;

/**
 * 邮箱脱敏注解
 *
 * @author x9x
 * @since 2024-10-23 14:23
 */
@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@JacksonAnnotationsInside
@DesensitizeBy(handler = EmailDesensitizationHandler.class)
public @interface EmailDesensitize {

    String ruleKey() default "emailDesensitize";

    /**
     * 匹配的正则表达式
     */
    String regex() default "(^.)[^@]*(@.*$)";

    /**
     * 替换规则，邮箱;
     * <p>
     * 比如：example@gmail.com 脱敏之后为 e****@gmail.com
     */
    String replacer() default "$1****$2";

    /**
     * 是否禁用脱敏
     * <p>
     * 支持 Spring EL 表达式，如果返回 true 则跳过脱敏
     */
    String disable() default "";

}
