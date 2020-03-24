package dev.iwhrim.client.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import dev.iwhrim.client.mappers.ClientMapper;
import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Date;

@Data
@Document(collection = "clients")
public class Client extends ClientMapper {
    @Id
    private String id;

    private String completeName;
    private String sex;
    private String birthDate;
    private String liveCity;

}
