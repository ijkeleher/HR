package hrprogram;

import java.util.HashMap;
import java.util.Scanner;

public class Course {

   String courseID;
   CourseCoordinator courseCoordinator;
   HashMap<?, ?> casualsMap;
   
   static Scanner console = new Scanner(System.in);
       
   public void addCasual() {
           //solicit info from user
           System.out.println("Please enter a Sale ID");
           String employeeNumber = console.nextLine();

           // validate saleID
           if (casualsMap.containsKey(employeeNumber)) {
               System.out.println("employee " + employeeNumber + " is already added"
                       + "to this course!");
               return;
           }
           //solicit more info
           System.out.println("Please enter a Property Address");
           String propertyAddress = console.nextLine();
           System.out.println("Please enter Reserve Price");
           int reservePrice = Integer.parseInt(console.nextLine());

           // add new sale
           Sale s = new Sale(saleID, propertyAddress, reservePrice);

           // insert into hash map and print details
           saleMap.put(s.getSaleID(), s);
           System.out.println(
                   "\nNew Property Sale added successfully " + "for property at: \n" + s.getPropertyAddress() + "\n");

       }
   }
   
}
