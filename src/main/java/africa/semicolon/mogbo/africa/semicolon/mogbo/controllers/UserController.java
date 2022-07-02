package africa.semicolon.mogbo.africa.semicolon.mogbo.controllers;

import africa.semicolon.mogbo.africa.semicolon.mogbo.dtos.requests.CreatePartyRequest;
import africa.semicolon.mogbo.africa.semicolon.mogbo.dtos.responses.ApiResponse;
import africa.semicolon.mogbo.africa.semicolon.mogbo.dtos.requests.RegisterUserRequest;
import africa.semicolon.mogbo.africa.semicolon.mogbo.dtos.requests.UserLoginRequest;
import africa.semicolon.mogbo.africa.semicolon.mogbo.exceptions.DuplicateEmailException;
import africa.semicolon.mogbo.africa.semicolon.mogbo.exceptions.InvalidDetailsException;
import africa.semicolon.mogbo.africa.semicolon.mogbo.exceptions.UserDoesNotExistException;
import africa.semicolon.mogbo.africa.semicolon.mogbo.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserServices userServices;

    @PostMapping("/user")
    public ResponseEntity<?> register(@RequestBody RegisterUserRequest registerUserRequest){
       try {
           var serviceResponse = userServices.registerUser(registerUserRequest);
           ApiResponse response = new ApiResponse(true, serviceResponse);
           return new ResponseEntity<>(response, HttpStatus.CREATED);
       }
       catch (DuplicateEmailException ex){
           ApiResponse response = new ApiResponse(false, ex.getMessage());
           return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
       }
    }

    @GetMapping("user/login")
    public ResponseEntity<?> login(@RequestBody UserLoginRequest loginUserResponse) {
        try {
            var serviceResponse = userServices.userLogin(loginUserResponse);
            ApiResponse response = new ApiResponse(true, serviceResponse);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (InvalidDetailsException ex) {
            ApiResponse response = new ApiResponse(false, ex.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/party")
    public ResponseEntity<?> createEvent(@RequestBody CreatePartyRequest createPartyRequest){
        try{
            var serviceResponse = userServices.addParty(createPartyRequest);
            ApiResponse response = new ApiResponse(true, serviceResponse);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        catch (UserDoesNotExistException ex){
            ApiResponse response = new ApiResponse(false, ex.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
}
