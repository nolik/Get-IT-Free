package com.getItFree.repository;

import com.getItFree.model.Advert;
import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvertRepository extends JpaRepository<Advert, Long> {

    List<Advert> findAllByTaker_Id(Long takerId);
}
