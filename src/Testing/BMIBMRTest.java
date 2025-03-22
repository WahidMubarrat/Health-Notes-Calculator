package Testing;
import Calculation.BMIBMRcalculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;





    class BMIBMRTest {

        @Test
        void testBMICalculation() {
            BMIBMRcalculator calculator = new BMIBMRcalculator(100,2, 25, "male");
            assertEquals(25, calculator.calculateBMI(), 0.01);
        }

        @Test
        void testBMRCalculation() {
            BMIBMRcalculator calculator = new BMIBMRcalculator(100, 2, 25, "male");
            assertNotEquals(2100, calculator.calculateBMR(), 0.01);
        }

        @Test
        void testInvalidGender() {
            Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                new BMIBMRcalculator(100, 2, 25, "other").calculateBMR();
            });
            assertEquals("Gender must be 'male' or 'female'", exception.getMessage());
        }
    }


