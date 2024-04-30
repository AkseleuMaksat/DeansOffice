package com.DeansOffice.service;


import com.DeansOffice.model.*;
import com.DeansOffice.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepo userRepo;
    private final GroupRepo groupRepo;
    private final FacultyRepo facultyRepo;
    private final CountryRepo countryRepo;
    private final CityRepo cityRepo;
    @Autowired
    public UserService(UserRepo userRepo, GroupRepo groupRepo, FacultyRepo facultyRepo, CountryRepo countryRepo, CityRepo cityRepo) {
        this.userRepo = userRepo;
        this.groupRepo = groupRepo;
        this.facultyRepo = facultyRepo;
        this.countryRepo = countryRepo;
        this.cityRepo = cityRepo;
    }

    public List<User> getUsers(){
       return userRepo.findAll();
    }

    public User getDetails(Long id){
        return userRepo.findById(id).orElse(null);
    }
    public User addUser(User user){
        return userRepo.save(user);
    }

    public void deleteUser(Long id){
        userRepo.deleteById(id);
    }


    //country
    public List<Country> getCounties(){
        return countryRepo.findAll();
    }
    public Country addCounty(Country country){
        return countryRepo.save(country);
    }


    //group
    public List<Group> getGroup(){
        return groupRepo.findAll();
    }
    public Group addGroup(Group group){
        return groupRepo.save(group);
    }
    public List<Group> getGroups() {
        return groupRepo.findAll();
    }

    //faculty
    public List<Faculty> getFaculties(){
        return facultyRepo.findAll();
    }
    public Faculty addFaculty(Faculty faculty){
        return facultyRepo.save(faculty);
    }

    //city
    public List<City> getCities(){
        return cityRepo.findAll();
    }
    public City addCity(City city){return cityRepo.save(city);}

}
