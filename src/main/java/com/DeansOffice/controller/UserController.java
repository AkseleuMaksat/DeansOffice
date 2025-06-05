package com.DeansOffice.controller;

import com.DeansOffice.model.*;
import com.DeansOffice.repository.FacultyRepo;
import com.DeansOffice.repository.GroupRepo;
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
    private final FacultyRepo facultyRepo;
    private final GroupRepo groupRepo;

    @Autowired
    public UserController(UserService userService, UserRepo userRepo, FacultyRepo facultyRepo, GroupRepo groupRepo) {
        this.userService = userService;
        this.userRepo = userRepo;
        this.facultyRepo = facultyRepo;
        this.groupRepo = groupRepo;
    }


//USER
    @GetMapping("/user")
    public String index(Model model, @RequestParam(name = "key", required = false, defaultValue = "") String key) {
        List<User> users = userRepo.searchUserByFirstName(key);
        model.addAttribute("UserLar", users);
        return "index";
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

    @PostMapping(value = "/delete-user")
    public String deleteUser(@RequestParam(name = "id") Long id) {
        userService.deleteUser(id);
        return "redirect:/api/v1/user";
    }


//CITY
    @PostMapping("/edit-city")
    public String editCity(City city, Model model) {
        try {
            userService.addCity(city);
        } catch (Exception e) {
            model.addAttribute("error", true);
            return "cityDetails.html";
        }
        return "redirect:/api/v1/address";
    }
    @GetMapping("/add-address")
    public String addAddressPage(Model model) {
        model.addAttribute("countyLar",userService.getCounties());
        return "addAddress.html";
    }
    @GetMapping(value = "/address/details")
    public String getCityDetails(@RequestParam(name = "cityId") Long id, Model model) {
        model.addAttribute("city", userService.getCityDetails(id));
        model.addAttribute("countryLar", userService.getCounties());
        return "cityDetails.html";
    }
    @PostMapping("/add-address")
    public String addAddress(City city) {
        userService.addCity(city);
        return "redirect:/api/v1/user";
    }
    @GetMapping("/address")
    public String getCity(Model model){
        model.addAttribute("cityLar", userService.getCities());
        return "addCityTable.html";
    }
//COUNTRY
    @PostMapping("/edit-country")
    public String editCountry(Country country, Model model) {
        try {
            userService.addCounty(country);
        } catch (Exception e) {
            model.addAttribute("error", true);
            return "countryDetails.html";
        }
        return "redirect:/api/v1/country";
    }

    @GetMapping(value = "/country/details")
    public String getCountryDetails(@RequestParam(name = "countryId") Long id, Model model) {
        model.addAttribute("country", userService.getCountryDetails(id));
        return "countryDetails.html";
    }
    @GetMapping("/add-country")
    public String addCountryPage() {
        return "addCountry.html";
    }

    @PostMapping("/add-country")
    public String addCounty(Country country) {
        userService.addCounty(country);
        return "redirect:/api/v1/user";
    }

    @GetMapping("/country")
    public String getCountry(Model model){
        model.addAttribute("countyLar",userService.getCounties());
        return "addCountryTable.html";
    }
//GROUP
    @GetMapping("/add-group")
    public String addGroupPage(Model model) {
        model.addAttribute("facultyLar", userService.getFaculties());
        model.addAttribute("groups", userService.getGroup());
        return "addGroup.html";
    }
    @PostMapping("/add-group")
    public String addGroup(Group group, Model model) {
        try {
            userService.addGroup(group);
        } catch (Exception e) {
            model.addAttribute("error", true);
            return "groupDetails.html";
        }
        return "redirect:/api/v1/group";

    }
    @GetMapping("/group")
    public String getGroup(Model model, @RequestParam(name = "key", required = false, defaultValue = "") String key){

        List<Group> groups = userService.getGroup();
        Collections.sort(groups, new Sort());
        model.addAttribute("groups", groupRepo.searchGroupByGroupName(key));
        model.addAttribute("facultyLar", userService.getFaculties());
        return "addGroupTable.html";
    }
    @GetMapping(value = "/group/details")
    public String getGroupDetails(@RequestParam(name = "groupId") Long id, Model model) {
        model.addAttribute("group", userService.getGroupDetails(id));
        model.addAttribute("facultyLar", userService.getFaculties());
        return "groupDetails.html";
    }
    @PostMapping("/edit-group")
    public String editGroup(Group group, Model model) {
        try {
            userService.addGroup(group);
        } catch (Exception e) {
            model.addAttribute("error", true);
            return "groupDetails.html";
        }
        return "redirect:/api/v1/group";
    }
    @PostMapping(value = "/delete-group")
    public String deleteGroup(@RequestParam(name = "id") Long id) {
        userService.deleteGroup(id);
        return "redirect:/api/v1/group";
    }

    //FACULTY
    @GetMapping(value = "/faculty/details")
    public String getFacultyDetails(@RequestParam(name = "facultyId") Long id, Model model) {
        Faculty faculty = userService.getFacultyDetails(id);
        model.addAttribute("faculty", faculty);
        return "facultyDetails.html";
    }
    @PostMapping("/edit-faculty")
    public String editFaculty(Faculty faculty, Model model) {
        try {
            userService.addFaculty(faculty);
        } catch (Exception e) {
            model.addAttribute("error", true);
            return "groupDetails.html";
        }
        return "redirect:/api/v1/faculty";
    }


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
    @GetMapping("/faculty")
    public String getFaculty(Model model, @RequestParam(name = "id", required = false, defaultValue = "") Long id) {
        List<Faculty> faculties = userService.getFaculties();
        Long facultyAmount = null;
        List<Long> famount =new ArrayList<>();
        for (Faculty faculty : faculties) {
            Long facultyId = faculty.getFacultyId();
            facultyAmount = facultyRepo.sumAmountByFacultyId(facultyId);
            famount.add(facultyAmount);
        }

        model.addAttribute("facultyLar", faculties);
        model.addAttribute("famount", famount);
        return "addFacultyTable.html";
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
