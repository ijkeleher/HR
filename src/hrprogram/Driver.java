package hrprogram;

/**
 * this is a new HR system for RMIT created by Inci, Dhiraj, Serena and Shuoyu
 * for Software Engineering Fundamentals Sem 1 2018
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.*;
import java.util.ArrayList;


public class Driver {
    
    
    static ArrayList<Driver> userInfoArray = new ArrayList<Driver>();
           public String username;
           public String password;  
           
           public Driver (){
               
           }
           
           public Driver (String args_username, String args_password){
               username = args_username;
               password = args_password; 
           }
    
           // getter methods 
            public String getUserName(){
                return username;
            }
            
            public String getPassword(){
                return password; 
            }
            
            // setter methods 
            public void setUserName(String args_username){
                username = args_username; 
            }
            
            public void setPassword(String args_password){
                password = args_password; 
            }
            
        public static void main(String[] args) {
            
            //course, coordinator and schedule pre-created for testing purposes

            Course SEFCOSC2537 = new Course("SEFCOSC253");
            CourseCoordinator Andrew = new CourseCoordinator("Andrew", "e4545416");
            Timetable SEFschedule = new Timetable(SEFCOSC2537, Andrew);
            
            
            //load();
            Driver d = new Driver(); 
            
            Scanner inputChoice = new Scanner(System.in);
            Scanner inputUserName = new Scanner(System.in);
            Scanner inputPassword = new Scanner(System.in);
            
            System.out.println("*** Welcome to HR Management System. ***" + "\n" + "\n" + "\n");
            System.out.println("If you have an existing account            1" + "\n");
            System.out.println("If you want to create a new account        2" + "\n");
            System.out.println("Exit Program            X" + "\n");

            Scanner menuValue = new Scanner(System.in);
            String enteredValue = "";
            
            
            do {

                System.out.println("Enter a value");
                enteredValue = menuValue.next();

                switch (enteredValue) {
                case "1":
                    System.out.println("Existing Account");

                    System.out.println("Enter the username: ");
                    d.username = inputUserName.nextLine();      

                    if (d.username.isEmpty()) {
                        System.out.println("\nNothing was entered for the UserName, Please try again.");
                        d.username = inputUserName.nextLine();
                    }
                    
                    if (!(d.username.isEmpty()) && d.userNameDuplicate(d.username)){
                        System.out.println("Enter the password: ");
                        d.password = inputPassword.nextLine();
                                            
                        //check if password is correct 
                        System.out.println(d.getUserInfo(d.username).getPassword());
                        if (d.password.equals(d.getUserInfo(d.username).getPassword())){
                            // password matches
                            System.out.println("You are logged in");
                        } else {
                            System.out.println("Password does not match ");
                        }
                        
                    } else {
                        System.out.println("This username does not exist");
                    }

                    
                    break;
                case "2":
                    System.out.println("Creating Account");

                    System.out.println("Enter the username: ");
                    d.username = inputUserName.nextLine();      

                    if (d.username.isEmpty()) {
                        System.out.println("\nNothing was entered for the UserName, Please try again.");
                        d.username = inputUserName.nextLine();
                    }

                    //check for username duplicity 
                    if (!(d.username.isEmpty()) && !(d.userNameDuplicate(d.username))){
                        //continue
                        
                        System.out.println("Enter the password: ");
                        d.password = inputPassword.nextLine();
                    } else {
                        System.out.println("UserName already exist, Choose another User Name");
                    }
            
                    //adding user details to the array list 
                    Driver d1 = new Driver(d.username,d.password); 
                    d.userInfoArray.add(d1);    
                    break;

                case "X":
                case "x":
/*
                    try{
                    FileWriting();
                    System.out.println("Save and Exit");
                    } catch (FileNotFoundException fe){
                        //throw OfferException("File Not Found");
                        System.out.println("File Not Found" );
                    }
*/              }               

            } while (!(enteredValue.toUpperCase().equals("X")));

            
        }
        
        
        //checks if the username exists in the arraylist 
        
        public boolean userNameDuplicate(String arg_username) {

            boolean userNameFound = false;
            
            //System.out.println("In if duplicate check Array Size"+userInfoArray.size());
            
            for (int i = 0; i < userInfoArray.size(); i++) {

                String currentUserName = ((Driver) userInfoArray.get(i)).getUserName();

                if (arg_username.toUpperCase().equals(currentUserName.toUpperCase())) {

                    userNameFound = true;
                    break;

                } else {
                    userNameFound = false;
                }
            }

            return userNameFound;
        }


        public Driver getUserInfo(String arg_username) {
            for (Driver d0 : userInfoArray) {
                if (d0.getUserName().toUpperCase().equals(arg_username.toUpperCase())) {
                    return d0;
                }
            }

            return null;
        }
        
        
        /*Writing arraylist into a file
         * 
         */
        public static void FileWriting() throws FileNotFoundException {
            // TODO Auto-generated method stub
            String filename = "backup.txt"; // path & filename
            //C:\Users\Dhiraj\workspace\Sem2\SEF
            PrintWriter outputStream = null;

            try {
                // create a new object of the printWriter class & assign to the
                // Object variable
                outputStream = new PrintWriter(new FileOutputStream(filename));

                for (Driver d0 : userInfoArray) {
                        outputStream.print(d0.getUserName()+ ",");
                        outputStream.print(d0.getPassword()); 
                        outputStream.println();
                }
                System.out.println("Yeah! File was written to without error");

            } catch (FileNotFoundException e) {
                // display the inbuilt error message belonging to e object
                System.out.println(e);
            } // end try catch
            outputStream.close(); // close the stream
        }

        
        //load values from the txt file 
        private static void load() {
            Scanner inputStream = null; // create object variable

            try { // create Scanner object & assign to variable
                inputStream = new Scanner(new File("backup.txt"));
                inputStream.useDelimiter(",");
            } catch (FileNotFoundException e) {
                System.out.println("No User Infomation was Loaded");
                //System.exit(0);
                return;
            }

            try{
                while (inputStream.hasNext()) {
                            System.out.println(inputStream.toString());
                          String readUserName = inputStream.next();
                          String readPassword = inputStream.next();
                          
                          Driver d1 = new Driver(readUserName, readPassword);
                          
                          userInfoArray.add(d1);
 
                } 
            } catch (IllegalStateException e){
                System.err.println("Could not read from the file");
            } catch (InputMismatchException e){
                System.err.println("Something wrong happened while reading the file");
            }
            inputStream.close();
        }       

    
   void modifyTimetable(Timetable timetable){
       
       //use the createClass, removeClass and listClass here to make timetable changes
       //for each course

       //each course has a single timetable object
       //the timetable object contains a hashmap called tutorialsMap containing
       //all of the tutorials for that course
       
       //the course has a hashmap containing all the imported casual objects
        
    }
   
  
  void createTimeSheet(){
      
      //timesheet constructor takes a tutorial object as input
      
      
  }
  
  
  void deleteTimeSheet(TimeSheet timesheet){
      
  }
  
  void createReport(){
      
      //report constructor takes a course object as input
      
  }
  
  
  void deleteReport(Report report){
      
  }

  
  
}
