package ru.matveykenya.spring_dao_postgres.service;

import org.springframework.stereotype.Component;
import ru.matveykenya.spring_dao_postgres.repository.Repository;
import java.util.List;

@org.springframework.stereotype.Service
public class Service {
    private final Repository repository;

    Service(Repository repository){
        this.repository = repository;
    }

    public List<?> getProductName(String name) {
        return repository.getProductName(name);
    }
}
