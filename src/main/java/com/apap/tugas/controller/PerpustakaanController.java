package com.apap.tugas.controller;
import java.util.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import com.apap.tugas.model.PerpustakaanModel;
import com.apap.tugas.service.*;

/**
 * PerpustakaanController
 */
@Controller
public class PerpustakaanController {

    @Autowired
    private PerpustakaanService perpustakaanService;

    @RequestMapping(value ="/perpustakaan", method = RequestMethod.GET)
    private String viewAllPerpustakaan(Model model) {
        List<PerpustakaanModel> allPerpustakaan = perpustakaanService.getAllPerpustakaan();
        if (allPerpustakaan == null) {
            return "not-found";
        }else {
            model.addAttribute("perpustakaan_list", allPerpustakaan);
            return "view-perpustakaan";
        }
    }

	@RequestMapping(value = "/perpustakaan/tambah", method = RequestMethod.GET)
	private String addPerpustakaan(Model model) {
		PerpustakaanModel perpustakaan = new PerpustakaanModel();
		perpustakaan.setId(perpustakaan.getId());
		model.addAttribute("perpustakaan", perpustakaan);
		return "add-perpustakaan2";
	}

	@RequestMapping(value = "/perpustakaan/tambah", method = RequestMethod.POST)
	private String addPerpustakaanSubmit(@ModelAttribute PerpustakaanModel perpustakaan, Model model) {
		perpustakaanService.addPerpustakaan(perpustakaan);
		return "add-success2";
	}

	
	@RequestMapping(value = "/perpustakaan/delete/{id}")
	private String deletePerpustakaan(@PathVariable(value = "id") long id, Model model) {
		perpustakaanService.deleteById(id);
		model.addAttribute("nav", "Hapus Pustakawan");
		return "add-message2";
	}


}