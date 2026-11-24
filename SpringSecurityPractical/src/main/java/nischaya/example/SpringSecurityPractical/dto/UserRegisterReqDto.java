package nischaya.example.SpringSecurityPractical.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserRegisterReqDto {

    private String username;
    private String password;
}
