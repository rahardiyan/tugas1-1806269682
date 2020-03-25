package com.apap.tugas.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Entity
@Table(name = "spesialisasi")
public class SpesialisasiModel implements Serializable {
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
    @Column(name = "deskripsi", nullable = false)
    private String deskripsi;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name= "spesialisasi_pustakawan",
            joinColumns = @JoinColumn(name = "spesialisasi_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "pustakawan_id", referencedColumnName = "id"))
    private Set<PustakawanModel> pustakawan_list;

//    public SpesialisasiModel(String name, String deskripsi, PustakawanModel... pustakawan_list) {
//        this.nama = name;
//        this.deskripsi = deskripsi;
//        this.pustakawan_list = Stream.of(pustakawan_list).collect(Collectors.toSet());
//        this.pustakawan_list.forEach(x -> x.getSpesialisasiList().add(this));
//    }

    public SpesialisasiModel() {}

    public void setId(long id) {
        this.id = id;
    }
    public void setNama(String nama) { this.nama = nama; }
    public void setDeskripsi(String deskripsi) { this.deskripsi = deskripsi; };

    public long getId() { return id; }
    public String getNama() { return nama; }
    public String getDeskripsi() { return deskripsi; }
}

