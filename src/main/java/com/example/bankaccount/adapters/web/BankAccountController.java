package com.example.bankaccount.adapters.web;

import com.example.bankaccount.application.domain.BankAccount;
import com.example.bankaccount.application.port.incoming.*;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class BankAccountController {

    private final IncomingPort incomingPort;


    public BankAccountController(IncomingPort incomingPort ) {
        this.incomingPort = incomingPort;

    }

    @PostMapping("/{balance}/{username}")
    void createAccount(@PathVariable final float balance , @PathVariable final String username) {
        BankAccount bankAccount = new BankAccount(new ObjectId() , balance , username) ;
        incomingPort.createAccount(bankAccount);
    }

    @PostMapping(value = "/{id}/deposit/{amount}")
    void deposit(@PathVariable final ObjectId id, @PathVariable final float amount) {
        incomingPort.deposit(id, amount);
    }

    @PostMapping(value = "/{id}/withdraw/{amount}")
    void withdraw(@PathVariable final ObjectId id, @PathVariable final float amount) {
        incomingPort.withdraw(id, amount);
    }
    @GetMapping(value ="/{username}")
    BankAccount getAccountByUsername (@PathVariable final String username){
        return incomingPort.getAccountByUsername(username) ;
    }
}
