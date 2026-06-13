package za.ac.cput.domain;

public class ContactDetails {
    private String cellNumber;
    private String email;
    private String homePhone;
    private String workPhone;
    private String emergencyContact;

    protected ContactDetails() {}

    private ContactDetails(Builder builder) {
        this.cellNumber = builder.cellNumber;
        this.email = builder.email;
        this.homePhone = builder.homePhone;
        this.workPhone = builder.workPhone;
        this.emergencyContact = builder.emergencyContact;
    }

    // Getters
    public String getCellNumber() { return cellNumber; }
    public String getEmail() { return email; }
    public String getHomePhone() { return homePhone; }
    public String getWorkPhone() { return workPhone; }
    public String getEmergencyContact() { return emergencyContact; }

    // Validation methods
    public boolean validateEmail() {
        return email != null && email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }

    public boolean validatePhone() {
        return cellNumber != null && cellNumber.matches("^[0-9]{10}$");
    }

    @Override
    public String toString() {
        return "ContactDetails{" +
                "cellNumber='" + cellNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public static class Builder {
        private String cellNumber;
        private String email;
        private String homePhone;
        private String workPhone;
        private String emergencyContact;

        public Builder setCellNumber(String cellNumber) { this.cellNumber = cellNumber; return this; }
        public Builder setEmail(String email) { this.email = email; return this; }
        public Builder setHomePhone(String homePhone) { this.homePhone = homePhone; return this; }
        public Builder setWorkPhone(String workPhone) { this.workPhone = workPhone; return this; }
        public Builder setEmergencyContact(String emergencyContact) { this.emergencyContact = emergencyContact; return this; }

        public ContactDetails build() { return new ContactDetails(this); }
    }
}
