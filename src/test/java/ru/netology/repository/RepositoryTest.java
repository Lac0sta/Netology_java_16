package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

public class RepositoryTest {

    Product product1 = new Book(11, "Три мушкетера", 250.00, "Дюма");
    Product product2 = new Smartphone(1, "iPhone X", 80_000.00, "Apple");
    Product product3 = new Smartphone(5, "Nokia 999", 20_000.00, "Nokia");
    Product product4 = new Book(34, "Мастер и Маргарита", 650.00, "Булгаков");

    @Test
    public void mayAddProduct() {

        Repository repo = new Repository();

        repo.saveProducts(product1);
        repo.saveProducts(product2);
        repo.saveProducts(product3);
        repo.saveProducts(product4);

        Product[] expected = {product1, product2, product3, product4};
        Product[] actual = repo.getProducts();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void mayRemoveProduct() {

        Repository repo = new Repository();

        repo.saveProducts(product1);
        repo.saveProducts(product2);
        repo.saveProducts(product3);
        repo.saveProducts(product4);
        repo.removeProductsById(product2.getId());

        Product[] expected = {product1, product3, product4};
        Product[] actual = repo.getProducts();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void mayRemoveProductById() {

        Repository repo = new Repository();

        repo.saveProducts(product1);
        repo.saveProducts(product2);
        repo.saveProducts(product3);
        repo.saveProducts(product4);
        repo.removeProductsById(11);

        Product[] expected = {product2, product3, product4};
        Product[] actual = repo.getProducts();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void exceptionIfArrayNotHaveSuchId() {

        Repository repo = new Repository();

        repo.saveProducts(product1);
        repo.saveProducts(product2);
        repo.saveProducts(product3);
        repo.saveProducts(product4);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeProductsById(2);
        });
    }

    @Test
    public void addNewElement() {

        Repository repo = new Repository();

        repo.saveProducts(product1);
        repo.saveProducts(product2);
        repo.saveProducts(product3);
        repo.saveProducts(product4);


        Product product5 = new Book(18, "Старик и море", 730.00, "Хемингуэй");
        repo.saveProducts(product5);

        Product[] expected = {product1, product2, product3, product4, product5};
        Product[] actual = repo.getProducts();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void exceptionIfAddProductWithSameId() {

        Repository repo = new Repository();

        repo.saveProducts(product1);
        repo.saveProducts(product2);
        repo.saveProducts(product3);
        repo.saveProducts(product4);

        Product product5 = new Book(34, "Старик и море", 730.00, "Хемингуэй");

        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            repo.saveProducts(product5);
        });

    }

}