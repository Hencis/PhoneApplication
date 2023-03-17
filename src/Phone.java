public interface Phone {

    public void addContact(Integer contactsOrder, String phoneNumber, String lastName, String firstName);

    void sendMessage(String phoneNumber, String messageContent);

    public void call(String phoneNumber);

    public void viewCallHistory();

    public void seeAllMessages();

    public void seeExistingContacts();

}
