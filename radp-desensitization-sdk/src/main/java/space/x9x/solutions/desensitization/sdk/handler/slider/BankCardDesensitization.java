package space.x9x.solutions.desensitization.sdk.handler.slider;


import space.x9x.solutions.desensitization.sdk.annotation.slider.BankCardDesensitize;

/**
 * {@link BankCardDesensitize} 的脱敏处理器
 *
 * @author x9x
 * @since 2024-10-23 15:58
 */
public class BankCardDesensitization extends AbstractSliderDesensitizationHandler<BankCardDesensitize> {

    @Override
    Integer getInnerPrefixKeep(BankCardDesensitize annotation) {
        return annotation.prefixKeep();
    }

    @Override
    Integer getInnerSuffixKeep(BankCardDesensitize annotation) {
        return annotation.suffixKeep();
    }

    @Override
    String getInnerReplacer(BankCardDesensitize annotation) {
        return annotation.replacer();
    }

    @Override
    public String getDisable(BankCardDesensitize annotation) {
        return "";
    }

    @Override
    protected String getRuleKey(BankCardDesensitize annotation) {
        return annotation.ruleKey();
    }
}
