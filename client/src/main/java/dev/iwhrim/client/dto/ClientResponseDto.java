package dev.iwhrim.client.dto;

import dev.iwhrim.client.exceptions.InvalidDateTimeFormatException;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Data
@NoArgsConstructor
public class ClientResponseDto {

    private String id;
    private String completeName;
    private String sex;
    private String birthDate;
    private int age;
    private String liveCity;

    public void calculateAge() {
        LocalDate birth;
        try {
            birth = LocalDate.parse(this.birthDate, DateTimeFormatter.ISO_ZONED_DATE_TIME);
        } catch (DateTimeParseException ex) {
            throw new InvalidDateTimeFormatException();
        }
        this.setAge(Period.between(birth, LocalDate.now()).getYears());
    }

}
