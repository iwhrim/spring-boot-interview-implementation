package dev.iwhrim.client.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import dev.iwhrim.client.mappers.ClientMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientRequestDto extends ClientMapper {

    @NotNull @NotEmpty private String completeName;
    @NotNull @NotEmpty private String sex;
    @JsonFormat
    @NotNull @NotEmpty private String birthDate;
    @NotNull @NotEmpty private String liveCity;

}
