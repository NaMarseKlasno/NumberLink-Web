package sk.tuke.gamestudio.service;

import java.util.List;
import sk.tuke.gamestudio.entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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

//        List<Person> list = getUsersList();
//        for (Person person : list) {
//            if (person.getUserName().equals(name)) {
//                Person res = new Person(name, person.getLastLevel());
//                res.setUserID(person.getUserID());
//                return res;
//            }
//        }

        Person user = null;

        Query query = entityManager.createQuery("SELECT u FROM Person u WHERE u.userName=:name");
        query.setParameter("name", name);

        try {
        user = (Person) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public Person getPersonByID(Long userID) {
        List<Person> list = getUsersList();

        for (Person person : list) {
            if (person.getUserID().equals(userID)) {
                Person res = new Person(person.getUserName(), person.getLastLevel());
                res.setUserID(person.getUserID());
                return res;
            }
        }

        return null;
    }
}
