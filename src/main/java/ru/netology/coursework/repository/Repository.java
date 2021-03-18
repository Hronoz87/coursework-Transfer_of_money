package ru.netology.coursework.repository;

import javax.annotation.PostConstruct;
import java.util.concurrent.CopyOnWriteArrayList;

@org.springframework.stereotype.Repository
public class Repository {

    CopyOnWriteArrayList<Card> cards = new CopyOnWriteArrayList<>();

    @PostConstruct
    public CopyOnWriteArrayList<Card> addCardsToList() {
        cards.add(new Card("Sberbank", "Ivan", "Ivanov", 1112 - 1111 - 1111 - 1111, 10 / 22, 100, 500.00));
        cards.add(new Card("Sberbank", "Ivas", "Ivasov", 1211 - 1111 - 1111 - 111, 10 / 22, 110, 1000.00));
        cards.add(new Card("Home", "Petr", "Petrov", 1112 - 1111 - 1111 - 1111, 10 / 22, 101, 1500.00));
        cards.add(new Card("Home", "Jon", "Jons", 1113 - 1111 - 1111 - 1111, 10 / 22, 102, 2500.00));
        cards.add(new Card("Alfa", "Smit", "Smitov", 1114 - 1111 - 1111 - 1111, 10 / 22, 103, 4500.00));
        cards.add(new Card("Alfa", "Richard", "King", 1115 - 1111 - 1111 - 1111, 10 / 22, 113, 200.00));
        cards.add(new Card("VTB", "Pons", "Ponsov", 1116 - 1111 - 1111 - 1111, 10 / 22, 125, 1800.00));
        cards.add(new Card("VTB", "Tom", "Tomson", 1117 - 1111 - 1111 - 1111, 10 / 22, 145, 5500.00));
        cards.add(new Card("Renesans", "Iv", "Love", 1118 - 1111 - 1111 - 1111, 10 / 22, 156, 6100.00));

        return cards;
    }
}
