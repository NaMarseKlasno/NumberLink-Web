package sk.tuke.gamestudio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import sk.tuke.gamestudio.entity.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class UserServiceRestClient implements UserService {
    //See value of remote.server.api in application.properties
    private final String url = "http://localhost:8080/api/users";


    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void addUser(Person user) {
        restTemplate.postForEntity(url, user, Person.class);
    }

    @Override
    public List<Person> getUsersList() {
        return Arrays.asList(restTemplate.getForEntity(url + "/", Person[].class).getBody());
    }

    @Override
    public void reset() {
        throw new UnsupportedOperationException("Not supported via web service");
    }

    @Override
    public void update(Person user) {
        throw new UnsupportedOperationException("Not supported via web service");
    }

    @Override
    public Person getPerson(String name) {
        return null;
//        return restTemplate.getForObject(url, Person.class, name);
//        return new Person("lalalalalalal", 100);
    }
}
