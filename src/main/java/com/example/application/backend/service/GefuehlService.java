package com.example.application.backend.service;

import com.example.application.backend.entity.Gefuehl;
import com.example.application.backend.repository.GefuehlRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GefuehlService {
    private GefuehlRepository gefuehlRepository;

    public GefuehlService(GefuehlRepository gefuehlRepository) {
        this.gefuehlRepository = gefuehlRepository;
    }
    public List<Gefuehl>findALL(){
        return gefuehlRepository.findAll();
    }
}
