package com.DeansOffice.repository;

import com.DeansOffice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {
    @Query(value = "" +
            "SELECT u " +
            "FROM User u " +
            "WHERE LOWER(u.firstName) LIKE LOWER(CONCAT('%', :firstName, '%'))"+
            "ORDER BY u.userId ASC ")
    List<User> searchUserByFirstName(@Param("firstName") String firstName);
}
