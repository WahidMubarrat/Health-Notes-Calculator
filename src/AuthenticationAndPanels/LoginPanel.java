package AuthenticationAndPanels;
import java.util.Scanner;




import java.util.Scanner;
import PersonalDataTracker.StepTracker;
import PersonalDataTracker.WaterIntake;
import Calculation.SleepTracker;
import Calculation.WorkOutTracker;
import PersonalDataTracker.HealthMetrics;

public class LoginPanel {
    private Scanner scanner = new Scanner(System.in);
    private boolean isLoggedIn;
    private String loggedInUser;
    private SleepTracker sleepTracker;
    private WaterIntake waterIntakeTracker;
    private StepTracker stepTracker;
    private WorkOutTracker workoutTracker;
    private HealthMetrics healthMetricsTracker;

    public LoginPanel(String loggedInUser) {
        this.loggedInUser = loggedInUser;
        this.isLoggedIn = true;
        this.sleepTracker = new SleepTracker(loggedInUser);
        this.waterIntakeTracker = new WaterIntake(loggedInUser);
        this.stepTracker = new StepTracker(loggedInUser);
        this.workoutTracker = new WorkOutTracker(loggedInUser);
        this.healthMetricsTracker = new HealthMetrics(loggedInUser);

    }

    public void showPanel() {
        while (isLoggedIn) {
            clearScreen();
            System.out.println("===== Login Panel =====");
            System.out.println("Welcome, " + loggedInUser + "!");
            System.out.println("Choose an option:");
            System.out.println("1. Track Sleep");
            System.out.println("2. Track Water Intake");
            System.out.println("3. Track Steps");
            System.out.println("4. Track Workout");
            System.out.println("5. Track Health Metrics");
            System.out.println("6. Logout");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    trackSleep();
                    break;
                case 2:
                    trackWaterIntake();
                    break;
                case 3:
                    trackSteps();
                    break;
                case 4:
                    trackWorkout();
                    break;
                case 5:
                    trackHealthMetrics();
                    break;
                case 6:
                    logout();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    pause();
            }
        }
    }

    private void logout() {
        System.out.println("Logging out...");
        isLoggedIn = false;
        loggedInUser = null;
    }

    private void trackSleep() {
        clearScreen();
        System.out.println("===== Sleep Tracker =====");
        System.out.println("1. Start Sleep Timer");
        System.out.println("2. Stop Sleep Timer");
        System.out.println("3. View Sleep Records");

        System.out.print("Enter your choice: ");
        int sleepChoice = scanner.nextInt();
        scanner.nextLine();

        switch (sleepChoice) {
            case 1:
                sleepTracker.startSleep();
                break;
            case 2:
                sleepTracker.stopSleep();
                break;
            case 3:
                sleepTracker.viewSleepRecords();
                break;
            default:
                System.out.println("Invalid choice.");
        }

        pause();
    }

    private void trackWaterIntake() {
        clearScreen();
        System.out.println("===== Water Intake Tracker =====");
        System.out.println("What would you like to do?");
        System.out.println("1. Record & Save Water Intake");
        System.out.println("2. View Water Intake History");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Enter water intake amount for today (in liters): ");
                double intakeAmount = scanner.nextDouble();
                scanner.nextLine();

                waterIntakeTracker.addWaterIntake(intakeAmount);
                break;

            case 2:
                waterIntakeTracker.viewWaterIntakeHistory();
                break;

            default:
                System.out.println("Invalid choice. Returning to main panel.");
        }

        pause();
    }

    private void trackSteps() {
        clearScreen();
        System.out.println("===== Step Tracker =====");
        System.out.println("What would you like to do?");
        System.out.println("1. Record & Save Steps");
        System.out.println("2. View Step History");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Enter number of steps taken today: ");
                int steps = scanner.nextInt();
                scanner.nextLine();

                stepTracker.addSteps(steps);
                break;

            case 2:
                stepTracker.viewStepHistory();
                break;

            default:
                System.out.println("Invalid choice. Returning to main panel.");
        }

        pause();
    }
    private void trackWorkout() {
        clearScreen();
        System.out.println("===== Workout Tracker =====");
        System.out.println("1. Start Workout Timer");
        System.out.println("2. Stop Workout Timer");
        System.out.println("3. View Workout Records");

        System.out.print("Enter your choice: ");
        int workoutChoice = scanner.nextInt();
        scanner.nextLine();

        switch (workoutChoice) {
            case 1:
                workoutTracker.startWorkout();
                break;
            case 2:
                workoutTracker.stopWorkout();
                break;
            case 3:
                workoutTracker.viewWorkoutRecords();
                break;
            default:
                System.out.println("Invalid choice.");
        }

        pause();
    }

    private void trackHealthMetrics() {
        clearScreen();
        System.out.println("===== Health Metric Tracker =====");
        System.out.println("1. Record & Save Health Metrics");
        System.out.println("2. View Health History");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Enter Blood Pressure (e.g., 120/80): ");
                String bloodPressure = scanner.nextLine();

                System.out.print("Enter Glucose Level (mg/dL): ");
                String glucose = scanner.nextLine();

                System.out.print("Enter Heart Rate (bpm): ");
                String heartRate = scanner.nextLine();

                System.out.print("Enter Pulse Rate (bpm): ");
                String pulseRate = scanner.nextLine();

                healthMetricsTracker.addHealthMetric(bloodPressure, glucose, heartRate, pulseRate);
                break;

            case 2:
                healthMetricsTracker.viewHealthHistory();
                break;

            default:
                System.out.println("Invalid choice. Returning to main panel.");
        }

        pause();}

    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private void pause() {
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }
}
