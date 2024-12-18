package space.x9x.solutions.desensitization.sdk.handler.slider;


import space.x9x.solutions.desensitization.sdk.annotation.slider.FixedPhoneDesensitize;

/**
 * {@link FixedPhoneDesensitize} 的脱敏处理器
 *
 * @author x9x
 * @since 2024-10-23 15:58
 */
public class FixedPhoneDesensitization extends AbstractSliderDesensitizationHandler<FixedPhoneDesensitize> {

    @Override
    Integer getInnerPrefixKeep(FixedPhoneDesensitize annotation) {
        return annotation.prefixKeep();
    }

    @Override
    Integer getInnerSuffixKeep(FixedPhoneDesensitize annotation) {
        return annotation.suffixKeep();
    }

    @Override
    String getInnerReplacer(FixedPhoneDesensitize annotation) {
        return annotation.replacer();
    }

    @Override
    protected String getRuleKey(FixedPhoneDesensitize annotation) {
        return annotation.ruleKey();
    }
}
