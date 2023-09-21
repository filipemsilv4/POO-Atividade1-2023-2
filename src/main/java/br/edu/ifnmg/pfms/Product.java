package br.edu.ifnmg.pfms;

import java.math.BigDecimal;

public class Product {
    private String name;
    private BigDecimal price;

    @Override
    public String toString() {
        return name + " R$ " + price.toString();
    }

    public Product(String name, BigDecimal price) throws Exception {
        this.setName(name);
        this.setPrice(price);
    }

    public Product() {
    }

    //<editor-fold desc="Getters and Setters">
    public BigDecimal getPrice() {
        return this.price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public String getName() {
        return this.name;
    }

    public void setName(String name) throws Exception {
        if (name == null || name.isEmpty()) {
            throw new Exception("Name cannot be null or empty");
        } else if (name.length() > 150){
            throw new Exception("Name cannot be longer than 150 characters");
        }

        this.name = name;
    }
    //</editor-fold>
}
