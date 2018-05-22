package hrprogram;

public class Casual extends User{
    
	private String employeeNum;
	private String name;
	private String email;
	private String phone; 
    int hrly_rate;
    
    public Casual(String userName, String password, String employeeNum, String name, String email, String phone) {
        super(userName, password, employeeNum);
        
    }
    
    public String getName(){
    	return name; 
    }
   
    
}
