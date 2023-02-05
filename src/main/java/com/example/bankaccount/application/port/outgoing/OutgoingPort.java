package com.example.bankaccount.application.port.outgoing;

import com.example.bankaccount.application.domain.BankAccount;
import org.bson.types.ObjectId;

import java.util.Optional;

public interface OutgoingPort {
    Optional<BankAccount> load(ObjectId id);
    BankAccount loadByUsername(String username);
    void save(BankAccount bankAccount);

}
