package com.DeansOffice.repository;
import com.DeansOffice.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
public interface GroupRepo extends JpaRepository<Group, Long> {
}
