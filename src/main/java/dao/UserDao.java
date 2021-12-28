package dao;

import config.HibernateUtil;
import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class UserDao {
    public User getUser(String name, String password) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from User where userName=:name and password=:password");
        query.setParameter("name", name);
        query.setParameter("password", password);
        User user = (User) query.getSingleResult();
        transaction.commit();
        session.close();
        return user;
    }

    public void saveUser(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();

    }
}
