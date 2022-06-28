package solution.weekthree;

public class Student {
	
	private int id;
	private String name;
	private double cgpa;
	
	// Constructor
	public Student(int id, String name, double cgpa) {
		this.id = id;
		this.name = name;
		this.cgpa = cgpa;
	}
	
	// Getter Methods
	
	public int getID() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public double getCGPA() {
		return this.cgpa;
	}
	
	// Setter Methods
	
	/*
	public void setID(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setCGPA(double cgpa) {
		this.cgpa = cgpa;
	}
	*/

}
