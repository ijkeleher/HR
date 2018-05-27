package hrprogram;

public class Casual extends User{
    
	private String employeeNum;
	private String name;
	private String email;
	private String phone; 
	private String username; 
    int hrly_rate;
    
    public Casual(String userName, String password, String employeeNum, String args_name, String args_email, String args_phone) {
        super(userName, password, employeeNum,"CA");
        //System.out.println("here in Casual");        
        name = args_name;
        email = args_email; 
        phone = args_phone; 
        hrly_rate = 0; 
        this.employeeNum = employeeNum; 
        this.username = userName;
    }

    public String getEmployeeNum(){
    	return employeeNum; 
    }
    
    public String getUserName(){
    	return username; 
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
    
    public void setHrly_rate(int args_hrly_rate){
    	hrly_rate = args_hrly_rate; 
    }
    public int getHrly_rate(){
    	return hrly_rate; 
    }
    
    public String getDetails(){
    	String casualName = " " + name;
    	return casualName;
	}
    
}
