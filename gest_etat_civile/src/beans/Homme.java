/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author Abla
 */
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Homme")

@NamedQueries({
    @NamedQuery(
    name = "HommeWifeBetweenDate",
    query = "select m.femme from Mariage m where m.homme.id = :HId AND m.dateDebut BETWEEN :d1 AND :d2"
),

    @NamedQuery(
        name = "Homme4WifeBetweenDate",
        query = "SELECT m.homme FROM Mariage m WHERE m.dateDebut BETWEEN :debut AND :fin GROUP BY m.homme HAVING COUNT(m.femme) = 4" )
})

public class Homme extends Personne {

    @OneToMany(mappedBy = "homme", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Mariage> mariages = new ArrayList<>();

    public Homme() {
    }

    public List<Mariage> getMariages() {
        return mariages;
    }

    public void setMariages(List<Mariage> mariages) {
        this.mariages = mariages;
    }

    public Homme(String nom, String prenom, String telephone, String adresse, Date dateNaissance) {
        super(nom, prenom, telephone, adresse, dateNaissance);
    }

   
    public void addMariage(Mariage m) {
        mariages.add(m);
        m.setHomme(this);
    }
}