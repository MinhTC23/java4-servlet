package repository;

import entity.SanPham;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import untils.HibernateConfig;

import java.util.ArrayList;

public class SanPhamRepository {

    public ArrayList<SanPham> getAll(){
        ArrayList<SanPham> listSanPham = new ArrayList<>();
        try (Session session = HibernateConfig.getSessionFactory().openSession()){
            Query query = session.createQuery("FROM SanPham");
            listSanPham = (ArrayList<SanPham>) query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return listSanPham;
    }

    public boolean addSanPham(SanPham sanPham){
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.save(sanPham);
            transaction.commit();
            return true;
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateSanPham(SanPham sanPham){
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.update(sanPham);
            transaction.commit();
            return true;
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteSanPham(SanPham sanPham){
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.delete(sanPham);
            transaction.commit();
            return true;
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
        return false;
    }

    public SanPham detail(SanPham sanPham){
        SanPham sp = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()){
            Query query = session.createQuery("FROM SanPham WHERE id=:id1");
            query.setParameter("id1", sanPham.getId());
            sp = (SanPham) query.getSingleResult();
            return sp;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
