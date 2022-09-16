package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.Repository;

public class ProductManagerTest {

    Repository repo = new Repository();
    ProductManager manager = new ProductManager(repo);

    Product product1 = new Book(11, "Три мушкетера", 250.00, "Дюма");
    Product product2 = new Smartphone(1, "iPhone X", 80_000.00, "Apple");
    Product product3 = new Smartphone(5, "Nokia 999", 20_000.00, "Nokia");
    Product product4 = new Book(34, "Мастер и Маргарита", 650.00, "Булгаков");
    Product product5 = new Book(12, "Три товарища", 280.00, "Ремарк");

    @BeforeEach
    public void setup() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);
        manager.add(product5);
    }

    @Test
    public void MayFindOneProductByName() {

        Product[] expected = {product4};
        Product[] actual = manager.searchBy("Мастер и Маргарита");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void MayFindOneProductByName1() {

        Product[] expected = {product1, product5};
        Product[] actual = manager.searchBy("Три");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void MayFindOneProductByName4() {

        Product[] expected = {};
        Product[] actual = manager.searchBy("Дюна");

        Assertions.assertArrayEquals(expected, actual);
    }
}

