package com.DeansOffice.controller;

import com.DeansOffice.model.*;
import com.DeansOffice.repository.UserRepo;
import com.DeansOffice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
@RequestMapping("/api/v1/")
public class UserController {
    private final UserService userService;
    private final UserRepo userRepo;

    @Autowired
    public UserController(UserService userService, UserRepo userRepo) {
        this.userService = userService;
        this.userRepo = userRepo;
    }
//USER
    @GetMapping("/user")
    public String index(Model model, @RequestParam(name = "key", required = false, defaultValue = "") String key) {
        List<User> users = userRepo.searchUserByFirstName(key);
        model.addAttribute("UserLar", users);
        return "index.html";
    }

    @GetMapping(value = "/user/details")
    public String getUser(@RequestParam(name = "userId") Long id, Model model) {
        model.addAttribute("user", userService.getDetails(id));
        model.addAttribute("groupLar", userService.getGroups());
        model.addAttribute("cityLar", userService.getCities());
        return "details.html";
    }

    @GetMapping(value = "/add-user")
    public String addUserPage(Model model) {
        model.addAttribute("groupLar", userService.getGroups());
        model.addAttribute("cityLar", userService.getCities());
        return "addUser.html";
    }

    @PostMapping("/add-user")
    public String addUser(User user) {
        userService.addUser(user);
        return "redirect:/api/v1/user";
    }

    @PostMapping("/edit-user")
    public String editUser(User user) {
        userService.addUser(user);
        return "redirect:/api/v1/user";
    }

    @PostMapping(value = "/delete-music")
    public String deleteUser(@RequestParam(name = "id") Long id) {
        userService.deleteUser(id);
        return "redirect:/api/v1/user";
    }

//FACULTY
    @GetMapping("/add-faculty")
    public String addFacultyPage(Model model) {
        model.addAttribute("facultyLar", userService.getFaculties());
        return "addFaculty.html";
    }

    @PostMapping("/add-faculty")
    public String addFaculty(Faculty faculty) {
        userService.addFaculty(faculty);
        return "redirect:/api/v1/user";
    }

//CITY
    @GetMapping("/add-address")
    public String addAddressPage(Model model) {
        model.addAttribute("countyLar",userService.getCounties());
        return "addAddress.html";
    }

    @PostMapping("/add-address")
    public String addAddress(City city) {
        userService.addCity(city);
        return "redirect:/api/v1/user";
    }
//COUNTRY
    @GetMapping("/add-country")
    public String addCountryPage() {

        return "addCountry.html";
    }

    @PostMapping("/add-country")
    public String addCounty(Country country) {
        userService.addCounty(country);
        return "redirect:/api/v1/user";
    }

//GROUP
    @GetMapping("/add-group")
    public String addGroupPage(Model model) {
        model.addAttribute("facultyLar", userService.getFaculties());
        model.addAttribute("groups", userService.getGroup());
        return "addGroup.html";
    }
    @PostMapping("/add-group")
    public String addGroup(Group group) {
        userService.addGroup(group);
        return "redirect:/api/v1/user";

    }
//Auth
    @GetMapping(value = "/sign-in-page")
    public String SingInPage(){
    return "signIn";
}

    @GetMapping(value = "/profile")
    public String ProfilePage(){
        return "profile";
    }


}
