package com.example.bankaccount.application.domain;

public enum OperationType {
    WITHDRAWAL("WITHDRAWAL") ,
    DEPOSIT("DEPOSIT") ;
    private String value;

    private OperationType(String value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
}
