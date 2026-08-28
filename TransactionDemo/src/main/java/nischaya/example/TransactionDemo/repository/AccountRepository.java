package nischaya.example.TransactionDemo.repository;

import nischaya.example.TransactionDemo.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {

}
