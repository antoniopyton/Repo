package it.NextDevs;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String id;
    private Customer customer;
    private List<Product> products;
    private Double totalAmount;

    public String getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public Order(Customer customer, String id) {
        this.customer = customer;
        this.id = id;
        this.products = new ArrayList<Product>();
        this.totalAmount = 0.0;
    }

    public void aggiungiProdotto(Product product) {
        this.products.add(product);
        this.totalAmount += product.getPrice();
    }


}
