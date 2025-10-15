/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gest_projet;

/**
 *
 * @author Abla
 */
import Service.EmployeService;
import Service.ProjetService;
import Service.TacheService;
import entities.EmployeTache;
import entities.Projet;
import entities.Tache;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.junit.Test;

public class QueryTest {

    
    public static void main(String[] args) {
    EmployeService es = new EmployeService();
    ProjetService ps = new ProjetService();
    TacheService ts = new TacheService();

    try {
        System.out.println("===== TÂCHES PAR EMPLOYÉ =====");
        List<Tache> tachesEmploye = es.TacheRealiseParEmp(1);
        if (tachesEmploye != null) {
            for (Tache t : tachesEmploye) {
                System.out.println(" - " + t.getId() + " | " + t.getNom());
            }
        } else {
            System.out.println("Aucune tâche trouvée.");
        }

        System.out.println("\n===== PROJETS PAR EMPLOYÉ =====");
        List<Projet> projetsEmploye = es.ProjetGereParEmp(1);
        if (projetsEmploye != null && !projetsEmploye.isEmpty()) {
            for (Projet p : projetsEmploye) {
                if (p != null) {
                    System.out.println(" - Projet: " + p.getId() + " | " + p.getNom());
                }
            }
        } else {
            System.out.println("Aucun projet trouvé pour cet employé.");
        }

        System.out.println("\n===== TÂCHES PLANIFIÉES D’UN PROJET =====");
        List<Tache> tachesPlanifiees = ps.TachePlanifie(1);
        if (tachesPlanifiees != null) {
            for (Tache t : tachesPlanifiees) {
                System.out.println(" - " + t.getId() + " | " + t.getNom() +
                        " | Début: " + t.getDateDebut() +
                        " | Fin: " + t.getDateFin());
            }
        }

        System.out.println("\n===== TÂCHES RÉALISÉES D’UN PROJET =====");
        List<EmployeTache> tachesRealisees = ps.TacheRealisee(1);
        if (tachesRealisees != null) {
            for (EmployeTache et : tachesRealisees) {
                System.out.println(" - " + et.getTache().getId() +
                        " | " + et.getTache().getNom() +
                        " | Début réel: " + et.getDateDebutReelle() +
                        " | Fin réelle: " + et.getDateFinReelle());
            }
        }

        System.out.println("\n===== TÂCHES AVEC PRIX > 1000 =====");
        List<Tache> tachesChères = ts.TachePrixSup();
        if (tachesChères != null) {
            for (Tache t : tachesChères) {
                System.out.println(" - " + t.getId() + " | " + t.getNom() +
                        " | Prix: " + t.getPrix());
            }
        }

        System.out.println("\n===== TÂCHES ENTRE DEUX DATES =====");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date d1 = sdf.parse("01/02/2023");
        Date d2 = sdf.parse("31/12/2023");

        List<EmployeTache> tachesDates = ts.TacheBetweenDate(d1, d2);
        if (tachesDates != null) {
            for (EmployeTache et : tachesDates) {
                System.out.println(" - " + et.getTache().getNom() +
                        " | Début réel: " + et.getDateDebutReelle() +
                        " | Fin réelle: " + et.getDateFinReelle());
            }
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}
}