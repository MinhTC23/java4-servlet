package repository;

import entity.NSX;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import untils.HibernateConfig;

import java.util.ArrayList;

public class NsxRepository {
    public ArrayList<NSX> getAll(){
        ArrayList<NSX> listNSX = new ArrayList<>();
        try (Session session = HibernateConfig.getSessionFactory().openSession()){
            Query query = session.createQuery("FROM NSX");
            listNSX = (ArrayList<NSX>) query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return listNSX;
    }

    public boolean addNSX(NSX nsx){
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.save(nsx);
            transaction.commit();
            return true;
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateNSX(NSX nsx){
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.update(nsx);
            transaction.commit();
            return true;
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteNSX(NSX nsx){
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.delete(nsx);
            transaction.commit();
            return true;
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
        return false;
    }

    public NSX detail(NSX nsx){
        NSX nsx1 = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()){
            Query query = session.createQuery("FROM NSX WHERE id=:id1");
            query.setParameter("id1", nsx.getId());
            nsx1 = (NSX) query.getSingleResult();
            return nsx1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
