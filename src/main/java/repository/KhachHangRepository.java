package repository;

import entity.KhachHang;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import untils.HibernateConfig;

import java.util.ArrayList;

public class KhachHangRepository {

    public ArrayList<KhachHang> getAll(){
        ArrayList<KhachHang> listKhachHang = new ArrayList<>();
        try (Session session = HibernateConfig.getSessionFactory().openSession()){
            Query query = session.createQuery("FROM KhachHang");
            listKhachHang = (ArrayList<KhachHang>) query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return listKhachHang;
    }

    public boolean addKhachHang(KhachHang khachHang){
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.save(khachHang);
            transaction.commit();
            return true;
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateKhachHang(KhachHang khachHang){
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.update(khachHang);
            transaction.commit();
            return true;
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteKhachHang(KhachHang khachHang){
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.delete(khachHang);
            transaction.commit();
            return true;
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
        return false;
    }

    public KhachHang detail(KhachHang khachHang){
        KhachHang kh = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()){
            Query query = session.createQuery("FROM KhachHang WHERE id=:id1");
            query.setParameter("id1", khachHang.getId());
            kh = (KhachHang) query.getSingleResult();
            return kh;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
