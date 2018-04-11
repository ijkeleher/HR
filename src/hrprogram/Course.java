package hrprogram;

import java.util.HashMap;
import java.util.Scanner;

public class Course {

   String courseID;
   CourseCoordinator courseCoordinator;
   HashMap<String, Casual> casualsMap;
   
   static Scanner console = new Scanner(System.in);
   
   public Course (String courseID){
       
   }
   
   
   public void listCasuals(){
           
           if (casualsMap.isEmpty()){
               System.out.println("NoCasuals assigned for teaching in this course!\n");
           }
           // for each key in hash map retrieve the casual object
           //and it's details
           for (Object key : casualsMap.keySet()) {
               Casual c = (Casual) casualsMap.get(key);
               System.out.println(c.name+" - "+c.employeeNum+"\n");
           }
       
   }
       }
   
   

