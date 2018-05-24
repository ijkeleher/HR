package hrprogram;

import java.awt.im.InputMethodHighlight;

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
	static ArrayList<User> loginArray = new ArrayList<User>();
	static ArrayList<Course> courseInfoArray = new ArrayList<Course>();
	static ArrayList<TimeSlot> timeSlotArray = new ArrayList<TimeSlot>();
	static String loginUserType;

	public Driver() {

	}

	public static void main(String[] args) {

		loginUserType = null;
		loadUser();
		loadCourse();
		loadTimeSlot();
		login();
		Driver d = new Driver();

		System.out.println("*** Welcome to HR Management System. ***" + "\n" + "\n" + "\n");
		if (loginUserType.equals("AD")) {
			menuAdmin();
		} else if (loginUserType.equals("CC")) {
			menuCourseCoordinator();
		} else if (loginUserType.equals("AP")) {
			menuApproval();
		} else if (loginUserType.equals("CA")) {
			menuCasual();
		}
		System.out.println("Exit Program            X" + "\n");

		Scanner menuValue = new Scanner(System.in);
		String enteredValue = "";

		do {

			System.out.println("Enter a menu value");
			enteredValue = menuValue.next();
			
			if (loginUserType.equals("AD")){
				switchCaseAdmin( d, enteredValue); 
			} else if (loginUserType.equals("CC")){
				switchCaseCourseCoordinator(d, enteredValue); 
			} else if (loginUserType.equals("AP")){
				switchCaseApproval(d, enteredValue);
			} else if (loginUserType.equals("CA")){
				switchCaseCasual(d, enteredValue);
			} 
		} while (!(enteredValue.toUpperCase().equals("X")));
	}// end of psvm()

	// load values from the txt file
	private static void loadUser() {
		Scanner inputStream = null; // create object variable

		try { // create Scanner object & assign to variable
			inputStream = new Scanner(new File("user.txt"));
			inputStream.useDelimiter(",");
		} catch (FileNotFoundException e) {
			System.out.println("No User Infomation was Loaded");
			// System.exit(0);
			return;
		}

		try {
			while (inputStream.hasNext()) {

				String instanceOf = inputStream.next();

				String readUserName = inputStream.next();
				String readPassword = inputStream.next();
				String readEmployeeNumber = inputStream.next();
				String readName = inputStream.next();
				String readPhone = inputStream.next();
				String readEmail = inputStream.next();
				if (instanceOf.contains("*AD*")) {
					Admin a1 = new Admin(readUserName, readPassword, readEmployeeNumber, readName, readPhone,
							readEmail);
					userInfoArray.add(a1);
					System.out.println("Read an Admin User: " + ((User) a1).getUserName() + " " + a1.getPassword() + " "
							+ a1.getEmployeeNum());
				} else if (instanceOf.contains("*CC*")) {
					CourseCoordinator a1 = new CourseCoordinator(readUserName, readPassword, readEmployeeNumber,
							readName, readPhone, readEmail);
					userInfoArray.add(a1);
					System.out.println("Read an CC User: " + ((User) a1).getUserName() + " " + a1.getPassword() + " "
							+ a1.getEmployeeNum());
				} else if (instanceOf.contains("*AP*")) {
					Approval a1 = new Approval(readUserName, readPassword, readEmployeeNumber, readName, readPhone,
							readEmail);
					userInfoArray.add(a1);
					System.out.println("Read an Approval User: " + ((User) a1).getUserName() + " " + a1.getPassword()
							+ " " + a1.getEmployeeNum());
				} else if (instanceOf.contains("*CA*")) {
					Casual a1 = new Casual(readUserName, readPassword, readEmployeeNumber, readName, readPhone,
							readEmail);
					a1.setHrly_rate(inputStream.nextInt());
					userInfoArray.add(a1);
					System.out.println("Read an Casual User: " + ((User) a1).getUserName() + " " + a1.getPassword()
							+ " " + a1.getEmployeeNum());
				}
			}
		} catch (IllegalStateException e) {
			System.err.println("Could not read from the file");
		} catch (InputMismatchException e) {
			System.err.println("Something wrong happened while reading the file");
		}
		inputStream.close();
	} // end of load()

	// load values from the txt file
	private static void loadCourse() {
		Scanner inputStreamC = null; // create object variable for Course

		try { // create Scanner object & assign to variable
			inputStreamC = new Scanner(new File("course.txt"));
			inputStreamC.useDelimiter(",");
		} catch (FileNotFoundException e) {
			System.out.println("No Course Infomation was Loaded");
			// System.exit(0);
			return;
		}

		try {
			while (inputStreamC.hasNext()) {

				String readCourseID = inputStreamC.next();
				String readCourseName = inputStreamC.next();
				String readCourseUserName = inputStreamC.next();
				
				Course c1 = new Course(readCourseID, readCourseName, readCourseUserName);
				courseInfoArray.add(c1);
				System.out.println("Read a Course " + c1.getCourseID() + " " + c1.getCourseName() + " "	+ c1.getCoordinatorUserID());
				
			} //eo while
		}  catch (IllegalStateException e) {
			System.err.println("Could not read from the file");
		} catch (InputMismatchException e) {
			System.err.println("Something wrong happened while reading the file");
		}
		inputStreamC.close();
	} //eo loadCourse()
	
	// load values from the txt file
	private static void loadTimeSlot() {
		Scanner inputStreamT = null; // create object variable for Course

		try { // create Scanner object & assign to variable
			inputStreamT = new Scanner(new File("timeslot.txt"));
			inputStreamT.useDelimiter(",");
		} catch (FileNotFoundException e) {
			System.out.println("No time slot infomation was Loaded");
			// System.exit(0);
			return;
		}

		try {
			while (inputStreamT.hasNext()) {

				String readTimeSlotID = inputStreamT.next();
				String readTimePeriodID = inputStreamT.next();
				String readCourseID = inputStreamT.next();
				String readCasualUser = inputStreamT.next();
				
				TimeSlot t1 = new TimeSlot(readTimeSlotID, readCourseID, readTimePeriodID, readCasualUser);
				timeSlotArray.add(t1);
				t1.getTimeSlotDetails();
				
			} //eo while
		}  catch (IllegalStateException e) {
			System.err.println("Could not read from the file");
		} catch (InputMismatchException e) {
			System.err.println("Something wrong happened while reading the file");
		}
		inputStreamT.close();
	} //eo loadCourse()
	
	private static void login() {

		Scanner inputUserName = new Scanner(System.in);
		Scanner inputPassword = new Scanner(System.in);

		System.out.println("Enter the username: ");
		String entValue_userName = inputUserName.nextLine();

		if (entValue_userName.isEmpty()) {
			System.out.println("\nNothing was entered for the UserName, Please try again.");
			entValue_userName = inputUserName.nextLine();
		}

		// check if existing
		if (!(entValue_userName.isEmpty()) && (userNameDuplicate(entValue_userName.toUpperCase()))) {
			System.out.println("Enter the password: ");
			String entValue_password = inputPassword.nextLine();

			User thisUser = getUserDetails(entValue_userName.toUpperCase());

			// check if password is correct
			System.out.println(thisUser.getPassword());
			if (thisUser.getPassword().equals(entValue_password)) {
				// password matches - add to login array
				loginArray.add(thisUser);
				loginUserType = thisUser.getUserType(); // add the user type
				System.out.println("You (" + loginUserType + ") are logged in");
			} else {
				System.out.println("Password does not match ");
			}

		} else {
			System.out.println("This username does not exist");
		}

	} //end of login()

	
	public static void menuAdmin() {
		System.out.println("Add a new user        	1" + "\n");
		System.out.println("Delete a user  	    	2" + "\n");
		System.out.println("Add a new time slot   	3" + "\n");
		System.out.println("Delete time slot     	4" + "\n");
		System.out.println("View Reports	        5" + "\n");
	}

	public static void menuCourseCoordinator() {
		System.out.println("Add a new course       	1" + "\n");
		System.out.println("Delete a course  	   	2" + "\n");
		System.out.println("Add a new time table   	3" + "\n");
		System.out.println("Delete time table     	4" + "\n");
		System.out.println("View Reports	        5" + "\n");
	}

	public static void menuApproval() {
		System.out.println("Approve Application    	1" + "\n");
		System.out.println("View TimeTable	        2" + "\n");
	}

	public static void menuCasual() {
		System.out.println("View Timetable        	1" + "\n");
		System.out.println("Apply for course    	2" + "\n");
		System.out.println("View Pay		        3" + "\n");
	}

	public static void switchCaseAdmin(Driver d,String enteredValue){
		switch (enteredValue) {
		case "1":
			System.out.println("Add New User");
			d.addUser();
			break;
		case "2":
			System.out.println("Delete an existing User");
			d.deleteUser();
			break;
		case "3":
			System.out.println("Add a Time Slot");
			d.displayTimeSlot();
			break;
		case "4":
			System.out.println("Delete a existing Time Slot");
			// d.addAccounts();
			break;
		case "5":
			System.out.println("View Reports");
			// d.addAccounts();
			break;
		case "X":
		case "x":
			try {
				userFileWriting();
				courseFileWriting();
				System.out.println("Save and Exit");
			} catch (FileNotFoundException fe) {
				// throw OfferException("File Not Found");
				System.out.println("File Not Found");
			}
		}

	} //end of switchCaseAdmin()

	public static void switchCaseCourseCoordinator(Driver d,String enteredValue){
		switch (enteredValue) {
		case "1":
			System.out.println("Add New Course");
			d.addCourse();
			break;
		case "2":
			System.out.println("Delete an existing Course");
			//d.deleteUser();
			break;
		case "3":
			System.out.println("Add a Time Table");
			//d.deleteUser();
			break;
		case "4":
			System.out.println("Delete a existing Time Table");
			// u.addAccounts();
			break;
		case "5":
			System.out.println("View Time Table");
			// d.addAccounts();
			break;
		case "X":
		case "x":
			try {
				userFileWriting();
				courseFileWriting();
				System.out.println("Save and Exit");
			} catch (FileNotFoundException fe) {
				// throw OfferException("File Not Found");
				System.out.println("File Not Found");
			}
		}

	}  //end of switchCaseCourseCoordinator()

	public static void switchCaseApproval(Driver d,String enteredValue){
		switch (enteredValue) {
		case "1":
			System.out.println("Approve Application");
			//d.addUser();
			break;
		case "2":
			System.out.println("View Time Table");
			// d.addAccounts();
			break;
		case "X":
		case "x":
			try {
				userFileWriting();
				courseFileWriting();
				System.out.println("Save and Exit");
			} catch (FileNotFoundException fe) {
				// throw OfferException("File Not Found");
				System.out.println("File Not Found");
			}
		}

	}  //end of switchCaseApproval()

	public static void switchCaseCasual(Driver d,String enteredValue){
		switch (enteredValue) {
		case "1":
			System.out.println("View Timetable");
			//d.addUser();
			break;
		case "2":
			System.out.println("Apply for timeslots");
			// d.applyForTimeSlot();
			break;
		case "3":
			System.out.println("View pay ");
			// u.addAccounts();
			break;
		case "X":
		case "x":
			try {
				userFileWriting();
				courseFileWriting();
				System.out.println("Save and Exit");
			} catch (FileNotFoundException fe) {
				// throw OfferException("File Not Found");
				System.out.println("File Not Found");
			}
		}

	}  //end of switchCaseCasual()

	public static User getUserDetails(String arg_userName) {
		for (User u : userInfoArray) {
			if (u.getUserName().toUpperCase().equals(arg_userName)) {
				System.out.println("Found somethin  :) ");
				return u;
			}
		}
		System.out.println("Nothing to return :( ");
		return null;
	}
	
	public static void courseFileWriting() throws FileNotFoundException {

		String filename = "course.txt"; // path & filename
		PrintWriter outputStream = null;

		try {
			// create a new object of the printWriter class & assign to the
			outputStream = new PrintWriter(new FileOutputStream(filename));

			for (Course course : courseInfoArray) {
				outputStream.println();
				outputStream.print(course.getCourseID().toUpperCase() + ",");
				outputStream.print(course.getCourseName().toUpperCase() + ",");
				outputStream.print(course.getCoordinatorUserID().toUpperCase());
			}
		} catch (FileNotFoundException e) {
			// display the inbuilt error message belonging to e object
			System.out.println(e);
		} // end try catch
		outputStream.close(); // close the stream
	}
	
	public static void userFileWriting() throws FileNotFoundException {
		String filename = "user.txt"; // path & filename
		PrintWriter outputStream = null;

		try {
			// create a new object of the printWriter class & assign to the
			outputStream = new PrintWriter(new FileOutputStream(filename));

			for (User user : userInfoArray) {
				if (user instanceof Admin) {
					outputStream.println();
					outputStream.print("*AD*,");
					outputStream.print(user.getUserName().toUpperCase() + ",");
					outputStream.print(user.getPassword() + ",");
					outputStream.print(user.getEmployeeNum() + ",");
					outputStream.print(((Admin) user).getName() + ",");
					outputStream.print(((Admin) user).getEmail() + ",");
					outputStream.print(((Admin) user).getPhone() + ",");
				} else if (user instanceof CourseCoordinator) {
					outputStream.println();
					outputStream.print("*CC*,");
					outputStream.print(user.getUserName().toUpperCase() + ",");
					outputStream.print(user.getPassword() + ",");
					outputStream.print(user.getEmployeeNum() + ",");
					outputStream.print(((CourseCoordinator) user).getName() + ",");
					outputStream.print(((CourseCoordinator) user).getEmail() + ",");
					outputStream.print(((CourseCoordinator) user).getPhone() + ",");
				} else if (user instanceof Approval) {
					outputStream.println();
					outputStream.print("*AP*,");
					outputStream.print(user.getUserName().toUpperCase() + ",");
					outputStream.print(user.getPassword() + ",");
					outputStream.print(user.getEmployeeNum() + ",");
					outputStream.print(((Approval) user).getName() + ",");
					outputStream.print(((Approval) user).getEmail() + ",");
					outputStream.print(((Approval) user).getPhone() + ",");
				} else if (user instanceof Casual) {
					outputStream.println();
					outputStream.print("*CA*,");
					outputStream.print(user.getUserName().toUpperCase() + ",");
					outputStream.print(user.getPassword() + ",");
					outputStream.print(user.getEmployeeNum() + ",");
					outputStream.print(((Casual) user).getName() + ",");
					outputStream.print(((Casual) user).getEmail() + ",");
					outputStream.print(((Casual) user).getPhone() + ",");
					outputStream.print(((Casual) user).getHrly_rate() + ",");
				}
			}

		} catch (FileNotFoundException e) {
			// display the inbuilt error message belonging to e object
			System.out.println(e);
		} // end try catch
		outputStream.close(); // close the stream

	} // end of fileWriting()

	public void addUser() {

		Scanner inputUserType = new Scanner(System.in);
		Scanner inputUserName = new Scanner(System.in);
		Scanner inputPassword = new Scanner(System.in);
		Scanner inputEmail = new Scanner(System.in);
		Scanner inputName = new Scanner(System.in);
		Scanner inputEmpNumber = new Scanner(System.in);
		Scanner inputPhone = new Scanner(System.in);
		Scanner inputHrlyRate = new Scanner(System.in);

		System.out.println("Enter the User Type: AD,CC,AP,CA");
		String entValue_userType = inputUserType.nextLine();
		String entValue_userName = null;
		String entValue_password = null;
		String entValue_email = null;
		String entValue_name = null;
		String entValue_empNumber = null;
		String entValue_phone = null;
		String userType = null;
		int entValueHrlyRate = 0;

		if (entValue_userType.isEmpty()) {
			System.out.println("\nNothing was entered for the User Type, Please try again.");
			entValue_userType = inputUserType.nextLine();
		}

		if (!(entValue_userType.isEmpty()) && !(userTypeValidation(entValue_userType.toUpperCase()).equals(null))) {
			System.out.println("Enter the username: ");
			entValue_userName = inputUserName.nextLine();

			if (entValue_userName.isEmpty()) {
				System.out.println("\nNothing was entered for the UserName, Please try again.");
				entValue_userName = inputUserName.nextLine();
			}

			// check for username duplicity
			if (!(entValue_userName.isEmpty()) && !(userNameDuplicate(entValue_userName.toUpperCase()))) {
				System.out.println("Enter the password: ");
				entValue_password = inputPassword.nextLine();

				if (entValue_password.isEmpty()) {
					System.out.println("\nNothing was entered for the password, Please try again.");
					entValue_password = inputPassword.nextLine();
				}

				if (!(entValue_password.isEmpty())) {
					// get email, employee number, name , phone number details
					System.out.println("Enter the Employee Number: ");
					entValue_empNumber = inputEmpNumber.nextLine();
					System.out.println("Enter the Name: ");
					entValue_name = inputName.nextLine().toUpperCase();
					System.out.println("Enter the Phone Number: ");
					entValue_phone = inputPhone.nextLine();
					System.out.println("Enter the Email: ");
					entValue_email = inputEmail.nextLine().toUpperCase();

					if (entValue_userType.toUpperCase().equals("CA")) {
						System.out.println("Enter the Hourly Rate: ");
						entValueHrlyRate = inputHrlyRate.nextInt();
					}

					// adding user details to the array list
					if (entValue_userType.toUpperCase().equals("AD")) {
						Admin u1 = new Admin(entValue_userName, entValue_password, entValue_empNumber, entValue_name,
								entValue_email, entValue_phone);
						userInfoArray.add(u1);
						System.out.println("New Admin Added " + entValue_userName);
					} else if (entValue_userType.toUpperCase().equals("CC")) {
						CourseCoordinator u1 = new CourseCoordinator(entValue_userName, entValue_password,
								entValue_empNumber, entValue_name, entValue_email, entValue_phone);
						userInfoArray.add(u1);
						System.out.println("New CC Added " + entValue_userName);
					} else if (entValue_userType.toUpperCase().equals("CA")) {
						Casual u1 = new Casual(entValue_userName, entValue_password, entValue_empNumber, entValue_name,
								entValue_email, entValue_phone);
						u1.setHrly_rate(entValueHrlyRate);
						userInfoArray.add(u1);
						System.out.println("New Casual Added " + entValue_userName);
					} else if (entValue_userType.toUpperCase().equals("AP")) {
						Approval u1 = new Approval(entValue_userName, entValue_password, entValue_empNumber,
								entValue_name, entValue_email, entValue_phone);
						userInfoArray.add(u1);
						System.out.println("New Approval Added " + entValue_userName);
					}
				}
			} else {
				System.out.println("UserName already exist, Choose another User Name");
			}
		} else {
			System.out.println("User Type is not valid");
		}
	} // end of addUser()

	public void deleteUser() {
		Scanner inputUserName = new Scanner(System.in);

		System.out.println("Enter the username: ");
		String entValue_userName = inputUserName.nextLine();

		if (entValue_userName.isEmpty()) {
			System.out.println("\nNothing was entered for the UserName, Please try again.");
			entValue_userName = inputUserName.nextLine();
		}

		// check for username duplicity
		if (!(entValue_userName.isEmpty()) && userNameDelete(entValue_userName.toUpperCase())) {
			// userInfoArray.remove(arg0)
			System.out.println("User Deleted");
		}

	} // end of deleteUser()

	
	public void displayTimeSlot(){
		
	} // end of displayTimeSlot()
	
	public void addCourse(){
		
		Scanner inputCourseID = new Scanner(System.in);
		Scanner inputCourseName = new Scanner(System.in);
		Scanner inputCourseCoordinator = new Scanner(System.in);
		Scanner inputCasual = new Scanner(System.in);

		String entValue_courseID = null;
		String entValue_courseName = null;
		String entValue_ccempNo = null;//course cordinator employee number
		String entValue_caempNo = null;//casual employee number
		
		
		System.out.println("Enter CourseID: ");
		entValue_courseID = inputCourseID.nextLine().toUpperCase();
		
		if (entValue_courseID.isEmpty()) {
			System.out.println("\nNothing was entered for the UserName, Please try again.");
			entValue_courseID = inputCourseID.nextLine().toUpperCase();
		}

		// check for username duplicity
		if (!(entValue_courseID.isEmpty()) && !(courseIDDuplicate(entValue_courseID.toUpperCase()))) {

			System.out.println("Enter the course name: ");
			entValue_courseName = inputCourseName.nextLine();
			
			System.out.println("Enter course coordinator employee number: ");
			entValue_ccempNo = inputCourseCoordinator.nextLine();
			
			if (entValue_ccempNo.isEmpty()) {
				System.out.println("\nNothing was entered for the coordinator username, Please try again.");
				entValue_ccempNo = inputCourseCoordinator.nextLine();
			}
			
			if (!(entValue_ccempNo.isEmpty()) && (userNameDuplicate(entValue_ccempNo.toUpperCase()))) {
				
				Course c1 = new Course(entValue_courseID, entValue_courseName, entValue_ccempNo);
				//add the obj to the array
				courseInfoArray.add(c1);
				System.out.println("New Course Added " + entValue_courseName);
				
			} else {
				System.out.println("Incorrect employee number!!");
			}

		} else {
			System.out.println("Invalid courseID");
		}
	} // end of addCourse()
	
	
	public void applyForTimeSlot(){
		
		//list the time slots
		Scanner inputTimeSlotID = new Scanner(System.in);
		String entValue_timeSlotID = null;
		
		System.out.println("Enter ID: ");
		entValue_timeSlotID = inputTimeSlotID.nextLine().toUpperCase();
		
		if (entValue_timeSlotID.isEmpty()) {
			System.out.println("\nNothing was entered for the timeslot, Please try again.");
			entValue_timeSlotID = inputTimeSlotID.nextLine().toUpperCase();
		}

		// check for username duplicity
		if (!(entValue_timeSlotID.isEmpty()) && (timeSlotDuplicate(entValue_timeSlotID.toUpperCase()))) {
			
		} else {
			System.out.println("Invalid timeslot");
		}

	}//end of apply for timeslot method
	
	
	// check for User Type
	public String userTypeValidation(String arg_userType) {
		String userType = null;

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

	public static boolean timeSlotDuplicate(String arg_timeSlotID) {

		boolean timeSlotFound = false;

		for (TimeSlot t : timeSlotArray) {
			String currenttimeSlotID = t.getTimeSlotID();
			if (arg_timeSlotID.toUpperCase().trim().equals(currenttimeSlotID.toUpperCase().trim())) {
				timeSlotFound = true;
				break;

			} else {
				timeSlotFound = false;
			}

		}
		return timeSlotFound;
	}
	
	// checks if the username exists in the arraylist
	public static boolean userNameDuplicate(String arg_username) {

		boolean userNameFound = false;

		for (User u0 : userInfoArray) {
			String currentUserName = ((User) u0).getUserName();
			if (arg_username.toUpperCase().equals(currentUserName.toUpperCase())) {
				userNameFound = true;
				break;

			} else {
				userNameFound = false;
			}

		}
		return userNameFound;
	}

	// checks if the username exists in the arraylist
	public static boolean courseIDDuplicate(String arg_courseID) {

		boolean courseIDFound = false;

		for (Course c : courseInfoArray) /*need to make course Array*/{
			String currentCourseID = c.getCourseID();

			System.out.println("Current Course ID " + currentCourseID + "& Arg Course ID " + arg_courseID) ;
			if (arg_courseID.toUpperCase().trim().equals(currentCourseID.toUpperCase().trim())) {
				courseIDFound = true;
				break;

			} else {
				courseIDFound = false;
			}

		}
		return courseIDFound;
	}
	
	public static boolean userNameDelete(String arg_username) {

		boolean userNameDeleted = false;

		for (User u0 : userInfoArray) {
			String currentUserName = ((User) u0).getUserName();
			if (arg_username.toUpperCase().equals(currentUserName.toUpperCase())) {
				userInfoArray.remove(arg_username);
				userNameDeleted = true;
				break;

			} else {
				userNameDeleted = false;
			}

		}
		return userNameDeleted;
	}

	public User getUserInfo(String arg_username) {
		for (User u0 : userInfoArray) {
			if (u0.getUserName().toUpperCase().equals(arg_username.toUpperCase())) {
				return u0;
			}
		}

		return null;
	}

	void modifyTimetable(Timetable timetable) {

		// use the createClass, removeClass and listClass here to make timetable
		// changes
		// for each course

	}

	void createTimeSheet() {

	}

	void modifyTimesheet(TimeSheet timesheet) {

	}

	void deleteTimeSheet(TimeSheet timesheet) {

	}

	void createReport() {

	}

	void modifyReport(Report Report) {

	}

	void deleteReport(Report report) {

	}

}
