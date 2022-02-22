package ru.matveykenya.spring_dao_postgres.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Repository
public class Repository {

    @PersistenceContext
    EntityManager entityManager;

    public List<?> getProductName(String name){

        String sqlQuery = "select o.productName, o.amount from Order o where o.customer.name = :name";   //=read("query1.sql");
        Query query = entityManager.createQuery(sqlQuery);
        query.setParameter("name", name);
        var res = query.getResultList();
        return res;
    }
}
