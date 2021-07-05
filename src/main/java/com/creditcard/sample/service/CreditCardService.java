package com.creditcard.sample.service;

import com.creditcard.sample.model.CreditCard;

import java.util.List;

public interface CreditCardService {
    List<CreditCard> getAllCreditCards();

    CreditCard addCreditCard(CreditCard card);
}
