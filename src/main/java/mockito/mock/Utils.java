package mockito.mock;

public class Utils {
    public static ContactInformation createContactInformation(String email) {
        return createContactInformation(email, "Great Britan", "London", 04200);
    }

    public static ContactInformation createContactInformation(String email, String country, String city, Integer postalCode) {
        Address address = new Address();
        address.setCountry(country);
        address.setCity(city);
        address.setPostalCode(postalCode);

        ContactInformation contactInformation = new ContactInformation();
        contactInformation.setEmail(email);
        contactInformation.setAddress(address);
        contactInformation.setEmail(email);

        return contactInformation;

    }
}
