package com.jmstest.JmsTestSpringBoot.Model;

public class Employee {
	public String name;
	public String address;
	public int id;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String name, String address, int id) {
		this.name = name;
		this.address = address;
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", address=" + address + ", id=" + id + "]";
	}
	
	
}
