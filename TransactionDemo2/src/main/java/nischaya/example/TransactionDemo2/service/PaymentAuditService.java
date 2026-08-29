package nischaya.example.TransactionDemo2.service;

import nischaya.example.TransactionDemo2.entity.Order;
import nischaya.example.TransactionDemo2.entity.PaymentAudit;
import nischaya.example.TransactionDemo2.repository.PaymentAuditRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PaymentAuditService {

    private PaymentAuditRepository paymentAuditRepository;

    public PaymentAuditService(PaymentAuditRepository paymentAuditRepository) {
        this.paymentAuditRepository = paymentAuditRepository;
    }

    @Transactional(propagation = Propagation.REQUIRED,
    isolation = Isolation.READ_UNCOMMITTED) // shares persistence context and entity manager with parent class
    public void audit(Order order){
        PaymentAudit paymentAudit =
                new PaymentAudit(order.getAmount(),order.getId(),true);

        paymentAuditRepository.save(paymentAudit);
        //throw new RuntimeException(); RollBack will occur
    }
}
