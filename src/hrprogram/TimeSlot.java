package hrprogram;

public class TimeSlot {
    
    public String timeSlotID;
    public String courseID;
    //public String date;
    public String timePeriod;
    public String casualUser;
    //public int duration;
    
           

    public TimeSlot(String timeSlotID, String courseID, String timePeriod, String casualUser) {
		//super();
		this.timeSlotID = timeSlotID;
		this.courseID = courseID;
		this.timePeriod = timePeriod;
		this.casualUser = casualUser;
	}

    public String getTimeSlotID(){
        return timeSlotID;
    }
    
	public void getTimeSlotDetails() {
        // TODO Auto-generated method stub
        System.out.printf("%s\n, %s\n, %s\n, %s\n",
        		timeSlotID, timePeriod, courseID,casualUser);
    }
    
	public String getCasualUser(){
		return casualUser;
	}

}