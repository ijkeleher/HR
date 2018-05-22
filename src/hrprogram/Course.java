package hrprogram;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Course {

    String courseID;
    CourseCoordinator courseCoordinator;
    HashMap<String, Casual> casualsMap;
    boolean isApproved = false;

    static Scanner console = new Scanner(System.in);

    public Course(String courseID) {
        this.courseID = courseID;
    }

    void importListOfCasuals() {

        try {// finding the file and setting up scanner to read it
            String filename = "casuals.txt";
            Scanner targetFile = new Scanner(new File(filename));
            targetFile.useDelimiter("#");
            System.out.println("Casuals file found! Using backup file for loading data!");

/*            try {
                // if file has no content throw "file empty" exception
                if (targetFile.hasNextLine() == false) {
                    throw new Exception("File is empty!");

                } else {// grab info from file if available

                    while (targetFile.hasNextLine()) {
                        String employeeNum = targetFile.next();
                        String name = targetFile.next();
                        String email = targetFile.next();
                        int phone = targetFile.nextInt();
                        int hrly_rate = targetFile.nextInt();

                        Casual c = new Casual(employeeNum, name, email, phone, hrly_rate);
                        casualsMap.put(c.getEmployeeNum(), c);
                    }
                }
                // print file empty message if file is empty
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                targetFile.close();
            } */
        } catch (

        FileNotFoundException e) {
            System.out.println("Casuals file not found! No casuals data was loaded");

        }

    }// end of method

public void listCasuals(){
        
        if (casualsMap.isEmpty()){
            System.out.println("No Casuals assigned for teaching in this course!\n");
        }
        // for each key in hash map retrieve the casual object
        //and it's details
        for (Object key : casualsMap.keySet()) {
            Casual c = (Casual) casualsMap.get(key);
            System.out.println(c.getName()+" - "+c.getEmployeeNum()+"\n");
        }
    }

    public void setIsApproved() {
        isApproved = true;
    }

    public void setNotApproved() {
        isApproved = false;
    }

}
