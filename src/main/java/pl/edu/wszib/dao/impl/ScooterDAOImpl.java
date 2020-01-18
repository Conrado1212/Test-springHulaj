package pl.edu.wszib.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;
import pl.edu.wszib.dao.IScooterDAO;
import pl.edu.wszib.model.Scooter;

import java.util.List;

@Component
public class ScooterDAOImpl implements IScooterDAO {
    SessionFactory sessionFactory;


    public ScooterDAOImpl(SessionFactory sessionFactory){
        this.sessionFactory=sessionFactory;
    }



    @Override
    public  void addScooter(Scooter scooter){
        Session session = null;
        Transaction tx = null;
        try{
            session = this.sessionFactory.openSession();
            tx = session.beginTransaction();
            session.save(scooter);
            tx.commit();
        }catch(HibernateException e){
            e.printStackTrace();
            if(tx !=null) tx.rollback();
        }finally{
            session.close();
        }
    }



    @Override
    public    Scooter getScooter(int Id){
        Session  session = this.sessionFactory.openSession();
        Scooter scooter =
                (Scooter) session.createQuery("FROM pl.edu.wszib.model.Scooter WHERE id = " + Id).uniqueResult();
        session.close();
        return scooter;
    }



    @Override
    public  void getUpdate(int Id, Scooter scooter){
        Session session = null;
        Transaction tx = null;
        try{
            session = this.sessionFactory.openSession();
            tx = session.beginTransaction();
            session.get(Scooter.class,Id);
            session.saveOrUpdate(scooter);
            tx.commit();
        }catch(HibernateException e){
            if(tx != null) tx.rollback();
        }finally{
            session.close();
        }
    }

    @Override
    public void getUpdateScooter(int Id, Scooter scooter){
        Session session = null;
        Transaction tx = null;
        Scooter scooter1 = new Scooter();
        try{
            session = this.sessionFactory.openSession();
            tx = session.beginTransaction();

            scooter = (Scooter) session.load(Scooter.class,Id);

            if(!(scooter.getBrand().equals(""))){
                scooter1.setBrand(scooter.getBrand());
            }
            if(!(scooter.getModel().equals(""))){
                scooter1.setBrand(scooter.getModel());
            }
            if(!(scooter.getPrice()==0)){
                scooter1.setPrice(scooter.getPrice());
            }



           // scooter.setBrand(scooter.getBrand());
           // scooter.setModel(scooter.getModel());
          //  scooter.setPrice(scooter.getPrice());

            session.update(scooter);
            tx.commit();
        }catch(HibernateException e){
            if(tx != null) tx.rollback();
        }finally{
            session.close();
        }
    }



    @Override
    public  void  removeScooterId(int Id){
        Session session = null;
        Transaction tx = null;
        try{
            session = this.sessionFactory.openSession();
            tx = session.beginTransaction();
            Scooter scooter =
                    (Scooter) session.get(Scooter.class, Id);
            session.delete(scooter);
            //wiecej operacji
            tx.commit();
        }catch(HibernateException e){
            if(tx !=null) tx.rollback();//wycofanie czynnosci
        }finally {
            session.close();
        }
    }



    @Override
    public  List<Scooter> getAllScooterXiaomi() {
        Session  session = this.sessionFactory.openSession();
        List<Scooter> allScooterXiomi =
                session.createQuery("FROM pl.edu.wszib.model.Scooter Where brand = 'Xiaomi'").list();
        session.close();
        return allScooterXiomi;
    }



    @Override
    public   List<Scooter> getAllScooters() {
        Session  session = this.sessionFactory.openSession();
        List<Scooter> allScooter = session.createQuery("FROM pl.edu.wszib.model.Scooter ").list();
        session.close();
        return allScooter;
    }



    @Override
    public  List<Scooter> getAllScooterFiat() {
        Session  session = this.sessionFactory.openSession();
        List<Scooter> allScooterFiat =
                session.createQuery("FROM pl.edu.wszib.model.Scooter Where brand = 'Fiat'").list();
        session.close();
        return allScooterFiat;



    }
}
