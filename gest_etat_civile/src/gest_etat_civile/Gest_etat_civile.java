package test;

import Service.FemmeService;
import Service.HommeService;
import Service.MariageService;
import beans.Femme;
import beans.Homme;
import beans.Mariage;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Gest_etat_civile {
    public static void main(String[] args) throws ParseException {
        FemmeService femmeService = new FemmeService();
        HommeService hommeService = new HommeService();
        MariageService mariageService = new MariageService();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


        Homme h1 = new Homme("Ali", "Karim", "06000001", "Casa", sdf.parse("01/01/1980"));
        Homme h2 = new Homme("Youssef", "Sami", "06000002", "Rabat", sdf.parse("02/02/1975"));
        Homme h3 = new Homme("Omar", "Hassan", "06000003", "Fès", sdf.parse("03/03/1982"));
        Homme h4 = new Homme("Khalid", "Amine", "06000004", "Agadir", sdf.parse("04/04/1970"));
        Homme h5 = new Homme("Hicham", "Said", "06000005", "Marrakech", sdf.parse("05/05/1978"));

        hommeService.create(h1);
        hommeService.create(h2);
        hommeService.create(h3);
        hommeService.create(h4);
        hommeService.create(h5);


        Femme f1 = new Femme("Sara", "Ait", "0610001", "Casa", sdf.parse("01/01/1985"));
        Femme f2 = new Femme("Nadia", "Bennani", "0610002", "Rabat", sdf.parse("01/01/1990"));
        Femme f3 = new Femme("Imane", "Omar", "0610003", "Agadir", sdf.parse("01/01/1972")); // plus âgée
        Femme f4 = new Femme("Fatima", "Zahra", "0610004", "Fès", sdf.parse("01/01/1995"));
        Femme f5 = new Femme("Salma", "Hassan", "0610005", "Marrakech", sdf.parse("01/01/1992"));
        Femme f6 = new Femme("Kawtar", "El Idrissi", "0610006", "Casa", sdf.parse("01/01/1988"));
        Femme f7 = new Femme("Mouna", "Amrani", "0610007", "Rabat", sdf.parse("01/01/1991"));
        Femme f8 = new Femme("Houda", "Tazi", "0610008", "Agadir", sdf.parse("01/01/1983"));
        Femme f9 = new Femme("Latifa", "Bouzid", "0610009", "Casa", sdf.parse("01/01/1987"));
        Femme f10 = new Femme("Samira", "El Alaoui", "0610010", "Fès", sdf.parse("01/01/1994"));

        femmeService.create(f1);
        femmeService.create(f2);
        femmeService.create(f3);
        femmeService.create(f4);
        femmeService.create(f5);
        femmeService.create(f6);
        femmeService.create(f7);
        femmeService.create(f8);
        femmeService.create(f9);
        femmeService.create(f10);

        Mariage m1 = new Mariage(sdf.parse("01/01/2010"), null, 2);
        m1.setHomme(h1);
        m1.setFemme(f1);
        mariageService.create(m1);

        Mariage m2 = new Mariage(sdf.parse("01/01/2012"), sdf.parse("01/01/2018"), 1);
        m2.setHomme(h1);
        m2.setFemme(f2);
        mariageService.create(m2);

        Mariage m3 = new Mariage(sdf.parse("01/01/2005"), null, 3);
        m3.setHomme(h2);
        m3.setFemme(f3);
        mariageService.create(m3);

        Mariage m4 = new Mariage(sdf.parse("01/01/2011"), null, 0);
        m4.setHomme(h3);
        m4.setFemme(f4);
        mariageService.create(m4);

        Mariage m5 = new Mariage(sdf.parse("01/01/2000"), sdf.parse("01/01/2010"), 2);
        m5.setHomme(h3);
        m5.setFemme(f5);
        mariageService.create(m5);

        Mariage m6 = new Mariage(sdf.parse("01/01/2015"), null, 1);
        m6.setHomme(h4);
        m6.setFemme(f6);
        mariageService.create(m6);

        
        System.out.println("=== Liste des femmes ===");
        for (Femme f : femmeService.findAll()) {
            System.out.println(f);
        }
        Femme plusAgee = femmeService.findAll().stream()
                .min((a, b) -> a.getDateNaissance().compareTo(b.getDateNaissance()))
                .orElse(null);
        System.out.println("\nFemme la plus âgée : " + plusAgee);

        System.out.println("\n__________________________________________");
        for (Femme f : femmeService.FemmeMarie2Fois()) {
            System.out.println(f);
        }

        System.out.println("\n=== Hommes mariés à 4 femmes entre 2000 et 2025 ===");
        for (Homme h : hommeService.Homme4WifeBetweenDate(sdf.parse("01/01/2000"), sdf.parse("01/01/2025"))) {
            System.out.println(h);
        }

        System.out.println("\n____________________________________");
        hommeService.afficherMariagesAvecDetails(h2.getId());
    }
}
