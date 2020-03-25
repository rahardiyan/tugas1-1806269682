package com.apap.tugas.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

import com.apap.tugas.model.SpesialisasiModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.apap.tugas.model.PustakawanModel;
import com.apap.tugas.service.*;
import java.util.Random;

/**
 * PustakawanController
 */
@Controller
public class PustakawanController {

    @Autowired
    private PustakawanService pustakawanService;

    @Autowired
    private  SpesialisasiService spesialisasiService;

    


    @RequestMapping(value ="/")
    private String viewAllPustakawan(Model model) {
        List<PustakawanModel> allPustakawan = pustakawanService.getAllPustakawan();
        model.addAttribute("pustakawan_list", allPustakawan);
            return "Home";
        
    }
    
    @RequestMapping(value ="/pustakawan/cari/")
    private String searchPustakawan(Model model) {
    	List<PustakawanModel> allPustakawan = pustakawanService.getAllPustakawan();
        model.addAttribute("pustakawan_list", allPustakawan);
        return "cari";
        
    }



    @RequestMapping(value = "/pustakawan/tambah", method = RequestMethod.GET)
    private String add(Model model) {
        List<SpesialisasiModel> spesialisasiList = spesialisasiService.getAllSpesialisasi();
        PustakawanModel newPustakawan = new PustakawanModel();
        newPustakawan.getSpesialisasiList().add(new SpesialisasiModel());
        model.addAttribute("genders", Arrays.asList(1,2));
        model.addAttribute("pustakawan", newPustakawan);
        model.addAttribute("spesialisasiList", spesialisasiList);
        return "add-pustakawan2";
    }

    @RequestMapping(value = "/pustakawan/tambah", method = RequestMethod.POST, params={"addSpesialisasi"})
    private String addSpesialisasi(@ModelAttribute PustakawanModel pustakawan, Model model) {

        System.out.println("UDAH MASUK SINII" + pustakawan.getSpesialisasiList().size());
        System.out.println("COBA2: " + pustakawan.getNip());
        List<SpesialisasiModel> spesialisasiList = spesialisasiService.getAllSpesialisasi();

        model.addAttribute("genders", Arrays.asList(1,2));
        model.addAttribute("pustakawan", pustakawan);
        model.addAttribute("spesialisasiList", spesialisasiList);
        return "add-pustakawan2";
    }


    @RequestMapping(value = "/pustakawan/tambah", method = RequestMethod.POST, params={"save"})
    private String addPilotSubmit(@ModelAttribute PustakawanModel pustakawan, Model model) {
        if(pustakawan.getNip() == null) pustakawan.setNip(pustakawanService.generateNip(pustakawan.getTanggal_lahir()));
        

        pustakawanService.addPustakawan(pustakawan);
        model.addAttribute("pustakawan", pustakawan);
        return "add-success";
    }
	
    @RequestMapping(value ="/pustakawan", method = RequestMethod.GET)
    public String showPustakawanDetail(@RequestParam(value = "nip") String nip, Model model) {
        PustakawanModel pustakawan = pustakawanService.getPustakawanDetailByNip(nip);
        System.out.println("LEWAT SINI GAES" + pustakawan.getNama() + pustakawan.getNip() + pustakawan.getTanggal_lahir() + pustakawan.getTempat_lahir());
        model.addAttribute("pustakawan", pustakawan);
        return "view-pustakawan-info";
    }

    

    @RequestMapping(value = "/pustakawan/delete/{id}")
	private String deletePustakawan(@PathVariable(value = "id") int id, Model model) {
		pustakawanService.deleteById(id);
		model.addAttribute("nav", "Hapus Pustakawan");
		return "add-message";
	}


    @RequestMapping(value = "/pustakawan/edit", method = RequestMethod.GET)
    public String editPustakawan(@RequestParam(value = "nip") String nip, Model model) {


        PustakawanModel pustakawan = pustakawanService.getPustakawanDetailByNip(nip);
        
        List<SpesialisasiModel> spesialisasiList = spesialisasiService.getAllSpesialisasi();
        model.addAttribute("genders", Arrays.asList(1,2));
        model.addAttribute("pustakawan", new PustakawanModel());
        model.addAttribute("existingPustakawan", pustakawan);
        model.addAttribute("spesialisasiList", spesialisasiList);
        return "edit-pustakawan2";
    }

    @RequestMapping(value = "/pustakawan/edit", method = RequestMethod.POST)
    private String editPilotSubmit(@ModelAttribute PustakawanModel pustakawan, Model model) {
        PustakawanModel editedPustakawan = pustakawanService.getPustakawanDetailByNip(pustakawan.getNip());
        pustakawanService.editPustakawan(pustakawan.getNip(), pustakawan);
        model.addAttribute("pustakawan", editedPustakawan);
        return "add-success2";
    }
    
    @RequestMapping(value = "/statistik/", method = RequestMethod.POST)
    private String statistik(@ModelAttribute PustakawanModel pustakawan, Model model) {
    	List<SpesialisasiModel> spesialisasiList = spesialisasiService.getAllSpesialisasi();
    	model.addAttribute("spesialisasiList", spesialisasiList);
    	model.addAttribute("pustakawan", new PustakawanModel());
        return "statistik";
    }

   


       
       
}