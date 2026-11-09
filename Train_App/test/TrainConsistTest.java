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
        testSnapshotIsImmutable();
        testConstructorRejectsDuplicateIds();
        testIdsAreTrimmedConsistently();
        testNullInitialListRejected();
        System.out.println("All " + passed + " train consist checks passed.");
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
        expect(IllegalArgumentException.class, () -> train.addLast(" "), "blank ID rejected");
        expect(IllegalArgumentException.class, () -> train.addLast("A"), "duplicate ID rejected");
        expect(IllegalArgumentException.class, () -> train.addLast(null), "null ID rejected");
        expect(IllegalArgumentException.class, () -> train.find(" "), "blank search rejected");
        expect(IllegalArgumentException.class, () -> train.remove(null), "null removal ID rejected");
        expect(IndexOutOfBoundsException.class, () -> train.insertAt(3, "B"), "position above size rejected");
        expect(IndexOutOfBoundsException.class, () -> train.insertAt(-1, "B"), "negative position rejected");
    }

    private static void testEmptyRemoval() {
        TrainConsist train = new TrainConsist();
        check(train.isEmpty() && train.size() == 0, "empty state");
        expect(IllegalStateException.class, train::removeFirst, "remove first from empty train rejected");
        expect(IllegalStateException.class, train::removeLast, "remove last from empty train rejected");
    }

    private static void testSnapshotIsImmutable() {
        TrainConsist train = new TrainConsist(List.of("A", "B"));
        List<String> snapshot = train.getBogies();
        expect(UnsupportedOperationException.class, () -> snapshot.add("C"), "snapshot is immutable");
        train.addLast("C");
        check(snapshot.equals(List.of("A", "B")), "snapshot does not change with the train");
    }

    private static void testConstructorRejectsDuplicateIds() {
        expect(IllegalArgumentException.class,
                () -> new TrainConsist(List.of("A", "A")), "constructor rejects duplicate IDs");
    }

    private static void testIdsAreTrimmedConsistently() {
        TrainConsist train = new TrainConsist();
        train.addLast("  B-1  ");
        check(train.find("B-1") == 0, "stored ID is trimmed");
        expect(IllegalArgumentException.class,
                () -> train.addLast("B-1"), "trimmed duplicate ID rejected");
        check(train.remove(" B-1 "), "removal trims the supplied ID");
    }

    private static void testNullInitialListRejected() {
        expect(IllegalArgumentException.class,
                () -> new TrainConsist(null), "null initial list rejected");
    }

    private static void check(boolean condition, String name) {
        if (!condition) throw new AssertionError("FAILED: " + name);
        passed++;
        System.out.println("PASS: " + name);
    }

    private static void expect(Class<? extends Throwable> type, Runnable action, String name) {
        try {
            action.run();
        } catch (Throwable error) {
            if (type.isInstance(error)) {
                passed++;
                System.out.println("PASS: " + name);
                return;
            }
            throw new AssertionError("Expected " + type.getSimpleName() + " but got " + error, error);
        }
        throw new AssertionError("Expected " + type.getSimpleName() + ": " + name);
    }
}
