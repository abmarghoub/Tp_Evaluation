/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Abla
 */
@Entity
@Table(name="EmployeTache")
public class EmployeTache {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Date dateDebutReelle;
    private Date dateFinReelle;

    @ManyToOne
    @JoinColumn(name="employe_id")
    private Employe employe;

    @ManyToOne
    @JoinColumn(name="tache_id")
    private Tache tache;

    public EmployeTache() {
    }

    public EmployeTache(Date dateDebutReelle, Date dateFinReelle, Employe employe, Tache tache) {
        this.dateDebutReelle = dateDebutReelle;
        this.dateFinReelle = dateFinReelle;
        this.employe = employe;
        this.tache = tache;
    }

    

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateDebutReelle() {
        return dateDebutReelle;
    }

    public void setDateDebutReelle(Date dateDebutReelle) {
        this.dateDebutReelle = dateDebutReelle;
    }

    public Date getDateFinReelle() {
        return dateFinReelle;
    }

    public void setDateFinReelle(Date dateFinReelle) {
        this.dateFinReelle = dateFinReelle;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public Tache getTache() {
        return tache;
    }

    public void setTache(Tache tache) {
        this.tache = tache;
    }

    @Override
    public String toString() {
        return "EmployeTache{" + "id=" + id + ", dateDebutReelle=" + dateDebutReelle + ", dateFinReelle=" + dateFinReelle + ", employe=" + employe + ", tache=" + tache + '}';
    }
    

    
}
