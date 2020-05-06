package com.javatechie.service.doctor;

import com.javatechie.service.doctor.dao.doctor.DoctorRepository;
import com.javatechie.service.doctor.model.doctor.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository repository;

    @PostConstruct
    public void initDoctor(){
        System.out.println("init Doctor");
        repository.saveAll(Stream.of
                (new Doctor(101, "John", "Cardiac"),
                        new Doctor(102, "Peter", "Eye")).collect(Collectors.toList()));
    }

    public List<Doctor> getDoctors(){
        return repository.findAll();
    }

}
