import java.util.*;

public class PhoneBook {
    private final Map<String, Set<String>> phoneBook = new HashMap<>();

    public void addPhoneNumber(String name, String phoneNumber) {
        phoneBook.computeIfAbsent(name, k -> new HashSet<>()).add(phoneNumber);
    }

    public void removePhoneNumber(String name, String phoneNumber) {
        if (phoneBook.containsKey(name)) {
            phoneBook.get(name).remove(phoneNumber);
            if (phoneBook.get(name).isEmpty()) {
                phoneBook.remove(name);
            }
        }
    }

    public List<Map.Entry<String, Set<String>>> getSortedPhoneBook() {
        List<Map.Entry<String, Set<String>>> entries = new ArrayList<>(phoneBook.entrySet());
        entries.sort((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()));
        return entries;
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addPhoneNumber("Peter", "00001");
        phoneBook.addPhoneNumber("Alice", "12345");
        phoneBook.addPhoneNumber("Bob", "23456");
        phoneBook.addPhoneNumber("Bob", "23456324");
        phoneBook.addPhoneNumber("Bob", "23456234");
        phoneBook.addPhoneNumber("Alice", "34567");

        for (Map.Entry<String, Set<String>> entry : phoneBook.getSortedPhoneBook()) {
    System.out.println(entry.getKey() + ": " + entry.getValue() + "\n");
}

    }
}
