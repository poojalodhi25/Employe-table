package com.pojo;
//POJO(Plain Old Java Object class/)
//DTO(Data Transfer Object Class)
public class Employe {

	private int Id;
	private String Name;
	private int age;
	public Employe() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employe(int id, String name, int age) {
		super();
		this.Id = id;
		this.Name = name;
		this.age = age;
	}
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		this.Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		this.Name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
