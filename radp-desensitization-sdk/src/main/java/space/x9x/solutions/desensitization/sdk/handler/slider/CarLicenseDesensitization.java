package space.x9x.solutions.desensitization.sdk.handler.slider;


import space.x9x.solutions.desensitization.sdk.annotation.slider.CarLicenseDesensitize;

/**
 * {@link CarLicenseDesensitize} 的脱敏处理器
 *
 * @author x9x
 * @since 2024-10-23 15:58
 */
public class CarLicenseDesensitization extends AbstractSliderDesensitizationHandler<CarLicenseDesensitize> {

    @Override
    Integer getInnerPrefixKeep(CarLicenseDesensitize annotation) {
        return annotation.prefixKeep();
    }

    @Override
    Integer getInnerSuffixKeep(CarLicenseDesensitize annotation) {
        return annotation.suffixKeep();
    }

    @Override
    String getInnerReplacer(CarLicenseDesensitize annotation) {
        return annotation.replacer();
    }

    @Override
    public String getDisable(CarLicenseDesensitize annotation) {
        return annotation.disable();
    }

    @Override
    protected String getRuleKey(CarLicenseDesensitize annotation) {
        return annotation.ruleKey();
    }
}
