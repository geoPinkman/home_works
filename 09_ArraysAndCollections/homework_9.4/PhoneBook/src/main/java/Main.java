import org.apache.commons.collections.map.HashedMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PhoneBook book = new PhoneBook();
        book.addContact("89025295041", "");
        book.addContact("89147871234", "geo");
        book.addContact("89039999898", "zeo");
        book.print();
        System.out.println("***");
        book.addContact("89025295041", "zeo");
        book.print();
        System.out.println("***");
        book.addContact("89025295041", "teo");
        book.print();
        System.out.println("***");
        book.addContact("89025295051", "teo");
        book.print();
        System.out.println("***");
        book.addContact("89025295051", "qqeo");
        book.print();
        System.out.println("***");
    }
}
