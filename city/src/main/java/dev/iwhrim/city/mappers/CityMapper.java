package dev.iwhrim.city.mappers;

import dev.iwhrim.city.dto.CityResponseDto;
import dev.iwhrim.city.entities.City;
import org.modelmapper.ModelMapper;

public abstract class CityMapper {

    public City toCity() {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(this, City.class);
    }

    public CityResponseDto toResponseDto() {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(this, CityResponseDto.class);
    }

}