package space.x9x.solutions.desensitization.sdk.handler.slider;


import space.x9x.solutions.desensitization.sdk.annotation.slider.SliderDesensitize;

/**
 * {@link SliderDesensitize} 的脱敏处理器
 *
 * @author x9x
 * @since 2024-10-23 15:58
 */
public class DefaultDesensitizationHandler extends AbstractSliderDesensitizationHandler<SliderDesensitize> {

    @Override
    Integer getInnerPrefixKeep(SliderDesensitize annotation) {
        return annotation.prefixKeep();
    }

    @Override
    Integer getInnerSuffixKeep(SliderDesensitize annotation) {
        return annotation.suffixKeep();
    }

    @Override
    String getInnerReplacer(SliderDesensitize annotation) {
        return annotation.replacer();
    }

    @Override
    protected String getRuleKey(SliderDesensitize annotation) {
        return annotation.ruleKey();
    }
}
