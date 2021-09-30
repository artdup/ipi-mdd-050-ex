package com.ipiecoles.java.mdd050.controller;

import com.ipiecoles.java.mdd050.model.Employe;
import com.ipiecoles.java.mdd050.repository.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.Optional;

@RestController
@RequestMapping(value = "/employes")

public class EmployeController {

    @Autowired
    private EmployeRepository employeRepository;

    //GET /employes/count => Nombre d'employés
    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            value = "/count"
    )
    public Long countEmploye() {
        return employeRepository.count();
    }

    //GET /employes/6 => employé d'id 6
    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            value = "/6"
    )
    public Optional<Employe> getEmployeById() {
        return employeRepository.findById(6L);
    }

    //GET /employes/id => employé d'id
    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            value = "/{id}"
    )
    public Optional<Employe> getEmployeById(
            @PathVariable(value = "id") Long id
    ){
        return employeRepository.findById(id);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            value = ""
    )
    public Employe findEmployeByMatricule(
            @RequestParam(value = "matricule") String matricule){
        return employeRepository.findByMatricule(matricule);
    }
}
