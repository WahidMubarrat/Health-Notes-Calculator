
package Calculation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class SleepTracker extends ActivityTracker{


   public SleepTracker(String loggedInUser) {
       super(loggedInUser, "sleep_duration.txt");
   }
    public void startActivity() {
        startTime = LocalDateTime.now();
        System.out.println("Sleep timer started at: " + formatTime(startTime));
    }

    public void stopActivity() {
        endTime = LocalDateTime.now();

        saveDurationToFile();
    }


    public void viewRecords() {
        System.out.println("\n===== Sleep Records for " + username + " =====");
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            boolean found = false;
            while ((line = reader.readLine()) != null) {
                if (line.contains("User: " + username)) {

                    String[] parts = line.split(" - ");
                    String date = parts[0];
                    String user = parts[1].split(": ")[1];
                    String duration = parts[2].split(": ")[1];


                    System.out.println("┌────────────────────────────────────────────────┐");
                    System.out.printf("│ %-46s │\n", "Date & Time: " + date);
                    System.out.printf("│ %-46s │\n", "Username: " + user);
                    System.out.printf("│ %-46s │\n", "Sleep Duration: " + duration);
                    System.out.println("└────────────────────────────────────────────────┘");
                    found = true;
                }
            }
            if (!found) {
                System.out.println("No sleep records found.");
            }
        } catch (IOException e) {
            System.out.println("Error reading sleep duration file: " + e.getMessage());
        }
    }



    @Override
    public String getDuration() {
        Duration duration = Duration.between(startTime, endTime);
        long hours = duration.toHours();
        long minutes = duration.toMinutes() % 60;
        return hours + " hours and " + minutes + " minutes";
    }

    private void saveDurationToFile() {

        String sleepRecord = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
                + " - User: " + username + " - Sleep Duration: " + getDuration() + "\n";

        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(sleepRecord);
            System.out.println("Sleep duration saved to 'Sleep_Duration' file");
        } catch (IOException e) {
            System.out.println("Error saving sleep duration to file: " + e.getMessage());
        }
    }
}


