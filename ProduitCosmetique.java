public class ProduitCosmetique extends Produit {
    private String typePeau;
    private Boolean testeSurAnimaux;

    public ProduitCosmetique(int id, String nom, double prix, int quantite, String typePeau, Boolean testeSurAnimaux) {
        super(id, nom, prix, quantite);
        this.typePeau = typePeau;
        this.testeSurAnimaux = testeSurAnimaux;
    }

    public String getTypePeau() {
        return typePeau;
    }

    public void setTypePeau(String typePeau) {
        this.typePeau = typePeau;
    }

    public Boolean getTesteSurAnimaux() {
        return testeSurAnimaux;
    }

    public void setTesteSurAnimaux(Boolean testeSurAnimaux) {
        this.testeSurAnimaux = testeSurAnimaux;
    }

    @Override
    public void afficherDetails() {
        super.afficherDetails();
        System.out.println("Type de peau: " + typePeau + ", Testé sur animaux: " + testeSurAnimaux);
    }
    
}