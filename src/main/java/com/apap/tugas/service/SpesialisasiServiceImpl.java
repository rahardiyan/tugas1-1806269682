package com.apap.tugas.service;

import com.apap.tugas.model.PustakawanModel;
import com.apap.tugas.model.SpesialisasiModel;
import com.apap.tugas.respository.PustakawanDb;
import com.apap.tugas.respository.SpesialisasiDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SpesialisasiServiceImpl implements SpesialisasiService {
    @Autowired
    private SpesialisasiDb spesialisasiDb;

//    @Override
//    public PustakawanModel addPustakawan(PustakawanModel pustakawan) {
//        return pustakawanDb.save(pustakawan);
//    }

    @Override
    public List<SpesialisasiModel> getAllSpesialisasi() {
        return spesialisasiDb.findAll();
    }

	

//    @Override
//    public void deleteByFlightNumber(String flightNumber) {
//        pustakawanDb.deleteByFlightNumber(flightNumber);
//    }
//
//    @Override
//    public Optional<PustakawanModel> getFlightDetailByFlightNumber(String flightNumber) {
//        return pustakawanDb.findByFlightNumber(flightNumber);
//    }
}