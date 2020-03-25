package com.apap.tugas.respository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.apap.tugas.model.PustakawanModel;

/**
 * FlightDb
 */
@Repository
public interface PustakawanDb extends JpaRepository<PustakawanModel, Long> {


    PustakawanModel findByNip(String nip);

    @Query(value = "SELECT nip FROM `pustakawan` ORDER BY id DESC LIMIT 0,1", nativeQuery = true)
    String getLatestNip();


}