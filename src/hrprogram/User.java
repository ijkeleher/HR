package hrprogram;

//import org.omg.CORBA.ARG_IN;

public class User {

    // login info
    private String username;
    private String password;

    // personal info
    private String employeeNum;
    private String userType; 

    public User(){
    	
    }
    public User(String args_username, String args_password, String args_employeeNum, String args_userType) {
    	username = args_username;
    	password = args_password;
    	employeeNum = args_employeeNum; 
    	userType = args_userType; 
    	System.out.println("here in User()");
    }

    // getter methods 
    public String getUserName(){
        return username;
    }
    
    public String getPassword(){
        return password; 
    }
    
    // setter methods 
    public void setUserName(String args_username){
        username = args_username; 
    }
    
    public void setPassword(String args_password){
        password = args_password; 
    }

    public String getEmployeeNum() {
        return employeeNum;

    }
    
    public void setEmployeeNum(String args_empno){
        employeeNum = args_empno; 
    }
    
    public String getUserType(){
    	return userType;
    }


}
