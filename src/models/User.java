package models;

public class User {
    private String name;
    private String userId;
    private String password;

    public User(String name, String userId, String password) {
        this.name = name;
        this.userId = userId;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public boolean login(String userId, String password) {
        return this.userId.equals(userId) && this.password.equals(password);
    }
}