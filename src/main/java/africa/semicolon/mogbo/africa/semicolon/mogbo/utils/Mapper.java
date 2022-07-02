package africa.semicolon.mogbo.africa.semicolon.mogbo.utils;

import africa.semicolon.mogbo.africa.semicolon.mogbo.data.models.Event;
import africa.semicolon.mogbo.africa.semicolon.mogbo.data.models.User;
import africa.semicolon.mogbo.africa.semicolon.mogbo.dtos.requests.CreatePartyRequest;
import africa.semicolon.mogbo.africa.semicolon.mogbo.dtos.requests.RegisterUserRequest;
import africa.semicolon.mogbo.africa.semicolon.mogbo.dtos.responses.CreateEventResponse;
import africa.semicolon.mogbo.africa.semicolon.mogbo.dtos.responses.RegisterUserResponse;

import java.time.format.DateTimeFormatter;

public class Mapper {

//    public static User map(RegisterUserRequest request) {
//        User user = new User();
//        user.setEmail(request.getEmail());
//        user.setFirstName(request.getFirstName());
//        user.setLastName(request.getLastName());
//        user.setPassword(request.getPassword());
//        return user;
//    }

    public static void map(RegisterUserRequest request, User user) {
        user.setEmail(request.getEmail());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPassword(request.getPassword());
    }

    public static void map(User savedUser, RegisterUserResponse response){
        response.setEmail(savedUser.getEmail());
        response.setDateCreated(DateTimeFormatter.ofPattern("EEEE, dd/MM/yyy, hh:mm, a").format(savedUser.getDateTimeRegistered()));
    }


    public static void map(CreatePartyRequest createPartyRequest, Event event) {
        event.setLocation(createPartyRequest.getPartyLocation());
        event.setName(createPartyRequest.getPartyName());
    }

    public static void map(User foundUser, Event savedEvent, CreateEventResponse response) {
        response.setPartyName(savedEvent.getName());
        response.setPartyLocation(savedEvent.getLocation());
        response.setCreatedBy(foundUser.getFirstName());
    }
}
