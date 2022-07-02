package africa.semicolon.mogbo.africa.semicolon.mogbo.dtos.requests;

import lombok.Data;

@Data
public class RegisterUserRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String password;

}
