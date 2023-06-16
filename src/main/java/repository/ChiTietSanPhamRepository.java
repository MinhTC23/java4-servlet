package repository;

import entity.ChiTietSP;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import untils.HibernateConfig;

import java.util.ArrayList;

public class ChiTietSanPhamRepository {

    public ArrayList<ChiTietSP> getAll(){
        ArrayList<ChiTietSP> chiTietSPs = new ArrayList<>();
        try (Session session = HibernateConfig.getSessionFactory().openSession()){
            Query query = session.createQuery("FROM ChiTietSP");
            chiTietSPs = (ArrayList<ChiTietSP>) query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return chiTietSPs;
    }

    public boolean addChiTietSP(ChiTietSP chiTietSP){
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.save(chiTietSP);
            transaction.commit();
            return true;
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateChiTietSP(ChiTietSP chiTietSP){
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.update(chiTietSP);
            transaction.commit();
            return true;
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteChiTietSP(ChiTietSP chiTietSP){
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.delete(chiTietSP);
            transaction.commit();
            return true;
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
        return false;
    }

    public ChiTietSP detail(ChiTietSP chiTietSP){
        ChiTietSP ctsp = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()){
            Query query = session.createQuery("FROM ChiTietSP WHERE id=:id1");
            query.setParameter("id1", chiTietSP.getId());
            ctsp = (ChiTietSP) query.getSingleResult();
            return ctsp;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
