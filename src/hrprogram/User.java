package hrprogram;

public class User {

    // login info
    private String username;
    private String password;

    // personal info
    //private String email;
    //private String name;
    private String employeeNum;
    //private  int phone;

    public User(){
    	
    }
    public User(String username, String password, String employeeNum) {

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
    


}
