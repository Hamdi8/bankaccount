package com.example.bankaccount.application.domain;


import lombok.Builder;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "bank_account")
public class BankAccount {
    private ObjectId id;
    private float balance;
    @Indexed( unique = true)
    private String username ;
    private List<History> history ;


    public BankAccount() {

    }

    public BankAccount(ObjectId id, float balance , String username ) {
        this.id = id;
        this.balance = balance;
        this.history = new ArrayList<>() ;
        this.username=username;
    }
    public BankAccount(ObjectId id, float balance , List<History> history , String username ) {
        this.id = id;
        this.balance = balance;
        this.history = history ;
        this.username= username;
    }


    public boolean withdraw(float amount) {
        if(balance < amount ) {
            return false;
        }

        balance = balance - amount;
        return true;
    }

    public void deposit(float amount) {
        balance = balance + amount;
    }

    public float getBalance() {
        return balance;
    }

    public ObjectId getId() {
        return id;
    }

    public List<History> getHistory() {
        return history;
    }



    public void setBalance(float balance) {
        this.balance = balance;
    }

    public void setHistory(List<History> history) {
        this.history = history;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
