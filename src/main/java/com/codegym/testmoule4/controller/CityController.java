package com.codegym.testmoule4.controller;

import com.codegym.testmoule4.model.City;
import com.codegym.testmoule4.repository.CityRepository;
import com.codegym.testmoule4.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin("*")
@RequestMapping("/cities")
public class CityController {
    @Autowired
    private ICityService cityService;

    @GetMapping("")
    private ResponseEntity<List<City>> getAllCities() {
        List<City> cities = cityService.findAll();
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<String> addCity(@RequestBody City city) {
        cityService.save(city);
        String mess = "Add successfully !";
        return new ResponseEntity<>(mess, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<String> edit(@PathVariable Long id, @RequestBody City city) {
        city.setId(id);
        cityService.save(city);
        String message = "Edit successfully !";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        cityService.remove(id);
        String message = "Deleted successfully !";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<City> findById(@PathVariable Long id) {
        City city = cityService.findById(id);
        return new ResponseEntity<>(city, HttpStatus.OK);
    }


}
