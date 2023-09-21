package br.edu.ifnmg.pfms;

import java.math.BigDecimal;

public class Item {
    private Product product;
    private Order order;
    private Integer amount;

    public Item() {
    }

    public Item(Product product, Integer amount) throws Exception {
        this.setProduct(product);
        this.setAmount(amount);
    }

    public BigDecimal calculateTotal() {
        return product.getPrice().multiply(new BigDecimal(amount));
    }

    //<editor-fold desc="Getters and Setters">
    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return this.order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Integer getAmount() {
        return this.amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    //</editor-fold>

    @Override
    public String toString() {
        return product.getName() + " " + amount + " x R$ " + product.getPrice() + " = R$ " + calculateTotal();
    }
}
