package ru.netology.money.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.netology.money.MoneyService;
import ru.netology.money.domain.CardRepository;
import ru.netology.money.domain.TransferRepository;

@Configuration
public class JavaConfig {

    @Bean
    public MoneyService moneyService(CardRepository cardRepository, TransferRepository transferRepository){
        return new MoneyService(cardRepository, transferRepository);
    }

    @Bean
    public CardRepository cardRepository(){
        return new CardRepository();
    }

    @Bean
    public TransferRepository transferRepository(){
        return new TransferRepository();
    }

}
