package eapli.base.app.backoffice.console.Domain;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class User {
    @Id
    private String id;
    private String password;
    public User() {
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
