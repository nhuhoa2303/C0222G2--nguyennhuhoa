package com.codegym.controller;

import com.codegym.model.Smartphone;
import com.codegym.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
@CrossOrigin
@Controller
@RequestMapping("/phone")
public class HomeController {
    @Autowired
    private ISmartphoneService smartphoneService;

    @PostMapping
    public ResponseEntity<Smartphone> createSmartphone(@RequestBody Smartphone smartphone) {
        return new ResponseEntity<>(smartphoneService.save(smartphone), HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<Iterable<Smartphone>> allPhones() {
        return new ResponseEntity<>(smartphoneService.findAll(), HttpStatus.OK);
    }
//
//    @GetMapping()
//    public ModelAndView getAllSmartphonePage() {
//        ModelAndView modelAndView = new ModelAndView("/list");
//        modelAndView.addObject("smartphones", smartphoneService.findAll());
//        return modelAndView;
//    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<Smartphone> deleteSmartphone(@PathVariable Long id) {
//        Optional<Smartphone> smartphoneOptional = smartphoneService.findById(id);
//        if (!smartphoneOptional.isPresent()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        smartphoneService.remove(id);
//        return new ResponseEntity<>(smartphoneOptional.get(), HttpStatus.NO_CONTENT);
//    }

    @PutMapping("/update")
    public ResponseEntity<Smartphone> updateSmartphone(@RequestBody Smartphone smartphone) {
        return new ResponseEntity<>(smartphoneService.save(smartphone), HttpStatus.OK);
    }
}
