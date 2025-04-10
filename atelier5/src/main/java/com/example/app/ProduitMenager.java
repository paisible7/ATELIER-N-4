package com.example.app;
public class ProduitMenager extends Produit {
    private String typeProduit;
    private String dateFabrication;

    public ProduitMenager(int id, String nom, double prix, int quantite, String typeProduit, String dateFabrication) {
        super(id, nom, prix, quantite);
        this.typeProduit = typeProduit;
        this.dateFabrication = dateFabrication;
    }

    public String getTypeProduit() {
        return typeProduit;
    }

    public void setTypeProduit(String typeProduit) {
        this.typeProduit = typeProduit;
    }

    public String getDateFabrication() {
        return dateFabrication;
    }

    public void setDateFabrication(String dateFabrication) {
        this.dateFabrication = dateFabrication;
    }

    @Override
    public void afficherDetails() {
        super.afficherDetails();
        System.out.println("Type: " + typeProduit + ", Date de Fabrication: " + dateFabrication);
    }
    
}
