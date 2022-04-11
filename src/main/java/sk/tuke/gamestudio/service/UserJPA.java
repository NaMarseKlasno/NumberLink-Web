package sk.tuke.gamestudio.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import sk.tuke.gamestudio.entity.Person;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;



@Transactional
public class UserJPA implements UserService {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void addUser(Person user) {
        entityManager.persist(user);
    }

    @Override
    public List<Person> getUsersList() {
        return entityManager.createQuery("select user from Person user").getResultList();
    }

    @Override
    public void reset() {
        entityManager.createNativeQuery("DELETE FROM person").executeUpdate();
    }

    @Override
    public void update(Person user) {
        entityManager.createNativeQuery("UPDATE person SET last_level = " + user.getLastLevel() + " WHERE userid = " + user.getUserID()).executeUpdate();
    }

    @Override
    public Person getPerson(String name) {

        List<Person> list = getUsersList();

        for (Person person : list) {
            if (person.getUserName().equals(name)) {
                Person res = new Person(name, person.getLastLevel());
                res.setUserID(person.getUserID());
                return res;
            }
        }

        return null;


//        Person user = null;
//
//        Query query = entityManager.createQuery("SELECT u FROM Person u WHERE u.userName=:name");
//        query.setParameter("name", name);
//
////        try {
//        user = (Person) query.getSingleResult();
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
//
//        return user;
    }
}
