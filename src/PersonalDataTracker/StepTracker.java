package PersonalDataTracker;

import java.io.*;
import java.time.LocalDate;

public class StepTracker {
    private static final String FILENAME2 = "C:\\Users\\wahid\\IdeaProjects\\Savour the Flavour of Health\\src\\step_tracker.txt";
    private String loggedInUser;

    public StepTracker(String loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public void addSteps(int steps) {
        String date = LocalDate.now().toString();
        String record = loggedInUser + "," + date + "," + steps + " steps";

        try (FileWriter writer = new FileWriter(FILENAME2, true)) {
            writer.write(record + "\n");
            System.out.println("Recorded: " + steps + " steps on " + date);
        } catch (IOException e) {
            System.out.println("An error occurred while saving data: " + e.getMessage());
        }
    }

    public void viewStepHistory() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME2))) {
            String line;
            boolean found = false;

            System.out.println("===== Step History for " + loggedInUser + " =====");

            while ((line = reader.readLine()) != null) {
                if (line.startsWith(loggedInUser + ",")) {
                    String[] data = line.split(",");
                    System.out.println(data[1] + ": " + data[2]);
                    found = true;
                }
            }

            if (!found) {
                System.out.println("No previous step records found for " + loggedInUser + ".");
            }
        } catch (IOException e) {
            System.out.println("No previous step records found.");
        }
    }
}
