package nischaya.example.SpringSecurityPractical.controller;


import nischaya.example.SpringSecurityPractical.dto.UserRegisterReqDto;
import nischaya.example.SpringSecurityPractical.dto.UserRegisterResponseDto;
import nischaya.example.SpringSecurityPractical.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private AuthService authService;

    public UserController(AuthService authService) {
        this.authService = authService;
    }


    @GetMapping("/hello")
    public String HelloUser(){
        return "Hello";
    }

    @PostMapping("/register")
    public ResponseEntity<UserRegisterResponseDto>register(
            @RequestBody UserRegisterReqDto userRegisterReqDto)
    {
        return ResponseEntity.ok(authService.register(userRegisterReqDto));

    }

    @GetMapping("/token")
    public CsrfToken getToken(CsrfToken csrfToken){
        return csrfToken;
    }
}
