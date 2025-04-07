package exos;

public class Animal {
    private String nom;
    private int age;

    public Animal(String nom, int age) throws AgeInvalidException {
        this.nom = nom;
        setAge(age); 
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws AgeInvalidException {
        if (age < 0) {
            throw new AgeInvalidException("L'âge ne peut pas être négatif.");
        }
        this.age = age;
    }
}