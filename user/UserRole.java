package user;
import java.util.ArrayList;
import java.util.List;

public class UserRole {
    private List<User> users;

    public UserRole() {
        users = new ArrayList<>();
        users.add(new Admin("admin", "admin123", "admin"));
        users.add(new Caissier("caissier", "caissier123", "caissier"));
        users.add(new Client("client", "client123", "client"));
    }

    public User authenticate(String nom, String motdePasse) {
        for (User  user : users) {
            if (user.getnom().equals(nom) && user.getmotDePasse().equals(motdePasse)) {
                return user;
            }
        }
        return null; 
    }
}