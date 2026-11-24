package nischaya.example.SpringSecurityDemo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class studentController {

    @GetMapping // Spring sec dependency doesn't allow hitting end point without generated pass
    public ResponseEntity<String>getStudent(){
        return ResponseEntity.ok("Student returned");
    }

    @PostMapping
    public ResponseEntity<String>postStudent(){
        return ResponseEntity.ok("Student posted");
    }

    @PutMapping
    public ResponseEntity<String>updateStudent(){
        return ResponseEntity.ok("Student updated");
    }

    @DeleteMapping
    public ResponseEntity<String>deleteStudent(){
        return ResponseEntity.ok("Student deleted");
    }

    @GetMapping("/csrf")
    public CsrfToken getToken(CsrfToken csrfToken){
        return csrfToken;
    }
}
