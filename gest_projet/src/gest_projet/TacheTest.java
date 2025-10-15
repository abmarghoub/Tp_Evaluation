/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gest_projet;

import Service.ProjetService;
import Service.TacheService;
import entities.Projet;
import entities.Tache;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
/**
 *
 * @author Abla
 */
public class TacheTest {
    
    public static void main(String[] args) {
        try {
            TacheService ts = new TacheService();
            ProjetService ps = new ProjetService();

            // Récupérer le projet existant (id = 1)
            Projet p1 = ps.findById(1);

            // Formatter pour les dates
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date d1 = sdf.parse("12/02/2024");
            Date d2 = sdf.parse("20/02/2024");
            Date d3 = sdf.parse("20/02/2024");
            Date d4 = sdf.parse("10/03/2024");

            // Créer et persister les tâches
            Tache t1 = new Tache("Analyse", d1, d2, 2500, p1);
            Tache t2 = new Tache("Conception", d3, d4, 1500, p1);

            ts.create(t1);
            ts.create(t2);

            // Affichage
            System.out.println(ts.findById(t1.getId()));
            System.out.println(ts.findById(t2.getId()));

            System.out.println("Tâches ajoutées avec succès !");

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    
}
