package com.healthcarepro.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long patientId;
    private Long doctorId;

    private LocalDateTime appointmentTime;

    private String status; // PENDING, CONFIRMED, COMPLETED, CANCELLED

    private String department;
    private String reason;

    // getters and setters
}
