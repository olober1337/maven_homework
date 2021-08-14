package homework1.entities;

public class Human {

    private String name;
    private String lastName;
    private int age;
    private String emailAddress;
    private String password;
    private Roles role;

    public Human(Roles role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return name + "\n"
                + lastName + "\n"
                + age + "\n"
                + emailAddress + "\n"
                + password + "\n"
                + role + "\n";
    }
}