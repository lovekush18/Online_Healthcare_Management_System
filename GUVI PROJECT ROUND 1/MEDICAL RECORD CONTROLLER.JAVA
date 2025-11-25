package com.healthcarepro.controller;

import com.healthcarepro.model.MedicalRecord;
import com.healthcarepro.repository.MedicalRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/records")
@CrossOrigin("*")
public class MedicalRecordController {

    @Autowired
    private MedicalRecordRepository repository;

    @PostMapping("/add")
    public MedicalRecord addRecord(@RequestBody MedicalRecord record) {
        return repository.save(record);
    }

    @GetMapping("/patient/{id}")
    public List<MedicalRecord> getRecords(@PathVariable Long id) {
        return repository.findByPatientId(id);
    }
}
