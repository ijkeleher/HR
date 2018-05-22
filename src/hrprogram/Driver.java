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
    
    
    static ArrayList<User> userInfoArray = new ArrayList<User>();
           //public String username;
           //public String password;  
           
           public Driver (){
               
           }
           
           /*public Driver (String args_username, String args_password){
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
            */
        public static void main(String[] args) {
            
            //course, coordinator and schedule pre-created for testing purposes

            //Course SEFCOSC2537 = new Course("SEFCOSC253");
            //CourseCoordinator Andrew = new CourseCoordinator("Andrew", "4545416");
            //Timetable SEFschedule = new Timetable(SEFCOSC2537, Andrew);
            
            
            //load();
            User u = new User(); 
            
            
            System.out.println("*** Welcome to HR Management System. ***" + "\n" + "\n" + "\n");
            System.out.println("If you have an existing account            1" + "\n");
            System.out.println("If you want to create a new account        2" + "\n");
            System.out.println("Exit Program            X" + "\n");

            Scanner menuValue = new Scanner(System.in);
            String enteredValue = "";
            
            
            do {

                System.out.println("Enter a menu value");
                enteredValue = menuValue.next();

                switch (enteredValue) {
                case "1":
                    System.out.println("Existing Account");
                    u.getAccounts();
                    break;
                case "2":
                    System.out.println("Creating Account");
                    u.addAccounts();
                    break;
                case "X":
                case "x":

                    try{
                    fileWriting();
                    System.out.println("Save and Exit");
                    } catch (FileNotFoundException fe){
                        //throw OfferException("File Not Found");
                        System.out.println("File Not Found" );
                    }
             }               

            } while (!(enteredValue.toUpperCase().equals("X")));

            
        }
        
        public static void fileWriting() throws FileNotFoundException {
    		// TODO Auto-generated method stub
    		String filename = "backup.txt"; // path & filename
    		PrintWriter outputStream = null;

    		try {
    			// create a new object of the printWriter class & assign to the
    			// Object variable
    			outputStream = new PrintWriter(new FileOutputStream(filename));
    			
    			for (User user : userInfoArray) {
    				outputStream.println();
	    			outputStream.print("*User Name*,");
	    			outputStream.print(user.getUserName().toUpperCase() + ",");
	    			//outputStream.print("*Password*,");
	    			outputStream.print(user.getPassword() + ",");
    			}
    			
    		} catch (FileNotFoundException e) {
    			// display the inbuilt error message belonging to e object
    			System.out.println(e);
    		} // end try catch
    		outputStream.close(); // close the stream
    		
        }
        
        
        public void addAccounts(){
        	
            Scanner inputUserType = new Scanner(System.in);
            Scanner inputUserName = new Scanner(System.in);
            Scanner inputPassword = new Scanner(System.in);
            Scanner inputEmail = new Scanner(System.in);
            Scanner inputName = new Scanner(System.in);
            Scanner inputEmpNumber = new Scanner(System.in);
            Scanner inputPhone = new Scanner(System.in);

            
            System.out.println("Enter the User Type: AD,CC,AP,CA");
            String entValue_userType = inputUserType.nextLine();  
            String entValue_userName = null;
            String entValue_password = null;
            String entValue_email = null;
            String entValue_name = null;
            String entValue_empNumber = null;
            String entValue_phone = null;
            String userType = null;
            
            if(entValue_userType.isEmpty()){
                System.out.println("\nNothing was entered for the User Type, Please try again.");
                entValue_userType = inputUserType.nextLine();
            } 
            
             
            if(userType.isEmpty()){
                System.out.println("\nWrong value was entered for the UserTYpe, Please try again.");
                entValue_userType = inputUserType.nextLine();
            } 
            
            if(!(entValue_userType.isEmpty()) && !(userTypeValidation(entValue_userType.toUpperCase()).equals(null))){
                System.out.println("Enter the username: ");
                entValue_userName = inputUserName.nextLine();      

                if (entValue_userName.isEmpty()) {
                    System.out.println("\nNothing was entered for the UserName, Please try again.");
                    entValue_userName = inputUserName.nextLine();
                }

                //check for username duplicity 
                if (!(entValue_userName.isEmpty()) && !(userNameDuplicate(entValue_userName.toUpperCase()))){
                    System.out.println("Enter the password: ");
                    entValue_password = inputPassword.nextLine();

                    if (entValue_password.isEmpty()){
                        System.out.println("\nNothing was entered for the password, Please try again.");
                        entValue_password = inputPassword.nextLine();                    	
                    }
                    
                    if(!(entValue_password.isEmpty())) {
	                    // get email, employee number, name , phone number details 
	                    System.out.println("Enter the Name: ");
	                    entValue_name = inputName.nextLine();
	                    System.out.println("Enter the Email: ");
	                    entValue_email = inputEmail.nextLine();
	                    System.out.println("Enter the Employee Number: ");
	                    entValue_empNumber = inputEmpNumber.nextLine();
	                    System.out.println("Enter the Phone Number: ");
	                    entValue_phone = inputPhone.nextLine();
                    } 
                } else {
                    System.out.println("UserName already exist, Choose another User Name");
                }
            	
            } else {
            	System.out.println("User Type is not valid");
            
            }
				
            //adding user details to the array list 
            User u1 = new User(entValue_userName,entValue_password,entValue_empNumber); 
            userInfoArray.add(u1);    
			System.out.println("New Account Added " + entValue_userName);

			
        }
        
        public void getAccounts(){
/*        
            Scanner inputChoice = new Scanner(System.in);
            Scanner inputUserName = new Scanner(System.in);
            Scanner inputPassword = new Scanner(System.in);

            System.out.println("Enter the username: ");
            String entValue_userName = inputUserName.nextLine();      

            if (entValue_userName.isEmpty()) {
                System.out.println("\nNothing was entered for the UserName, Please try again.");
                entValue_userName = inputUserName.nextLine();
            }
            
            //check if existing
            if (!(entValue_userName.isEmpty()) && (userNameDuplicate(entValue_userName.toUpperCase()))){
                System.out.println("Enter the password: ");
                String entValue_password = inputPassword.nextLine();

				Driver thisDriver = getDriverDetails(entValue_userName.toUpperCase());

                //check if password is correct 
                System.out.println(thisDriver.getPassword());
                if (thisDriver.getPassword().equals(entValue_password)){
                	// password matches
                	// add to login array
                    System.out.println("You are logged in");
                } else {
                    System.out.println("Password does not match ");
                }
                
            } else {
                System.out.println("This username does not exist");
            }
*/
        }
        
