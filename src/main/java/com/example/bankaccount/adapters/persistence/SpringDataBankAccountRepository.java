package com.example.bankaccount.adapters.persistence;

import com.example.bankaccount.application.domain.BankAccount;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface SpringDataBankAccountRepository extends MongoRepository<BankAccount, ObjectId> {

    BankAccount findByUsername(String username);
}
