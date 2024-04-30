package com.DeansOffice.repository;


import com.DeansOffice.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultyRepo extends JpaRepository<Faculty, Long> {

}
