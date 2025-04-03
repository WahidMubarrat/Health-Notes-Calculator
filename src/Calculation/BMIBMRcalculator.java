




package Calculation;

public class BMIBMRcalculator {
    private static final double BMI_MULTIPLIER = 100.0;
    private static final double MALE_BMR_CONSTANT = 5;
    private static final double FEMALE_BMR_CONSTANT = -161;
    private static final double WEIGHT_MULTIPLIER = 10;
    private static final double HEIGHT_MULTIPLIER = 6.25;
    private static final double AGE_MULTIPLIER = 5;
    private static final double HEIGHT_CONVERSION = 100;

    private double weight;
    private double height;
    private int age;
    private String gender;

    public BMIBMRcalculator(double weight, double height, int age, String gender) {
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.gender = gender;
    }

    public double calculateBMI() {
        return Math.round((weight / (height * height)) * BMI_MULTIPLIER) / BMI_MULTIPLIER;
    }

    public double calculateBMR() {
        double bmr;

        if (gender.equalsIgnoreCase("male")) {
            bmr = WEIGHT_MULTIPLIER * weight + HEIGHT_MULTIPLIER * height * HEIGHT_CONVERSION - AGE_MULTIPLIER * age + MALE_BMR_CONSTANT;
        } else if (gender.equalsIgnoreCase("female")) {
            bmr = WEIGHT_MULTIPLIER * weight + HEIGHT_MULTIPLIER * height * HEIGHT_CONVERSION - AGE_MULTIPLIER * age + FEMALE_BMR_CONSTANT;
        } else {
            throw new IllegalArgumentException("Gender must be 'male' or 'female'");
        }

        return Math.round(bmr * BMI_MULTIPLIER) / BMI_MULTIPLIER;
    }
}
