package space.x9x.solutions.desensitization.sdk.test.annotation;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import space.x9x.solutions.desensitization.sdk.annotation.DesensitizeBy;
import space.x9x.solutions.desensitization.sdk.test.handler.AddressDesensitizationHandler;

import java.lang.annotation.*;

/**
 * 地址脱敏
 * <p>
 * 演示如何自定义脱敏注解
 *
 * @author x9x
 * @since 2024-10-23 16:20
 */
@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@JacksonAnnotationsInside
@DesensitizeBy(handler = AddressDesensitizationHandler.class)
public @interface Address {

    String replacer() default "*";
}

