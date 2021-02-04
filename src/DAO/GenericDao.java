/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author The Crush
 */
public class GenericDao<X> {
    private Class<X> type; 

    public GenericDao(Class<X> type) {
        this.type = type;
    }
    
    
    public String createX(X obj) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.save(obj);
        s.getTransaction().commit();
        s.close();
        return "success";
    }

    public String updateX(X obj) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.update(obj);
        s.getTransaction().commit();
        s.close();
        return "success";
    }

    public String deleteX(X obj) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.delete(obj);
        s.getTransaction().commit();
        s.close();
        return "success";
    }

    public List<X> findAll() {
        Session s = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Query q = s.createQuery("from "+type.getName());
        List<X> li = q.list();
        s.close();
        return li;
    }

    public X findById(String id) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        X obj = (X) s.get(type, id);
        s.close();
        return obj;
    }
}
