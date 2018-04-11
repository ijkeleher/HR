package hrprogram;

public class ApproveHire {
    Casual casual;
    Course course;
    
    public ApproveHire(Casual casual, Course course){
        
    }
    
       
//
//        //if offer accepted
//        
        public void addCasual() {
            
            if (course.casualsMap.containsKey(casual)) {
                System.out.println("employee " + casual.employeeNum + " is already"
                        + "assigned to this course!\n");
                return;
            }
            
            else course.casualsMap.put(casual.employeeNum, casual);
            System.out.println("new employee" + casual.employeeNum + "added!");

        }
;
}
