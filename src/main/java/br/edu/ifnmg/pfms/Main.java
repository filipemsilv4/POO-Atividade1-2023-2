package br.edu.ifnmg.pfms;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws Exception {

        // Phone
        Phone phone1_1 = null;
        Phone phone2_1 = null;
        Phone phone2_2 = null;
        Phone phone3_1 = null;
        Phone phone3_2 = null;
        try {
            phone1_1 = new Phone(new Byte("38"), 12341234);
            phone2_1 = new Phone(new Byte("38"), 23452345);
            phone2_2 = new Phone(new Byte("38"), 923452345);
            phone3_1 = new Phone(new Byte("38"), 934563456);
            phone3_2 = new Phone(new Byte("38"), 834563456);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Address
        Address a1 = null;
        Address a2 = null;
        Address a3 = null;
        Address a4 = null;
        Address a5 = null;
        Address a6 = null;
        try {
            a1 = new Address("A1", AddressType.RUA, 1011, "Santa Ana I", 39401111);
            a2 = new Address("A2", AddressType.RUA, 1012, "Santa Ana II", 39401112);
            a3 = new Address("B", AddressType.RUA, 2022, "Santa Beatriz", 39402222);
            a4 = new Address("C1", AddressType.RUA, 3031, "Santa Cecília I", 39403331);
            a5 = new Address("C2", AddressType.RUA, 3032, "Santa Cecília II", 39403332);
            a6 = new Address("C3", AddressType.RUA, 3033, "Santa Cecília III", 39403333);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Person and Credential
        Person p1 = new Person();
        Person p2 = new Person();
        Person p3 = new Person();
        Credential c1 = null;
        Credential c2 = null;
        Credential c3 = null;
        try {
            c1 = new Credential(p1, "ana.zaira@mail.com", "asdf123", true);
            c2 = new Credential(p2, "beatriz.yana@mail.com", "123asdf", false);
            c3 = new Credential(p3, "cecilia.xerxes@mail.com", "123123", false);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            p1.setName("Ana Zaira");
            p1.setBirthDate(LocalDate.of(2000, 1, 29));
            p1.setCredential(c1);
            p1.addPhone(phone1_1);
            p1.addAddress(a1);
            p1.addAddress(a2);

            p2.setName("Beatriz Yana");
            p2.setBirthDate(LocalDate.of(1999, 1, 28));
            p2.setCredential(c2);
            p2.addPhone(phone2_1);
            p2.addPhone(phone2_2);

            p3.setName("Cecília Xerxes");
            p3.setBirthDate(LocalDate.of(1998, 1, 27));
            p3.setCredential(c3);
            p3.addPhone(phone3_1);
            p3.addPhone(phone3_2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Product
        Product product1 = null;
        Product product2 = null;
        Product product3 = null;
        Product product4 = null;
        Product product5 = null;
        try {
            product1 = new Product("Abacaxi", new BigDecimal("1.99"));
            product2 = new Product("Banana", new BigDecimal("2.99"));
            product3 = new Product("Caqui", new BigDecimal("3.99"));
            product4 = new Product("Damasco", new BigDecimal("4.99"));
            product5 = new Product("Espinafre", new BigDecimal("5.99"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Item
        Item p1o1i1 = new Item(product1, 11);

        Item p2o1i1 = new Item(product2, 11);
        Item p2o1i2 = new Item(product3, 12);
        Item p2o1i3 = new Item(product4, 13);
        Item p2o1i4 = new Item(product5, 14);

        Item p2o2i1 = new Item(product1, 21);
        Item p2o2i2 = new Item(product3, 22);
        Item p2o2i3 = new Item(product5, 23);

        Item p3o1i1 = new Item(product1, 31);
        Item p3o1i2 = new Item(product3, 32);
        Item p3o1i3 = new Item(product5, 33);

        // Order
        Order p1o1 = new Order();
        Order p2o1 = new Order();
        Order p2o2 = new Order();
        Order p3o1 = new Order();

        try {
            p1o1.setPerson(p1);
            p2o1.setPerson(p2);
            p2o2.setPerson(p2);
            p3o1.setPerson(p3);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        p1o1.addItem(p1o1i1);

        p2o1.addItem(p2o1i1);
        p2o1.addItem(p2o1i2);
        p2o1.addItem(p2o1i3);
        p2o1.addItem(p2o1i4);

        p2o2.addItem(p2o2i1);
        p2o2.addItem(p2o2i2);
        p2o2.addItem(p2o2i3);

        p3o1.addItem(p3o1i1);
        p3o1.addItem(p3o1i2);
        p3o1.addItem(p3o1i3);

        try {
            p1.addOrder(p1o1);
            p2.addOrder(p2o1);
            p2.addOrder(p2o2);
            p3.addOrder(p3o1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        // Print
        // Credential
        System.out.println("Test Print: \n");
        System.out.println("Credentials:");
        System.out.println(p1.getCredential());
        System.out.println(p2.getCredential());
        System.out.println(p3.getCredential());

        // Address
        System.out.println("\nAddresses:");
        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);

        // Phone
        System.out.println("\nPhones:");
        System.out.println(p1.getPhones().get(0));
        System.out.println(p2.getPhones().get(0));
        System.out.println(p2.getPhones().get(1));

        // Product
        System.out.println("\nProducts:");
        System.out.println(product1);
        System.out.println(product2);
        System.out.println(product3);

        // Item
        System.out.println("\nItems:");
        System.out.println(p1o1i1);
        System.out.println(p2o1i1);
        System.out.println(p2o1i2);

        // Order
        System.out.println("\nOrders:");
        System.out.println(p1o1);
        System.out.println(p2o1);
        System.out.println(p2o2);

        // Person
        System.out.println("\nPersons:");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
    }
}