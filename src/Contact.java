public class Contact {

    Integer contactID;
    String phoneNumber;
    String firstName;
    String lastName;

    public Contact(Integer contactID, String phoneNumber, String firstName, String lastName) {
        this.contactID = contactID;
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Contact{" + "contactID=" + contactID + ", phoneNumber='" + phoneNumber + '\'' + ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + '}';
    }

    public String getFirstName() { return firstName; }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Integer getContactID() {
        return contactID;
    }

    public String getLastName() {
        return lastName;
    }
}
