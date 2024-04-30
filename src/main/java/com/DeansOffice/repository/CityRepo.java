package com.DeansOffice.repository;

import com.DeansOffice.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepo extends JpaRepository<City, Long> {
}
