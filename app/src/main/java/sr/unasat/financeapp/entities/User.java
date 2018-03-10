package sr.unasat.financeapp.entities;

public class User {
    public String id;
    public String userName;
    public String email;
    public String password;
    public String goal;

    public User(String id, String userName, String email, String password, String goal) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.goal = goal;
    }

}