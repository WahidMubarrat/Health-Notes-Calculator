





package PersonalDataTracker;

import java.io.*;
import java.time.LocalDate;

public class WaterIntake {
    private static final String FILENAME = "C:\\Users\\wahid\\IdeaProjects\\Savour the Flavour of Health\\src\\water_intake.txt";
    private String loggedInUser;

    public WaterIntake(String loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public void addWaterIntake(double amount) {
        String date = LocalDate.now().toString();
        String record = loggedInUser + "," + date + "," + amount + " liters";

        try (FileWriter writer = new FileWriter(FILENAME, true)) {
            writer.write(record + "\n");
            System.out.println("Recorded: " + amount + " liters on " + date);
        } catch (IOException e) {
            System.out.println("An error occurred while saving data: " + e.getMessage());
        }
    }

    public void viewWaterIntakeHistory() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            boolean found = false;

            System.out.println("===== Water Intake History for " + loggedInUser + " =====");

            while ((line = reader.readLine()) != null) {
                if (line.startsWith(loggedInUser + ",")) {
                    String[] data = line.split(",");
                    System.out.println(data[1] + ": " + data[2]);
                    found = true;
                }
            }

            if (!found) {
                System.out.println("No previous water intake records found for " + loggedInUser + ".");
            }
        } catch (IOException e) {
            System.out.println("No previous water intake records found.");
        }
    }
}

