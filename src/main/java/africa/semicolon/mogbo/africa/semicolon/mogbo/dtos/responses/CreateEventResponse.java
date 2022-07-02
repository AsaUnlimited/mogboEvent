package africa.semicolon.mogbo.africa.semicolon.mogbo.dtos.responses;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateEventResponse {
    private String partyName;
    private String partyLocation;
    private String createdBy;
}
