package net.kumasi.ushop.domain.shopper;

import java.util.Objects;

public class Person {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String confirmPassword;

    public Person() {}

    public Person(String firstName, String lastName, String email, String password, String confirmPassword) {
        loadProperties(null,firstName,lastName,email,password,confirmPassword);
    }

    public Person(Integer id, String firstName, String lastName, String email, String password, String confirmPassword) {
        loadProperties(id,firstName,lastName,email,password,confirmPassword);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return email.equals(person.email) && password.equals(person.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, password);
    }

    private void loadProperties(Integer id, String firstName, String lastName, String email, String password, String confirmPassword)  {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                '}';
    }
}
