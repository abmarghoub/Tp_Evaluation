/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import dao.IDao;
import beans.Femme;
import java.util.Date;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Abla
 */
public class FemmeService implements IDao<Femme> {

    @Override
    public boolean create(Femme o) {
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
    public boolean delete(Femme o) {
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
    public boolean update(Femme o) {
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
    public Femme findById(int id) {
        Session session = null;
        Transaction tx = null;
        Femme femme = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            femme = (Femme) session.get(Femme.class, id);
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally{
            if (session != null)
                session.close();
        }
        return femme;
    }

    @Override
    public List<Femme> findAll() {
        Session session = null;
        Transaction tx = null;
        List<Femme> femmes = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            femmes = session.createQuery("from Femme").list();
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
    public int NbEnfantsBetweenDate(int fId, Date d1, Date d2) {
    Session session = null;
    Transaction tx = null;
    Integer total = 0;
    try {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        total = (Integer) session.getNamedQuery("NbEnfantsBetweenDate")
                        .setParameter("fId", fId)
                        .setParameter("d1", d1)
                        .setParameter("d2", d2)
                        .uniqueResult();
        tx.commit();
    } catch (HibernateException e) {
        if(tx != null) tx.rollback();
        e.printStackTrace();
    } finally {
        if(session != null) session.close();
    }
    // si la femme n’a pas eu d’enfants, Hibernate renvoie null
    return total != null ? total : 0;
}

    
    public List<Femme> FemmeMarie2Fois() {
        Session session = null;
        Transaction tx = null;
        List<Femme> femmes = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            femmes = session.getNamedQuery("FemmeMarie2Fois").list();
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

}
