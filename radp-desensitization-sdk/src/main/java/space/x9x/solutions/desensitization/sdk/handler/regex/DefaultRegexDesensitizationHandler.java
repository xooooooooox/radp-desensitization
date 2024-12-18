package space.x9x.solutions.desensitization.sdk.handler.regex;


import space.x9x.solutions.desensitization.sdk.annotation.regex.RegexDesensitize;

/**
 * {@link RegexDesensitize} 的正则脱敏处理器
 *
 * @author x9x
 * @since 2024-10-23 14:23
 */
public class DefaultRegexDesensitizationHandler extends AbstractRegexDesensitizationHandler<RegexDesensitize> {

    @Override
    String getInnerRegex(RegexDesensitize annotation) {
        return annotation.regex();
    }

    @Override
    String getInnerReplacer(RegexDesensitize annotation) {
        return annotation.replacer();
    }

    @Override
    public String getDisable(RegexDesensitize annotation) {
        return annotation.disable();
    }

    @Override
    protected String getRuleKey(RegexDesensitize annotation) {
        return annotation.ruleKey();
    }
}
