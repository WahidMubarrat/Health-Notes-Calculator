package AuthenticationAndPanels;
import java.io.*;

public class Authentication {
    private static final String FILE_NAME = "user.txt";
    private boolean userExists(String username) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2 && parts[0].equals(username)) {
                    return true;
                }}
        } catch (IOException e) {
            System.out.println("Error reading user .");}
        return false;}
    public boolean register(String username, String password) {
        if (userExists(username)) {
            System.out.println("Username already exists!");
            return false;
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(username + "," + password);
            writer.newLine();

            return true;
        } catch (IOException e) {
            System.out.println("Error saving user data.");}
        return false;}
    public boolean login(String username, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2 && parts[0].equals(username) && parts[1].equals(password)) {
                    return true;
                }}
        } catch (IOException e) {
            System.out.println("Error reading user database.");}
        System.out.println("Invalid username or password.");
        return false;
    }}

