package hrprogram;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class UserInterface {
    
    public static void viewTimetable(Timetable timetable){
        
        timetable.listTutorials();
    }
   
    /*public static void mainMenu(){
    	  
    	  

      }*/
        
        //driver to ui and then back to driver for menus
        
        //timetable object has a tutorialsMap containing all tutorial objects which have getTutorialDetails method
        //you can also fetch the tutorial name if you need it using getTutorialID()
        
    
    
    static void viewTimeSheet(TimeSheet timesheet){
        
        timesheet.displayTimesheet();
        
    }
  
    /*
    static void viewListOfCasuals(Course course){
        
        course.listCasuals();
        
    }
    */
    static void viewReport(Report report){
        
     //   report.listCasuals();
        
        report.CalculateTotalHours();
        
        report.calculateTotalCost(); 
        
        //calculateEstimatedBudget method requires input form the user
        //report.calculateEstimatedBudget(estimatedNumberOfTutorials, estimatedDuration, estimatedHrlyRate)
        
        //report has listCasuals, calculatetotalCost and CalculateEstimatedBudget methods
        
    }
}

