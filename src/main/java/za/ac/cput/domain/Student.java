package za.ac.cput.domain;

import java.util.List;

public class Student {
    protected String studentId;
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String password;
    private List<Address> address;
    private byte[] profileImage;

    protected Student() {}

    public Student(Builder builder) {
        this.studentId = builder.studentId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.password = builder.password;
        this.address = builder.address;
        this.profileImage = builder.profileImage;
    }

    // --- Getters ---
    public String getStudentId() { return studentId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public List<Address> getAddress() { return address; }
    public byte[] getProfileImage() { return profileImage; }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                '}'; // not logging products/images for safety
    }

    public static class Builder {
        private String studentId;
        private String firstName;
        private String lastName;
        private String email;
        private String password;
        private List<Address> address;
        private byte[] profileImage;

        public Builder setStudentId(String studentId) { this.studentId = studentId; return this; }
        public Builder setFirstName(String firstName) { this.firstName = firstName; return this; }
        public Builder setLastName(String lastName) { this.lastName = lastName; return this; }
        public Builder setEmail(String email) { this.email = email; return this; }
        public Builder setPassword(String password) { this.password = password; return this; }
        public Builder setAddress(List<Address> address) { this.address = address; return this; }
        public Builder setProfileImage(byte[] profileImage) { this.profileImage = profileImage; return this; }

        public Builder copy(Student student) {
            this.studentId = student.studentId;
            this.firstName = student.firstName;
            this.lastName = student.lastName;
            this.email = student.email;
            this.password = student.password;
            this.address = student.address;
            this.profileImage = student.profileImage;
            return this;
        }

        public Student build() { return new Student(this); }
    }
}
