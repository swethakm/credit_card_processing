package com.creditcard.sample.service.impl;

import com.creditcard.sample.model.CreditCard;
import com.creditcard.sample.respository.CreditCardRepository;
import com.creditcard.sample.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of CreditCard Services 
 */
@Service
public class DefaultCreditCardService implements CreditCardService {

    private CreditCardRepository creditCardRepository;

    /**
     * returns all Credit Cards
     * @return List
     */
    @Override
    public List<CreditCard> getAllCreditCards() {
        return getCreditCardRepository().findAll();
    }

    /**
     * Adds new Credit Card
     * @param card
     * @return
     */
    @Override
    public CreditCard addCreditCard(CreditCard card) {
        card.setBalance(0.0);
        return getCreditCardRepository().save(card);
    }

    public CreditCardRepository getCreditCardRepository() {
        return creditCardRepository;
    }

    @Autowired
    public void setCreditCardRepository(CreditCardRepository creditCardRepository) {
        this.creditCardRepository = creditCardRepository;
    }
}
