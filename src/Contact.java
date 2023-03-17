public class Contact {

    Integer contactsOrder;
    String phoneNumber;
    String firstName;
    String lastName;

    public Contact(Integer contactsOrder, String phoneNumber, String firstName, String lastName) {
        this.contactsOrder = contactsOrder;
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "contactsOrder=" + contactsOrder +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public String getFirstName() { return firstName; }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Integer getContactsOrder() {
        return contactsOrder;
    }

    public String getLastName() {
        return lastName;
    }
}
