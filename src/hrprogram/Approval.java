package hrprogram;

public class Approval extends User{
    
    public Approval(String employeeNum, String name) {
        super(employeeNum, name);
        // TODO Auto-generated constructor stub
    }

    void setIsApproved(Course course){
       course.setIsApproved();
    
}
}
