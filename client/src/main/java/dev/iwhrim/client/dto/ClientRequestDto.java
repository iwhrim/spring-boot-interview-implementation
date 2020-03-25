package dev.iwhrim.client.dto;

import dev.iwhrim.client.mappers.ClientMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientRequestDto extends ClientMapper {

    @Size(min = 4, max = 100, message = "Complete name must be between 4 and 100 characters.")
    @NotBlank(message = "Complete name can not be empty.")
    @Pattern(regexp = "[A-Za-z ]*")
    private String completeName;

    @Size(min = 4, max = 6, message = "Sex can must be between 4 and 6 characters (Male or Female).")
    @NotBlank(message = "Sex can not be empty.")
    @Pattern(regexp = "Male|Female")
    private String sex;

    @Size(min = 4, max = 100, message = "Birth date must be between 4 and 100 characters and must be in ISO 8601 format.")
    @NotBlank(message = "Birth date can not be empty.")
    private String birthDate;

    @Size(min = 4, max = 50, message = "Live city must be between 4 and 50 characters.")
    @NotBlank(message = "Live city can not be empty.")
    @Pattern(regexp = "[A-Za-z ]*")
    private String liveCity;

    public boolean isValidBirthDate() {
        try { LocalDate.parse(this.birthDate, DateTimeFormatter.ISO_ZONED_DATE_TIME); }
        catch (DateTimeParseException ex) { return false; } return true;
    }

}
