package br.edu.ifnmg.pfms;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

public class Person {
    private String name;
    private Credential credential;
    private ArrayList<Phone> phones = new ArrayList<>();
    private ArrayList<Address> addresses = new ArrayList<>();

    private ArrayList<Order> orders = new ArrayList<>();
    private LocalDate birthDate;

    public Person() {}
    public Person(String name, Credential credential, LocalDate birthDate) throws Exception {
        this.setName(name);
        this.setBirthDate(birthDate);

    }

    public void setCredential(Credential credential) throws Exception {
        if (credential == null) {
            throw new Exception("Credential cannot be null");
        }
        this.credential = credential;
    }

    public Credential getCredential() {
        return this.credential;
    }

    public void setName(String name) throws Exception {
        if (name == null || name.isEmpty()) {
            throw new Exception("Name cannot be null or empty");
        } else if (name.length() > 45){
            throw new Exception("Name cannot be longer than 45 characters");
        }
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void addPhone(Phone phone) throws Exception {
        if (phone == null) {
            throw new Exception("Phone cannot be null");
        }
        this.phones.add(phone);
    }

    public void addOrder(Order order) throws Exception {
        if (order == null) {
            throw new Exception("Order cannot be null");
        }
        this.orders.add(order);
    }

    public ArrayList<Phone> getPhones() {
        return this.phones;
    }

    public void addAddress(Address address) throws Exception {
        if (address == null) {
            throw new Exception("Address cannot be null");
        }
        this.addresses.add(address);
    }

    public void setBirthDate(LocalDate birthDate) throws Exception {
        if (birthDate == null) {
            throw new Exception("Birth date cannot be null");
        } else if (birthDate.isAfter(LocalDate.now())) {
            throw new Exception("Birth date cannot be in the future");
        }
        this.birthDate = birthDate;
    }

    public BigDecimal calculateTotalSpent() {
        BigDecimal total = BigDecimal.ZERO;

        for (Order order : this.orders) {
            total = total.add(order.calculateTotal());
        }

        return total;
    }

    public LocalDate getBirthDate() {
        return this.birthDate;
    }

    @Override
    public String toString() {
        String adminStatus = this.credential.isAdmin() ? "Administrador" : "Usuário geral";
        StringBuilder addressessString = new StringBuilder("[");
        for (Address address : this.addresses) {
            addressessString.append(address.toString()).append("; ");
        }
        addressessString.append("]");

        StringBuilder phonesString = new StringBuilder("[");
        for (Phone phone : this.phones) {
            phonesString.append(phone.toString()).append("; ");
        }
        phonesString.append("]");

        StringBuilder ordersString = new StringBuilder("[");
        for (Order order : this.orders) {
            ordersString.append((order.getInvoiceNumberFormatted()))
                    .append(", ")
                    .append("R$ ")
                    .append(order.calculateTotal().toString())
                    .append("; ");
        }
        ordersString.append("]");

        String birthDateStr = String.format("%02d", this.birthDate.getDayOfMonth()) + "/" + String.format("%02d", this.birthDate.getMonthValue()) + "/" + this.birthDate.getYear();
        return this.name + ", " + birthDateStr + ", "
                + birthDate.until(LocalDate.now()).getYears() + " anos, "
                + getCredential().getEmail() + ", "
                + "Senha: '" + getCredential().getPassword() + "', "
                + adminStatus + ", Endereços: " + addressessString + ", "
                + "Telefones: " + phonesString + ", "
                + "Gasto total: R$ " + calculateTotalSpent() + ", "
                + "Compras: " + ordersString;
    }
}
