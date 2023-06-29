package camerarentalapplication;
import java.util.Scanner;
public class User {

	    private static final String USERNAME = "admin";
	    private static final String PASSWORD = "admin123";

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.println(" | Welcome To Camera Rental System |, " + USERNAME + ".");
	        System.out.print("Enter your username: ");
	        String usernameInput = scanner.nextLine();

	        System.out.print("Enter your password: ");
	        String passwordInput = scanner.nextLine();
	        if (login(USERNAME, PASSWORD)) {
	        } else {
	            System.out.println("Invalid username or password. Please try again.");
	        }
	        scanner.close();
	    }

	    private static boolean login(String username, String password) {
	        return username.equals(USERNAME) && password.equals(PASSWORD);
	    }
	}