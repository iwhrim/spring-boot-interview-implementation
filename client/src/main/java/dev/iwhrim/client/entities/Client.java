package dev.iwhrim.client.entities;

import dev.iwhrim.client.mappers.ClientMapper;
import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "clients")
public class Client extends ClientMapper {

    @Id
    private String id;
    private String completeName;
    private String sex;
    private String birthDate;
    private String liveCity;

}
