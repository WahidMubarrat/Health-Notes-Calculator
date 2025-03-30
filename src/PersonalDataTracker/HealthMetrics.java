
package PersonalDataTracker;
import java.io.*;
import java.time.LocalDate;
public class HealthMetrics extends Tracker {
    public HealthMetrics(String loggedInUser) {
        super(loggedInUser, "health_metrics.txt");
    }

    public void addRecord(String bloodPressure, String glucose, String heartRate, String pulseRate) {
        String date = LocalDate.now().toString();
        String record = loggedInUser + "," + date + "," + bloodPressure + "," + glucose + "," + heartRate + "," + pulseRate;

        try (FileWriter writer = new FileWriter(filename, true)) {
            writer.write(record + "\n");
            System.out.println("Recorded on " + date + " - Blood Pressure: " + bloodPressure + ", Glucose: " + glucose + ", Heart Rate: " + heartRate + ", Pulse Rate: " + pulseRate);
        } catch (IOException e) {
            System.out.println("An error occurred while saving health data: " + e.getMessage());
        }
    }

    public void viewHistory() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            boolean found = false;

            System.out.println("┌──────────────────────────────────────────┐");
            System.out.println("│  ===== Health History for " + loggedInUser + " =====    │");

            while ((line = reader.readLine()) != null) {
                if (line.startsWith(loggedInUser + ",")) {
                    String[] data = line.split(",");
                    String recordDate = data[1];
                    String bloodPressure = data[2];
                    String glucose = data[3];
                    String heartRate = data[4];
                    String pulseRate = data[5];

                    System.out.println("│ Date: " + recordDate + "                         │");
                    System.out.println("│ Glucose: " + glucose + ", BP: " + bloodPressure + "                   │");
                    System.out.println("│ HR: " + heartRate + ", PR: " + pulseRate + "                           │");
                    System.out.println("│------------------------------------------│");
                    found = true;
                }
            }
            if (!found) {
                System.out.println("│ No previous health records found for " + loggedInUser + " │");
            }
            System.out.println("└──────────────────────────────────────────┘");
        } catch (IOException e) {
            System.out.println("No previous health records found.");
        }
    }
}
