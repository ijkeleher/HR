package hrprogram;

public class UserInterface {
    
    void viewTimetable(Course course){
        
        course.timetable.listTutorials();
        
        //timetable object has a tutorialsMap containing all tutorial objects which have getTutorialDetails method
        //you can also fetch the tutorial name if you need it using getTutorialID()
        
    }
    
    void viewTimeSheet(TimeSheet timesheet){
        
        timesheet.displayTimesheet();
        
    }
    
    void viewListOfCasuals(Course course){
        
        course.listCasuals();
        
    }
    
    void viewReport(Report report){
        
        report.listCasuals();
        
        report.CalculateTotalHours();
        
        report.calculateTotalCost(); 
        
        //calculateEstimatedBudget method requires input form the user
        //report.calculateEstimatedBudget(estimatedNumberOfTutorials, estimatedDuration, estimatedHrlyRate)
        
        //report has listCasuals, calculatetotalCost and CalculateEstimatedBudget methods
        
    }
}

