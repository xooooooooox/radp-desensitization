package space.x9x.solutions.desensitization.sdk.handler.slider;


import space.x9x.solutions.desensitization.sdk.annotation.slider.IdCardDesensitize;

/**
 * {@link IdCardDesensitize} 的脱敏处理器
 *
 * @author x9x
 * @since 2024-10-23 15:58
 */
public class IdCardDesensitization extends AbstractSliderDesensitizationHandler<IdCardDesensitize> {
    @Override
    Integer getInnerPrefixKeep(IdCardDesensitize annotation) {
        return annotation.prefixKeep();
    }

    @Override
    Integer getInnerSuffixKeep(IdCardDesensitize annotation) {
        return annotation.suffixKeep();
    }

    @Override
    String getInnerReplacer(IdCardDesensitize annotation) {
        return annotation.replacer();
    }

    @Override
    protected String getRuleKey(IdCardDesensitize annotation) {
        return annotation.ruleKey();
    }
}
