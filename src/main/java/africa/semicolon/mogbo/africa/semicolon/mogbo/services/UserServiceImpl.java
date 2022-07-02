package africa.semicolon.mogbo.africa.semicolon.mogbo.services;

import africa.semicolon.mogbo.africa.semicolon.mogbo.data.models.Event;
import africa.semicolon.mogbo.africa.semicolon.mogbo.data.models.User;
import africa.semicolon.mogbo.africa.semicolon.mogbo.data.repositories.UserRepository;
import africa.semicolon.mogbo.africa.semicolon.mogbo.dtos.requests.CreatePartyRequest;
import africa.semicolon.mogbo.africa.semicolon.mogbo.dtos.responses.CreateEventResponse;
import africa.semicolon.mogbo.africa.semicolon.mogbo.dtos.responses.LoginUserResponse;
import africa.semicolon.mogbo.africa.semicolon.mogbo.dtos.requests.RegisterUserRequest;
import africa.semicolon.mogbo.africa.semicolon.mogbo.dtos.requests.UserLoginRequest;
import africa.semicolon.mogbo.africa.semicolon.mogbo.dtos.responses.RegisterUserResponse;
import africa.semicolon.mogbo.africa.semicolon.mogbo.exceptions.DuplicateEmailException;
import africa.semicolon.mogbo.africa.semicolon.mogbo.exceptions.InvalidDetailsException;
import africa.semicolon.mogbo.africa.semicolon.mogbo.exceptions.UserDoesNotExistException;
import africa.semicolon.mogbo.africa.semicolon.mogbo.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserServices {

    private UserRepository userRepository;

    private EventServices eventServices;
    @Autowired
    public UserServiceImpl(UserRepository userRepository, EventServices eventServices) {
        this.userRepository = userRepository;
        this.eventServices = eventServices;
    }

    @Override
    public RegisterUserResponse registerUser(RegisterUserRequest request) {
        if (userRepository.existsByEmail(request.getEmail()))
            throw new DuplicateEmailException(request.getEmail() + " already exists");
//        User user = Mapper.map(request);

        User user = new User();
        Mapper.map(request, user);
//        Mapper.map(request, user);
        // save user
        User savedUser = userRepository.save(user);
        RegisterUserResponse response = new RegisterUserResponse();
        Mapper.map(savedUser, response);
        return response;

//    public static void
//        User savedUser = userRepository.save(user);
//        RegisterUserResponse response = new RegisterUserResponse();
//        response.setEmail(savedUser.getEmail());
//        response.setDateCreated(DateTimeFormatter.ofPattern("EEEE, dd/MM/yyyy, hh:mm, a").format(savedUser.getLocalDateTime()));
//        return response;
    }

    @Override
    public LoginUserResponse userLogin(UserLoginRequest userLoginRequest) {
//        User user = userRepository.findByEmail(userLogin.getEmail());
//        if (user == null){
//            throw new IllegalArgumentException("Contact does not exist");
//        }
//
//        if (!Objects.equals(user.getEmail(), userLogin.getEmail())) {
//            throw new IllegalArgumentException("User email does not exist");
//        }
//        LoginUserResponse loginUserResponse = new LoginUserResponse();
//        loginUserResponse.setMessage("welcome " + user.getEmail());
//        return loginUserResponse;
        LoginUserResponse response = new LoginUserResponse();

        User user = userRepository.findByEmail(userLoginRequest.getEmail());
        if (Objects.equals(userLoginRequest.getPassword(), user.getPassword())){
            response.setMessage("Successfully logged in");
            return response;
        }
        throw new InvalidDetailsException("Invalid login details");
    }

    @Override
    public CreateEventResponse addParty(CreatePartyRequest createPartyRequest) {
        Optional<User> optionalUser = userRepository.findUserByEmail(createPartyRequest.getEmail());
        if (optionalUser.isEmpty()) throw new UserDoesNotExistException(createPartyRequest.getEmail() + " does not exist");
        User foundUser = optionalUser.get();
        Event event = new Event();
        Mapper.map(createPartyRequest, event);
        Event savedEvent = eventServices.saveEvent(event);
        foundUser.getEvents().add(savedEvent);
        userRepository.save(foundUser);

        CreateEventResponse response = new CreateEventResponse();
        Mapper.map(foundUser,savedEvent, response);

        return response;
    }
}
