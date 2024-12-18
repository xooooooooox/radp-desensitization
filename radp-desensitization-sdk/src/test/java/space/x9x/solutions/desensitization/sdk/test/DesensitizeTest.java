package space.x9x.solutions.desensitization.sdk.test;

import space.x9x.radp.commons.json.JacksonUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author x9x
 * @since 2024-10-23 16:14
 */
class DesensitizeTest {

    private OriginVO originVO;
    private DesensitizeVO desensitizeVO;

    @BeforeEach
    void init() {
        originVO = OriginVO.builder()
                .nickname("高启强")
                .bankCard("9988002866797031")
                .fixedPhone("01086551122")
                .idCard("3102342023080012345")
                .password("asdfsdfdf@1")
                .phoneNumber("16621343456")
                .slider1("ABCDEFG")
                .slider2("ABCDEFG")
                .slider3("ABCDEFG")
                .email("1@email.com")
                .regex("你好,我是脱敏")
                .address("北京海淀区清华大学")
                .origin("脱敏")
                .build();

        desensitizeVO = DesensitizeVO.builder()
                .nickname("高启强")
                .bankCard("9988002866797031")
                .fixedPhone("01086551122")
                .idCard("3102342023080012345")
                .password("asdfsdfdf@1")
                .phoneNumber("16621343456")
                .slider1("ABCDEFG")
                .slider2("ABCDEFG")
                .slider3("ABCDEFG")
                .email("1@email.com")
                .regex("你好,我是脱敏")
                .address("北京海淀区清华大学")
                .origin("脱敏")
                .build();
    }

    @Test
    void test_json() {
        System.out.println("脱敏前: \n" + JacksonUtils.toJSONStringPretty(originVO));
        System.out.println("脱敏后: \n" + JacksonUtils.toJSONStringPretty(desensitizeVO));

        // 断言
        DesensitizeVO d = JacksonUtils.parseObject(JacksonUtils.toJSONString(desensitizeVO), DesensitizeVO.class);
        Assertions.assertNotNull(d);
        Assertions.assertEquals("高**", d.getNickname());
        Assertions.assertEquals("998800********31", d.getBankCard());
        Assertions.assertEquals("0108*****22", d.getFixedPhone());
        Assertions.assertEquals("310234***********45", d.getIdCard());
        Assertions.assertEquals("***********", d.getPassword());
        Assertions.assertEquals("166****3456", d.getPhoneNumber());
        Assertions.assertEquals("#######", d.getSlider1());
        Assertions.assertEquals("ABC*EFG", d.getSlider2());
        Assertions.assertEquals("*******", d.getSlider3());
        Assertions.assertEquals("1****@email.com", d.getEmail());
        Assertions.assertEquals("你好,我是*", d.getRegex());
        Assertions.assertEquals("北京海淀区清华大学*", d.getAddress());
        Assertions.assertEquals("脱敏", d.getOrigin());
    }

    @Test
    void test_xml() {
        System.out.println("脱敏前: \n" + JacksonUtils.toXMLStringPretty(originVO));
        System.out.println("脱敏后: \n" + JacksonUtils.toXMLStringPretty(desensitizeVO));

        // Parse the desensitized XML string back to a DesensitizeVO object
        DesensitizeVO d = JacksonUtils.parseXMLObject(JacksonUtils.toXMLString(desensitizeVO), DesensitizeVO.class);

        // Assertions
        Assertions.assertNotNull(d);
        Assertions.assertEquals("高**", d.getNickname());
        Assertions.assertEquals("998800********31", d.getBankCard());
        Assertions.assertEquals("0108*****22", d.getFixedPhone());
        Assertions.assertEquals("310234***********45", d.getIdCard());
        Assertions.assertEquals("***********", d.getPassword());
        Assertions.assertEquals("166****3456", d.getPhoneNumber());
        Assertions.assertEquals("#######", d.getSlider1());
        Assertions.assertEquals("ABC*EFG", d.getSlider2());
        Assertions.assertEquals("*******", d.getSlider3());
        Assertions.assertEquals("1****@email.com", d.getEmail());
        Assertions.assertEquals("你好,我是*", d.getRegex());
        Assertions.assertEquals("北京海淀区清华大学*", d.getAddress());
        Assertions.assertEquals("脱敏", d.getOrigin());
    }

}
