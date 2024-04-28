package beautybook.API.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class NewUserDto {
    private  String firstName;
    private  String lastName;
    private  String email;
    private  String hashPassword;
    private  String role;
}
