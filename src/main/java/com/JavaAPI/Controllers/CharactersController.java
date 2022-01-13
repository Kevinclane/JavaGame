package com.JavaAPI.Controllers;

import com.JavaAPI.Models.Character;
import com.JavaAPI.RequestModels.CharacterReq;
import com.JavaAPI.Services.CharactersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CharactersController {

    @Autowired
    private CharactersService _charactersService;

    @PostMapping("/characters")
    public Character createCharacter(@RequestBody final CharacterReq characterReq){
        return _charactersService.createCharacter(characterReq);
    }

    @GetMapping("/characters/{id}")
    public Character getCharacter(@PathVariable String id) throws Exception {
        try {
            return _charactersService.getCharacter(id);
        } catch (Exception err){
            throw new Exception(err);
        }
    }

    @GetMapping("/characters/all")
    public List<Character> getAllCharacters() throws Exception {
        try{
            return _charactersService.getAllCharacters();
        } catch(Exception err) {
            throw new Exception(err);
        }
    }

    @PostMapping("/characters/list")
    public List<Character> getListOfCharactersByIds(@RequestBody final List<String> ids) throws Exception {
        try{
            return _charactersService.getListOfCharactersByIds(ids);
        } catch(Exception err){
            throw new Exception(err);
        }
    }
}
