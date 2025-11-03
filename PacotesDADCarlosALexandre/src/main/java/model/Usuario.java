package model;

public class Usuario {

    private String user;
    private String email;

    public Usuario() {}

    public Usuario(String user, String email) {
        this.user = user;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "user='" + user + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
