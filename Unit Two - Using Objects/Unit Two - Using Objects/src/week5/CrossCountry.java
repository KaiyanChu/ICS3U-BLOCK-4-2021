package week5;

import java.util.Scanner;

public class CrossCountry { 
    /** 
     * Creates the main method
     * Creates a scanner that gets user input
     * calls the processRunner method 3 times 
    */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);  
        processRunner(in);
        processRunner(in);
        processRunner(in);

        in.close();

    }

    /**
     * creates the variables (strings) for firstName, lastName, mileOne, mileTwo, finish, splitTwo, 
     *it takes in the scannner input to get user input 
     * it calculates the split 2 and 3 time using the subtracttimes method. 
     * prints the summary
     * there is no return type because its void
     */
    private static void processRunner(Scanner in) {
        String firstName, lastName;
        String mileOne, mileTwo, finish;
        String splitTwo, splitThree;
        System.out.println("Please enter your first name: ");
        firstName = in.nextLine();
        System.out.println("Please enter your last name: ");
        lastName = in.nextLine();
        System.out.println("Please enter Mile 1 Time: ");
        mileOne = in.nextLine();
        System.out.println("Please enter Mile 2 Time: ");
        mileTwo = in.nextLine();
        System.out.println("Please enter Finish Time: ");
        finish = in.nextLine();


        
        // get the first and last name of the runner
        // get the mileOne and the mileTwo and finish times for all runners

        splitTwo = subtractTimes(mileTwo,mileOne);
        splitThree = subtractTimes(finish,mileTwo);



        //display a summary for the runnner
        System.out.println("Name: " + firstName + " " + lastName );
        System.out.println("Spilt One: " + mileOne);
        System.out.println("Spilt Two: " + splitTwo);
        System.out.println("Spilt Three: " + splitThree);
        System.out.println("Finish Time : " + finish);






    }

    /**
     * 
     * @param endTime
     * @param startTime
     * @return returns the difference of the 2 times
     * it does this by calling convertToseconds to convert the 2 times into seconds so that it can subtract them to find the difference
     * after it uses the convert to Time method to convert the difference in seconds back to the time in minutes and seconds
     * 
     * 
     */    
    private static String subtractTimes(String endTime, String startTime) {
        double endTimeInSeconds = covertToSeconds(endTime);
        double startTimeInSeconds = covertToSeconds(startTime);

        double diffInSeconds = endTimeInSeconds-startTimeInSeconds;

        return convertToTime(diffInSeconds);

        
    }
/**
 * 
 * @param seconds
 * @return the format of the strings
 * 
 * it divides the seconds by 60 to get the mins, it casts it as an int so that there is no decimals, it modulous the seconds to get the seconds 
 * it adds them together in a string to return to the original format
 * it converts them to the right format by using the String.format method. 
 *
 */
    private static String convertToTime(double seconds) {
        return String.format("%d:%.3f", ((int)seconds/60), seconds%60);
    }

    /**
     * 
     * @param time
     * @returnthe time in seconds
     * it seperates the minutes from the seconds 
     * it multiplies the mins by 60 to get the mins in seconds
     * it sets them to doubles using the parseDouble method
     * returns the mins in seconds and seconds added together. 
     */
    private static double covertToSeconds(String time) {
        //5:89.74
        String seconds1 = time.substring(0, time.indexOf(":"));
        String seconds2 = time.substring(time.indexOf(":") +1);
        double time1 = Double.parseDouble(seconds1)*60;
        double time2 = Double.parseDouble(seconds2);
        double finaltime = time1 + time2; 

        return finaltime; 

    }
    
}