package com.example.bankaccount.application.port.incoming;

import com.example.bankaccount.application.domain.BankAccount;
import org.bson.types.ObjectId;

public interface IncomingPort {
    void createAccount(BankAccount bankAccount) ;
    void deposit(ObjectId id, float amount);
    BankAccount getAccountById(ObjectId id) ;
    BankAccount getAccountByUsername(String username) ;
    boolean withdraw(ObjectId id, float amount);

}
