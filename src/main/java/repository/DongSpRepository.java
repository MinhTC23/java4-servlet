package repository;

import entity.DongSP;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import untils.HibernateConfig;

import java.util.ArrayList;

public class DongSpRepository {
    public ArrayList<DongSP> getAll(){
        ArrayList<DongSP> listDongSp = new ArrayList<>();
        try (Session session = HibernateConfig.getSessionFactory().openSession()){
            Query query = session.createQuery("FROM DongSP");
            listDongSp = (ArrayList<DongSP>) query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return listDongSp;
    }

    public boolean addDongSP(DongSP dongSP){
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.save(dongSP);
            transaction.commit();
            return true;
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateDongSP(DongSP dongSP){
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.update(dongSP);
            transaction.commit();
            return true;
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteDongSP(DongSP dongSP){
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.delete(dongSP);
            transaction.commit();
            return true;
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
        return false;
    }

    public DongSP detail(DongSP dongSP){
        DongSP dsp = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()){
            Query query = session.createQuery("FROM DongSP WHERE id=:id1");
            query.setParameter("id1", dongSP.getId());
            dsp = (DongSP) query.getSingleResult();
            return dsp;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
