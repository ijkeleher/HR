package hrprogram;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Test;
import org.junit.Before;



public class DriverTest {  
    
    
    /*
     * testing the report class takes input of object type "course"
     *  and budget estimate method works
     *  as a result of test we changed return value to double
     *  By Inci
     */
    
    @Test
    public void reportEstimateTest(){
        Course c = new Course("ISYS888", "EXAMPLE COURSE", "DAVID");

        Report r = new Report(c); 
        
        double estimatetestValue = r.calculateEstimatedBudget(12, 2, 32.50);
        assertEquals(estimatetestValue, 780.0, 0);
    }
    
    /*
     * testing that the error checking for loadCourse is working
     * by Dhiraj
     */ 
    
    @Test(expected = NoSuchElementException.class)
    public void testloadCourseException() { 
       System.out.println("testing load course()");     
       Driver.loadCourse();    
    }
    
    /*
     * public class TimeSheet {
    TimeSlot timeSlotID;
    int hrs = 2;
    
    public TimeSheet(TimeSlot timeSlotID){
        this.timeSlotID = timeSlotID;
        as a result of this test we had to fix the constructor
     */ 
    @Test
    public void timeSheetTest(){
        TimeSlot t = new TimeSlot("TSM1","10-12","COSC123","KAREN");
        TimeSheet ts = new TimeSheet(t);
        ts.displayTimesheet();
    }

    /*
     * test that timeslots are loaded from file
     * delete timeslot.txt to see if this test succeeeds
     * in creating a new textfile
     */ 
    @Test
    public void testLoadTimeSlot(){
        Driver.loadTimeSlot();
    }
    
    
    

}
