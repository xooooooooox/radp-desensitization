package space.x9x.solutions.desensitization.sdk.handler.slider;


import space.x9x.solutions.desensitization.sdk.annotation.slider.PasswordDesensitize;

/**
 * {@link PasswordDesensitize} 的码脱敏处理器
 *
 * @author x9x
 * @since 2024-10-23 15:58
 */
public class PasswordDesensitization extends AbstractSliderDesensitizationHandler<PasswordDesensitize> {
    @Override
    Integer getInnerPrefixKeep(PasswordDesensitize annotation) {
        return annotation.prefixKeep();
    }

    @Override
    Integer getInnerSuffixKeep(PasswordDesensitize annotation) {
        return annotation.suffixKeep();
    }

    @Override
    String getInnerReplacer(PasswordDesensitize annotation) {
        return annotation.replacer();
    }

    @Override
    protected String getRuleKey(PasswordDesensitize annotation) {
        return annotation.ruleKey();
    }
}
