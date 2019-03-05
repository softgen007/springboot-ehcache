package demo.springboot.cache.usercache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import demo.springboot.cache.model.Users;
import demo.springboot.cache.repository.UsersRepository;

@Component
public class UsersCache {

    @Autowired
    UsersRepository usersRepository;

    @Cacheable(value = "usersCache", key = "#name")
    public Users getUser(String name) {
        System.out.println("Retrieving from Database for name: " + name);
        return usersRepository.findByName(name);
    }
    
    @CacheEvict(value = "usersCache", key = "#name")
    public void removeUser(String name) {
        System.out.println("Removing from Cache for name: " + name);
        
    }
}
