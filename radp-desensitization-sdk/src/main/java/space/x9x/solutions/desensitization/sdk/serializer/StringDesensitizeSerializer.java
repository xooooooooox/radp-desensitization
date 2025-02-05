package space.x9x.solutions.desensitization.sdk.serializer;

import cn.hutool.core.lang.Singleton;
import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import space.x9x.solutions.desensitization.sdk.annotation.DesensitizeBy;
import space.x9x.solutions.desensitization.sdk.handler.DesensitizationHandler;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.lang.annotation.Annotation;

/**
 * 脱敏序列化器
 * <p>
 * 实现返回数据时，使用 {@link DesensitizationHandler} 对声明脱敏注解的字段，进行脱敏处理。
 * 同时支持返回报文是 JSON 或 XML.
 *
 * @author x9x
 * @since 2024-10-23 14:16
 */
@SuppressWarnings("rawtypes")
@Getter
@Setter
public class StringDesensitizeSerializer extends StdSerializer<String> implements ContextualSerializer {

    /**
     * 脱敏处理器，负责对字段值进行脱敏处理。
     */
    private DesensitizationHandler desensitizationHandler;
    /**
     * 字段上存在的脱敏注解。
     */
    private Annotation desensitizeAnnotation;

    protected StringDesensitizeSerializer() {
        super(String.class);
    }

    /**
     * 初始化脱敏处理器和注解。
     *
     * @param handler    脱敏处理器实例。
     * @param annotation 脱敏注解实例。
     */
    protected StringDesensitizeSerializer(DesensitizationHandler handler, Annotation annotation) {
        super(String.class);
        this.desensitizationHandler = handler;
        this.desensitizeAnnotation = annotation;
    }

    /**
     * 创建上下文相关的序列化器，根据属性的注解进行配置。
     *
     * @param serializerProvider 序列化提供者。
     * @param beanProperty       当前处理的属性。
     * @return 如果存在脱敏注解，返回新的序列化器；否则，返回当前序列化器。
     */
    @Override
    public JsonSerializer<?> createContextual(SerializerProvider serializerProvider, BeanProperty beanProperty) {
        if (beanProperty != null) {
            // 遍历属性上的所有注解(Iterate over annotations to find one with @DesensitizeBy)
            for (Annotation annotation : beanProperty.getMember().getAllAnnotations().annotations()) {
                // 检查注解是否被@DesensitizeBy注解标记
                DesensitizeBy desensitizeBy = annotation.annotationType().getAnnotation(DesensitizeBy.class);
                if (desensitizeBy != null) {
                    // 获取脱敏处理器实例
                    DesensitizationHandler handler = Singleton.get(desensitizeBy.handler());
                    // 返回配置了处理器和注解的新序列化器
                    return new StringDesensitizeSerializer(handler, annotation);
                }
            }
        }
        return this;
    }

    /**
     * 序列化字符串值，必要时应用脱敏处理。
     *
     * @param value              要序列化的字符串值。
     * @param gen                JSON生成器。
     * @param serializerProvider 序列化提供者。
     * @throws IOException 如果发生I/O错误。
     */
    @Override
    @SuppressWarnings("unchecked")
    public void serialize(String value, JsonGenerator gen, SerializerProvider serializerProvider) throws IOException {
        if (StrUtil.isBlank(value)) {
            // 如果值为空，写入null
            // TODO 2024/11/14: 未来这里考虑是否需要支持配置化, 比如有的时候, 对于值为null的字段,我们并不期望它出现在返回报文中
            gen.writeNull();
            return;
        }
        if (desensitizeAnnotation != null && desensitizationHandler != null) {
            // 使用脱敏处理器对值进行脱敏
            value = desensitizationHandler.desensitize(value, desensitizeAnnotation);
        }
        gen.writeString(value);
    }

}
