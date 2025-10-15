/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gest_projet;


import Service.EmployeService;
import entities.Employe;



/**
 *
 * @author Abla
 */
public class EmployeTest {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EmployeService es = new EmployeService();
        
        es.create(new Employe("Marghoub", "Abla","0660129596"));
        es.create(new Employe("Addahbi", "Amina", "0662031506"));
        
        System.out.println(es.findById(1));
        System.out.println(es.findById(2));

        System.out.println("Employe ajoutées avec succès ");
    
    }
    
}
