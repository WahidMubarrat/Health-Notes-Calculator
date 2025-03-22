

package MainProgramme;

import java.util.Scanner;
import Authentication.LoginPanel;
import Authentication.Authentication;
import Calculation.BMIBMRcalculator;

public class ServiceHandler {
    private Authentication auth = new Authentication();
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        while (true) {
            clearScreen();
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
                    handleGeneralService();
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

            LoginPanel loginPanel = new LoginPanel(username);
            loginPanel.showPanel();

        } else {
            System.out.println("Invalid credentials.");
        }

    }

    private void handleGeneralService() {
        while (true) {
            clearScreen();
            System.out.println("Welcome to General Services!");
            System.out.println("Choose an option:");
            System.out.println("1. Calculate BMI and BMR");
            System.out.println("2. Back to Main Menu");

            System.out.print("Enter your choice: ");
            int generalChoice = scanner.nextInt();
            scanner.nextLine();

            switch (generalChoice) {
                case 1:
                    calculateBMIAndBMR();
                    break;
                case 2:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    pause();
            }
        }
    }

    private void calculateBMIAndBMR() {
        clearScreen();
        System.out.print("Enter your weight (kg): ");
        double weight = scanner.nextDouble();
        System.out.print("Enter your height (m): ");
        double height = scanner.nextDouble();
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter your gender (male/female): ");
        String gender = scanner.nextLine();

        BMIBMRcalculator calculator = new BMIBMRcalculator(weight, height, age, gender);
        double bmi = calculator.calculateBMI();
        double bmr = calculator.calculateBMR();

        System.out.println("\nYour BMI is: " + bmi);
        System.out.println("Your BMR is: " + bmr);
        pause();
    }

    public  void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void pause() {
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }
}

