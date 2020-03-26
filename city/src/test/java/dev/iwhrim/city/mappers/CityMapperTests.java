package dev.iwhrim.city.mappers;

import dev.iwhrim.city.dto.CityRequestDto;
import dev.iwhrim.city.dto.CityResponseDto;
import dev.iwhrim.city.entities.City;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CityMapperTests {

    @Test
    public void shouldConvertCityRequestDtoToCity() {
        CityRequestDto cityRequestDto = new CityRequestDto("City name", "State name");

        Assertions.assertThat(cityRequestDto.toCity()).isExactlyInstanceOf(City.class);
        Assertions.assertThat(cityRequestDto.toCity().getName()).isEqualTo("City name");
        Assertions.assertThat(cityRequestDto.toCity().getState()).isEqualTo("State name");
    }

    @Test public void shouldConvertCityToCityResponseDto() {
        City city = new City("a89sd7as89da", "City name", "State name");

        Assertions.assertThat(city.toResponseDto()).isExactlyInstanceOf(CityResponseDto.class);
        Assertions.assertThat(city.toResponseDto().getId()).isEqualTo("a89sd7as89da");
        Assertions.assertThat(city.toResponseDto().getName()).isEqualTo("City name");
        Assertions.assertThat(city.toResponseDto().getState()).isEqualTo("State name");
    }

}
