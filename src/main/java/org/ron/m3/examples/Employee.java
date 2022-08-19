package org.ron.m3.examples;

import java.util.Objects;

public class Employee {

    private String name;
    private String address;
    private String phoneNum;
    private double salary;
    private String dept;

    public Employee(String name, String address, String phoneNum, double salary, String dept) {
        this.name = name;
        this.address = address;
        this.phoneNum = phoneNum;
        this.salary = salary;
        this.dept = dept;
    }

    // getters & setters

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Employee e)) {
            return false;
        }
        return Objects.equals(name, e.name) &&
                Objects.equals(address, e.address) &&
                Objects.equals(phoneNum, e.phoneNum) &&
                Objects.equals(dept, e.dept) &&
                salary == e.salary;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address, phoneNum, dept, salary);
    }

    public int hashCode_v3() {
        final int PRIME = 91;
        int val = name.hashCode() * PRIME;
        val *= address.hashCode() * PRIME;
        val *= phoneNum.hashCode() * PRIME;
        val *= dept.hashCode() * PRIME;
        val *= (int) salary * PRIME;
        return val;
    }

    public int hashCode_v2() {
        return name.hashCode() + address.hashCode() + phoneNum.hashCode() + dept.hashCode() + (int) salary;
    }

    public int hashCode_v1() {
        return 0;
    }
}
