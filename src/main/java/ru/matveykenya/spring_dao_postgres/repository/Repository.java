package ru.matveykenya.spring_dao_postgres.repository;

import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@org.springframework.stereotype.Repository
public class Repository {
    private final String myScript = read("query1.sql");

    private final NamedParameterJdbcTemplate npJdbcTemplate;

    public Repository(NamedParameterJdbcTemplate npJdbcTemplate) {
        this.npJdbcTemplate = npJdbcTemplate;
    }

    public List<String> getProductName(String name){
        var queryForList = npJdbcTemplate.queryForList(myScript, Map.of("name",name));
        List<String> list = new ArrayList<>();
        for (Map<String,Object> item:queryForList) {
            list.add(item.get("product_name").toString());
        }
        return list;
    }

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
