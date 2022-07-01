package com.homeworkfour.studentenrollment;

import java.util.List;

public class Student {
	
	private String name;
	private String surname;
	private int age;
	
	//Constructor
	
	public Student() {		
	}
	
	public Student(String name, String surname, int age) {
		this.name = name;
		this.surname = surname;
		this.age = age;
	}

	//Getter and Setter Methods
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public static void printList(List<Student> students) {
		for(Student item : students) {
//			System.out.println(item.getName());
			System.out.println(item.getName() + " " + item.getSurname() + " " + item.getAge());
		}
		
	}
	
}
