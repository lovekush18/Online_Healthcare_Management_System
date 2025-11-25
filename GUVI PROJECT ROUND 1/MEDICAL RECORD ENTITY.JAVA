package com.healthcarepro.model;

import jakarta.persistence.*;

@Entity
@Table(name="medical_records")
public class MedicalRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long patientId;
    private String diagnosis;
    private String prescription;
    private String notes;

    // getters and setters
}
