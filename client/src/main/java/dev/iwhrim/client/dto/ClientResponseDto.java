package dev.iwhrim.client.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;


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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate birth = LocalDate.parse(this.birthDate, formatter);
        Period agePeriod = Period.between(birth, LocalDate.now());
        this.setAge(agePeriod.getYears());
    }

}
