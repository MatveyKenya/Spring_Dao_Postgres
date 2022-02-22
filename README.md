Задача Две таблицы с Hibernate
---
---
две Entity, соответствующие двум таблицам из задания.

(Entity: OneToOne, OneToMany, ManyToOne, ManyToMany)

теперь с EntityManager, а не через NamedParameterJdbcTemplate.

---
метод должен уметь обрабатывать запрос вида

localhost:8080/products/fetch-product?name=Ivan. Контроллер должен будет возвращать название продукта, который он получит от репозитория.