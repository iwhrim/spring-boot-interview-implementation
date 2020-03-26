package dev.iwhrim.city.services;

import dev.iwhrim.city.dto.CityRequestDto;
import dev.iwhrim.city.dto.CityResponseDto;
import dev.iwhrim.city.repositories.CityRepository;
import dev.iwhrim.city.entities.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImp implements CityService {

    @Autowired
    public CityRepository cityRepository;

    @Override
    public CityResponseDto saveCity(CityRequestDto cityRequestDto) {
        City city = cityRequestDto.toCity();
        City savedCity = cityRepository.save(city);
        return savedCity.toResponseDto();
    }

    @Override
    public List<CityResponseDto> findCityByName(String name) {
        return cityRepository.findAllCityByNameContaining(name);
    }

    @Override
    public List<CityResponseDto> findCityByState(String state) {
        return cityRepository.findAllCityByStateContaining(state);
    }
}
