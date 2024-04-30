package com.DeansOffice.controller;

import ch.qos.logback.core.model.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class AdminController {
    @GetMapping(value = "/admin-panel")
    public String adminModel (Model model){
        return "admin.html";
    }
}
