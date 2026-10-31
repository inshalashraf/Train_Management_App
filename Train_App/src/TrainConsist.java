import java.util.LinkedList;
import java.util.List;

/**
 * Manages an ordered list of train bogies.
 * Positions are zero-based, like Java List indexes.
 */
public class TrainConsist {
    private final LinkedList<String> bogies = new LinkedList<>();

    public TrainConsist() {
    }

    public TrainConsist(List<String> initialBogies) {
        if (initialBogies == null) {
            throw new IllegalArgumentException("Initial bogie list cannot be null.");
        }
        for (String bogie : initialBogies) {
            addLast(bogie);
        }
    }

    public void addFirst(String bogie) {
        bogies.addFirst(validateBogie(bogie));
    }

    public void addLast(String bogie) {
        bogies.addLast(validateBogie(bogie));
    }

    public void insertAt(int position, String bogie) {
        if (position < 0 || position > bogies.size()) {
            throw new IndexOutOfBoundsException("Position must be between 0 and " + bogies.size() + ".");
        }
        bogies.add(position, validateBogie(bogie));
    }

    public String removeFirst() {
        if (bogies.isEmpty()) {
            throw new IllegalStateException("The train consist is empty.");
        }
        return bogies.removeFirst();
    }

    public String removeLast() {
        if (bogies.isEmpty()) {
            throw new IllegalStateException("The train consist is empty.");
        }
        return bogies.removeLast();
    }

    public boolean remove(String bogie) {
        if (bogie == null || bogie.isBlank()) {
            throw new IllegalArgumentException("Bogie ID cannot be blank.");
        }
        return bogies.remove(bogie.trim());
    }

    public int find(String bogie) {
        if (bogie == null || bogie.isBlank()) {
            throw new IllegalArgumentException("Bogie ID cannot be blank.");
        }
        return bogies.indexOf(bogie.trim());
    }

    public List<String> getBogies() {
        return List.copyOf(bogies);
    }

    public int size() {
        return bogies.size();
    }

    public boolean isEmpty() {
        return bogies.isEmpty();
    }

    private String validateBogie(String bogie) {
        if (bogie == null || bogie.isBlank()) {
            throw new IllegalArgumentException("Bogie ID cannot be blank.");
        }
        String cleaned = bogie.trim();
        if (bogies.contains(cleaned)) {
            throw new IllegalArgumentException("Bogie already exists: " + cleaned);
        }
        return cleaned;
    }
}
