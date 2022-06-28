//package classes;

public class MemberAccount {
	
	private int id; 
	private String name;
	private String surname;
	private double balance;
	private String phone;
	private String memberCode;
	private String code;
	
	//Constructor
	
	public MemberAccount() {		
	}
	
	public MemberAccount(int id, String name, String surname, double balance, String phone, String memberCode, String code) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.balance = balance;
		this.phone = phone;
//		this.memberCode = memberCode;
        this.memberCode = id + name.substring(0,2);
        this.code = code;

	}
	
	//getter and setter
	
	public int getId() {
		return id;
	}
	
	/*
	public void setId(int id) {
		this.id = id;
	}
	*/
	
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
	
	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getMemberCode() {
	//	setMemberCode();
		return memberCode;
	}
	
	public void setMemberCode(String memberCode){
	    this.memberCode = memberCode;
	}
	/*
	private void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
//		this.memberCode = this.id + this.name.substring(0,2);
	}
	*/
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}

}
