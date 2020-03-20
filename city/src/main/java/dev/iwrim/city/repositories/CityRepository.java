package dev.iwrim.city.repositories;

import dev.iwrim.city.dto.CityResponseDto;
import dev.iwrim.city.entities.City;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends MongoRepository<City, String> {
    public List<CityResponseDto> findAllCityByNameContaining(String name);
    public List<CityResponseDto> findAllCityByStateContaining(String name);

}
