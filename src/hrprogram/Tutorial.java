package hrprogram;

public class Tutorial {
    
    public String tutorialID;
    public String courseID;
    public String date;
    public String startTime;
    public String endTime;
    public Casual casual;
    

    public Tutorial(String tutorialID, String courseID, String date, 
            String startTime, String endTime, Casual casual){
        
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.casual = casual;
        this.courseID = courseID;
        this.tutorialID = tutorialID;
  
    }
    
    public String getTutorialID(){
        return tutorialID;
    }

    public void getTutorialDetails() {
        // TODO Auto-generated method stub
        System.out.printf("%s\n, %s\n, %s\n, %s\n, %s\n, %s\n, %s\n, %s\n\n",
                tutorialID, courseID, date, startTime, endTime, 
                casual.getEmployeeNum(), casual.getName());
    }
    

}