package com.apap.tugas.service;

import java.util.Date;
        import java.util.List;

        import com.apap.tugas.model.PustakawanModel;

public interface PustakawanService {
    List<PustakawanModel> getAllPustakawan();

    PustakawanModel addPustakawan(PustakawanModel pustakawan);

    PustakawanModel getPustakawanDetailByNip(String nip);

    String generateNip(Date tanggal_lahir);

    void editPustakawan(String nip, PustakawanModel newPustakawan);

    void deleteById(long id);


}