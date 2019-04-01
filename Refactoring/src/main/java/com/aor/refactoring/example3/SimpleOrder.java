package com.aor.refactoring.example3;

public class SimpleOrder {
    private final int fixed;
    private final double percentage;
    private double price;

    public SimpleOrder(double price) {
        this.price = price;
        this.fixed = 0;
        this.percentage = 0;
    }

    public SimpleOrder(double price, int discount) {
        this.price = price;
        fixed = discount;
        this.percentage = 0;
    }

    public SimpleOrder(double price, double discount) {
        this.price = price;
        this.fixed = 0;
        percentage = discount;
    }


    public double getTotal() {
        double discountedPrice = fixed > 0 ? price - fixed : price * (1-percentage);
        return discountedPrice > 0 ? discountedPrice : 0;
    }
}
