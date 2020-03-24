package dev.iwhrim.client.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

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
        LocalDate birth = LocalDate.parse(this.birthDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        this.setAge(Period.between(birth, LocalDate.now()).getYears());
    }

}
