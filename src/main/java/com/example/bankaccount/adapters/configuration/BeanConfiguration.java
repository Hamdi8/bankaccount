package com.example.bankaccount.adapters.configuration;


import com.example.bankaccount.BankaccountApplication;
import com.example.bankaccount.adapters.persistence.BankAccountRepository;
import com.example.bankaccount.application.services.BankAccountService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = BankaccountApplication.class)
public class BeanConfiguration {

    @Bean
    BankAccountService bankAccountService(BankAccountRepository repository) {
        return new BankAccountService(repository);
    }
}
