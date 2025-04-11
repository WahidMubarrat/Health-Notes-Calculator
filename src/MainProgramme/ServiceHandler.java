


package MainProgramme;

import AuthenticationAndPanels.GeneralPanel;
import java.util.Scanner;
import AuthenticationAndPanels.PersonalPanel;
import AuthenticationAndPanels.Authentication;

public class ServiceHandler {
    private Authentication auth = new Authentication();
    private Scanner scanner = new Scanner(System.in);
    private GeneralPanel generalPanel = new GeneralPanel();

    public void start() {
        while (true) {

            System.out.println("Welcome to Savour the Flavor of Life!\nChoose an option:");
            System.out.println("1. Individual Service");
            System.out.println("2. General Service");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    handleIndividualService();
                    break;
                case 2:
                    generalPanel.showGeneralServices();
                    break;
                case 3:
                    System.out.println("Exiting... Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    pause();
            }
        }
    }

    private void handleIndividualService() {
        while (true) {
            clearScreen();
            System.out.println("Individual Services - Choose an option:");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Back to Main Menu");

            System.out.print("Enter your choice: ");
            int indivChoice = scanner.nextInt();
            scanner.nextLine();

            if (indivChoice == 1) {
                registerUser();
            } else if (indivChoice == 2) {
                loginUser();
            } else if (indivChoice == 3) {
                return;
            } else {
                System.out.println("Invalid choice. Please try again.");
                pause();
            }
        }
    }

    private void registerUser() {
        clearScreen();
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (auth.register(username, password)) {
            System.out.println("Registration successful!");
        } else {
            System.out.println("User already exists.");
        }
        pause();
    }


    private void loginUser() {
        clearScreen();
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (auth.login(username, password)) {
            System.out.println("Login successful!");
            PersonalPanel loginPanel = new PersonalPanel(username);
            loginPanel.showPanel();
        } else {
            System.out.println("Invalid credentials.");
        }
    }


    private void clearScreen() {
        for (int i = 0; i < 5; i++) {
            System.out.println();
        }
    }



    private void pause() {
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }
}
