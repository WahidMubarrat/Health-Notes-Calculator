package MainProgramme;

import java.util.Scanner;


public class Main{
    public static void main(String[] args) {
        Authentication auth = new Authentication();
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Register\n");
        System.out.println("2.Login");
        int choice = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (choice == 1) {
            auth.register(username, password);
        } else if (choice == 2) {
            auth.login(username, password);
        } else {
            System.out.println("Invalid choice!");}
        scanner.close();
    }}