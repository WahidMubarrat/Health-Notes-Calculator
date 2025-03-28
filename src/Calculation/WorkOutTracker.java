package Calculation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class WorkOutTracker {
    private LocalDateTime workoutStartTime;
    private LocalDateTime workoutEndTime;
    private String username;

    public WorkOutTracker(String username) {
        this.username = username;
    }

    public void startWorkout() {
        workoutStartTime = LocalDateTime.now();
        System.out.println("Workout timer started at: " + formatTime(workoutStartTime));
    }

    public void stopWorkout() {
        workoutEndTime = LocalDateTime.now();
        saveWorkoutDurationToFile();
    }

    public String getWorkoutDuration() {
        Duration duration = Duration.between(workoutStartTime, workoutEndTime);
        long hours = duration.toHours();
        long minutes = duration.toMinutes() % 60;
        return hours + " hours and " + minutes + " minutes";
    }

    String fileName = "C:\\Users\\wahid\\IdeaProjects\\Savour the Flavour of Health\\src\\workout_duration.txt";

    private void saveWorkoutDurationToFile() {
        String workoutRecord = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
                + " - User: " + username + " - Workout Duration: " + getWorkoutDuration() + "\n";

        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(workoutRecord);
            System.out.println("Workout duration saved to " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving workout duration to file: " + e.getMessage());
        }
    }

    public void viewWorkoutRecords() {
        System.out.println("\n===== Workout Records for " + username + " =====");
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
                    System.out.printf("│ %-46s │\n", "Workout Duration: " + duration);
                    System.out.println("└────────────────────────────────────────────────┘");
                    found = true;
                }
            }
            if (!found) {
                System.out.println("No workout records found.");
            }
        } catch (IOException e) {
            System.out.println("Error reading workout duration file: " + e.getMessage());
        }
    }

    private String formatTime(LocalDateTime time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return time.format(formatter);
    }
}
