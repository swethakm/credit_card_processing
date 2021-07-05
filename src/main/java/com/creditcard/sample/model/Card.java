package com.creditcard.sample.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Card {

    @Id
    private String cardnumber;
    private String name;
    private double balance;
    private double cardlimit;

    public String getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber;
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

    public double getCardlimit() {
        return cardlimit;
    }

    public void setCardlimit(double cardlimit) {
        this.cardlimit = cardlimit;
    }
}
