package PersonalDataTracker;

import java.io.*;
import java.time.LocalDate;

public class WaterIntake {
    private static final String FILENAME1 = "C:\\Users\\wahid\\IdeaProjects\\Savour the Flavour of Health\\src\\water_intake.txt";
    private String loggedInUser;

    public WaterIntake(String loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public void addWaterIntake(double amount) {
        String date = LocalDate.now().toString();
        String record = loggedInUser + "," + date + "," + amount + " liters";

        try (FileWriter writer = new FileWriter(FILENAME1, true)) {
            writer.write(record + "\n");
            System.out.println("Recorded: " + amount + " liters on " + date);
        } catch (IOException e) {
            System.out.println("An error occurred while saving data: " + e.getMessage());
        }}

    public void viewWaterIntakeHistory() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME1))) {
            String line;
            boolean found = false;

            System.out.println("┌──────────────────────────────────────────┐");
            System.out.println("│===== Water Intake History for " + loggedInUser + " =====│");
            while ((line = reader.readLine()) != null) {
                if (line.startsWith(loggedInUser + ",")) {
                    String[] data = line.split(",");
                    String intakeDate = data[1];
                    String intakeAmount = data[2];

                    System.out.print("│ " + intakeDate + ": " + intakeAmount + "L");
                    for (int i = 0; i < 40 - (intakeDate.length() + intakeAmount.length() + 3); i++) {
                        System.out.print(" ");}
                    System.out.println(" │");
                    found = true;
                }}
            if (!found) {
                System.out.println("│ No previous water intake records found for " + loggedInUser + " │"); }

            System.out.println("└──────────────────────────────────────────┘"); }
        catch (IOException e) {
            System.out.println("No previous water intake records found.");
        }}}

