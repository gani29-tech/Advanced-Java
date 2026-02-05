package org.constructorinjection;

public class Address {
    private final String street;
    private final String city;
    private final String state;
    private final int pincode;

    public Address(String street, String city, String state, int pincode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", pincode=" + pincode +
                '}';
    }

}
