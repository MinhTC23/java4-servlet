package repository;

import entity.MauSac;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import untils.HibernateConfig;

import java.util.ArrayList;

public class MauSacRepository {

    public ArrayList<MauSac> getAll(){
        ArrayList<MauSac> listMauSac = new ArrayList<>();
        try (Session session = HibernateConfig.getSessionFactory().openSession()){
            Query query = session.createQuery("FROM MauSac");
            listMauSac = (ArrayList<MauSac>) query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return listMauSac;
    }

    public boolean addMauSac(MauSac mauSac){
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.save(mauSac);
            transaction.commit();
            return true;
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateMauSac(MauSac mauSac){
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.update(mauSac);
            transaction.commit();
            return true;
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteMauSac(MauSac mauSac){
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.delete(mauSac);
            transaction.commit();
            return true;
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
        return false;
    }

    public MauSac detail(MauSac mauSac){
        MauSac ms = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()){
            Query query = session.createQuery("FROM MauSac WHERE id=:id1");
            query.setParameter("id1", mauSac.getId());
            ms = (MauSac) query.getSingleResult();
            return ms;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
