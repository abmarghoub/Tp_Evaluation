/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gest_projet;

import Service.EmployeService;
import Service.ProjetService;
import entities.Employe;
import entities.Projet;
import java.util.Date;

/**
 *
 * @author Abla
 */
public class ProjetTest {
    
    public static void main(String[] args) {
        ProjetService ps = new ProjetService();
        
        EmployeService es = new EmployeService();
        Employe e1 = es.findById(1);
        Employe e2 = es.findById(2);

        
        
        ps.create(new Projet("Gestion de stock", new Date("12/02/2024"),new Date("12/04/2024"),e1));
        ps.create(new Projet("Gestion de bib", new Date("15/01/2025"),new Date("01/03/2025"),e2));
        
        System.out.println(ps.findById(1));
        System.out.println(ps.findById(2));

        System.out.println("Projet ajoutées avec succès ");
    
    }
    
}
