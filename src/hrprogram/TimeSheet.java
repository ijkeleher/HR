package hrprogram;

public class TimeSheet {
    Tutorial tutorialID;
    int hrs;
    
    public TimeSheet(Tutorial tutorialID){
     
    }
    
    public void displayTimesheet(){
    //print class details
    System.out.println(tutorialID.tutorialID+"\n");
    System.out.println(tutorialID.courseID+"\n");
    System.out.println(tutorialID.startTime+"\n");
    System.out.println(tutorialID.endTime+"\n");
    System.out.println(tutorialID.casual+"\n");
    
    //hourly rate of the casual
    System.out.print(tutorialID.casual.hrly_rate);
    //number of hours worked
    System.out.print(hrs);
    //display total pay
    System.out.print(hrs*tutorialID.casual.hrly_rate);
    }

}
