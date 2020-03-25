package com.apap.tugas.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * FlightModel
 */
@Entity
@Table(name = "pustakawan")
public class PustakawanModel implements Serializable {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Size(max = 50)
    @Column(name = "nama", nullable = false)
    private String nama;

    @NotNull
    @Size(max = 20)
    @Column(name = "nip", nullable = false, unique = true)
    private String nip;

    @Size(max = 100)
    @Column(name = "tempat_lahir")
    private String tempat_lahir;

    @NotNull
    @Column(name = "tanggal_lahir", nullable = false)
    private Date tanggal_lahir;

    @NotNull
    @Column(name = "jenis_kelamin", nullable = false)
    private int jenis_kelamin;


    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },mappedBy = "pustakawan_list")
    private Set<SpesialisasiModel> spesialisasi_list = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },mappedBy = "pustakawan_list")
    private Set<PerpustakaanModel> perpustakaan_list = new HashSet<>();


    public PustakawanModel() {}

    public void setId(long id) {
        this.id = id;
    }

    public void setNama(String nama) { this.nama = nama; }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public void setTempat_lahir(String tempat_lahir) {
        this.tempat_lahir = tempat_lahir;
    }

    public void setTanggal_lahir(Date tanggal_lahir) {
        this.tanggal_lahir = tanggal_lahir;
    }

    public void setJenis_kelamin(int jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }


    public long getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getNip() {
        return nip;
    }

    public Set<PerpustakaanModel> getPerpustakaanList() { return this.perpustakaan_list; }

    public Set<SpesialisasiModel> getSpesialisasiList() { return this.spesialisasi_list; }

    public String getTempat_lahir() {
        return tempat_lahir;
    }

    public Date getTanggal_lahir() {
        return tanggal_lahir;
    }

    public int getJenis_kelamin() {
        return jenis_kelamin;
    }

	public List<PustakawanModel> getDaftarSpesialisasi() {
		// TODO Auto-generated method stub
		return null;
	}
}