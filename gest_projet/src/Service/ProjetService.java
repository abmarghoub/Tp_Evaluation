/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import dao.IDao;
import entities.EmployeTache;
import entities.Projet;
import entities.Tache;
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
public class ProjetService implements IDao<Projet> {

    @Override
    public boolean create(Projet o) {
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
    public boolean delete(Projet o) {
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
    public boolean update(Projet o) {
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
    public Projet findById(int id) {
        Session session = null;
        Transaction tx = null;
        Projet projet = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            projet = (Projet) session.get(Projet.class, id);
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally{
            if (session != null)
                session.close();
        }
        return projet;
    }

    @Override
    public List<Projet> findAll() {
        Session session = null;
        Transaction tx = null;
        List<Projet> projets = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            projets = session.createQuery("from Projet").list();
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally{
            if (session != null)
                session.close();
        }
        return projets;
    }
    
    public List<Tache> TachePlanifie(int PrjId) {
        Session session = null;
        Transaction tx = null;
        List<Tache> taches = null;
        try {
           session = HibernateUtil.getSessionFactory().openSession();
           tx = session.beginTransaction();
           taches = session.getNamedQuery("TachePlanifie").setParameter("PrjId", PrjId).list();
           tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally {
            if (session != null) session.close();
        }
        return taches;
    }
    
    public List<EmployeTache> TacheRealisee(int PrId) {
        Session session = null;
        Transaction tx = null;
        List<EmployeTache> employeTaches = null;
        try {
           session = HibernateUtil.getSessionFactory().openSession();
           tx = session.beginTransaction();
           employeTaches = session.getNamedQuery("TacheRealisee").setParameter("PrId", PrId).list();
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
