package ir.maktab.java32.projects.servlet.onlinebusticket.features.accountmanagement.repositories;

import ir.maktab.java32.projects.servlet.onlinebusticket.config.database.HibernateUtil;
import ir.maktab.java32.projects.servlet.onlinebusticket.features.accountmanagement.models.User;
import ir.maktab.java32.projects.servlet.onlinebusticket.features.shared.repositories.CrudRepository;
import org.hibernate.query.Query;

import java.util.List;


public class UserRepository extends CrudRepository<User, Long> {
    private static UserRepository userRepository;

    private UserRepository() {
        setSession(HibernateUtil.getSession());
    }

    public static UserRepository getInstance() {
        if (userRepository == null) {
            userRepository = new UserRepository();
        }
        return userRepository;
    }

    @Override
    protected Class<User> getEntityClass() {
        return User.class;
    }

    public List<User> getUserByUsernameAndPassword(User user) {

        if (!getSession().getTransaction().isActive())
            getSession().getTransaction().begin();

        Query query = getSession().createQuery("from User where username= :username and password=:password");
        query.setParameter("username", user.getUsername());
        query.setParameter("password", user.getPassword());
        List<User> users = query.list();

        if (users.size() != 1)
            return null;

        getSession().getTransaction().commit();
        return users;
    }
}
