package nischaya.example.TransactionDemo.service;

import nischaya.example.TransactionDemo.model.Account;
import nischaya.example.TransactionDemo.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void createAccount(Account account){
        accountRepository.save(account);
    }
}
