package nischaya.example.SpringSecurityPractical.service;

import nischaya.example.SpringSecurityPractical.dto.UserRegisterReqDto;
import nischaya.example.SpringSecurityPractical.dto.UserRegisterResponseDto;
import nischaya.example.SpringSecurityPractical.entity.User;
import nischaya.example.SpringSecurityPractical.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserRegisterResponseDto register(UserRegisterReqDto userRegisterReqDto){

        User user = new User();
        user.setUserName(userRegisterReqDto.getUsername());
        user.setPassword(passwordEncoder.encode(userRegisterReqDto.getPassword()));

        userRepository.save(user);

        UserRegisterResponseDto userRegisterResponseDto = new UserRegisterResponseDto();
        userRegisterResponseDto.setUserName(userRegisterReqDto.getUsername());
        userRegisterResponseDto.setMessage("User has been registered");

        return userRegisterResponseDto;
    }
}
