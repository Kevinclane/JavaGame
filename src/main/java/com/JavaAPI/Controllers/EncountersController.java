package com.JavaAPI.Controllers;

import com.JavaAPI.Models.Encounter;
import com.JavaAPI.RequestModels.EncounterReq;
import com.JavaAPI.RequestModels.EncounterUserAction;
import com.JavaAPI.Services.EncountersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class EncountersController {

    @Autowired
    private EncountersService _encountersService;

    @GetMapping("/encounters/{id}")
    public Optional<Encounter> getEncounter(@PathVariable String id) throws Exception {
        try {
            return _encountersService.getEncounter(id);
        } catch (Exception err){
            throw new Exception(err);
        }
    }

    @PostMapping("/encounters/new")
    public Encounter createEncounter(@RequestBody EncounterReq req) throws Exception {
        try {
            var res = _encountersService.createEncounter(req);
            return res;
        } catch (Exception err){
            throw new Exception(err);
        }
    }

    @PostMapping("/encounters/userchoice")
    public Encounter handleUserChoice(@RequestBody EncounterUserAction req) throws Exception {
        try {
            Encounter encounter = _encountersService.handleUserChoice(req);
            encounter = _encountersService.checkIfEnemysTurn(encounter);
            return encounter;
        } catch (Exception err){
            throw new Exception(err);
        }
    }

    @DeleteMapping("/encounters/{encounterId}")
    public void deleteEncounter(@PathVariable String encounterId) throws Exception{
        try{
            _encountersService.deleteEncounter(encounterId);
        } catch (Exception err){
            throw new Exception(err);
        }
    }

}
