package MainProgramme;


import java.util.Scanner;

public class ServiceHandler {
    private Authentication auth = new Authentication();
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        while (true) {
            System.out.println("Welcome to Savour the Flavor of Life!\n Choose an option:");
            System.out.println("1.  Individual Service");
            System.out.println("2.  General Service");
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
            }}  }

    private void handleIndividualService() {
        while (true) {
            System.out.println("Individual Services - Choose an option:");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Back to Main Menu");

            System.out.print("Enter your choice: ");
            int indivChoice = scanner.nextInt();
            scanner.nextLine();

            if (indivChoice == 1) {
                System.out.print("Enter username: ");
                String username = scanner.nextLine();
                System.out.print("Enter password: ");
                String password = scanner.nextLine();
                if (auth.register(username, password)) {
                    System.out.println("Registration successful!");
                } else {
                    System.out.println("User already exists.");
                }
            } else if (indivChoice == 2) {
                System.out.print("Enter username: ");
                String username = scanner.nextLine();
                System.out.print("Enter password: ");
                String password = scanner.nextLine();
                if (auth.login(username, password)) {
                    System.out.println("Login successful!");
                } else {
                    System.out.println("Invalid credentials.");
                }
            } else if (indivChoice == 3) {
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }}}

    private void handleGeneralService() {
        while (true) {
            System.out.println("Welcome to General Services!");
            System.out.println("Choose an option:");

            System.out.println("1. Calculate BMI and BMR");
            System.out.println("2. Back to Main Menu");

            System.out.print("Enter your choice (e.g 1,2): ");
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
            }}}

    private void calculateBMIAndBMR() {
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

        System.out.println("Your BMI is: " + bmi);
        System.out.println("Your BMR is: " + bmr);
    }}
