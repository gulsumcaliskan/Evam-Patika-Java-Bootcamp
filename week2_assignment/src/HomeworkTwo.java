//import java.time.LocalDate;

public class HomeworkTwo {
	public static void main(String[] args) throws CustomException {
		
		//CRUD process; create, read, update, delete
		MemberAccountService memberAccountService = new MemberAccountService();
		
		//The member is created in member account
		MemberAccount member = new MemberAccount(1, "Rose", "Gwen", 9500.0, "+53214569878", "1ro", "1RoGw");
		
		//create method
//		MemberAccountService memberAccountServ1 = MemberAccountService.create(2, "Mary", "Stefan", 8500.0, "+51214569899", "2ma");
		
		Bill bill = new Bill();
		System.out.println("*****************");
		
	
		
		try {
		    BillService billService = new Client();
//		    Response resp = billService.payTheBill(0, "1ro", 500.0, 9500.0);		
//		    Response resp = billService.payTheBill(0, "1ro", 10500.0, 9500.0);
		    Response resp = new Response();
		    resp = billService.payTheBill(bill.getBillType(), member.getMemberCode(), bill.getAmount(), member.getBalance(), bill.getProcessDate());
		    
		    if(resp.getCode().equals("0")) {
			    System.out.println("Successfull Process. The time of the created was : " + resp.getCode() + " ----> " + resp.getDate());
		    }else if(resp.getCode().equals("1")) {
			    System.out.println("Unsuccessfull Process. The time of the created was : " + resp.getCode() + " ----> " + resp.getDate());
		    }else {
			    System.out.println("Invalid value!!!");
		    }
		}catch (Exception e){
		    System.out.println("Error message: " + e.getMessage());
		    
		}
		
		
		
		
	}

}
