package cl.duoc.daibarram.ecomarketstoreservice.service.domain;

import java.time.LocalDate;

public class Invoice {
    private int id;
    private int orderId;
    private LocalDate date;
    private double amount;

    public Invoice(int id, int orderId, LocalDate date, double amount) {
        this.id = id;
        this.orderId = orderId;
        this.date = date;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public int getOrderId() {
        return orderId;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

}
