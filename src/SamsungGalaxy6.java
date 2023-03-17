import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SamsungGalaxy6 extends Samsung {

    List<Contact> contacts;

    private Integer numberOfCalls = 0;

    private String IMEI;

    private String firstName;

    private String lastName;

    private Integer changingBatteryLife;
    private Integer contactID;

    private Map<String, List<String>> messages;

    private Map<String, Integer> calls;

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

    public Integer getContactID() {
        return contactID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<Contact> getContacts() { return contacts; }

    public Map<String, Integer> getCalls() { return calls; }

    public SamsungGalaxy6(Integer batteryLife, String color, String material, String IMEI) {
        super(batteryLife, color, material);
        this.IMEI = IMEI;
        this.changingBatteryLife = batteryLife;
        messages = new HashMap<>();
        contacts=new ArrayList<>();
        calls=new HashMap<>();
    }

    @Override
    public void addContact(Integer contactID, String phoneNumber, String lastName, String firstName) {
        contacts.add(new Contact(contactID, phoneNumber, lastName, firstName));
    }

    @Override
    public String toString() {
        return "SamsungGalaxy6{" +
                "contacts=" + contacts +
                ", IMEI='" + IMEI + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", changingBatteryLife=" + changingBatteryLife +
                ", contactID=" + contactID +
                '}';
    }

    public void sendMessage(String phoneNumber, String messageContent) {
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
        //System.out.println(messages);
    }


   public void viewCallHistory() {
        if(calls.isEmpty()){
            System.out.println("We have 0 calls!");
            return;
        }
       System.out.println(calls);

    }

    public void seeExistingContacts() {
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

    @Override
    public void seeAllMessages() {
        if(messages.isEmpty()){
            System.out.println("We don't have messages!");
            return;
        }
        System.out.println(messages);
    }
}
