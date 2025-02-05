package space.x9x.solutions.desensitization.sdk.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import space.x9x.solutions.desensitization.sdk.context.DesensitizationContext;
import space.x9x.solutions.desensitization.sdk.factory.DefaultDesensitizationMatterFactory;
import space.x9x.solutions.desensitization.sdk.factory.DesensitizationMatterFactory;
import space.x9x.solutions.desensitization.sdk.service.IDesensitizationRuleService;

/**
 * @author x9x
 * @since 2024-12-06 21:33
 */
@EnableConfigurationProperties(DesensitizationProperties.class)
@Configuration
public class DesensitizationAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public DesensitizationMatterFactory desensitizationMatterFactory() {
        return new DefaultDesensitizationMatterFactory();
    }

    @Bean
    @ConditionalOnProperty(value = "radp.desensitization.mode", havingValue = "FETCH")
    public IDesensitizationRuleService desensitizationRuleService(DesensitizationProperties properties, DesensitizationMatterFactory factory) {
        IDesensitizationRuleService ruleService = factory.getRuleService(properties.getConfig());
        DesensitizationContext.setRuleService(ruleService);
        return ruleService;
    }
}
