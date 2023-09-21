package br.edu.ifnmg.pfms;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Order {
    private static Long lastInvoiceNumber = 0L;
    private Long invoiceNumber;
    private Person person;
    private ArrayList<Item> items;

    public Order() {
        this.items = new ArrayList<>();
        this.invoiceNumber = ++lastInvoiceNumber;
    }

    public BigDecimal calculateTotal() {
        BigDecimal total = BigDecimal.ZERO;

        for (Item item : this.items) {
            total = total.add(item.calculateTotal());
        }

        return total;
    }

    public void setPerson(Person person) throws Exception {
        if (person == null) {
            throw new Exception("Person cannot be null");
        }
        this.person = person;
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    private Person getPerson() {
        return this.person;
    }

    public Long getInvoiceNumber() {
        return invoiceNumber;
    }

    public void removeItem(Item item) {
        this.items.remove(item);
    }

    public ArrayList<Item> getItems() {
        return this.items;
    }

    public String getInvoiceNumberFormatted() {
        String invoiceNonFormatted = String.format("%09d", this.invoiceNumber);
        String invoiceString = invoiceNonFormatted.substring(0, 3) + "." + invoiceNonFormatted.substring(3, 6) + "." + invoiceNonFormatted.substring(6, 9);
        return invoiceString;
    }

    @Override
    public String toString() {
        String invoiceString = getInvoiceNumberFormatted();

        StringBuilder itemsString = new StringBuilder("[");

        int i = 1;
        for (Item item : this.items) {
            itemsString.append("Item ").append(i++).append(": ").append(item.toString()).append("; ");
        }

        return "Nota fiscal: " + invoiceString + "; "
                + "Cliente: " + getPerson().getName() + "; "
                + "R$ " + calculateTotal() + "; "
                + "Itens: " + itemsString.toString() + "]";
    }

}
