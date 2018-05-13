package hrprogram;

public class Tutorial {
    
    
    public String date;
    public String startTime;
    public String endTime;
    public Casual casual;
    public Course course;
    public String tutorialID;
    

    public Tutorial(String date, String startTime, String endTime, Casual casual,
            Course course, String tutorialID){
        
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.casual = casual;
        this.course = course;
        this.tutorialID = tutorialID;
  
    }
    
    //check in casualsMap contained in Course object
    public void setCasual(Course course) {
        
        if (course.casualsMap.containsKey(casual.getEmployeeNum())) {
            System.out.println("employee " + casual.getEmployeeNum() + " is already"
                    + "assigned to this course!\n");
            return;
        }
        
        else course.casualsMap.put(casual.getEmployeeNum(), casual);
        System.out.println("new employee" + casual.getEmployeeNum() + "added!");

    }
    
    

}