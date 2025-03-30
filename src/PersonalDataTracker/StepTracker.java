

package PersonalDataTracker;
import java.io.*;
import java.time.LocalDate;
public class StepTracker extends Tracker {
    public StepTracker(String loggedInUser) {
        super(loggedInUser, "step_tracker.txt");
    }



    public void addRecord(int steps) {
        String date = LocalDate.now().toString();
        String record = loggedInUser + "," + date + "," + steps + " steps";

        try (FileWriter writer = new FileWriter(filename, true)) {
            writer.write(record + "\n");
            System.out.println("Recorded: " + steps + " steps on " + date);
        } catch (IOException e) {
            System.out.println("An error occurred while saving data: " + e.getMessage());
        }}
    public void viewHistory() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            boolean found = false;

            System.out.println("┌──────────────────────────────────────────┐");
            System.out.println("│ ===== Step History for " + loggedInUser + " =====       │");

            while ((line = reader.readLine()) != null) {
                if (line.startsWith(loggedInUser + ",")) {
                    String[] data = line.split(",");
                    String stepDate = data[1];
                    String stepCount = data[2];

                    System.out.print("│ " + stepDate + ": " + stepCount);
                    for (int i = 0; i < 40 - (stepDate.length() + stepCount.length() + 2); i++) {
                        System.out.print(" ");}
                    System.out.println(" │");
                    found = true;
                }}
            if (!found) {
                System.out.println("│ No previous step records found for " + loggedInUser + " │");}
            System.out.println("└──────────────────────────────────────────┘");
        } catch (IOException e) {
            System.out.println("No previous step records found.");
        }}
}