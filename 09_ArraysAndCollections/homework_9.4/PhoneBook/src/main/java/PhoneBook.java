import org.apache.commons.collections.map.HashedMap;
import java.util.*;

public class PhoneBook {
    private Map<String, Set<String>> phoneBook = new HashMap<>();

    public void addContact(String phone, String name) {
        Map<String, Set<String>> testMap = new HashedMap(phoneBook);
        Set<String> testSet = new TreeSet<>();
            if (isPhone(phone) & isName(name)) {
                    for (Map.Entry<String, Set<String>> map : testMap.entrySet()) {
                        String key = map.getKey();
                        Set<String> value = map.getValue();
                        if (key.equals(name)) {
                            testSet = map.getValue();
                        } else if (value.contains(phone)) {
                            testSet = phoneBook.remove(key);
                        }
                    }
                    testSet.add(phone);
                    phoneBook.put(name, testSet);
            }
    }

//        if (!phoneBook.containsKey(name)) {
//            phoneBook.put(name, new HashSet<>());
//        }
//        phoneBook.get(name).add(phone);

    public void print() {
        Set<String> setPrint = new TreeSet<>(getAllContacts());
        for(String data : setPrint) {
            System.out.println(data);
        }
    }

    public String getContactByPhone(String phone) {
        Map<String, Set<String>> getContact = new HashMap<>(phoneBook);
        String result = "";
        for(Map.Entry<String, Set<String>> map : getContact.entrySet()) {
            String key = map.getKey();
            Set<String> value = map.getValue();
            String phonesString = "";
            if (value.contains(phone)) {
                for(String list : value) {
                    phonesString += list + " ";
                }
                result = key + " - " + phone;
                break;
            }
        }
        return result;
    }

    public Set<String> getContactByName(String name) {
        Map<String, Set<String>> getContact = new HashMap<>(phoneBook);
        Set<String> result = new TreeSet<>();
        for(Map.Entry<String, Set<String>> map : getContact.entrySet()) {
            String key = map.getKey();
            if (key.equals(name)) {
                result.add(name + " - " + map.getValue().toString().replaceAll("[^0-9]", ""));
            }

        }
        return result;
    }

    public Set<String> getAllContacts() {
        Map<String, Set<String>> allContacts = new HashMap<>(phoneBook);
        Set<String> setOfContacts = new TreeSet<>();
        for(Map.Entry<String, Set<String>> map : allContacts.entrySet()) {
            String key = map.getKey();
            Set<String> value = map.getValue();
            String result = "";
            for(String phones : value) {
                result += phones + ", ";
            }
            setOfContacts.add(key + " - " + result.substring(0, result.length() - 2));
        }
        return setOfContacts;
    }
    public static boolean isName(String input) {
        return !isPhone(input) & !input.isEmpty();
    }
    public static boolean isPhone(String input) {
        return (input.replaceAll("[^0-9]", "").matches("[0-9]{11}"));
    }
}