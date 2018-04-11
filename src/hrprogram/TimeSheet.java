package hrprogram;

public class TimeSheet {
    Class classID;
    int hrs;
    
    public TimeSheet(Class classID){
     
    }
    
    public void displayTimesheet(){
    //print class details
    System.out.println(classID.classID+"\n");
    System.out.println(classID.course+"\n");
    System.out.println(classID.startTime+"\n");
    System.out.println(classID.endTime+"\n");
    System.out.println(classID.casual+"\n");
    
    //hourly rate of the casual
    System.out.print(classID.casual.hrly_rate);
    //number of hours worked
    System.out.print(hrs);
    //display total pay
    System.out.print(hrs*classID.casual.hrly_rate);
    }

}
