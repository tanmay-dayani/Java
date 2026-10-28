package minibank;

public class Customer {
    private static long customerCounter = 100;
    private final String customerId;
    private final String name;
    private final String email;
    private final String mobile;
    private final Address address;

    public Customer(String name, String email, String mobile, Address address) {
        this.customerId = "CUST" + (++customerCounter);
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.address = address;
    }

    public String getCustomerId() { return customerId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getMobile() { return mobile; }
    public Address getAddress() { return address; }

    public static class Address {
        private final String line;
        private final String city;
        private final String pincode;

        public Address(String line, String city, String pincode) {
            this.line = line;
            this.city = city;
            this.pincode = pincode;
        }

        @Override
        public String toString() { return line + ", " + city + " - " + pincode; }
    }
}
