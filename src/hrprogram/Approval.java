package hrprogram;

public class Approval extends User{
    
    public Approval(String name, int employeeNum) {
        super(name, employeeNum);
        // TODO Auto-generated constructor stub
    }

    void sendOffer(){
        
    }
    
    void approveHire(){
        
        Casual casual = null;
        Course course = null;
        
        //to be supplied by user
        
        ApproveHire hire = new ApproveHire(casual, course);
        
        hire.addCasual();

    }
    
}
