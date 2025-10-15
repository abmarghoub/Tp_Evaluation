/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import beans.Femme;
import dao.IDao;
import beans.Homme;
import beans.Mariage;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Abla
 */
public class HommeService implements IDao<Homme> {

    @Override
    public boolean create(Homme o) {
        Session session = null;
        Transaction tx = null;
        boolean etat = false;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(o);
            tx.commit();
            etat = true;
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
            etat = false;
        } finally{
            if (session != null)
                session.close();
        }
        return etat;
    }

    @Override
    public boolean delete(Homme o) {
        Session session = null;
        Transaction tx = null;
        boolean etat = false;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.delete(o);
            tx.commit();
            etat = true;
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
            etat = false;
        } finally{
            if (session != null)
                session.close();
        }
        return etat;
    }

    @Override
    public boolean update(Homme o) {
        Session session = null;
        Transaction tx = null;
        boolean etat = false;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(o);
            tx.commit();
            etat = true;
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
            etat = false;
        } finally{
            if (session != null)
                session.close();
        }
        return etat;
    }

    @Override
    public Homme findById(int id) {
        Session session = null;
        Transaction tx = null;
        Homme homme = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            homme = (Homme) session.get(Homme.class, id);
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally{
            if (session != null)
                session.close();
        }
        return homme;
    }

    @Override
    public List<Homme> findAll() {
        Session session = null;
        Transaction tx = null;
        List<Homme> hommes = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            hommes = session.createQuery("from Homme").list();
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally{
            if (session != null)
                session.close();
        }
        return hommes;
        
    }
    
    public List<Femme> HommeWifeBetweenDate(int HId,Date d1, Date d2) {
        Session session = null;
        Transaction tx = null;
        List<Femme> femmes = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            femmes = session.getNamedQuery("HommeWifeBetweenDate").setParameter("HId", HId).setParameter("d1", d1).setParameter("d2", d2).list();
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally{
            if (session != null)
                session.close();
        }
        return femmes;
    }
    
    public List<Homme> Homme4WifeBetweenDate(Date d1, Date d2) {
    Session session = null;
    Transaction tx = null;
    List<Homme> hommes = null;
    try {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        hommes = session.getNamedQuery("Homme4WifeBetweenDate")
                        .setParameter("debut", d1)
                        .setParameter("fin", d2)
                        .list();
        tx.commit();
    } catch (HibernateException e) {
        if(tx != null) tx.rollback();
        e.printStackTrace();
    } finally {
        if(session != null) session.close();
    }
    return hommes;
}

    
    public void afficherMariagesAvecDetails(Integer hommeId) {
    Session session = null;
    Transaction tx = null;
    try {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();

        Homme h = (Homme) session.get(Homme.class, hommeId);
        if (h == null) {
            System.out.println("Homme introuvable");
            return;
        }

        System.out.println("Nom : " + h.getNom() + " " + h.getPrenom());

        System.out.println("Mariages En Cours :");
        int idx = 1;
        for (Mariage m : h.getMariages()) {
            if (m.getDateFin() == null) {
                System.out.printf("%d. Femme : %s %s   Date Début : %td/%<tm/%<tY    Nbr Enfants : %d%n",
                    idx++, m.getFemme().getNom(), m.getFemme().getPrenom(),
                    m.getDateDebut(), m.getNbrEnfant());
            }
        }

        System.out.println("\nMariages échoués :");
        idx = 1;
        for (Mariage m : h.getMariages()) {
            if (m.getDateFin() != null) {
                System.out.printf("%d. Femme : %s %s  Date Début : %td/%<tm/%<tY  Date Fin : %td/%<tm/%<tY  Nbr Enfants : %d%n",
                    idx++, m.getFemme().getNom(), m.getFemme().getPrenom(),
                    m.getDateDebut(), m.getDateFin(),
                    m.getNbrEnfant());
            }
        }

        tx.commit();
    } catch (HibernateException e) {
        if (tx != null) tx.rollback();
        e.printStackTrace();
    } finally {
        if (session != null) session.close();
    }
}
    
    

}
