package nischaya.example.TransactionDemo.repository;

import nischaya.example.TransactionDemo.model.TransferRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferRepository extends JpaRepository<TransferRecord,Long> {

}
