package demo.springboot.cache.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.springboot.cache.model.Users;
import demo.springboot.cache.usercache.UsersCache;

@RestController
@RequestMapping(value = "/rest/users")
public class UsersResource {

    @Autowired
    UsersCache usersCache;

    @GetMapping(value = "/{name}")
    public Users getUser(@PathVariable final String name) {
        return usersCache.getUser(name);
    }
    
    @GetMapping(value = "/evict/{name}")
    public String evictUser(@PathVariable final String name) {
    	usersCache.removeUser(name);
        return "Removed from Cache User: " + name;
    }
}
