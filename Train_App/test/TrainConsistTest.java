import java.util.List;

/** Lightweight test runner; uses only the Java standard library. */
public class TrainConsistTest {
    private static int passed = 0;

    public static void main(String[] args) {
        testInitialAndAddOperations();
        testInsertAndRemoveEnds();
        testSearchAndRemoveById();
        testInvalidInputs();
        testEmptyRemoval();
        System.out.println("All " + passed + " train consist tests passed.");
    }

    private static void testInitialAndAddOperations() {
        TrainConsist train = new TrainConsist(List.of("A", "B"));
        train.addFirst("START");
        train.addLast("END");
        check(train.getBogies().equals(List.of("START", "A", "B", "END")), "add at both ends");
    }

    private static void testInsertAndRemoveEnds() {
        TrainConsist train = new TrainConsist(List.of("A", "C"));
        train.insertAt(1, "B");
        check(train.getBogies().equals(List.of("A", "B", "C")), "insert at index");
        check("A".equals(train.removeFirst()), "remove front");
        check("C".equals(train.removeLast()), "remove rear");
        check(train.getBogies().equals(List.of("B")), "remaining bogie");
    }

    private static void testSearchAndRemoveById() {
        TrainConsist train = new TrainConsist(List.of("A", "B", "C"));
        check(train.find("B") == 1, "find existing bogie");
        check(train.find("missing") == -1, "find missing bogie");
        check(train.remove("B"), "remove existing bogie");
        check(!train.remove("B"), "remove missing bogie");
    }

    private static void testInvalidInputs() {
        TrainConsist train = new TrainConsist(List.of("A"));
        expect(IllegalArgumentException.class, () -> train.addLast(" "));
        expect(IllegalArgumentException.class, () -> train.addLast("A"));
        expect(IndexOutOfBoundsException.class, () -> train.insertAt(3, "B"));
        expect(IndexOutOfBoundsException.class, () -> train.insertAt(-1, "B"));
    }

    private static void testEmptyRemoval() {
        TrainConsist train = new TrainConsist();
        check(train.isEmpty() && train.size() == 0, "empty state");
        expect(IllegalStateException.class, train::removeFirst);
        expect(IllegalStateException.class, train::removeLast);
    }

    private static void check(boolean condition, String name) {
        if (!condition) throw new AssertionError("FAILED: " + name);
        passed++;
        System.out.println("PASS: " + name);
    }

    private static void expect(Class<? extends Throwable> type, Runnable action) {
        try {
            action.run();
        } catch (Throwable error) {
            if (type.isInstance(error)) {
                passed++;
                System.out.println("PASS: expected " + type.getSimpleName());
                return;
            }
            throw new AssertionError("Expected " + type.getSimpleName() + " but got " + error, error);
        }
        throw new AssertionError("Expected " + type.getSimpleName() + " but no exception was thrown.");
    }
}
