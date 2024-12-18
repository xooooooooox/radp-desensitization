package space.x9x.solutions.desensitization.sdk.handler.slider;


import space.x9x.solutions.desensitization.sdk.annotation.slider.ChineseNameDesensitize;

/**
 * {@link ChineseNameDesensitize} 的脱敏处理器
 *
 * @author x9x
 * @since 2024-10-23 15:58
 */
public class ChineseNameDesensitization extends AbstractSliderDesensitizationHandler<ChineseNameDesensitize> {

    @Override
    Integer getInnerPrefixKeep(ChineseNameDesensitize annotation) {
        return annotation.prefixKeep();
    }

    @Override
    Integer getInnerSuffixKeep(ChineseNameDesensitize annotation) {
        return annotation.suffixKeep();
    }

    @Override
    String getInnerReplacer(ChineseNameDesensitize annotation) {
        return annotation.replacer();
    }

    @Override
    protected String getRuleKey(ChineseNameDesensitize annotation) {
        return annotation.ruleKey();
    }
}
