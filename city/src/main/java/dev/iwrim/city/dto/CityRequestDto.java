package dev.iwrim.city.dto;

import dev.iwrim.city.mappers.CityMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityRequestDto extends CityMapper  {

    @Size(min = 1, max = 85, message = "City name must be between 1 and 85 characters.")
    @NotBlank(message = "City name can not be empty.")
    @Pattern(regexp = "[A-Za-z ]*")
    private String name;

    @Size(min = 2, max = 2, message = "State must have 2 characters.")
    @NotBlank(message = "State can not be empty.")
    @Pattern(regexp = "[A-Za-z ]*")
    private String state;

}
