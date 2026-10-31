import java.util.Scanner;

/** Console interface for managing an ordered train consist. */
public class TrainManagementApp {
    private static void showMenu() {
        System.out.println("\n===== TRAIN MANAGEMENT =====");
        System.out.println("1. Display train consist");
        System.out.println("2. Add bogie at front");
        System.out.println("3. Add bogie at rear");
        System.out.println("4. Insert bogie at position");
        System.out.println("5. Remove front bogie");
        System.out.println("6. Remove rear bogie");
        System.out.println("7. Search for a bogie");
        System.out.println("8. Remove a bogie by ID");
        System.out.println("9. Exit");
        System.out.print("Choose an option: ");
    }

    public static void main(String[] args) {
        TrainConsist train = new TrainConsist();
        train.addLast("Bogie-1");
        train.addLast("Bogie-2");
        train.addLast("Bogie-3");

        try (Scanner scanner = new Scanner(System.in)) {
            boolean running = true;
            while (running) {
                showMenu();
                String choice = scanner.nextLine().trim();
                try {
                    switch (choice) {
                        case "1": display(train); break;
                        case "2":
                            System.out.print("Enter bogie ID: ");
                            train.addFirst(scanner.nextLine());
                            System.out.println("Bogie added at the front.");
                            break;
                        case "3":
                            System.out.print("Enter bogie ID: ");
                            train.addLast(scanner.nextLine());
                            System.out.println("Bogie added at the rear.");
                            break;
                        case "4":
                            System.out.print("Enter position (0 to " + train.size() + "): ");
                            int position = Integer.parseInt(scanner.nextLine().trim());
                            System.out.print("Enter bogie ID: ");
                            train.insertAt(position, scanner.nextLine());
                            System.out.println("Bogie inserted successfully.");
                            break;
                        case "5": System.out.println("Removed: " + train.removeFirst()); break;
                        case "6": System.out.println("Removed: " + train.removeLast()); break;
                        case "7":
                            System.out.print("Enter bogie ID to search: ");
                            int foundAt = train.find(scanner.nextLine());
                            System.out.println(foundAt >= 0 ? "Bogie found at position " + foundAt + "." : "Bogie not found.");
                            break;
                        case "8":
                            System.out.print("Enter bogie ID to remove: ");
                            System.out.println(train.remove(scanner.nextLine()) ? "Bogie removed successfully." : "Bogie not found.");
                            break;
                        case "9": running = false; System.out.println("Train Management App closed."); break;
                        default: System.out.println("Invalid option. Choose a number from 1 to 9.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid whole number.");
                } catch (IllegalArgumentException | IndexOutOfBoundsException | IllegalStateException e) {
                    System.out.println("Operation failed: " + e.getMessage());
                }
            }
        }
    }

    private static void display(TrainConsist train) {
        System.out.println("Train consist (" + train.size() + " bogies): " + train.getBogies());
    }
}
