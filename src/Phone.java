import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Phone {
    List<Contact> contacts;
    private String messageContent;

    private Integer numberOfCalls = 0;
    private final Integer batteryLife;

    private Integer changingBatteryLife;
   // private Integer contactID;

    private Map<String, List<String>> messages;

    private Map<String, Integer> calls;

    public Integer getBatteryLife() {
        return batteryLife;
    }

    public Integer getNumberOfCalls() {
        return numberOfCalls;
    }

    public void setNumberOfCalls(Integer numberOfCalls) {
        this.numberOfCalls = numberOfCalls;
    }

    public Integer getChangingBatteryLife() {
        return changingBatteryLife;
    }

    public void setChangingBatteryLife(Integer changingBatteryLife) {
        this.changingBatteryLife = changingBatteryLife;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public Map<String, Integer> getCalls() {
        return calls;
    }

    public Phone(Integer batteryLife) {
        this.batteryLife = batteryLife;
        this.changingBatteryLife = batteryLife;
        messages = new HashMap<>();
        contacts = new ArrayList<>();
        calls = new HashMap<>();
    }

    public void addContact(Integer contactID, String phoneNumber, String lastName, String firstName) {
        contacts.add(new Contact(contactID, phoneNumber, lastName, firstName));
    }

    void sendMessage(String phoneNumber, String messageContent) {
        if (changingBatteryLife < 1) {
            System.out.println("You don't have enough battery life in order to send a message");
            return;
        }
        changingBatteryLife = changingBatteryLife - 1;
        setChangingBatteryLife(changingBatteryLife);

        if (messages.get(phoneNumber) == null) {
            messages.put(phoneNumber, new ArrayList<>());
        }

        if (messageContent.length() > 500) {
            messageContent = messageContent.substring(0, 500);
        }

        messages.get(phoneNumber).add(messageContent);
    }

    public void call(String phoneNumber) {
        if (changingBatteryLife < 2) {
            System.out.println("You don't have enough battery life in order to make a call");
        } else {
            changingBatteryLife = changingBatteryLife - 2;
            setChangingBatteryLife(changingBatteryLife);
            numberOfCalls = numberOfCalls + 1;
            setNumberOfCalls(numberOfCalls);

        }
        if (calls.get(phoneNumber) == null) {
            calls.put(phoneNumber, numberOfCalls);

        }
        calls.put(phoneNumber, numberOfCalls);

    }

    public void getCallHistory() {
        if (calls.isEmpty()) {
            System.out.println("We have 0 calls!");
            return;
        }
        System.out.println(calls);
    }

    public void getAllMessages() {
        if (messages.isEmpty()) {
            System.out.println("We don't have messages!");
            return;
        }
        System.out.println(messages);
    }

    public void getExistingContacts() {
        if (contacts.isEmpty()) {
            System.out.println("We have no contacts!");
            return;
        }
        for (int i = 0; i < getContacts().size(); i++) {
            System.out.println((getContacts().get(i)));
        }
    }

    public void getFirstMessage(String phoneNumber) {
        if (!messages.containsKey(phoneNumber)) {
            System.out.println("There is no message");
            return;
        }
        if (messages.containsKey(phoneNumber) && messages.get(phoneNumber).isEmpty()) {
            System.out.println("There is no message");
            return;
        }
        System.out.println("The first message: ");
        System.out.println(messages.get(phoneNumber).get(0));

    }

    public void getSecondMessage(String phoneNumber) {
        if (!messages.containsKey(phoneNumber)) {
            System.out.println("There is no message");
            return;
        }
        if (messages.containsKey(phoneNumber) && messages.get(phoneNumber).size() <= 1) {
            System.out.println("There is no second message");
            return;
        } else {
            System.out.println("The second message: ");
            System.out.println(messages.get(phoneNumber).get(1));
        }

    }

    public void getFirstContact() {
        if (contacts.isEmpty()) {
            System.out.println("We have no contacts!");
            return;
        }
        System.out.println("The first contact:");
        System.out.println(contacts.get(0));
    }

    public void getLastContact() {
        if (contacts.isEmpty()) {
            System.out.println("We have no contacts");
            return;
        }

        if (contacts.size() == 1) {
            System.out.println("We have only one contact:");
            System.out.println(contacts.get(0));
            return;
        }
        System.out.println("The last contact:");
        System.out.println(contacts.get(contacts.size() - 1));
    }

}
