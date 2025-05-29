package cl.duoc.daibarram.ecomarketstoreservice.service.domain;

import cl.duoc.daibarram.ecomarketstoreservice.repository.entity.ProductEntity;

import java.util.List;

public class Order {
    private int id;
    private List<ProductEntity> products;
    private String status;

    public Order(int id, List<ProductEntity> products, String status) {
        this.id = id;
        this.products = products;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public List<ProductEntity> getProducts() {
        return products;
    }

    public String getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProducts(List<ProductEntity> products) {
        this.products = products;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}