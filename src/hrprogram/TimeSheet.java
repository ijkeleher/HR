package hrprogram;

import java.util.ArrayList;

public class TimeSheet {
	TimeSlot timeSlotID;
    int hrs;
    
    public TimeSheet(){
     
    }
    
    public void displayTimesheet(ArrayList<TimeSlot> timeSlotArray,ArrayList<User> userInfoArray ){
    	
		for (TimeSlot t : timeSlotArray) {
			t.getTimeSlotDetails();
			for (User u : userInfoArray) {
				if (u instanceof Casual) {
					if (t.getCasualUser().equals(((Casual)u).getUserName())){
						System.out.print(", "+((Casual) u).getDetails());
						System.out.print(", "+(((Casual) u).getHrly_rate())*2);
					}
				} 
			}
		} 
		System.out.println();
    }
    
    public void getTimeTableDetails(ArrayList<User> userInfoArray){
    //System.out.printf("%s, %s, %s, %s",timeSlotID, timePeriod, courseID,casualUser);
    }

}
