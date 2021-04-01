package be.intecbrussel.dumbstarbucks.v1.models;

import java.math.BigDecimal;

public abstract class MenuItem {

    public enum Size {
        SMALL, MEDIUM, LARGE, FAMILY
    }

    private final String name;
    private BigDecimal price;
    private Size size;

    public MenuItem(String name, BigDecimal price) {
        this(name, price, Size.MEDIUM);
    }

    public MenuItem(String name, BigDecimal price, Size size) {
        this.name = name;
        this.price = price;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Size getSize() {
        return size;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public void setDiscount(Double discountRate) {
        final BigDecimal discountedPrice = this.getPrice().multiply(BigDecimal.valueOf(discountRate));
        this.setPrice(discountedPrice);
    }

    public MenuItem withDiscount(Double discountRate) {
        this.setDiscount(discountRate);
        return this;
    }

    public MenuItem withSize(Size size) {
        this.size = size;
        return this;
    }

    public MenuItem withPrice(BigDecimal price) {
        this.setPrice(price);
        return this;
    }
}
