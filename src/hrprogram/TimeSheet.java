package hrprogram;

public class TimeSheet {
	TimeSlot timeSlotID;
    int hrs;
    
    public TimeSheet(TimeSlot tutorialID){
     
    }
    
    public void displayTimesheet(){
    //print class details
    System.out.println(timeSlotID.timeSlotID+"\n");
    System.out.println(timeSlotID.courseID+"\n");
    System.out.println(timeSlotID.timePeriod+"\n");
 //   System.out.println(timeSlotID.casual+"\n");
    
    //hourly rate of the casual
//    System.out.print(timeSlotID.casual.hrly_rate);
    //number of hours worked
    System.out.print(hrs);
    //display total pay
 //   System.out.print(hrs*timeSlotID.casual.hrly_rate);
    }

}
