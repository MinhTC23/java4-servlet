package repository;

import entity.ChucVu;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import untils.HibernateConfig;

import java.util.ArrayList;

public class ChucVuRepository {

    public ArrayList<ChucVu> getAll(){
        ArrayList<ChucVu> listChucVu = new ArrayList<>();
        try (Session session = HibernateConfig.getSessionFactory().openSession()){
            Query query = session.createQuery("FROM ChucVu");
            listChucVu = (ArrayList<ChucVu>) query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return listChucVu;
    }

    public boolean addChucVu(ChucVu chucVu){
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.save(chucVu);
            transaction.commit();
            return true;
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateChucVu(ChucVu chucVu){
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.update(chucVu);
            transaction.commit();
            return true;
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteChucVu(ChucVu chucVu){
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.delete(chucVu);
            transaction.commit();
            return true;
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
        return false;
    }

    public ChucVu detail(ChucVu chucVu){
        ChucVu cv = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()){
            Query query = session.createQuery("FROM ChucVu WHERE id=:id1");
            query.setParameter("id1", chucVu.getId());
            cv = (ChucVu) query.getSingleResult();
            return cv;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
