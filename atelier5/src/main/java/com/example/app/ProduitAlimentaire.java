package com.example.app;
public class ProduitAlimentaire extends Produit {
    private String dateExpiration;
    private String origine;

    public ProduitAlimentaire(int id, String nom, double prix, int quantite, String dateExpiration, String origine) {
        super(id, nom, prix, quantite);
        this.dateExpiration = dateExpiration;
        this.origine = origine;
    }

    public String getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(String dateExpiration) {
        this.dateExpiration = dateExpiration;
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
