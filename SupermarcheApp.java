import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SupermarcheApp {
    private static List<Produit> produits = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choix;
        do {
            System.out.println("Menu :");
            System.out.println("1. Ajouter un produit");
            System.out.println("2. Afficher tous les produits");
            System.out.println("3. Modifier un produit");
            System.out.println("4. Supprimer un produit");
            System.out.println("5. Quitter");
            System.out.print("Choisissez une option : ");
            choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    ajouterProduit();
                    break;
                case 2:
                    afficherProduits();
                    break;
                case 3:
                    modifierProduit();
                    break;
                case 4:
                    supprimerProduit();
                    break;
                case 5:
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        } while (choix != 5);
    }

}

