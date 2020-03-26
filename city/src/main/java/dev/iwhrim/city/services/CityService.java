package dev.iwhrim.city.services;

import dev.iwhrim.city.dto.CityRequestDto;
import dev.iwhrim.city.dto.CityResponseDto;

import java.util.List;

public interface CityService {

    public CityResponseDto saveCity(CityRequestDto cityRequestDto);
    public List<CityResponseDto> findCityByName(String name);
    public List<CityResponseDto> findCityByState(String state);

}
