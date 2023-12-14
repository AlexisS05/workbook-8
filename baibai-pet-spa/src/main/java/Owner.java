public class Owner {
    private int ownerId;
    private String firstName;
    private String lastName;
    private String address;
    private String phone;

    public Owner(String firstName, String lastName, String address, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
    }

    public String getLastName() {
        return lastName;
    }
}
