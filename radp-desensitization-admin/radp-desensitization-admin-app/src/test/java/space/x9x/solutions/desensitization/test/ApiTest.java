package space.x9x.solutions.desensitization.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import space.x9x.solutions.desensitization.domain.rule.model.valobj.RuleType;

/**
 * @author x9x
 * @since 2024-12-10 20:17
 */
@Slf4j
class ApiTest {

    @Test
    void test() {
        log.info("name {}", RuleType.SLIDER.name());
        log.info("tostring {}", RuleType.SLIDER.toString());
        log.info("code {}", RuleType.SLIDER.getCode());
        log.info("enum {}", RuleType.SLIDER);
        log.info("name {}", RuleType.valueOf(RuleType.SLIDER.name()));
        log.info(">>>>>>>>>>>1");
        log.info("slider {}", RuleType.valueOf("SLIDER"));
        log.info(">>>>>>>>>>>2");
        log.info("0 {}", RuleType.valueOf("0"));
    }
}
