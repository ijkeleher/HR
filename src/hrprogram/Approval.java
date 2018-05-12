package hrprogram;

public class Approval extends User{
    
    public Approval(String name, int employeeNum) {
        super(name, employeeNum);
        // TODO Auto-generated constructor stub
    }

    void setIsApproved(Course course){
       course.setIsApproved();
    
}
}
