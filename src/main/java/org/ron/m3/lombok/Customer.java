package org.ron.m3.lombok;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Customer {

    private String name;
    private String contact;
    private String email;
    private List<String> address;
    private LocalDate startDate;
    private int discountLevel;
    private int salesLevel;

    public Customer(String name, String contact, String email, List<String> address, LocalDate startDate, int discountLevel, int salesLevel) {
        this.name = name;
        this.contact = contact;
        this.email = email;
        this.address = address;
        this.startDate = startDate;
        this.discountLevel = discountLevel;
        this.salesLevel = salesLevel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getAddress() {
        return address;
    }

    public void setAddress(List<String> address) {
        this.address = address;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public int getDiscountLevel() {
        return discountLevel;
    }

    public void setDiscountLevel(int discountLevel) {
        this.discountLevel = discountLevel;
    }

    public int getSalesLevel() {
        return salesLevel;
    }

    public void setSalesLevel(int salesLevel) {
        this.salesLevel = salesLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return discountLevel == customer.discountLevel && salesLevel == customer.salesLevel && Objects.equals(name, customer.name) && Objects.equals(contact, customer.contact) && Objects.equals(email, customer.email) && Objects.equals(address, customer.address) && Objects.equals(startDate, customer.startDate);
    }

    @Override
    public int hashCode() {
        var hash = Objects.hash(name, contact, email, address, startDate, discountLevel, salesLevel);
        return hash;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", contact='" + contact + '\'' +
                ", email='" + email + '\'' +
                ", address=" + address +
                ", startDate=" + startDate +
                ", discountLevel=" + discountLevel +
                ", salesLevel=" + salesLevel +
                '}';
    }
}
