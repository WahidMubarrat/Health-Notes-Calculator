package AuthenticationAndPanels;
import java.util.Scanner;


import Calculation.SleepTracker;
public class LoginPanel {
    private Scanner scanner = new Scanner(System.in);
    private boolean isLoggedIn;
    private String loggedInUser;
    private SleepTracker sleepTracker;

    public LoginPanel(String loggedInUser) {
        this.loggedInUser = loggedInUser;
        this.isLoggedIn = true;
        this.sleepTracker = new SleepTracker(loggedInUser);
    }

    public void showPanel() {
        while (isLoggedIn) {
            clearScreen();
            System.out.println("===== Login Panel =====");
            System.out.println("Welcome, " + loggedInUser + "!");
            System.out.println("Choose an option:");
            System.out.println("1. Track Sleep");
            System.out.println("2. Logout");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    trackSleep();

                    break;
                case 2:
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
        System.out.println("3. View sleep Records");

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
            default:

                pause();
        }
    }

    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private void pause() {
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }

}


