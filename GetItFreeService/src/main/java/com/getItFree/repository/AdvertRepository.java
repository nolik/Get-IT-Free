package com.getItFree.repository;

import com.getItFree.model.Advert;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface AdvertRepository extends MongoRepository<Advert, BigInteger>{
}
