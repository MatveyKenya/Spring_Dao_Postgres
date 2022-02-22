package ru.matveykenya.spring_dao_postgres.controller;

import org.springframework.web.bind.annotation.*;
import ru.matveykenya.spring_dao_postgres.service.Service;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/products")
public class Controller {

    private final Service service;

    public Controller(Service service) {
        this.service = service;
    }

    @GetMapping("/fetch-product")
    public List<?> getProductName(@RequestParam String name){
        return service.getProductName(name);
    }
}
