package com.example.service;
import java.util.List;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import com.example.app.*;
import java.io.*;
import java.nio.file.*;

public class JsonManager {
    private static final String FILE_PATH = "produits.json";

    public static void sauvegarderProduits(List<Produit> produits) {
        JSONArray jsonArray = new JSONArray();
        
        for (Produit p : produits) {
            JSONObject jsonProduit = new JSONObject();
            jsonProduit.put("id", p.getId());
            jsonProduit.put("nom", p.getNom());
            jsonProduit.put("prix", p.getPrix());
            jsonProduit.put("quantite", p.getQuantite());
            
            if (p instanceof ProduitAlimentaire) {
                ProduitAlimentaire pa = (ProduitAlimentaire) p;
                jsonProduit.put("type", "alimentaire");
                jsonProduit.put("dateExpiration", pa.getDateExpiration());
                jsonProduit.put("origine", pa.getOrigine());
            }
            
            jsonArray.put(jsonProduit);
        }
        
        try (FileWriter file = new FileWriter(FILE_PATH)) {
            file.write(jsonArray.toString(4));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Produit> chargerProduits() {
        List<Produit> produits = new ArrayList<>();
        
        try {
            String content = new String(Files.readAllBytes(Paths.get(FILE_PATH)));
            JSONArray jsonArray = new JSONArray(content);
            
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                String type = obj.optString("type", "standard");
                
                Produit p;
                switch (type) {
                    case "alimentaire":
                        p = new ProduitAlimentaire(
                            obj.getInt("id"),
                            obj.getString("nom"),
                            obj.getDouble("prix"),
                            obj.getInt("quantite"),
                            obj.getString("dateExpiration"),
                            obj.getString("origine")
                        );
                        break;
                    default:
                        p = new Produit(   
                            obj.getInt("id"),
                            obj.getString("nom"),
                            obj.getDouble("prix"),
                            obj.getInt("quantite")
                        );
                        break;
                }
                produits.add(p);
            }
        } catch (IOException e) {
            System.out.println("Création d'un nouveau fichier...");
        }
        return produits;
    }
}
