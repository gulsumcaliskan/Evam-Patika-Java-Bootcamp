

public class CustomException extends Exception{
	
	String message; 
	
	public CustomException(String message) {
		this.message = message;
	}
	
	@Override
	
	public String getMessage() { // It will show the error messages at the console.
		//return "Insufficient balance";
		return message; 
	}
	
	
	

}
