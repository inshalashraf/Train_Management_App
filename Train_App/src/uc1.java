import java.util.ArrayList;
import java.util.List;

public class uc1 {

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("UC2 - Add Passenger Bogies to Train");
        System.out.println("======================================\n");

        List<String> passengerBogies = new ArrayList<>();

        passengerBogies.add("Bogie-1");
        passengerBogies.add("Bogie-2");
        passengerBogies.add("Bogie-3");

        System.out.println("Bogies after adding:");
        System.out.println(passengerBogies);

        System.out.println("\nTotal bogies: " + passengerBogies.size());

        if (passengerBogies.contains("Bogie-2")) {
            System.out.println("Bogie-2 is available in the train.");
        }

        passengerBogies.remove("Bogie-1");

        System.out.println("\nBogies after removing Bogie-1:");
        System.out.println(passengerBogies);

        System.out.println("\nFinal Train Consist:");
        System.out.println(passengerBogies);
    }
}