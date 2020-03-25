package com.apap.tugas.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Entity
@Table(name = "perpusatakaan")
public class PerpustakaanModel implements Serializable {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Size(max = 50)
    @Column(name = "nama", nullable = false)
    private String nama;

    @NotNull
    @Size(max = 500)
    @Column(name = "lokasi", nullable = false)
    private String lokasi;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name= "perpustakaan_pustakawan",
            joinColumns = @JoinColumn(name = "perpustakaan_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "pustakawan_id", referencedColumnName = "id"))
    private Set<PustakawanModel> pustakawan_list;



    public PerpustakaanModel() {}

    public void setId(long id) {
        this.id = id;
    }
    public void setNama(String nama) { this.nama = nama; }
    public void setLokasi(String lokasi) { this.lokasi = lokasi; };

    public long getId() { return id; }
    public String getNama() { return nama; }
    public String getLokasi() { return lokasi; }
}
