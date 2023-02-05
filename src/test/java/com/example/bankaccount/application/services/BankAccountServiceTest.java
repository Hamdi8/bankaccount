package com.example.bankaccount.application.services;

import com.example.bankaccount.application.domain.BankAccount;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class BankAccountServiceTest {

    @Autowired
    private BankAccountService bankAccountService ;
    private BankAccount bankAccount ;
    private float amount  ;

    @BeforeEach
    public void prepare() {
        amount = 1000 ;
        try {
            bankAccount = bankAccountService.getAccountByUsername("testAccount");
        }
        catch( Exception ex ) {
            bankAccount = new BankAccount(new ObjectId() , amount , "testAccount") ;
            bankAccountService.createAccount(bankAccount);
        }
    }

    @Test
    public void deposit_with_success () {
        Float oldBalance = bankAccount.getBalance() ;
        bankAccountService.deposit( bankAccount.getId() , amount );
        BankAccount ba =  bankAccountService.getAccountById(bankAccount.getId()) ;
        assertNotNull(ba.getId());
        assertTrue( oldBalance + amount == ba.getBalance() );
    }
    @Test
    public void withdraw_with_success () {
        Float oldBalance = bankAccount.getBalance() ;
        bankAccountService.withdraw( bankAccount.getId() , amount );
        BankAccount ba =  bankAccountService.getAccountById(bankAccount.getId()) ;
        assertNotNull(ba.getId());
        assertTrue( oldBalance - amount == ba.getBalance() );
    }
}