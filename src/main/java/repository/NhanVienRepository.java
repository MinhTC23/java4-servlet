package repository;

import entity.NhanVien;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import untils.HibernateConfig;

import java.util.ArrayList;

public class NhanVienRepository {

    public ArrayList<NhanVien> getAll(){
        ArrayList<NhanVien> listNhanVien = new ArrayList<>();
        try (Session session = HibernateConfig.getSessionFactory().openSession()){
            Query query = session.createQuery("FROM NhanVien");
            listNhanVien = (ArrayList<NhanVien>) query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return listNhanVien;
    }

    public boolean addNhanVien(NhanVien nhanVien){
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.save(nhanVien);
            transaction.commit();
            return true;
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateNhanVien(NhanVien nhanVien){
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.update(nhanVien);
            transaction.commit();
            return true;
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteNhanVien(NhanVien nhanVien){
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.delete(nhanVien);
            transaction.commit();
            return true;
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
        return false;
    }

    public NhanVien detail(NhanVien nhanVien){
        NhanVien nv = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()){
            Query query = session.createQuery("FROM NhanVien WHERE id=:id1");
            query.setParameter("id1", nhanVien.getId());
            nv = (NhanVien) query.getSingleResult();
            return nv;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
