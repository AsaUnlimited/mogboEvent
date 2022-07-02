//package africa.semicolon.mogbo.africa.semicolon.mogbo.data.models;
//
//import africa.semicolon.mogbo.africa.semicolon.mogbo.dto.responses.LoginUserResponse;
//import africa.semicolon.mogbo.africa.semicolon.mogbo.dto.requests.RegisterUserRequest;
//import africa.semicolon.mogbo.africa.semicolon.mogbo.dto.requests.UserLogin;
//import africa.semicolon.mogbo.africa.semicolon.mogbo.services.UserServices;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class LoginUserRequestTest {
//    @Autowired
//    private UserServices userServices;
//
//    @Test
//    public void userCanRegister(){
//        RegisterUserRequest request = new RegisterUserRequest();
//        request.setFirstName("Asa");
//        request.setLastName("asa");
//        request.setEmail("asa@gmail.com");
//        request.setPassword("12345");
//
//        String response = String.valueOf(userServices.registerUser(request));
//        assertEquals("registered sucessfully", response);
//    }
//
//    @Test
//    public void userCanLoginTest(){
//        UserLogin userLogin = new UserLogin();
//        userLogin.setEmail("asa@gmail.com");
//        userLogin.setPassword("12345");
//
//        LoginUserResponse response = userServices.userLogin(userLogin);
//        assertEquals("User logged successfully", response);
//    }
//
//}