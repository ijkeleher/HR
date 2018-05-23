package hrprogram;

public class Casual extends User{
    
	private String employeeNum;
	private String name;
	private String email;
	private String phone; 
    int hrly_rate;
    
    public Casual(String userName, String password, String employeeNum, String args_name, String args_email, String args_phone) {
        super(userName, password, employeeNum,"CA");
        System.out.println("here in Casual");        
        name = args_name;
        email = args_email; 
        phone = args_phone; 
        hrly_rate = 0; 
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
}
