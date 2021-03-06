package com.example.repository;

import com.example.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User,Integer> {
    @Query("SELECT u FROM User u WHERE u.username =:username " )
    public User getUserByUsername(@Param("username") String username);

    @Query("Select u FROM User u WHERE lower(u.username) LIKE CONCAT('%', lower(?1), '%')")
    public Iterable<User> findAll(@Param("username") String username);
}
