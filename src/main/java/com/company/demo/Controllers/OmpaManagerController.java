package com.company.demo.Controllers;

import com.company.demo.Models.OmpaManager;
import com.company.demo.Models.repositories.OmpaManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class OmpaManagerController {
    @Autowired
    private OmpaManagerRepository ompaManagerRepository;

    @RequestMapping(value = "/api/v1/managers", method = RequestMethod.GET)
    public ArrayList<OmpaManager> getAllManagers(){
        var managers = ompaManagerRepository.findAll();
        return (ArrayList<OmpaManager>) managers;
    }
    @RequestMapping(value = "/api/v1/managers", method = RequestMethod.POST)
    public ResponseEntity<OmpaManager> createManager(@RequestBody OmpaManager manager){
        manager = ompaManagerRepository.save(manager);
        return new ResponseEntity<>(manager, HttpStatus.CREATED);

    }
    @RequestMapping(value = "/api/v1/managers/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<OmpaManager> updateManager(@RequestBody OmpaManager manager){
        var managerToUpdate = ompaManagerRepository.findById(manager.getId()).get();
        managerToUpdate.setId(manager.getId());
        managerToUpdate.setOmpaname(manager.getOmpaname());
        managerToUpdate.setDateofbirth(manager.getDateofbirth());
        managerToUpdate.setAddress(manager.getAddress());
        ompaManagerRepository.save(managerToUpdate);

        return new ResponseEntity<>(managerToUpdate, HttpStatus.OK);
    }
    @RequestMapping (value = "/api/v1/managers/delete/{id}")
    public String deleteManager(@PathVariable String id){
        ompaManagerRepository.deleteById(Integer.parseInt(id));
        return "Oompaloomamanager with id " + id + " was deleted";
    }
}
