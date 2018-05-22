package hrprogram;

public class CourseCoordinator extends User{
    
	private String employeeNum;
	private String name;
	private String email;
	private String phone; 
	
    public CourseCoordinator(String userName, String password, String employeeNum, String name, String email, String phone) {
        super(userName, password, employeeNum);
        
    }

    public String getName(){
    	return name; 
    }
   
}
