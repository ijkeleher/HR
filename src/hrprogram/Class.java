package hrprogram;

public class Class {
    
    
    public String date;
    public String startTime;
    public String endTime;
    public Casual casual;
    public Course course;
    public String classID;
    

    public Class(String date, String startTime, String endTime, Casual casual,
            Course course, String classID){
  
    }
    
    public void setCasual() {
        
        if (course.casualsMap.containsKey(casual)) {
            System.out.println("employee " + casual.employeeNum + " is already"
                    + "assigned to this course!\n");
            return;
        }
        
        else course.casualsMap.put(casual.employeeNum, casual);
        System.out.println("new employee" + casual.employeeNum + "added!");

    }
    
    

}