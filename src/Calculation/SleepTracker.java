package Calculation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SleepTracker {
    private LocalDateTime sleepStartTime;
    private LocalDateTime wakeUpTime;
    private String username;


    public SleepTracker(String username) {
        this.username = username;
    }

    public void startSleep() {
        sleepStartTime = LocalDateTime.now();
        System.out.println("Sleep timer started at: " + formatTime(sleepStartTime));
    }

    public void stopSleep() {
        wakeUpTime = LocalDateTime.now();

        saveSleepDurationToFile();
    }


    public String getSleepDuration() {
        Duration duration = Duration.between(sleepStartTime, wakeUpTime);
        long hours = duration.toHours();
        long minutes = duration.toMinutes() % 60;
        return hours + " hours and " + minutes + " minutes";
    }
    String fileName = "C:\\Users\\wahid\\IdeaProjects\\Savour the Flavour of Health\\src\\sleep_duration.txt";
    private void saveSleepDurationToFile() {

        String sleepRecord = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
                + " - User: " + username + " - Sleep Duration: " + getSleepDuration() + "\n";

        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(sleepRecord);
            System.out.println("Sleep duration saved to " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving sleep duration to file: " + e.getMessage());
        }
    }

    public void viewSleepRecords() {
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
                    System.out.printf("│ %-46s │\n", "Date & Time: " + date);         // Adjusted format for date
                    System.out.printf("│ %-46s │\n", "Username: " + user);      // Adjusted format for username
                    System.out.printf("│ %-46s │\n", "Sleep Duration: " + duration); // Adjusted format for sleep duration
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


    private String formatTime(LocalDateTime time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return time.format(formatter);
    }
}

