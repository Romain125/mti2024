package org.example;





public class User {

    private String mail;
    private String name;
    private String phone;

    public User(String mail, String name, String phone) {
        this.mail = mail;
        this.name = name;
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }
}
