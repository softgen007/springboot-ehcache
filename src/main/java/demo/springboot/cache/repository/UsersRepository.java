package demo.springboot.cache.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.springboot.cache.model.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {
    Users findByName(String name);
}
