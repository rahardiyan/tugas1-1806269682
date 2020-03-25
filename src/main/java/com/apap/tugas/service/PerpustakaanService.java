package com.apap.tugas.service;

import java.util.List;

import com.apap.tugas.model.PerpustakaanModel;

/**
 * FlightService
 */
public interface PerpustakaanService {
    List<PerpustakaanModel> getAllPerpustakaan();

    //PerpustakaanModel addPerpustakaan(PerpustakaanModel perpustakaan);

	


	void addPerpustakaan(PerpustakaanModel perpustakaan);
	

	

	void deleteById(long id);

	void deleteById(int id);

}
