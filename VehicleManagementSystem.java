import java.util.Scanner;

public class VehicleManagementSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Automobile automobile = null;
        int choice;
        // Choice menu
        do {
            System.out.println("Vehicle Management System");
            System.out.println("1. Store Vehicle Information");
            System.out.println("2. Update Vehicle Information");
            System.out.println("3. Remove Vehicle Information");
            System.out.println("4. Display Vehicle Information");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Store info
                    System.out.print("Enter Vehicle Make: ");
                    String make = scanner.nextLine();
                    System.out.print("Enter Vehicle Model: ");
                    String model = scanner.nextLine();
                    System.out.print("Enter Vehicle Color: ");
                    String color = scanner.nextLine();
                    System.out.print("Enter Vehicle Year: ");
                    int year = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    automobile = new Automobile(make, model, color, year);
                    System.out.println("Vehicle information stored successfully.\n");
                    break;
                case 2:
                    // Update vehicle information
                    if (automobile != null) {
                        System.out.print("Enter New Vehicle Make: ");
                        String newMake = scanner.nextLine();
                        System.out.print("Enter New Vehicle Model: ");
                        String newModel = scanner.nextLine();
                        System.out.print("Enter New Vehicle Color: ");
                        String newColor = scanner.nextLine();
                        System.out.print("Enter New Vehicle Year: ");
                        int newYear = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        String updateMessage = automobile.updateVehicle(newMake, newModel, newColor, newYear);
                        System.out.println(updateMessage + "\n");
                    } else {
                        System.out.println("No Vehicle Information Available to Update.\n");
                    }
                    break;

                case 3:
                    // Remove Vehicle Information
                    if (automobile != null) {
                        System.out.print("Enter Vehicle Make: ");
                        String removeMake = scanner.nextLine();
                        System.out.print("Enter Vehicle Model: ");
                        String removeModel = scanner.nextLine();
                        System.out.print("Enter Vehicle Color: ");
                        String removeColor = scanner.nextLine();
                        System.out.print("Enter Vehicle Year: ");
                        int removeYear = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        String removeMessage = automobile.removeVehicle(removeMake, removeModel, removeColor, removeYear);
                        System.out.println(removeMessage + "\n");
                    } else {
                        System.out.println("No Vehicle Information Available to Remove.\n");
                    }
                    break;

                case 4:
                    // Display vehicle info
                    if (automobile != null) {
                        String displayMessage = automobile.displayVehicle();
                        System.out.println(displayMessage + "\n");
                    } else {
                        System.out.println("No Vehicle Information Available to Display.\n");
                    }
                    break;

                case 5:
                    // Exit
                    System.out.println("Exiting Vehicle Management System");
                    break;

                default:
                    System.out.println("Invalid Choice. Please Try Again.\n");
            }
        } while (choice != 5);

        scanner.close();
    }

    // Static nested class Automobile
    public static class Automobile {

        // Private variables to store automobile details
        private String autoMake;
        private String autoModel;
        private String autoColor;
        private int autoYear;

        // Constructor to initialize the Automobile object
        public Automobile(String make, String model, String color, int year) {
            this.autoMake = make;
            this.autoModel = model;
            this.autoColor = color;
            this.autoYear = year;
        }

        // Method to remove vehicle info
        public String removeVehicle(String make, String model, String color, int year) {
            if (this.autoMake.equals(make) && this.autoModel.equals(model) &&
                this.autoColor.equals(color) && this.autoYear == year) {
                this.autoMake = null;
                this.autoModel = null;
                this.autoColor = null;
                this.autoYear = 0;
                return "Vehicle information removed successfully.";
            } else {
                return "Mismatch: Vehicle information does not match records.";
            }
        }

        // Method to update vehicle info
        public String updateVehicle(String newMake, String newModel, String newColor, int newYear) {
            if (newMake != null && newModel != null && newColor != null && newYear > 0) {
                this.autoMake = newMake;
                this.autoModel = newModel;
                this.autoColor = newColor;
                this.autoYear = newYear;
                return "Vehicle information updated successfully.";
            } else {
                return "Invalid Input: All fields must be filled with valid data.";
            }
        }

        // Method to display vehicle information
        public String displayVehicle() {
            if (this.autoMake != null && this.autoModel != null &&
                this.autoColor != null && this.autoYear > 0) {
                return "Make: " + this.autoMake + ", Model: " + this.autoModel + 
                       ", Color: " + this.autoColor + ", Year: " + this.autoYear;
            } else {
                return "No vehicle information available.";
            }
        }
    }
}
