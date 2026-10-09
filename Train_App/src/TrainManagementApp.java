import java.util.LinkedList;
import java.util.List;

public class TrainManagementApp {
    private static void printConsist(String label, List<String> trainConsist) {
        System.out.println(label);
        System.out.println(trainConsist);
    }

    private static boolean insertBogie(List<String> trainConsist, int position, String bogie) {
        if (position < 0 || position > trainConsist.size() || bogie == null || bogie.isBlank()) {
            return false;
        }
        trainConsist.add(position, bogie);
        return true;
    }

    private static void removeEndBogies(List<String> trainConsist) {
        if (!trainConsist.isEmpty()) {
            trainConsist.remove(0);
        }
        if (!trainConsist.isEmpty()) {
            trainConsist.remove(trainConsist.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println("======================================");
        System.out.println("Train Management - Ordered Consist");
        System.out.println("======================================\n");

        List<String> trainConsist = new LinkedList<>(List.of("Bogie-1", "Bogie-2", "Bogie-3"));
        printConsist("Initial Train Consist:", trainConsist);

        if (insertBogie(trainConsist, 1, "Bogie-1A")) {
            printConsist("\nAfter inserting Bogie-1A at position 1:", trainConsist);
        } else {
            System.out.println("Could not insert bogie: invalid position or bogie name.");
        }

        removeEndBogies(trainConsist);
        printConsist("\nAfter removing front and rear bogies:", trainConsist);
    }
}