package hrprogram;

public class User {

    // login info
    private String username;
    private String password;

    // personal info
    private String email;
    private String name;
    private String employeeNum;
    private  int phone;

    public User(String employeeNum, String name) {

    }

    public String getEmployeeNum() {
        return employeeNum;

    }
    
    public String getName() {
        return name;

    }

}
