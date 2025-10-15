/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Abla
 */
@Entity
@Table(name="Projet")

@NamedQueries({
    @NamedQuery(name = "TachePlanifie", query = "from Tache t where t.projet.id = :PrjId"),
    @NamedQuery(name = "TacheRealisee", query = "from EmployeTache et where et.tache.projet.id = :PrTd")
})

public class Projet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nom;
    private Date dateDebut;
    private Date dateFin;

    @ManyToOne
    @JoinColumn(name="chef_id")
    private Employe chefProjet;

    @OneToMany(mappedBy="projet")
    private List<Tache> taches;

    public Projet() {
    }

    

    public Projet(String nom, Date dateDebut, Date dateFin, Employe chefProjet) {
        this.nom = nom;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.chefProjet = chefProjet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Employe getChefProjet() {
        return chefProjet;
    }

    public void setChefProjet(Employe chefProjet) {
        this.chefProjet = chefProjet;
    }

    public List<Tache> getTaches() {
        return taches;
    }

    public void setTaches(List<Tache> taches) {
        this.taches = taches;
    }

    @Override
    public String toString() {
        return "Projet{" + "id=" + id + ", nom=" + nom + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", chefProjet=" + chefProjet + '}';
    }

    

    
}
