package com.apap.tugas.respository;

import java.util.Optional;

import com.apap.tugas.model.PerpustakaanModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * PilotDb
 */
@Repository
public interface PerpustakaanDb extends JpaRepository<PerpustakaanModel, Long> {
}