package hrprogram;

public class Approval extends User{
    
	private String employeeNum;
	private String Name;
	private String email;
	private String phone; 
	
    public Approval(String userName, String password, String employeeNum, String name, String email, String phone) {
        super(userName, password, employeeNum);
        
    }

    void setIsApproved(Course course){
       course.setIsApproved();
    
}
}
