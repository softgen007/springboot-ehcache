package demo.springboot.cache.loader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import demo.springboot.cache.model.Users;
import demo.springboot.cache.repository.UsersRepository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class Loader {

    @Autowired
    UsersRepository usersRepository;

    @PostConstruct
    public void load() {
        List<Users> usersList = getList();
        usersRepository.saveAll(usersList);
    }

    public List<Users> getList() {
        List<Users> usersList = new ArrayList<>();
        usersList.add(new Users("Ajay", "Tech",123L));
        usersList.add(new Users("Jaga", "Tech",13L));
        return usersList;
    }
}
