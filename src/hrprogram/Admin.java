package hrprogram;

public class Admin extends User{

	private String employeeNum;
	private String Name;
	private String email;
	private String phone; 
	
    public Admin(String userName, String password, String employeeNum, String name, String email, String phone) {
        super(userName, password, employeeNum);
        
    }
    
    
}
