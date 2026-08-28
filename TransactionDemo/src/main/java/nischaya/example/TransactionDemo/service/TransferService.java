package nischaya.example.TransactionDemo.service;

import nischaya.example.TransactionDemo.model.Account;
import nischaya.example.TransactionDemo.model.TransferRecord;
import nischaya.example.TransactionDemo.repository.AccountRepository;
import nischaya.example.TransactionDemo.repository.TransferRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class TransferService {

    private AccountRepository accountRepository;
    private TransferRepository transferRepository;

    public TransferService(AccountRepository accountRepository, TransferRepository transferRepository) {
        this.accountRepository = accountRepository;
        this.transferRepository = transferRepository;
    }

    @Transactional
    public void transfer(Long fromAccId,
                         Long toAccId,
                         BigDecimal amount) throws Throwable {
        Account fromAcc = accountRepository.findById(fromAccId)
                .orElseThrow(
                        ()->new RuntimeException("No such account id found")
                );

        Account toAcc = accountRepository.findById(toAccId)
                .orElseThrow(
                        ()->new RuntimeException("No such account id found")
                );

        fromAcc.debitAmount(amount);
        toAcc.creditAccount(amount);

        // Record save
        transferRepository.save(
                new TransferRecord(amount,fromAccId,toAccId, LocalDate.now())
        );
    }
}
