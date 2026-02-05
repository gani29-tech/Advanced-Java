package org.constructorinjection;

public class Employee {
    private final int id;
    private final String name;
    private Address address;
    public Employee(int id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    void show() {
        System.out.println("Employee id: " + id);
        System.out.println("Employee name: " + name);
        System.out.println("Employee address: " + address.toString());
    }
}
