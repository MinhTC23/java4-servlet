package repository;

import entity.CuaHang;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import untils.HibernateConfig;

import java.util.ArrayList;

public class CuaHangRepository {
    public ArrayList<CuaHang> getAll(){
        ArrayList<CuaHang> listCuaHang = new ArrayList<>();
        try (Session session = HibernateConfig.getSessionFactory().openSession()){
            Query query = session.createQuery("FROM CuaHang");
            listCuaHang = (ArrayList<CuaHang>) query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return listCuaHang;
    }

    public boolean addCuaHang(CuaHang cuaHang){
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.save(cuaHang);
            transaction.commit();
            return true;
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateCuaHang(CuaHang cuaHang){
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.update(cuaHang);
            transaction.commit();
            return true;
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteCuaHang(CuaHang cuaHang){
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.delete(cuaHang);
            transaction.commit();
            return true;
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
        return false;
    }

    public CuaHang detail(CuaHang cuaHang){
        CuaHang ch = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()){
            Query query = session.createQuery("FROM CuaHang WHERE id=:id1");
            query.setParameter("id1", cuaHang.getId());
            ch = (CuaHang) query.getSingleResult();
            return ch;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
