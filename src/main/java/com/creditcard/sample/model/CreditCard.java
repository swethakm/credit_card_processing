package com.creditcard.sample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "CREDIT_CARD")
public class CreditCard {

    @Id
    @Column(name = "cardnumber")
    @NotEmpty(message = "Please provide a valid Card Number")
    private String cardNumber;

    @NotEmpty(message = "Please provide a valid Name")
    @Column(name = "name")
    private String name;

    @Column(name = "balance")
    private double balance;

    @Column(name = "cardlimit")
    private double limit;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "cardNumber='" + cardNumber + '\'' +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                ", limit=" + limit +
                '}';
    }
}
