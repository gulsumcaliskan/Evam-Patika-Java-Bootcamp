//package Services

//import Classes.MemberAccount;

public class MemberAccountService {
	
	//CRUD methods are written
	
	//MemberAccount member = new MemberAccount();
	// create
	
	public static MemberAccountService create(int id, String name, String surname, double balance, String phone, String memberCode) { //MemberAccount member
//		System.out.println(member.getMemberCode() + " account of the member is created");
		System.out.println("The member is created");
		return null;
	}
	
	//read
	
	public static void read(MemberAccount member) {
		System.out.println("The information of the member is listed");
	}
	
	// update
	
	public static void update(MemberAccount member, MemberAccount newMember) {
		System.out.println(member.getMemberCode() + " the information of the member's account is updated");
	}
	
	
	//delete 
	public static void delete(int id) {
		System.out.println(id + " the information about the member's account is deleted");
	}
	
	
}
