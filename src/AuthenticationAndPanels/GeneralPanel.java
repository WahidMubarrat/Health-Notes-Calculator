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

  /*  private void calculateBMIAndBMR() {
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

    */

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


        String line1 = "BMI: " + String.format("%.2f", bmi);
        String line2 = "BMR: " + String.format("%.2f", bmr);


        int boxwidth=40;

        System.out.println("┌──────────────────────────────────────────┐");
        System.out.print("│ " + line1);
        for (int i = 0; i < boxwidth - line1.length(); i++) {
            System.out.print(" ");
        }
        System.out.println(" │");
        System.out.print("│ " + line2);
        for (int i = 0; i <boxwidth - line2.length(); i++) {
            System.out.print(" ");
        }
        System.out.println(" │");
        System.out.println("└──────────────────────────────────────────┘");

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
            String line1 = "Food Item: " + foodItem;
            String line2 = "Quantity: " + quantityInGrams + " grams";
            String line3 = "Calories: " + String.format("%.2f", calories) + " kcal";

            int boxWidth = 40;
            System.out.println("┌──────────────────────────────────────────┐");
            System.out.print("│ " + line1);
            for (int i = 0; i < boxWidth - line1.length(); i++) {
                System.out.print(" ");
            }
            System.out.println(" │");
            System.out.print("│ " + line2);
            for (int i = 0; i < boxWidth - line2.length(); i++) {
                System.out.print(" ");
            }
            System.out.println(" │");
            System.out.print("│ " + line3);
            for (int i = 0; i < boxWidth - line3.length(); i++) {
                System.out.print(" ");
            }
            System.out.println(" │");
            System.out.println("└──────────────────────────────────────────┘");
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
