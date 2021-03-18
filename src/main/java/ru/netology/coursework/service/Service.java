package ru.netology.coursework.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.netology.coursework.repository.Repository;

@org.springframework.stereotype.Service
public class Service {

    private final Repository repository;

    @Autowired
    public Service(Repository repository) {
        this.repository = repository;
    }
}
