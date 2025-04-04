package user;

public abstract class User {
    private String nom;
    private String motDePasse;
    private String role;

    public User(String nom, String motDePasse, String role) {
        this.nom = nom;
        this.motDePasse = motDePasse;
        this.role = role;
    }

    public String getnom() {
        return nom;
    }

    public void setnom(String nom) {
        this.nom = nom;
    }

    public String getmotDePasse() {
        return motDePasse;
    }

    public void setmotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }



}
