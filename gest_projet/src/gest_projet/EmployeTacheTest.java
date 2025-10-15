/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gest_projet;

import Service.EmployeService;
import Service.EmployeTacheService;
import Service.TacheService;
import entities.Employe;
import entities.EmployeTache;
import entities.Tache;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;
import org.junit.Test;



/**
 *
 * @author Abla
 */
public class EmployeTacheTest {
    
   public static void main(String[] args) throws ParseException {
        EmployeTacheService ets = new EmployeTacheService();
        EmployeService es = new EmployeService();
        TacheService ts = new TacheService();
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            Date d1 = sdf.parse("15/01/2025");
            Date d2 = sdf.parse("01/03/2025");
            Date d3 = sdf.parse("12/02/2024");
            Date d4 = sdf.parse("12/04/2024");
      
        ets.create(new EmployeTache( d1, d2, es.findById(1), ts.findById(2)));
        ets.create(new EmployeTache(d3, d4, es.findById(1), ts.findById(1)));
        
        System.out.println(ets.findById(1));
        System.out.println(ets.findById(2));

        System.out.println("EmployeTache ajoutées avec succès ");
    
    }
    
}
