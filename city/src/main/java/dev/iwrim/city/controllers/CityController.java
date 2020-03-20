package dev.iwrim.city.controllers;

import dev.iwrim.city.dto.CityRequestDto;
import dev.iwrim.city.dto.CityResponseDto;
import dev.iwrim.city.services.CityService;
import dev.iwrim.city.services.CityServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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

    @GetMapping
    public ResponseEntity<List<CityResponseDto>> getCityByName(@NotEmpty @NotNull @RequestParam(value = "name") String name) {
        List<CityResponseDto> cityResponseList = cityService.findCityByName(name);
        return new ResponseEntity<>(cityResponseList, HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<CityResponseDto>> getCityByState(@NotEmpty @NotNull @RequestParam(value = "state") String state) {
        List<CityResponseDto> cityResponseList = cityService.findCityByState(state);
        return new ResponseEntity<>(cityResponseList, HttpStatus.OK);
    }

}
