package user;
import java.util.ArrayList;
import java.util.List;

public class UserRole {
    private List<User> users;

    public UserRole() {
        users = new ArrayList<>();
        users.add(new Admin("paisible", "admin123", "admin"));
        users.add(new Caissier("augustin", "caissier123", "caissier"));
        users.add(new Client("mulet", "client123", "client"));
    }

    public User authenticate(String nom, String motdePasse) {
        for (User  user : users) {
            if (user.getNom().equals(nom) && user.getMotDePasse().equals(motdePasse)) {
                return user;
            }
        }
        return null; 
    }
}