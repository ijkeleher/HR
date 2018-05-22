package hrprogram;

import java.util.HashMap;

public class Report {
    String courseID;
    Course course;
    String courseCoordinator;
    int totalHours;
    int totalCost;
    int estimatedBudget;
    int tutorialCost;
    
    public Report(Course course){
        this.course = course;
        this.courseID = course.courseID;
        this.courseCoordinator = course.courseCoordinator.getName();
    }

    
   void listCasuals(){
       
       course.listCasuals();
   }

   void CalculateTotalHours(){
       
     //iterate through all of the tutorials in the tutorial map and add up hrs
    /*   
       for (String key : course.timetable.tutorialsMap.keySet()) {
           Tutorial s = course.timetable.tutorialsMap.get(key);
           totalHours += s.duration;
       }
    */   
   }
   
   void calculateTotalCost(){
       
     //iterate through all of the tutorials in the tutorial map
       //then calculate the cost of the tutorial and add to totalCost
       /*
       for (String key : course.timetable.tutorialsMap.keySet()) {
           Tutorial s = course.timetable.tutorialsMap.get(key);
           tutorialCost = (s.duration*s.casual.hrly_rate);
           totalCost += tutorialCost;
       }*/
   }
   
   int calculateEstimatedBudget(int estimatedNumberOfTutorials, int estimatedDuration,
           int estimatedHrlyRate){
       
       //does the same as estimated budget but will take an input of num of tutorials
       
       estimatedBudget = (estimatedDuration*estimatedHrlyRate)*estimatedNumberOfTutorials;
       
       return estimatedBudget;

   }
}
