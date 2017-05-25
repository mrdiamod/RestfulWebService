package project.repositories;

import org.springframework.data.repository.CrudRepository;

import project.entities.User;

public interface UsersRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}