/*        
    	public Driver getDriverDetails(String arg_userName) {
    		for (Driver d : userInfoArray) {
    			if (d.getUserName().toUpperCase().equals(arg_userName)) {
    	    		System.out.println("Found somethin  :) ");
    				return d;
    			}
    		}
    		System.out.println("Nothing to return :( ");
    		return null;
    	}
 */   	
    	//check for User TYpe 
    	public String userTypeValidation(String arg_userType){
    		String userType=null;
    		
            switch (arg_userType) {
 			case "AD":
 			case "ad":
 				userType = "ADMIN";
 				break;
 			case "CC":
 			case "cc":
 				userType = "COORDINATOR";
 				break;
 			case "AP":
 			case "ap":
 				userType = "APPROVER";
 				break;
 			case "CA":
 			case "ca":
 				userType = "CASUAL";
 				break;
 			default: 
 				break;
             }

    		return userType;
    	}
        //checks if the username exists in the arraylist 
        public boolean userNameDuplicate(String arg_username) {

            boolean userNameFound = false;
          
            for (int i = 0; i < userInfoArray.size(); i++) {
                
            	String currentUserName = ((User) userInfoArray.get(i)).getUserName();
            	
                if (arg_username.toUpperCase().equals(currentUserName.toUpperCase())) {
                    userNameFound = true;
                    break;

                } else {
                    userNameFound = false;
                }
            }
            return userNameFound;
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
                	if (!(inputStream.next().isEmpty())){
                          String readUserName = inputStream.next();
                          String readPassword = inputStream.next();
                          String readEmployeeNumber = inputStream.next(); 
                          
                          User u1 = new User(readUserName, readPassword, readEmployeeNumber);
                          
                          userInfoArray.add(u1);
    			          System.out.println("Read an User Account: "+ readUserName + " " + readPassword + " " + readEmployeeNumber);
                	}
                } 
            } catch (IllegalStateException e){
                System.err.println("Could not read from the file");
            } catch (InputMismatchException e){
                System.err.println("Something wrong happened while reading the file");
            }
            inputStream.close();
        }       

    
        /*
        public Driver getUserInfo(String arg_username) {
            for (Driver d0 : userInfoArray) {
                if (d0.getUserName().toUpperCase().equals(arg_username.toUpperCase())) {
                    return d0;
                }
            }

            return null;
        }
         */        
        
   void modifyTimetable(Timetable timetable){
       
       //use the createClass, removeClass and listClass here to make timetable changes
       //for each course

        
    }
   
  
  void createTimeSheet(){
      
      
  }
  
  void modifyTimesheet(TimeSheet timesheet){
      
  }
  
  void deleteTimeSheet(TimeSheet timesheet){
      
  }
  
  void createReport(){
      
  }
  
  void modifyReport(Report Report){
      
  }
  
  void deleteReport(Report report){
      
  }

  
  
}
