//import java.util.Date;

import java.time.LocalDate;

public abstract class BillService {
	
	public abstract Response payTheBill(int billType, String memberCode, double amount, double balance, LocalDate processDate) throws CustomException;
    public abstract Response queryBill(int billType, String memberCode, String phone);
    public abstract Response queryBill(int billType, String memberCode, String phone, double amount);
    public abstract Response cancelPayment(int billType, String memberCode, double amount, LocalDate processDate); 
}
