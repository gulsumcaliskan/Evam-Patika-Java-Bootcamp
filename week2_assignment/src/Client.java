//import java.util.Date;

import java.time.LocalDate;

public class Client extends BillService{
	
	
//	public boolean status = true;
	
	// payments
	
	@Override
	public Response payTheBill(int billType, String memberCode, double amount, double balance, LocalDate processDate) throws CustomException{
	
	    Response resp = new Response();	
		// check the amount 
		if(balance < amount) {
		    resp.setCode("1");
		    resp.setDate(LocalDate.now().toString());
			throw new CustomException("Insufficient Balance Exception"); // it will show the error messages
		} else {
		    resp.setCode("0");
		    resp.setDate(LocalDate.now().toString());
			//member.setBalance(member.getBalance() - member.getAmount());
		    System.out.println("The bill is paid");  // otherwise the result shown as "0".
		    
		}
		
		return resp;
	}
	
	
	//queryBill
	
	@Override
	
	public Response queryBill(int billType, String memberCode, String phone) {
		if(billType == 1){
		    System.out.println("The bill of the telephone is paid");
//		    return new Response("0", "2022-05-04"); // until the status true the result will be "0".
		} else if(billType == 2){
		    System.out.println("The bill of the internet is paid");
//		    return new Response("1", "2022-05-04");
		} else if (billType == 3){
		    System.out.println("The bill of the water is paid");
		}else {
		    System.out.println("Invalid value");
		}
		
		return new Response("0" , LocalDate.now().toString());
	}
	
	

	@Override
	
	public Response queryBill(int billType, String memberCode, String phone, double amount) {
		if(billType == 1){
		    return new Response("0" , LocalDate.now().toString());
		} else {
		    return new Response("1" , LocalDate.now().toString());
		}
	}
	
	
	//cancel payment
	@Override
	public Response cancelPayment(int billType, String memberCode, double amount, LocalDate processDate) {
		System.out.println("The process of the payment is canceled.");
		return new Response("0" , LocalDate.now().toString());
	}

}
