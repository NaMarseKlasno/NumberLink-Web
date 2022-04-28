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
    @Value("${remote.server.api}")
    private String url;


    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void addUser(Person user) {
        restTemplate.postForEntity(url+"/users/", user, Person.class);
    }

    @Override
    public List<Person> getUsersList() {
        return Arrays.asList(restTemplate.getForEntity(url, Person[].class).getBody());
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
//        return null;
        System.out.println(url);
        return restTemplate.getForObject(url + "/users/" + name , Person.class);
//        return restTemplate.getForObject(url, Person.class, name);
    }
}
