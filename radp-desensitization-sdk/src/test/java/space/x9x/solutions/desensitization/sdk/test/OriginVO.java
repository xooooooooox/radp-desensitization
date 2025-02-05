package space.x9x.solutions.desensitization.sdk.test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author x9x
 * @since 2024-11-14 21:58
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OriginVO {
    private String nickname;
    private String bankCard;
    private String fixedPhone;
    private String idCard;
    private String password;
    private String phoneNumber;

    private String slider1;
    private String slider2;
    private String slider3;

    private String email;
    private String regex;

    private String address;
    private String origin;
}
