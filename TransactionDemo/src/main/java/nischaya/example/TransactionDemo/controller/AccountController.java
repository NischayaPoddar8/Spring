package nischaya.example.TransactionDemo.controller;

import nischaya.example.TransactionDemo.model.Account;
import nischaya.example.TransactionDemo.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<String> createAccount(@RequestBody Account account){
        accountService.createAccount(account);
        return ResponseEntity.ok("Account has been created");
    }


}
