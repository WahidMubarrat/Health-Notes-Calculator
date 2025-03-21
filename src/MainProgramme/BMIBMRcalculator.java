package MainProgramme;
public class BMIBMRcalculator {
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
            return Math.round((weight / (height * height)) * 100.0) / 100.0; }
           public double calculateBMR() {
            double bmr;

            if (gender.equalsIgnoreCase("male")) {
                bmr = 10 * weight + 6.25 * height * 100 - 5 * age + 5;
            } else if (gender.equalsIgnoreCase("female")) {
                bmr = 10 * weight + 6.25 * height * 100 - 5 * age - 161;
            } else {
                throw new IllegalArgumentException("Gender must be 'male' or 'female'");
            }
            return Math.round(bmr * 100.0) / 100.0;
        }}
