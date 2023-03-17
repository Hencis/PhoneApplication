import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Map<String, Integer> calls = new HashMap<>();

        Phone phone = new SamsungGalaxy6(10, "blue", "steel", "1234gggr");
        Phone phone1 = new SamsungGalaxy6(15, "red", "steel", "12567hgf");

        phone.addContact(1, "phone number", "first name", "last name");
        phone.addContact(2, "second phone number", "second first name", "second last name");

        phone1.addContact(1, "phone number1", "first name1", "last name1");
        phone1.addContact(2, "second phone number1", "second first name1", "second last name1");

        System.out.println("See existing contacts in the first phone: ");
        phone.seeExistingContacts();
        System.out.println("\n");

        System.out.println("See existing contacts in the second phone: ");

        phone1.seeExistingContacts();
        System.out.println('\n');

        ((SamsungGalaxy6) phone).getFirstContact();
        ((SamsungGalaxy6) phone).getLastContact();

        System.out.println("\n");


        phone.sendMessage("phone number", "message content");
        phone.sendMessage("phone number", "message content2");
        ((SamsungGalaxy6) phone).getFirstMessage("phone number");
        ((SamsungGalaxy6) phone).getSecondMessage("phone number");

        //phone1.sendMessage("0755982345", "message content1");

        phone.call("second phone number");
        phone.call("second phone number");
        phone.call("second phone number");

        phone.viewCallHistory();
        phone1.viewCallHistory();

        System.out.println("Phone's messages: ");
        phone.seeAllMessages();
        //System.out.println("\n");
        System.out.println("Phone1's messages: ");
        phone1.seeAllMessages();


    }
}