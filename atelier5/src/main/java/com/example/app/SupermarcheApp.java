package com.example.app;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import com.example.service.JsonManager;
import com.example.user.*;
public class SupermarcheApp {
    private static List<Produit> produits = JsonManager.chargerProduits();
    private static Scanner scanner = new Scanner(System.in);
    private static UserRole userRole = new UserRole();

    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Sauvegarde des produits avant de quitter...");
            JsonManager.sauvegarderProduits(produits);
        }));

        User user = authUser();
        if (user == null) {
            System.out.println("Nom d'utilisateur ou mot de passe incorrect.");
            return;
        }
        System.out.println("Connexion réussie en tant que " + user.getRole());
        System.out.println("==========================");
        System.out.println("Bienvenue " + user.getNom() + "!");

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

    private static User authUser() {
        System.out.print("Nom d'utilisateur : ");
        String nom = scanner.nextLine();
        System.out.print("Mot de passe : ");
        String motDePasse = scanner.nextLine();
        return userRole.authenticate(nom, motDePasse);
    }

    private static void ajouterProduit() {
        System.out.print("Entrez l'ID du produit : ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Entrez le nom du produit : ");
        String nom = scanner.nextLine();
        System.out.print("Entrez le prix du produit : ");
        double prix = scanner.nextDouble();
        System.out.print("Entrez la quantité du produit : ");
        int quantite = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Entrez le type de produit (alimentaire, ménager, cosmétique) : ");
        String type = scanner.nextLine();

        Produit produit;
        switch (type.toLowerCase()) {
            case "alimentaire":
                System.out.print("Entrez la date d'expiration : ");
                String dateExpiration = scanner.nextLine();
                System.out.print("Entrez l'origine : ");
                String origine = scanner.nextLine();
                produit = new ProduitAlimentaire(id, nom, prix, quantite, dateExpiration, origine);
                break;
            case "ménager":
                System.out.print("Entrez le type : ");
                String typeMenager = scanner.nextLine();
                System.out.print("Entrez la dangerosité : ");
                String dangerosite = scanner.nextLine();
                produit = new ProduitMenager(id, nom, prix, quantite, typeMenager, dangerosite);
                break;
            case "cosmétique":
                System.out.print("Entrez le type de peau : ");
                String typePeau = scanner.nextLine();
                System.out.print("Est-il testé sur animaux ? (true/false) : ");
                boolean testeSurAnimaux = scanner.nextBoolean();
                produit = new ProduitCosmetique(id, nom, prix, quantite, typePeau, testeSurAnimaux);
                break;
            default:
                System.out.println("Type de produit invalide.");
                return;
        }
        produits.add(produit);
        System.out.println("Produit ajouté avec succès !");
    }

    private static void afficherProduits() {
        if (produits.isEmpty()) {
            System.out.println("Aucun produit à afficher.");
            return;
        }
        for (Produit produit : produits) {
            produit.afficherDetails();
            System.out.println("-------------------------");
        }
    }

    private static void modifierProduit() {
        System.out.print("Entrez l'ID du produit à modifier : ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        for (Produit produit : produits) {
            if (produit.id == id) {
                System.out.print("Entrez le nouveau nom : ");
                produit.nom = scanner.nextLine();
                System.out.print("Entrez le nouveau prix : ");
                produit.prix = scanner.nextDouble();
                System.out.print("Entrez la nouvelle quantité : ");
                produit.quantite = scanner.nextInt();
                System.out.println("Produit modifié avec succès !");
                return;
            }
        }
        System.out.println("Produit non trouvé.");
    }

    private static void supprimerProduit() {
        System.out.print("Entrez l'ID du produit à supprimer : ");
        int id = scanner.nextInt();
        produits.removeIf(produit -> produit.id == id);
        System.out.println("Produit supprimé avec succès !");
    }
}

