package africa.semicolon.mogbo.africa.semicolon.mogbo.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserResponse {
    private String email;
    private String dateCreated;
}
