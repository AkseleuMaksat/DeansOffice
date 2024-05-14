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
    public Country getCountryDetails(Long id){
        return countryRepo.findById(id).orElse(null);
    }


    //group
    public List<Group> getGroup(){
        return groupRepo.findAll();
    }
    public Group addGroup(Group group)  {
        return groupRepo.save(group);

    }
    public List<Group> getGroups() {
        return groupRepo.findAll();
    }
    public Group getGroupDetails(Long id){
        return groupRepo.findById(id).orElse(null);
    }
    public void deleteGroup(Long id) {
        groupRepo.deleteById(id);
    }

    //faculty
    public List<Faculty> getFaculties(){
        return facultyRepo.findAll();
    }
    public Faculty getFacultyById(Long id) {
        return facultyRepo.findById(id).orElse(null);
    }
    public Faculty getFacultyDetails(Long id){
        return facultyRepo.findById(id).orElse(null);
    }
    public Faculty addFaculty(Faculty faculty){
        return facultyRepo.save(faculty);
    }
    public void deleteFaculty(Long id) {
        facultyRepo.deleteById(id);
    }
    //city
    public List<City> getCities(){
        return cityRepo.findAll();
    }
    public City getCityDetails(Long id){
        return cityRepo.findById(id).orElse(null);
    }

    public City addCity(City city){return cityRepo.save(city);}

}
