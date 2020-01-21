package pl.edu.wszib.model;

public class RegisterUser {
    private String login;
    private String pass;
    private String repeatPass;
    private String name;
    private String surname;
    private int age;
    private String email;

    @Override
    public String toString() {
        return "RegisterUser{" +
                "login='" + login + '\'' +
                ", pass='" + pass + '\'' +
                ", repeatPass='" + repeatPass + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public RegisterUser(String login) {
        this.login = login;
    }

    public RegisterUser(String login, String pass, String repeatPass, String name, String surname, int age) {
        this.login = login;
        this.pass = pass;
        this.repeatPass = repeatPass;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public RegisterUser() {

    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getRepeatPass() {
        return repeatPass;
    }

    public void setRepeatPass(String repeatPass) {
        this.repeatPass = repeatPass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
