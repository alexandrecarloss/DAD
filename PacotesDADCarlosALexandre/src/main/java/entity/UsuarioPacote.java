package entity;

import javax.persistence.*;

@Entity
public class UsuarioPacote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique=true, nullable = false)
    private String user;
    @Column(unique=true,nullable = false)
    private String email;

    public UsuarioPacote() {}

    public UsuarioPacote(String user, String email) {
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
