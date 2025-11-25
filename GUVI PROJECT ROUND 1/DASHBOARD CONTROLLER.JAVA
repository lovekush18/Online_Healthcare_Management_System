package com.healthcarepro.controller;

import com.healthcarepro.repository.AppointmentRepository;
import com.healthcarepro.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin("*")
public class DashboardController {

    @Autowired
    private AppointmentRepository aptRepo;

    @Autowired
    private UserRepository userRepo;

    @GetMapping("/admin/stats")
    public Object getAdminStats() {
        return new Object() {
            public long totalUsers = userRepo.count();
            public long totalAppointments = aptRepo.count();
        };
    }
}
