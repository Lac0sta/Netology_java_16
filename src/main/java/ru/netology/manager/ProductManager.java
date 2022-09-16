package ru.netology.manager;

import ru.netology.domain.Product;
import ru.netology.repository.Repository;

public class ProductManager {

    private Repository repo;

    public ProductManager(Repository repo) {
        this.repo = repo;
    }

    public void add(Product product) {
        repo.saveProducts(product);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repo.getProducts()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }

        return result;
    }

    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }

    }
}