package ru.matveykenya.spring_dao_postgres.service;

import ru.matveykenya.spring_dao_postgres.repository.Repository;

import java.util.List;

@org.springframework.stereotype.Service
public class Service {
    Repository repository;

    Service(Repository repository){
        this.repository = repository;
    }

    public List<String> getProductName(String name) {
        return repository.getProductName(name);
    }
}
