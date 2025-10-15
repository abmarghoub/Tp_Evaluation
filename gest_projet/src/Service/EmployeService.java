/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import dao.IDao;
import entities.Employe;
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
public class EmployeService implements IDao<Employe> {

    @Override
    public boolean create(Employe o) {
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
    public boolean delete(Employe o) {
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
    public boolean update(Employe o) {
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
    public Employe findById(int id) {
        Session session = null;
        Transaction tx = null;
        Employe employe = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            employe = (Employe) session.get(Employe.class, id);
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally{
            if (session != null)
                session.close();
        }
        return employe;
    }

    @Override
    public List<Employe> findAll() {
        Session session = null;
        Transaction tx = null;
        List<Employe> employes = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            employes = session.createQuery("from Employe").list();
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally{
            if (session != null)
                session.close();
        }
        return employes;
    }
    
    public List<Tache> TacheRealiseParEmp(int EmpId) {
        Session session = null;
        Transaction tx = null;
        List<Tache> projets = null;
        try {
           session = HibernateUtil.getSessionFactory().openSession();
           tx = session.beginTransaction();
           projets = session.getNamedQuery("TacheRealiseParEmp").setParameter("EmpId", EmpId).list();
           tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally {
            if (session != null) session.close();
        }
        return projets;
    }
    
    public List<Projet> ProjetGereParEmp(int CpId) {
        Session session = null;
        Transaction tx = null;
        List<Projet> projets = null;
        try {
           session = HibernateUtil.getSessionFactory().openSession();
           tx = session.beginTransaction();
           projets = session.getNamedQuery("ProjetGereParEmp").setParameter("CpId", CpId).list();
           tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally {
            if (session != null) session.close();
        }
        return projets;
    }

}
    



