package ru.netology.domain;

public class Smartphone extends Product {

    private String developer;

    public Smartphone(int id, String name, double price, String developer) {
        super(id, name, price);
        this.developer = developer;
    }
}