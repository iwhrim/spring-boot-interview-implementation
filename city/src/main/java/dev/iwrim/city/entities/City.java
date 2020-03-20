package dev.iwrim.city.entities;

import dev.iwrim.city.mappers.CityMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "cities")
public class City extends CityMapper {

    @Id
    private String id;

    private String name;
    private String state;

}
