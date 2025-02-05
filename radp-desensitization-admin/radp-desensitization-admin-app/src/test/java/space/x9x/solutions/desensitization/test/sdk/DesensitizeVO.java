package space.x9x.solutions.desensitization.test.sdk;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import space.x9x.solutions.desensitization.sdk.annotation.regex.EmailDesensitize;
import space.x9x.solutions.desensitization.sdk.annotation.regex.RegexDesensitize;
import space.x9x.solutions.desensitization.sdk.annotation.slider.*;
import space.x9x.solutions.desensitization.test.sdk.annotation.Address;

/**
 * @author x9x
 * @since 2024-11-14 21:58
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DesensitizeVO {

    //region 滑动脱敏
    @ChineseNameDesensitize
    private String nickname;
    @BankCardDesensitize
    private String bankCard;
    @FixedPhoneDesensitize
    private String fixedPhone;
    @IdCardDesensitize
    private String idCard;
    @PasswordDesensitize
    private String password;
    @MobileDesensitize
    private String phoneNumber;

    @SliderDesensitize(prefixKeep = 6, suffixKeep = 1, replacer = "#")
    private String slider1;
    @SliderDesensitize(prefixKeep = 3, suffixKeep = 3)
    private String slider2;
    @SliderDesensitize(prefixKeep = 10)
    private String slider3;
    //endregion

    //region 正则脱敏
    @EmailDesensitize
    private String email;
    @RegexDesensitize(regex = "脱敏", replacer = "*")
    private String regex;
    //endregion

    //region 自定义脱敏
    @Address
    private String address;
    private String origin;
    //endregion
}
