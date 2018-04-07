package hrprogram;

public class Report {
    String courseID;
    String courseCoordinator;
    //listofcasuals contained in 'casuals' hashmap in course
    
    
    public Report(Course course){
        courseID = course.courseID;
        courseCoordinator = course.courseCoordinator.name;
    }

    void listCasuals(){
        
        //list casual.name, casual.employeeID and casual.hrly_rate
        
    }
    
   void listTotalHours(){
       
   }
   
   void calculateCost(){
       
   }
}
