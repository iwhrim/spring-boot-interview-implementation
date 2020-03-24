package dev.iwhrim.client.repositories;

import dev.iwhrim.client.entities.Client;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends MongoRepository<Client, String> {
    public List<Client> findAllByCompleteNameContaining(String name);
}
