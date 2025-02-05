package space.x9x.solutions.desensitization.sdk.util;

import space.x9x.radp.commons.lang.StringUtils;
import space.x9x.radp.spring.framework.expression.SpringExpressionUtils;
import lombok.experimental.UtilityClass;
import space.x9x.solutions.desensitization.sdk.model.DesensitizationRule;

/**
 * @author x9x
 * @since 2024-12-06 14:10
 */
@UtilityClass
public class DesensitizationUtil {


    /**
     * 对给定的字符串应用指定的脱敏规则。
     * <p>
     * 若传入的字符串为空白，或规则为 null，则直接返回原字符串不作修改。
     * </p>
     * <p>
     * 支持的规则类型：
     * <ul>
     *     <li><b>REGEX</b>：使用提供的正则表达式和替换字符串对原字符串进行替换。</li>
     *     <li><b>SLIDER</b>：通过保留指定前缀、后缀长度的字符，并用替换符号填充中间部分来实现脱敏。</li>
     *     <li>其他类型将不进行任何替换，直接返回原字符串。</li>
     * </ul>
     * </p>
     *
     * @param origin 原始字符串
     * @param rule   要应用的脱敏规则
     * @return 脱敏后的字符串；若未进行修改则返回原字符串
     */
    public String applyRule(String origin, DesensitizationRule rule) {
        if (StringUtils.isBlank(origin) || null == rule) return origin;

        // Check if disabled:
        if (Boolean.TRUE.equals(SpringExpressionUtils.parseExpression(rule.getDisable()))) {
            return origin;
        }

        switch (rule.getType().toUpperCase()) {
            case "REGEX":
                return applyRegex(origin, rule.getRegex(), rule.getReplacer());
            case "SLIDER":
                return applySlider(origin, rule);
            default:
                return origin;
        }
    }

    /**
     * 使用正则表达式对字符串进行替换脱敏。
     * <p>
     * 利用正则表达式匹配字符串中需要脱敏的部分，并使用给定的替换字符串进行替换。
     * 内部调用 {@link String#replaceAll(String, String)} 完成操作。
     * </p>
     *
     * @param origin   原始字符串
     * @param regex    正则表达式，用于匹配需要替换的部分
     * @param replacer 用于替换匹配部分的字符串
     * @return 替换后的字符串
     */
    public String applyRegex(String origin, String regex, String replacer) {
        return origin.replaceAll(regex, replacer);
    }

    /**
     * 使用指定的规则进行“滑动”类型的脱敏处理。
     * <p>
     * 滑动脱敏策略是指在字符串的前后分别保留一定长度的字符，中间部分以替换字符进行遮盖。
     * 例如：前缀保留 3 个字符，后缀保留 2 个字符，中间部分用 '*' 填充。
     * </p>
     *
     * @param origin 原始字符串
     * @param rule   包含前缀、后缀保留长度和替换字符的脱敏规则
     * @return 脱敏处理后的字符串
     */
    public String applySlider(String origin, DesensitizationRule rule) {
        int prefixKeep = rule.getPrefixKeep() == null ? 0 : rule.getPrefixKeep();
        int suffixKeep = rule.getSuffixKeep() == null ? 0 : rule.getSuffixKeep();
        String replacer = rule.getReplacer() == null ? "*" : rule.getReplacer();
        return applySlider(origin, prefixKeep, suffixKeep, replacer);
    }

    /**
     * 使用滑动规则对字符串进行脱敏处理。
     * <p>
     * 保留 {@code prefixKeep} 个前缀字符和 {@code suffixKeep} 个后缀字符，其余部分用 {@code replacer} 覆盖。
     * 若字符串长度小于或等于前后缀保留长度之和，则直接用 {@code replacer} 将整个字符串替换。
     * </p>
     *
     * @param origin     原始字符串
     * @param prefixKeep 保留的前缀字符个数
     * @param suffixKeep 保留的后缀字符个数
     * @param replacer   用于替换中间部分的字符或字符串
     * @return 经滑动脱敏处理后的字符串
     */
    public String applySlider(String origin, int prefixKeep, int suffixKeep, String replacer) {
        int length = origin.length();

        // 原始字符串长度小于等于保留长度 或 原始字符串长度小于等于前后缀保留字符串长度
        if (prefixKeep >= length || suffixKeep >= length || (prefixKeep + suffixKeep) >= length) {
            return buildReplacerByLength(replacer, length);
        }

        // 原始字符串长度大于前后缀保留字符串长度
        int interval = length - prefixKeep - suffixKeep;
        return origin.substring(0, prefixKeep) +
                buildReplacerByLength(replacer, interval) +
                origin.substring(prefixKeep + interval);
    }

    /**
     * 根据长度循环构建替换符
     *
     * @param replacer 替换符
     * @param length   长度
     * @return 构建后的替换符
     */
    private String buildReplacerByLength(String replacer, int length) {
        StringBuilder builder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            builder.append(replacer);
        }
        return builder.toString();
    }
}

