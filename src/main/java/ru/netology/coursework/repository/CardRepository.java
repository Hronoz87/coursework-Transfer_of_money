package ru.netology.coursework.repository;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;

@Repository
public class CardRepository {

    public CopyOnWriteArrayList<Card> cards = new CopyOnWriteArrayList<>();
    public ConcurrentMap<String, String> repositoryCodeAndId = new ConcurrentHashMap<>();

    Card card1 = new Card("1112111111111111", "1022", "100", new Card.Amount(1500, "rub"));
    Card card2 = new Card("1211111111111111", "1022", "110", new Card.Amount(500, "rub"));
    Card card3 = new Card("1112111111111111", "1022", "101", new Card.Amount(700, "rub"));
    Card card4 = new Card("1113111111111111", "1022", "102", new Card.Amount(2500, "rub"));
    Card card5 = new Card("1114111111111111", "1022", "103", new Card.Amount(11400, "rub"));
    Card card6 = new Card("1115111111111111", "1022", "113", new Card.Amount(11500, "rub"));
    Card card7 = new Card("1116111111111111", "1022", "125", new Card.Amount(15000, "rub"));
    Card card8 = new Card("1117111111111111", "1022", "145", new Card.Amount(15050, "rub"));
    Card card9 = new Card("1118111111111111", "1022", "156", new Card.Amount(15500, "rub"));


    @PostConstruct
    public CopyOnWriteArrayList<Card> addCardsToList() {
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);
        cards.add(card6);
        cards.add(card7);
        cards.add(card8);
        cards.add(card9);

        return cards;
    }


}
