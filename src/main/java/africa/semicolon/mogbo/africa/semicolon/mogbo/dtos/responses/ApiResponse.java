package africa.semicolon.mogbo.africa.semicolon.mogbo.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse {
    private boolean isSuccessful;
    private Object data;
}
