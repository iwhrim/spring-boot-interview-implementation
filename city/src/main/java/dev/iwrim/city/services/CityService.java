package dev.iwrim.city.services;

import dev.iwrim.city.dto.CityRequestDto;
import dev.iwrim.city.dto.CityResponseDto;

import java.util.List;

public interface CityService {

    public CityResponseDto saveCity(CityRequestDto cityRequestDto);
    public List<CityResponseDto> findCityByName(String name);
    public List<CityResponseDto> findCityByState(String state);

}
