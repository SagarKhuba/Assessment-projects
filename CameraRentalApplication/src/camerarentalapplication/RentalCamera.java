package camerarentalapplication;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class Camera {
    private int id;
    private String brand;
    private String model;
    private boolean available;
    public Camera(int id, String brand, String model) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.available = true;
    }
    public int getId() {
        return id;
    }
    public int getPrice() {
        return getPrice();
    }
    public String getBrand() {
        return brand;
    }
    public String getModel() {
        return model;
    }
    public boolean isAvailable() {
        return available;
    }
    public void setAvailable(boolean available) {
        this.available = available;
    }
    @Override
    public String toString() {
        return "ID: " + id + ", Brand: " + brand + ", Model: " + model;
    }
}

class RentalSystem {
    private List<Camera> cameras;

    public RentalSystem() {
        cameras = new ArrayList<>();
    }

    public void addCamera(Camera camera) {
        cameras.add(camera);
    }

    public void rentCamera(int id) {
        for (Camera camera : cameras) {
            if (camera.getId() == id && camera.isAvailable()) {
                camera.setAvailable(false);
                System.out.println("Camera with ID " + id + " has been rented.");
                return;
            }
        }
        System.out.println("Camera with ID " + id + " is not available for rent.");
    }

    public void returnCamera(int id) {
        for (Camera camera : cameras) {
            if (camera.getId() == id && !camera.isAvailable()) {
                camera.setAvailable(true);
                System.out.println("Camera with ID " + id + " has been returned.");
                return;
            }
        }
        System.out.println("Invalid camera ID or the camera is already available.");
    }
    public void checkAvailability(int id) {
        for (Camera camera : cameras) {
            if (camera.getId() == id) {
                System.out.println(camera.toString() + " is " + (camera.isAvailable() ? "available." : "not available."));
                return;
            }
        }
        System.out.println("Invalid camera ID.");
    }

	public int getnextcameraId() {
		// TODO Auto-generated method stub
		return 0;
	}
}
public class RentalCamera {
    public static void main(String[] args) {
        RentalSystem rentalSystem = new RentalSystem();

        // Adding cameras to the rental system
        rentalSystem.addCamera(new Camera(1, "Canon", "EOS 5D Mark IV"));
        rentalSystem.addCamera(new Camera(2, "Nikon", "D850"));
        rentalSystem.addCamera(new Camera(3, "Sony", "A7 III"));

        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 4) {
            System.out.println("\n | WELCOME TO CAMERA RENTAL | ");
            System.out.println("1. MY Camera ");
            System.out.println("2. Rent a Camera ");
            System.out.println("3. View All Camera ");
            System.out.println("4. My Wallet ");
            System.out.println("5. Exit ");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
            case 1:
            	  System.out.println("1. Add ");
                  System.out.println("2. Rent A Camera ");
                  System.out.println("3. View My Cameras ");
                  System.out.println("4. Go To My Menus ");
                  System.out.print("Enter your choice: ");
                  choice = scanner.nextInt();   
                case 2:
                    System.out.println("1. Enter The Camera Brand: ");
                    String cameraBrand = scanner.next();
                    System.out.println("2. Enter The Camera Model: ");
                    String cameraModel = scanner.next();
                    System.out.println("3. Enter The Per Day Price (INR): ");
                    String cameraprice = scanner.next();
                    Camera newCamera = new Camera( rentalSystem.getnextcameraId(), cameraBrand, cameraModel);
                    rentalSystem.addCamera(newCamera);
                    System.out.println("Camera with ID " + newCamera.getId() + " has been added.");
                    break;
                    
                    
                case 3:
                    System.out.print("Enter the camera ID to return: ");
                    int returnId = scanner.nextInt();
                    rentalSystem.returnCamera(returnId);
                    break;
                case 4:
                    System.out.print("Enter the camera ID to check availability: ");
                    int checkId = scanner.nextInt();
                    rentalSystem.checkAvailability(checkId);
                    break;
                case 5:
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        scanner.close();
    }
}