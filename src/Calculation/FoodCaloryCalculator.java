/*

package Calculation;

public class FoodCaloryCalculator {
    private String[] foodItems = {
            "White Rice", "Red Rice", "White Bread", "Brown Bread", "Bun Roti", "White Flour Roti", "Brown Flour Roti", "Fried Paratha", "Potato Paratha", "Luchi",
            "Naan Roti", "Butter Naan Roti", "Rice Roti", "Rumali Roti", "Rumali Roti with Ghee", "Tandoori Roti with Ghee", "Tandoori Roti without Ghee", "Moong Dal Khichuri", "Pulao", "Chicken Biryani",
            "Vegetable Biryani", "Mutton Biryani", "Fried Rice", "Boiled Noodles", "Chowmein", "Flour", "White Flour", "Brown Flour", "Rice Flour", "Milk",
            "Low Fat Milk", "Condensed Milk", "Soy Milk", "Cooked Masoor Dal", "Cooked Moong Dal", "Cooked Chana Dal", "Boiled Egg", "Fried Egg", "Poached Egg without Oil", "Poached Egg with Oil",
            "Chicken Tikka", "Chicken Bhuna", "Chicken Korma", "Fried Chicken", "Chicken Cutlet", "Fish Curry", "Prawn Curry", "Fish Cutlet", "Fish Finger", "Beef Bhuna",
            "Beef Korma", "Beef Seekh Kebab", "Beef Shami Kebab", "Cooked Beef Keema", "Beef Cutlet", "Mutton Korma", "Mutton Rezala", "Cooked Mutton Keema", "Beef Liver Curry", "Chicken Liver Curry"
    };

    private double[] foodCalories = {
            200, 218, 67, 60, 150, 72, 60, 243, 300, 140,
            312, 424, 105, 200, 245, 120, 147, 176, 258, 418,
            220, 470, 120, 220, 1820, 455, 400, 356, 578, 146,
            90, 490, 90, 226, 150, 107, 75, 92, 80, 202,
            148, 132, 250, 390, 375, 323, 261, 228, 162, 434,
            167, 160, 210, 555, 500, 143, 323, 175, 135, 172
    };

    public double calculateCalories(String foodItem, double quantityInGrams) {
        for (int i = 0; i < foodItems.length; i++) {
            if (foodItems[i].equalsIgnoreCase(foodItem)) {
                double caloriesPer100g = foodCalories[i];
                return (caloriesPer100g / 100) * quantityInGrams;
            }
        }
        System.out.println("Food item not found in database.");
        return -1;
    }
}

*/

package Calculation;

import java.io.*;

public class FoodCaloryCalculator {
    private String filePath="food_items.txt";

    public FoodCaloryCalculator(String filePath) {
        this.filePath = filePath;
    }

    public double calculateCalories(String foodItem, double quantityInGrams) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String item = parts[0].trim();
                    double calories = Double.parseDouble(parts[1].trim());


                    if (item.equalsIgnoreCase(foodItem)) {
                        return (calories / 100) * quantityInGrams;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }

        System.out.println("Food item not found in database.");
        return -1;
    }

    public void addFoodItem(String newItem, double newCalories) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.newLine();
            writer.write(newItem + "," + newCalories);
            System.out.println("Food item added successfully: " + newItem + " (" + newCalories + " cal/100g)");
        } catch (IOException e) {
            System.out.println("Error writing to food data file: " + e.getMessage());
        }
    }
}



