package dev.iwrim.city.controllers;

import dev.iwrim.city.dto.CityRequestDto;
import dev.iwrim.city.dto.CityResponseDto;
import dev.iwrim.city.services.CityServiceImp;
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
        List<CityResponseDto> result = new ArrayList<>();
        if (!name.isEmpty() && name != null) result.addAll(cityService.findCityByName(name));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/state/{state}")
    public ResponseEntity<List<CityResponseDto>> getCityByState(@PathVariable(value = "state") String state) {
        List<CityResponseDto> result = new ArrayList<>();
        if (!state.isEmpty() && state != null) result.addAll(cityService.findCityByState(state));
        return new ResponseEntity<>(result, HttpStatus.OK);

    }

}
