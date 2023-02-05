package com.example.bankaccount.adapters.persistence;

import com.example.bankaccount.application.domain.BankAccount;

import com.example.bankaccount.application.port.outgoing.OutgoingPort;

import com.example.bankaccount.exception.EntityNotFoundException;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BankAccountRepository implements OutgoingPort {

    private SpringDataBankAccountRepository repository;

    public BankAccountRepository(SpringDataBankAccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<BankAccount> load(ObjectId id) {
        return repository.findById(id);
    }

    @Override
    public void save(BankAccount bankAccount) {
        repository.save(bankAccount);
    }
    @Override
    public BankAccount loadByUsername (String username) {
        BankAccount bankAccount = repository.findByUsername(username);
        if (bankAccount == null) {
            throw new EntityNotFoundException("Cant find any object under given username" );
        }
        return bankAccount;
    }

}
