package hrprogram;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Test;
import org.junit.Before;



public class DriverTest {  
    
    
    /*
     * Testing the user loading system.
     * 
     */
    
    @Test
    public void userLoadingTest(){
        Driver.loadUser();
        

    }
    
    /*
     * testing that the error checking for loadCourse is working
     * 
     *
     */ 
    
    @Test
    public void testloadCourseException() { 
       System.out.println("testing load course()");     
       Driver.loadCourse();    
    }
    
    /*
     * testing displayTimeslot
     */ 
    @Test
    public void timeSheetTest(){
        Driver d = new Driver();
        d.displayTimeSlot();
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
