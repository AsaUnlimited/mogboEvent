package africa.semicolon.mogbo.africa.semicolon.mogbo.services;

import africa.semicolon.mogbo.africa.semicolon.mogbo.dtos.requests.CreatePartyRequest;
import africa.semicolon.mogbo.africa.semicolon.mogbo.dtos.responses.CreateEventResponse;
import africa.semicolon.mogbo.africa.semicolon.mogbo.dtos.responses.LoginUserResponse;
import africa.semicolon.mogbo.africa.semicolon.mogbo.dtos.requests.RegisterUserRequest;
import africa.semicolon.mogbo.africa.semicolon.mogbo.dtos.requests.UserLoginRequest;
import africa.semicolon.mogbo.africa.semicolon.mogbo.dtos.responses.RegisterUserResponse;
import org.springframework.stereotype.Service;

@Service
public interface UserServices {

    RegisterUserResponse registerUser(RegisterUserRequest request);

    LoginUserResponse userLogin(UserLoginRequest userLoginRequest);

    CreateEventResponse addParty(CreatePartyRequest createPartyRequest);
}
