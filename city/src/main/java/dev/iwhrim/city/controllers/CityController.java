package dev.iwhrim.city.controllers;

import dev.iwhrim.city.dto.CityRequestDto;
import dev.iwhrim.city.dto.CityResponseDto;
import dev.iwhrim.city.exceptions.InvalidParameterValueException;
import dev.iwhrim.city.services.CityServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {

    @Autowired
    private CityServiceImp cityService;

    @PostMapping
    public ResponseEntity<CityResponseDto> postNewCity(@Valid @RequestBody CityRequestDto cityRequestDto) {
        CityResponseDto savedCity = cityService.saveCity(cityRequestDto);
        return new ResponseEntity<>(savedCity, HttpStatus.CREATED);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<CityResponseDto>> getCityByName(@PathVariable(value = "name") String name) {
        if (name.isEmpty() || !name.matches("[A-Za-z ]*")) throw new InvalidParameterValueException();
        List<CityResponseDto> result = new ArrayList<>(cityService.findCityByName(name));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/state/{state}")
    public ResponseEntity<List<CityResponseDto>> getCityByState(@PathVariable(value = "state") String state) {
        if (state.isEmpty() || !state.matches("[A-Za-z ]*")) throw new InvalidParameterValueException();
        List<CityResponseDto> result = new ArrayList<>(cityService.findCityByState(state));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
