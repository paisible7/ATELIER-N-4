package app;
public class ProduitAlimenaire extends Produit {
    private String dateExpiration;
    private String origine;

    public ProduitAlimenaire(int id, String nom, double prix, int quantite, String dateExpiration, String origine) {
        super(id, nom, prix, quantite);
        this.dateExpiration = dateExpiration;
        this.origine = origine;
    }

    public String getDatePeremption() {
        return dateExpiration;
    }

    public void setDatePeremption(String datePeremption) {
        this.dateExpiration = datePeremption;
    }

    public String getOrigine() {
        return origine;
    }

    public void setOrigine(String origine) {
        this.origine = origine;
    }

    @Override
    public void afficherDetails() {
        super.afficherDetails();
        System.out.println("Date d'expiration: " + dateExpiration + ", Origine: " + origine);
    }
    
    
}
