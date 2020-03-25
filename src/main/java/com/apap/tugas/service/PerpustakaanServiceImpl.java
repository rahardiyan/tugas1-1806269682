package com.apap.tugas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tugas.model.PerpustakaanModel;
import com.apap.tugas.respository.PerpustakaanDb;

/**
 * FlightServiceImpl
 */
@Service
@Transactional
public class PerpustakaanServiceImpl implements PerpustakaanService {
    @Autowired
    private PerpustakaanDb perpustakaanDb;



    //@Override
    //public PerpustakaanModel addPerpustakaan(PerpustakaanModel pustakawan) {
      //  return perpustakaanDb.save(pustakawan);
    //}

    @Override
    public List<PerpustakaanModel> getAllPerpustakaan() {
        return perpustakaanDb.findAll();
    }

	

	@Override
	public void addPerpustakaan(PerpustakaanModel perpustakaan) {
		perpustakaanDb.save(perpustakaan);
		
	}

	

	@Override
	public void deleteById(long id) {
		perpustakaanDb.deleteById(id);
		
	}



	@Override
	public void deleteById(int id) {
		//perpustakaanDb.deleteById(id);
		
	}

}