package com.example.validatemusic.model;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "music")
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    // Có @Size thì không cần @Blank (chỉ được sử dụng 1 trong 2)
    @Column(name = "name_music")
    @Pattern(regexp = "^[A-Za-z-0-9 ]*$", message = "Sai định dạng")
    @Size(min = 1, max = 800, message = "không được để trống và không nhập quá 800 kí tự")

    private String nameMusic;


    @Pattern(regexp = "^[A-Za-z-0-9 ]*$", message = "Sai định dạng")
    @Size(min = 1, max = 300, message = "không được để trống và không nhập quá 300 kí tự")
    private String singer;

    @Column(name = "type_music")
    @Pattern(regexp = "^[A-Za-z-0-9, ]*$", message = "Sai định dạng")
    @Size(min = 1, max = 1000, message = "không được để trống và không nhập quá 1000 kí tự")
    private String typeMusic;

    @ColumnDefault("0")
    private int status;

    public Music(int id, @Pattern(regexp = "^[A-Za-z-0-9]*$", message = "Sai định dạng và không được để trống") @Size(max = 800) String nameMusic,
                 @Pattern(regexp = "^[A-Za-z-0-9]*$", message = "Sai định dạng và không được để trống") @Size(max = 300) String singer,
                 @Pattern(regexp = "^[A-Za-z-0-9],*$", message = "Sai định dạng và không được để trống") @Size(max = 1000) String typeMusic,
                 int status) {
        this.id = id;
        this.nameMusic = nameMusic;
        this.singer = singer;
        this.typeMusic = typeMusic;
        this.status = status;
    }

    public Music() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameMusic() {
        return nameMusic;
    }

    public void setNameMusic(String nameMusic) {
        this.nameMusic = nameMusic;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getTypeMusic() {
        return typeMusic;
    }

    public void setTypeMusic(String typeMusic) {
        this.typeMusic = typeMusic;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
