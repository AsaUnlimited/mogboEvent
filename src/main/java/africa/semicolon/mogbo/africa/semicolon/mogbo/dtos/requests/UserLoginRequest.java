package africa.semicolon.mogbo.africa.semicolon.mogbo.dtos.requests;

import lombok.Data;

@Data
public class UserLoginRequest {
    private String email;
    private String password;
}
