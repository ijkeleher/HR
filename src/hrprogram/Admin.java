package hrprogram;

public class Admin extends User{

	private String employeeNum;
	private String name;
	private String email;
	private String phone; 
	
    public Admin(String args_userName, String args_password, String args_employeeNum, String args_name, String args_email, String args_phone) {

    	super(args_userName, args_password, args_employeeNum,"AD");
        //System.out.println("here in Admin");        
        name = args_name;
        email = args_email; 
        phone = args_phone; 
        
    }
    
    public String getName(){
    	return name; 
    }
    
    public String getEmail(){
    	return email; 
    }
    
    public String getPhone(){
    	return phone; 
    }
    
}
