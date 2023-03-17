
public abstract class Samsung implements Phone {

    private final Integer batteryLife;

    private String color;

    private String material;

    private String messageContent;

    public Samsung(Integer batteryLife, String color, String material) {
        this.batteryLife = batteryLife;
        this.color = color;
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }

    public String getColor() {
        return color;
    }

    public Integer getBatteryLife() {
        return batteryLife;
    }

    @Override
    public void sendMessage(String phoneNumber, String messageContent) {
    }

    @Override
    public void call(String phoneNumber) {

    }

    @Override
    public void viewCallHistory() {

    }

    public abstract void addContact(Integer contactsOrder, String phoneNumber, String lastName, String firstName);

    @Override
    public void seeAllMessages() {

    }

    public void seeExistingContacts() {

    }
}
