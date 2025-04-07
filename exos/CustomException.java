package exos;

import java.util.Scanner;

public class CustomException {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            Animal animal = new Animal("Chien", 5);
            System.out.println("nom : " + animal.getNom() + ", Âge : " + animal.getAge());

            System.out.print("entrer l'âge pour l'animal : ");
            int nouvelAge = scanner.nextInt();
            animal.setAge(nouvelAge);
            System.out.println("Âge mis à jour : " + animal.getAge());
        } catch (AgeInvalidException e) {
            System.out.println("Erreur : " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Une erreur est survenue : " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}