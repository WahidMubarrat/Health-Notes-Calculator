package AuthenticationAndPanels;

import java.util.Scanner;
import Calculation.BMIBMRcalculator;
import Calculation.FoodCaloryCalculator;

public class GeneralPanel {
    private Scanner scanner = new Scanner(System.in);

    public void showGeneralServices() {
        while (true) {
            clearScreen();
            System.out.println("Welcome to General Services!");
            System.out.println("Choose an option:");
            System.out.println("1. Calculate BMI and BMR");
            System.out.println("2. Calculate Food Calories");
            System.out.println("3. Back to Main Menu");

            System.out.print("Enter your choice: ");
            int generalChoice = scanner.nextInt();
            scanner.nextLine();

            switch (generalChoice) {
                case 1:
                    calculateBMIAndBMR();
                    break;
                case 2:
                    calculateFoodCalories();
                    break ;
                case 3:
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

    private void calculateFoodCalories() {
        clearScreen();
        System.out.print("Enter the food item (e.g., 'White Rice'): ");
        String foodItem = scanner.nextLine();
        System.out.print("Enter the quantity in grams: ");
        double quantityInGrams = scanner.nextDouble();

        FoodCaloryCalculator foodCaloryCalculator = new FoodCaloryCalculator();
        double calories = foodCaloryCalculator.calculateCalories(foodItem, quantityInGrams);

        if (calories != -1) {
            System.out.println("\nThe calories for " + quantityInGrams + " grams of " + foodItem + " is: " + calories + " kcal");
        }
        pause();
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
