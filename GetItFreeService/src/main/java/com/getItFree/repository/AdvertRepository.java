package com.getItFree.repository;

import com.getItFree.model.Advert;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvertRepository extends MongoRepository<Advert, String>{
}
