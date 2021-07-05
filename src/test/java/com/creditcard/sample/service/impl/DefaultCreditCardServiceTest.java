package com.creditcard.sample.service.impl;

import com.creditcard.sample.model.CreditCard;
import com.creditcard.sample.respository.CreditCardRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest
class DefaultCreditCardServiceTest {

    @Mock
    CreditCardRepository creditCardRepository;

    @InjectMocks
    DefaultCreditCardService service = new DefaultCreditCardService();

    @BeforeEach
    void setUp() {
        when(creditCardRepository.findAll()).thenReturn(Collections.singletonList(mock(CreditCard.class)));
    }

    @Test
    @DisplayName("Test Mock CreditCardService.getAllCreditCards()")
    void getAllCreditCards() {
        assertEquals(1,service.getAllCreditCards().size());
    }

    @Test
    @DisplayName("Test Mock CreditCardService.addCreditCard()")
    void addCreditCard() {
        CreditCard creditCard = mock(CreditCard.class);
        when(creditCardRepository.save(creditCard)).thenReturn(creditCard);
        CreditCard result = service.addCreditCard(creditCard);
        verify(creditCardRepository,times(1)).save(creditCard);
        assertNotNull(result);
    }
}