package com.DeansOffice.repository;
import com.DeansOffice.model.Group;
import com.DeansOffice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GroupRepo extends JpaRepository<Group, Long> {
    @Query(value = "" +
            "SELECT u " +
            "FROM Group u " +
            "WHERE LOWER(u.groupName) LIKE LOWER(CONCAT('%', :groupName, '%'))"+
            "ORDER BY u.groupId ASC ")
    List<Group> searchGroupByGroupName(@Param("groupName") String groupName);
}
