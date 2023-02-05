package com.example.bankaccount.application.services;

import com.example.bankaccount.application.domain.BankAccount;
import com.example.bankaccount.application.domain.History;
import com.example.bankaccount.application.domain.OperationType;
import com.example.bankaccount.application.port.incoming.*;

import com.example.bankaccount.application.port.outgoing.OutgoingPort;

import org.bson.types.ObjectId;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

public class BankAccountService implements IncomingPort  {

    private OutgoingPort outgoingPort ;

    public BankAccountService(OutgoingPort outgoingPort) {
        this.outgoingPort = outgoingPort;
    }

    @Override
    public void deposit(ObjectId id, float amount) {
        BankAccount account = outgoingPort.load(id).orElseThrow(NoSuchElementException::new);

        History history1 = new History() ;
        history1.setAmount(amount);
        history1.setOldBalance(account.getBalance()) ;
        history1.setOperationType(OperationType.DEPOSIT);
        history1.setOperationDate(LocalDateTime.now());

        account.deposit(amount);

        history1.setNewBalance(account.getBalance());
        List<History> actualHistory = account.getHistory() ;
        actualHistory.add(history1) ;
        account.setHistory(actualHistory);

        outgoingPort.save(account);
    }

    @Override
    public boolean withdraw(ObjectId id, float amount) {
        BankAccount account = outgoingPort.load(id)
                .orElseThrow(NoSuchElementException::new);
        History history1 = new History() ;
        history1.setAmount(amount) ;
        history1.setOldBalance(account.getBalance()) ;
        history1.setOperationType(OperationType.WITHDRAWAL) ;
        history1.setOperationDate(LocalDateTime.now()) ;
        boolean hasWithdrawn = account.withdraw(amount) ;

        if(hasWithdrawn) {
            history1.setNewBalance(account.getBalance()) ;
            List<History> actualHistory = account.getHistory() ;
            actualHistory.add(history1) ;
            account.setHistory(actualHistory) ;
            outgoingPort.save(account) ;
        }
        return hasWithdrawn;
    }

    @Override
    public void createAccount(BankAccount bankAccount) {

        outgoingPort.save(bankAccount);
    }

    @Override
    public BankAccount getAccountById(ObjectId id) {
        return outgoingPort.load(id).orElseThrow(NoSuchElementException::new) ;
    }

    @Override
    public BankAccount getAccountByUsername(String username) {
        return outgoingPort.loadByUsername(username) ;
    }


}
