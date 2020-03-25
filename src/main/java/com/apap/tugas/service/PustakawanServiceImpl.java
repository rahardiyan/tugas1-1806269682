package com.apap.tugas.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tugas.model.PustakawanModel;
import com.apap.tugas.respository.PustakawanDb;

/**
 * FlightServiceImpl
 */
@Service
@Transactional
public class PustakawanServiceImpl implements PustakawanService {
    DateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
    DateFormat yearFormat = new SimpleDateFormat("yyyy");

    @Autowired
    private PustakawanDb pustakawanDb;

    @Override
    public PustakawanModel addPustakawan(PustakawanModel pustakawan) {
        return pustakawanDb.save(pustakawan);
    }

    @Override
    public List<PustakawanModel> getAllPustakawan() {
        return pustakawanDb.findAll();
    }

    @Override
    public PustakawanModel getPustakawanDetailByNip(String nip) {
        return pustakawanDb.findByNip(nip);
    }

    @Override
    public String generateNip(Date tanggal_lahir) {
        Date date = new Date();

        String latestNip = pustakawanDb.getLatestNip();
        int first = (int) latestNip.charAt(12);
        int second = (int) latestNip.charAt(13);

        if(first != 90 && second != 57) second ++;
        else if(first != 90 && second == 57) second = 65;
        else if(first != 90 && first == 57 && second == 90 ) { first = 65; second = 48; }
        else if(first != 90 && second == 90 ) { first ++; second = 48; }
        else if(first == 90 && second == 90 ) { first = 48; second = 48; }
        else { first ++; second++; }

        String newNip = yearFormat.format(date) + dateFormat.format(tanggal_lahir) + (char) first + (char) second;
        return newNip;
    }

    @Override
    public void editPustakawan(String nip, PustakawanModel newPustakawan) {
        PustakawanModel editedPustakawan = this.getPustakawanDetailByNip(nip);

        editedPustakawan.setJenis_kelamin(newPustakawan.getJenis_kelamin());
        editedPustakawan.setTempat_lahir(newPustakawan.getTempat_lahir());
        editedPustakawan.setTanggal_lahir(newPustakawan.getTanggal_lahir());
        editedPustakawan.setNama(newPustakawan.getNama());
    }

    @Override
    public void deleteById(long id) {
        pustakawanDb.deleteById(id);
    }

//    @Override
//    public void deleteByFlightNumber(String flightNumber) {
//        pustakawanDb.deleteByFlightNumber(flightNumber);
//    }

//    @Override
//    public Optional<PustakawanModel> getFlightDetailByFlightNumber(String flightNumber) {
//        return pustakawanDb.findByFlightNumber(flightNumber);
//    }
}