package com.healthcarepro.controller;

import com.healthcarepro.model.Appointment;
import com.healthcarepro.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
@CrossOrigin("*")
public class AppointmentController {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @PostMapping("/book")
    public Appointment book(@RequestBody Appointment appointment) {
        appointment.setStatus("PENDING");
        return appointmentRepository.save(appointment);
    }

    @GetMapping("/patient/{id}")
    public List<Appointment> patientAppointments(@PathVariable Long id) {
        return appointmentRepository.findByPatientId(id);
    }

    @GetMapping("/doctor/{id}")
    public List<Appointment> doctorAppointments(@PathVariable Long id) {
        return appointmentRepository.findByDoctorId(id);
    }

    @PutMapping("/update")
    public Appointment updateStatus(@RequestBody Appointment appt) {
        return appointmentRepository.save(appt);
    }
}
