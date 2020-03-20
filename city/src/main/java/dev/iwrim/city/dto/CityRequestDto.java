package dev.iwrim.city.dto;

import dev.iwrim.city.mappers.CityMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityRequestDto extends CityMapper  {

    @NotNull @NotEmpty private String name;
    @NotNull @NotEmpty private String state;

}
