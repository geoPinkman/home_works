public class Customer {
    private final String name;
    private final String phone;
    private final String email;
    final String PHONE_FORMAT = "^\\+?7(\\d{10})$";
    final String EMAIL_FORMAT = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public Customer(String name, String email, String phone) {
        this.name = name;
        if (!phone.matches(PHONE_FORMAT)) {
            throw new IllegalArgumentException("Wrong phone format. \n use +79215637722 format");
        }
        this.phone = phone;
        if (!email.matches(EMAIL_FORMAT)) {
            throw new IllegalArgumentException("Wrong email format. \n use vasily.petrov@gmail.com");
        }
        this.email = email;
    }

    public String toString() {
        return name + " - " + email + " - " + phone;
    }
}
