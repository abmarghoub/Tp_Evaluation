/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 *
 * @author Abla
 */


@Entity
@Table(name = "Femme")
@NamedQueries({
    @NamedQuery(
        name = "FemmeMarie2Fois",
        query = "SELECT f FROM Femme f WHERE (SELECT COUNT(m) FROM Mariage m WHERE m.femme = f) >= 2"
    )
})
@NamedNativeQueries({
    @NamedNativeQuery(
        name = "NbEnfantsBetweenDate",
        query = "SELECT SUM(m.nbr_enfant) as total FROM mariage m WHERE m.femme_id = :fId AND m.date_debut BETWEEN :d1 AND :d2",
        resultSetMapping = "ScalarInteger"
    )
})
@SqlResultSetMapping(name = "ScalarInteger", columns = {@ColumnResult(name = "total", type = Integer.class)})
public class Femme extends Personne {

    @OneToMany(mappedBy = "femme", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Mariage> mariages = new ArrayList<>();

    public Femme() {
    }

    public Femme(String nom, String prenom, String telephone, String adresse, Date dateNaissance) {
        super(nom, prenom, telephone, adresse, dateNaissance);
    }

    public List<Mariage> getMariages() {
        return mariages;
    }

    public void setMariages(List<Mariage> mariages) {
        this.mariages = mariages;
    }
    
    

    // getters/setters
    public void addMariage(Mariage m) {
        mariages.add(m);
        m.setFemme(this);
    }
}