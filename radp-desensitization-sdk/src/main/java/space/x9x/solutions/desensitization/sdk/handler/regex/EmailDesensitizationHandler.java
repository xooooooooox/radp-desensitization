package space.x9x.solutions.desensitization.sdk.handler.regex;


import space.x9x.solutions.desensitization.sdk.annotation.regex.EmailDesensitize;

/**
 * {@link EmailDesensitize} 的脱敏处理器
 *
 * @author x9x
 * @since 2024-10-23 14:23
 */
public class EmailDesensitizationHandler extends AbstractRegexDesensitizationHandler<EmailDesensitize> {

    @Override
    String getInnerRegex(EmailDesensitize annotation) {
        return annotation.regex();
    }

    @Override
    String getInnerReplacer(EmailDesensitize annotation) {
        return annotation.replacer();
    }

    @Override
    protected String getRuleKey(EmailDesensitize annotation) {
        return annotation.ruleKey();
    }
}
