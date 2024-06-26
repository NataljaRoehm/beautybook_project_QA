package beautybook.API.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class LoginRequestDto {
    private String email;
    private String hashPassword;
}