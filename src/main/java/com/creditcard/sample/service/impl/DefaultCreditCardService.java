package com.creditcard.sample.service.impl;

import com.creditcard.sample.model.CreditCard;
import com.creditcard.sample.service.CreditCardService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultCreditCardService implements CreditCardService {
    @Override
    public List<CreditCard> getAllCreditCards() {
        return null;
    }

    @Override
    public CreditCard addCreditCard(CreditCard card) {
        return null;
    }
}
