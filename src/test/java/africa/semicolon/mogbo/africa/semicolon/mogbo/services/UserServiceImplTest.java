package africa.semicolon.mogbo.africa.semicolon.mogbo.services;

import africa.semicolon.mogbo.africa.semicolon.mogbo.data.repositories.UserRepository;
import africa.semicolon.mogbo.africa.semicolon.mogbo.dtos.requests.RegisterUserRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserServiceImplTest {
    @Autowired
    private UserServices userServices;
    @Autowired
    private UserRepository userRepository;

    @Test
    public void registerUserTest(){
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setEmail("funmi@gmail.com");
        registerUserRequest.setFirstName("Omisande");
        registerUserRequest.setLastName("Funmi");
        registerUserRequest.setPassword("iLoveJesus222");
        userServices.registerUser(registerUserRequest);

        assertEquals(1, userRepository.count());
    }

}