package MainProgramme;
import java.util.Scanner;



class ServiceHandler {
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
                    System.out.println("General Services...");
                    break;
                case 3:
                    System.out.println("Exiting... Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

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
            }}}}
