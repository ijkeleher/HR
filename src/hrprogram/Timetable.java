package hrprogram;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Timetable {
    Course course;
    CourseCoordinator courseCoordinator;
    HashMap<String, Tutorial> tutorialsMap;

    public Timetable(Course course, CourseCoordinator courseCoordinator) {

    }

    void importListOfTutorials() {

        try {// finding the file and setting up scanner to read it
            String filename = "tutorials.txt";
            Scanner targetFile = new Scanner(new File(filename));
            targetFile.useDelimiter("#");
            System.out.println("Tutorials file found! Using backup file for loading data!");

            try {
                // if file has no content throw "file empty" exception
                if (targetFile.hasNextLine() == false) {
                    throw new Exception("File is empty!");

                } else {// grab info from file if available

                    while (targetFile.hasNextLine()) {
                        String tutorialID = targetFile.next();
                        String courseID = targetFile.next();
                        String date = targetFile.next();
                        String startTime = targetFile.next();
                        String endTime = targetFile.next();
                        String casualID = targetFile.next();
                        int duration = targetFile.nextInt();

                        if (course.casualsMap.containsKey(casualID)) {
                            Casual assignedCasual = course.casualsMap.get(casualID);

                            Tutorial t = new Tutorial(tutorialID, courseID, date, 
                                    startTime, endTime, assignedCasual, duration);

                            tutorialsMap.put(t.getTutorialID(), t);
                        }
                    } // end of while loop

                } // end of if else
                  // exception to print print file empty message if file is
                  // empty
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                targetFile.close();
            }
        } catch (

        FileNotFoundException e) {
            System.out.println("Tutorials file not found! No tutorials data was loaded");

        }

    }// end of method

    void createTutorial(String tutorialID, String courseID, String date, String startTime, String endTime,
            String casualID, int duration) {

        // search for casual in database
        if (course.casualsMap.containsKey(casualID)) {
            Casual assignedCasual = course.casualsMap.get(casualID);

            // create new tutorial object
            Tutorial t = new Tutorial(tutorialID, courseID, date, 
                    startTime, endTime, assignedCasual, duration);

            // add new tutorial object to tutorials hashmap
            tutorialsMap.put(t.getTutorialID(), t);

            course.setNotApproved();
        } else {
            System.out.print("Error could not create new tutorial");
        }

    }
    
    void setCasual(String tutorialID, String newCasual){
    	
    	 if (tutorialsMap.containsKey(tutorialID)) {
             Tutorial t = tutorialsMap.get(tutorialID);
             
             if (course.casualsMap.containsKey(newCasual)) {
             Casual c = course.casualsMap.get(newCasual);
             	t.casual = c;
    		 
             }
    	 }
    	
    }

    void removeTutorial(String tutorialID) {

        if (tutorialsMap.containsKey(tutorialID)) {
            tutorialsMap.remove(tutorialID);
        }

        course.setNotApproved();
    }

    public void listTutorials() {

        if (tutorialsMap.isEmpty()) {
            System.out.println("No Tutorial Data!\n");
        }
        // for each key in hash map retrieve the sale object
        // and it's details
        for (String key : tutorialsMap.keySet()) {
            Tutorial s = tutorialsMap.get(key);
            s.getTutorialDetails();
        }

    }

}
