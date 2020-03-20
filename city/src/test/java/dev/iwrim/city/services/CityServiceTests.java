package dev.iwrim.city.services;

import dev.iwrim.city.dto.CityRequestDto;
import dev.iwrim.city.dto.CityResponseDto;
import dev.iwrim.city.entities.City;
import dev.iwrim.city.repositories.CityRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CityServiceTests {

    @Mock
    private CityRepository cityRepository;

    @InjectMocks
    private CityServiceImp cityService;

    @Test
    public void shouldSaveCityRequestDtoAndReturnCityResponseDto(){
        CityRequestDto request = new CityRequestDto("City name", "State name");
        City cityWithId = request.toCity();
        cityWithId.setId("897ada70as");

        when(cityRepository.save(request.toCity())).thenReturn(cityWithId);

        Assertions.assertThat(cityService.saveCity(request)).isExactlyInstanceOf(CityResponseDto.class);
        Assertions.assertThat(cityService.saveCity(request).getId()).isEqualTo("897ada70as");
        Assertions.assertThat(cityService.saveCity(request).getName()).isEqualTo("City name");
        Assertions.assertThat(cityService.saveCity(request).getState()).isEqualTo("State name");
    }

    @Test
    public void shouldFindCityByName() {
        String cityName = "City name";
        City city = new City("897ada70as", "City name", "State name");
        List<CityResponseDto> list = new ArrayList<>();
        list.add(city.toResponseDto());

        when(cityRepository.findAllCityByNameContaining(cityName)).
                thenReturn(list);

        Assertions.assertThat(cityService.findCityByName(cityName)).hasSize(1);
        Assertions.assertThat(cityService.findCityByName(cityName).get(0).getName()).isEqualTo(cityName);
    }

}
