package space.x9x.solutions.desensitization.sdk.handler.slider;


import space.x9x.solutions.desensitization.sdk.annotation.slider.MobileDesensitize;

/**
 * {@link MobileDesensitize} 的脱敏处理器
 *
 * @author x9x
 * @since 2024-10-23 15:58
 */
public class MobileDesensitization extends AbstractSliderDesensitizationHandler<MobileDesensitize> {

    @Override
    Integer getInnerPrefixKeep(MobileDesensitize annotation) {
        return annotation.prefixKeep();
    }

    @Override
    Integer getInnerSuffixKeep(MobileDesensitize annotation) {
        return annotation.suffixKeep();
    }

    @Override
    String getInnerReplacer(MobileDesensitize annotation) {
        return annotation.replacer();
    }

    @Override
    protected String getRuleKey(MobileDesensitize annotation) {
        return annotation.ruleKey();
    }
}
