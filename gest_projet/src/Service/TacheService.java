/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import dao.IDao;
import entities.EmployeTache;
import entities.Tache;
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
public class TacheService implements IDao<Tache> {

    @Override
    public boolean create(Tache o) {
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
    public boolean delete(Tache o) {
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
    public boolean update(Tache o) {
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
    public Tache findById(int id) {
        Session session = null;
        Transaction tx = null;
        Tache tache = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            tache = (Tache) session.get(Tache.class, id);
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally{
            if (session != null)
                session.close();
        }
        return tache;
    }

    @Override
    public List<Tache> findAll() {
        Session session = null;
        Transaction tx = null;
        List<Tache> taches = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            taches = session.createQuery("from Tache").list();
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally{
            if (session != null)
                session.close();
        }
        return taches;
    }
    
    public List<Tache> TachePrixSup() {
        Session session = null;
        Transaction tx = null;
        List<Tache> taches = null;
        try {
           session = HibernateUtil.getSessionFactory().openSession();
           tx = session.beginTransaction();
           taches = session.getNamedQuery("TachePrixSup").list();
           tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally {
            if (session != null) session.close();
        }
        return taches;
    }
    
    public List<EmployeTache> TacheBetweenDate(Date d1, Date d2) {
        Session session = null;
        Transaction tx = null;
        List<EmployeTache> employeTaches = null;
        try {
           session = HibernateUtil.getSessionFactory().openSession();
           tx = session.beginTransaction();
           employeTaches = session.getNamedQuery("TacheBetweenDate").setParameter("d1", d1).setParameter("d2", d2).list();
           tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally {
            if (session != null) session.close();
        }
        return employeTaches;
    }

}


