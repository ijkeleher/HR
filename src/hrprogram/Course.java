package hrprogram;

import java.util.HashMap;
import java.util.Scanner;

public class Course {

   String courseID;
   CourseCoordinator courseCoordinator;
   HashMap<String, Casual> casualsMap;
   public Timetable timetable;
   boolean isApproved = false;
   
   
   static Scanner console = new Scanner(System.in);
   
   public Course (String courseID){
       
   }
   
   void importListOfCasuals(){
       //import list of casuals from text database
   }
   
   
   public void setIsApproved(){
       isApproved = true;
   }
   
   public void setNotApproved(){
       isApproved = false;
   }
   
   

       }
   
   

