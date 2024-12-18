package space.x9x.solutions.desensitization.sdk.handler;

import space.x9x.radp.commons.lang.StringUtils;
import space.x9x.solutions.desensitization.sdk.context.DesensitizationContext;
import space.x9x.solutions.desensitization.sdk.model.DesensitizationRule;
import space.x9x.solutions.desensitization.sdk.service.IDesensitizationRuleService;
import space.x9x.solutions.desensitization.sdk.util.DesensitizationUtil;

import java.lang.annotation.Annotation;

/**
 * @author x9x
 * @since 2024-12-03 13:35
 */
public abstract class AbstractDesensitizationHandler<T extends Annotation> implements DesensitizationHandler<T> {


    protected IDesensitizationRuleService ruleService = DesensitizationContext.getRuleService();


    /**
     * A template method to decide how to apply desensitization:
     * 1. Attempt to use a dynamic rule (if available).
     * 2. If not available or ruleKey is empty, fallback to static annotation configuration.
     */
    @Override
    public String desensitize(String origin, T annotation) {
        // If empty original string, return it as is
        if (StringUtils.isBlank(origin)) {
            return origin;
        }

        // Attempt dynamic rule first
        DesensitizationRule dynamicRule = getDynamicRule(annotation);
        if (dynamicRule != null) {
            return DesensitizationUtil.applyRule(origin, dynamicRule);
        }

        // Fallback: use the annotation-defined method
        return applyAnnotationRule(origin, annotation);
    }

    /**
     * Fetch a dynamic rule if ruleKey is present. Otherwise, return null.
     */
    protected DesensitizationRule getDynamicRule(T annotation) {
        String ruleKey = getRuleKey(annotation);
        if (StringUtils.isNotBlank(ruleKey)) {
            return ruleService.getRuleByRuleKey(ruleKey);
        }
        return null;
    }

    /**
     * Children must implement how to extract ruleKey from the annotation
     */
    protected abstract String getRuleKey(T annotation);

    /**
     * Children provide how to apply the annotation-defined rule if no dynamic rule is found.
     */
    protected abstract String applyAnnotationRule(String origin, T annotation);
}
