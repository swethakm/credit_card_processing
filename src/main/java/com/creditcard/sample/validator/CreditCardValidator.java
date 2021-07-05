package com.creditcard.sample.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Validator to Validate the Credit Card Number using Luhn 10 and other String validations
 */
public class CreditCardValidator implements ConstraintValidator<CardNumberConstraint, String> {
    @Override
    public boolean isValid(String number, ConstraintValidatorContext constraintValidatorContext) {
        final String cardNumber = number.replaceAll("\\s+", "");
        return number.length() > 20 && cardNumber.chars().allMatch(Character::isDigit) && validateCardNumber(cardNumber);
    }

    /**
     * Validates the CardNumber Using Luhn 10
     * @param cardNumber
     * @return boolean
     */
    public boolean validateCardNumber(String cardNumber){
        int[] a = {cardNumber.length() % 2 == 0 ? 1 : 2};
        boolean isValid = cardNumber
                .chars()
                .map(c -> Character.digit((char) c, 10))
                .map(n -> n * (a[0] = a[0] == 1 ? 2 : 1))
                .map(n -> n > 9 ? n - 9 : n)
                .sum() % 10 == 0;
        return isValid;
    }

}
