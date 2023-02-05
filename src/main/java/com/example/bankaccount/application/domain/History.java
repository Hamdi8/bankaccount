package com.example.bankaccount.application.domain;

import java.time.LocalDateTime;

public class History {
    private float amount ;
    private LocalDateTime operationDate ;
    private OperationType operationType ;
    private float oldBalance ;
    private float newBalance ;

    public float getAmount() {
        return amount;
    }

    public LocalDateTime getOperationDate() {
        return operationDate;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public float getOldBalance() {
        return oldBalance;
    }

    public float getNewBalance() {
        return newBalance;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public void setOperationDate(LocalDateTime operationDate) {
        this.operationDate = operationDate;
    }

    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }

    public void setOldBalance(float oldBalance) {
        this.oldBalance = oldBalance;
    }

    public void setNewBalance(float newBalance) {
        this.newBalance = newBalance;
    }
}
