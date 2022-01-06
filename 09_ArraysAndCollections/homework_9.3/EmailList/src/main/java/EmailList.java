import java.util.*;


public class EmailList {
    public static final String REGEX = "[a-zA-Z0-9]+[._a-zA-Z0-9!#$%&'*+-/=?^`{|}~]*[a-zA-Z]*@[a-zA-Z0-9]{2,8}.[a-zA-Z.]{2,6}";
    public static final String WRONG_EMAIL_ANSWER = "Неверный формат email";
    Set<String> mailList = new HashSet<>();

    public void add(String email) {
        String toCorrect = email.toLowerCase();
        if (mailList.contains(toCorrect)) {
            System.out.println("this mail is already in list");
        } else if (toCorrect.matches(REGEX)) {
            mailList.add(toCorrect);
            System.out.println("ok");
        } else {
            System.out.println(WRONG_EMAIL_ANSWER);
        }
    }
    public List<String> getSortedEmails() {
        List<String> sortedList = new ArrayList<>(mailList);
        Collections.sort(sortedList);
        return sortedList;
    }

}
