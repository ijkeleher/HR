package hrprogram;

import java.util.HashMap;

public class Report {
    String courseID;
    String courseCoordinator;
    //listofcasuals contained in 'casuals' hashmap must be changed to fetch the list in course
    HashMap<String, Casual> casualsMap;
    int totalHours;
    int totalCost;
    
    public Report(Course course){
        courseID = course.courseID;
        courseCoordinator = course.courseCoordinator.getName();
    }

    public void listCasuals(){
        
        if (casualsMap.isEmpty()){
            System.out.println("NoCasuals assigned for teaching in this course!\n");
        }
        // for each key in hash map retrieve the casual object
        //and it's details
        for (Object key : casualsMap.keySet()) {
            Casual c = (Casual) casualsMap.get(key);
            System.out.println(c.getName()+" - "+c.getEmployeeNum()+"\n");
        }
    
}    
   void CalculateTotalHours(){
       
       //hourse worked so far by all casuals
       
   }
   
   void calculateTotalCost(){
       //calculator cost based on work performed so far
   }
   
   void calculateEstimatedBudget(){
       //calculator a hypothetical totalCost based on total number of tutorials
       //in the semester and the hrly rates of casuals
       
      //will need to calculate some kind of numOfClasses int 
       //by estimating num of classes a week * 11 or 12 weeks
   }
}
