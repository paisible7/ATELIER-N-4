package user;

public abstract class User {
    private String nom;
    private String motDePasse;

    public User(String nom, String motDePasse) {
        this.nom = nom;
        this.motDePasse = motDePasse;
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

}
