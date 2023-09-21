package br.edu.ifnmg.pfms;

public class Address {
    private AddressType type;
    private String street;
    private Integer number;
    private String neighborhood;
    private Integer zipCode;

    public Address() {
    }

    public Address(String street, AddressType type, int number, String neighborhood, int zipCode) throws Exception {
        this.setStreet(street, type);
        this.setNumber(number);
        this.setNeighborhood(neighborhood);
        this.setZipCode(zipCode);
    }

    public void setStreet(String street, AddressType type) throws Exception {
        if (street == null || street.isEmpty()) {
            throw new Exception("Street cannot be null or empty");
        } else if (street.length() > 50){
            throw new Exception("Street cannot be longer than 50 characters");
        }
        this.street = street;
        this.type = type;
    }

    public void setNeighborhood(String neighborhood) throws Exception {
        if (neighborhood == null || neighborhood.isEmpty()) {
            throw new Exception("Neighborhood cannot be null or empty");
        } else if (neighborhood.length() > 50){
            throw new Exception("Neighborhood cannot be longer than 50 characters");
        }
        this.neighborhood = neighborhood;
    }

    public void setNumber(Integer number) throws Exception {
        if (number == null) {
            throw new Exception("Number cannot be null");
        } else if (number < 0){
            throw new Exception("Number cannot be negative");
        }
        this.number = number;
    }

    public void setZipCode(Integer zipCode) throws Exception {
        if (zipCode == null) {
            throw new Exception("Zip code cannot be null");
        } else if (zipCode < 0){
            throw new Exception("Zip code cannot be negative");
        }
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return this.street;
    }

    public String getNeighborhood() {
        return this.neighborhood;
    }

    public Integer getNumber() {
        return this.number;
    }

    public Integer getZipCode() {
        return this.zipCode;
    }

    public Enum getType() {
        return this.type;
    }

    public Address(String street, AddressType type, Integer number, String neighborhood, Integer zipCode) throws Exception {
        this.setStreet(street, type);
        this.setNumber(number);
        this.setNeighborhood(neighborhood);
        this.setZipCode(zipCode);
    }

    @Override
    public String toString() {
        // xx.xxx-xxx
        String zipCode = this.zipCode.toString();
        zipCode = zipCode.substring(0, 2) + "." + zipCode.substring(2, 5) + "-" + zipCode.substring(5, 8);
        return this.type + " " + this.street + ", " + this.number + ", " + this.neighborhood + ", " + zipCode;
    }

}

