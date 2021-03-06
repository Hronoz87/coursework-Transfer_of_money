package ru.netology.coursework.service;

import ru.netology.coursework.repository.Card;

public class CardFormDTO {

    String cardFromNumber;

    String cardFromValidTill;

    String cardFromCVV;

    String cardToNumber;

    Card.Amount amount;

    public String getCardFromNumber() {
        return cardFromNumber;
    }

    public void setCardFromNumber(String cardFromNumber) {
        this.cardFromNumber = cardFromNumber;
    }

    public String getCardFromValidTill() {
        return cardFromValidTill;
    }

    public void setCardFromValidTill(String cardFromValidTill) {
        this.cardFromValidTill = cardFromValidTill;
    }

    public String getCardFromCVV() {
        return cardFromCVV;
    }

    public void setCardFromCVV(String cardFromCVV) {
        this.cardFromCVV = cardFromCVV;
    }

    public String getCardToNumber() {
        return cardToNumber;
    }

    public void setCardToNumber(String cardToNumber) {
        this.cardToNumber = cardToNumber;
    }

    public Card.Amount getAmount() {
        return amount;
    }

    public void setAmount(Card.Amount amount) {
        this.amount = amount;
    }

}
