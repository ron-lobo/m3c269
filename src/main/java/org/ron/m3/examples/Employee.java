package org.ron.m3.examples;

import java.util.Objects;

public class Employee {

    private final String name;
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

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", salary=" + salary +
                ", dept='" + dept + '\'' +
                '}';
    }

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
