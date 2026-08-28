package nischaya.example.TransactionDemo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class TransferRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long fromAccId;
    private Long toAccId;
    private BigDecimal amount;
    private LocalDate transferredAt;

    public TransferRecord(BigDecimal amount, Long fromAccId, Long toAccId, LocalDate transferredAt) {
        this.amount = amount;
        this.fromAccId = fromAccId;
        this.toAccId = toAccId;
        this.transferredAt = transferredAt;
    }
}
