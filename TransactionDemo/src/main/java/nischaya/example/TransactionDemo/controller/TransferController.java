package nischaya.example.TransactionDemo.controller;

import nischaya.example.TransactionDemo.model.TransferRecord;
import nischaya.example.TransactionDemo.service.TransferService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;

@RestController
@RequestMapping("/api/transfer")
public class TransferController {

    private TransferService transferService;

    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping
    public ResponseEntity<String>transferAmount(
            @RequestBody TransferRecord transferRecord) throws Throwable {

        transferService.transfer(transferRecord.getFromAccId(),
                transferRecord.getToAccId(),transferRecord.getAmount());

        return ResponseEntity.ok("Created Transfer Record");
    }

}
