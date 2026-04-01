import java.util.LinkedList;
import java.util.List;

public class uc1 {

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("UC4 - Maintain Ordered Bogie Consist");
        System.out.println("======================================\n");

        List<String> trainConsist = new LinkedList<>();

        trainConsist.add("Bogie-1");
        trainConsist.add("Bogie-2");
        trainConsist.add("Bogie-3");

        System.out.println("Initial Train Consist:");
        System.out.println(trainConsist);

        trainConsist.add(1, "Bogie-1A");

        System.out.println("\nAfter inserting Bogie-1A at position 1:");
        System.out.println(trainConsist);

        trainConsist.remove(0);
        trainConsist.remove(trainConsist.size() - 1);

        System.out.println("\nAfter removing front and rear bogies:");
        System.out.println(trainConsist);
    }
}