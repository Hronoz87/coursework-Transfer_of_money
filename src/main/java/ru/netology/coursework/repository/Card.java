package ru.netology.coursework.repository;

public final class Card {
    String bank_name;
    String nameUser;
    String lastNameUser;
    int numberCard;
    int date;
    int cvc;
    Double balance;

    public Card(String bank_name, String nameUser, String lastNameUser, int numberCard, int date, int cvc, Double balance) {
        this.bank_name = bank_name;
        this.nameUser = nameUser;
        this.lastNameUser = lastNameUser;
        this.numberCard = numberCard;
        this.date = date;
        this.cvc = cvc;
        this.balance = balance;
    }

    public String getBank_name() {
        return bank_name;
    }

    public String getNameUser() {
        return nameUser;
    }

    public String getLastNameUser() {
        return lastNameUser;
    }

    public int getNumberCard() {
        return numberCard;
    }

    public int getDate() {
        return date;
    }

    public int getCvc() {
        return cvc;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
