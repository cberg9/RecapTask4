package com.company.demo.Controllers;




import com.company.demo.Models.Factory;
import com.company.demo.Models.repositories.FactoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class FactoryController {
    @Autowired
    private FactoryRepository factoryRepository;

    @RequestMapping(value = "/api/v1/factories", method = RequestMethod.GET)
    public ArrayList<Factory> getAllFactories(){
        var factories = factoryRepository.findAll();
        return (ArrayList<Factory>) factories;
    }
    @RequestMapping(value = "/api/v1/factories", method = RequestMethod.POST)
    public ResponseEntity<Factory> createFactory(@RequestBody Factory factory){
        factory = factoryRepository.save(factory);
        return new ResponseEntity<>(factory, HttpStatus.CREATED);

    }
    @RequestMapping(value = "/api/v1/factories/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Factory> updateFactory(@RequestBody Factory factory){
        var factoryToUpdate = factoryRepository.findById(factory.getId()).get();
        factoryToUpdate.setId(factory.getId());
        factoryToUpdate.setFactoryName(factory.getFactoryName());
        factoryToUpdate.setFactorySize(factory.getFactorySize());
        factoryToUpdate.setOmpaManager(factory.getOmpaManager());

        factoryRepository.save(factoryToUpdate);

        return new ResponseEntity<>(factoryToUpdate, HttpStatus.OK);
    }
    @RequestMapping (value = "/api/v1/factories/delete/{id}")
    public String deleteFactory(@PathVariable String id){
        factoryRepository.deleteById(Integer.parseInt(id));
        return "Factory with id " + id + " was deleted";
    }
}
