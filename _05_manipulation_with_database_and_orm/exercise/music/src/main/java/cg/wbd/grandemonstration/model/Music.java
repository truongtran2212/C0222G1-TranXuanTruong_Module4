package cg.wbd.grandemonstration.model;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Table(name = "music")
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name_music")
    private String nameMusic;
    private String singer;
    @Column(name = "type_music")
    private String typeMusic;
    @Column(name = "link_music")
    private String linkMusic;

    @ColumnDefault("0")
    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Music(int id, String nameMusic, String singer, String typeMusic, String linkMusic, int status) {
        this.id = id;
        this.nameMusic = nameMusic;
        this.singer = singer;
        this.typeMusic = typeMusic;
        this.linkMusic = linkMusic;
        this.status = status;
    }

    public Music() {
    }

    public Music(int id, String nameMusic, String singer, String typeMusic, String linkMusic) {
        this.id = id;
        this.nameMusic = nameMusic;
        this.singer = singer;
        this.typeMusic = typeMusic;
        this.linkMusic = linkMusic;
    }

    public Music(String nameMusic, String singer, String typeMusic, String linkMusic) {
        this.nameMusic = nameMusic;
        this.singer = singer;
        this.typeMusic = typeMusic;
        this.linkMusic = linkMusic;
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

    public String getLinkMusic() {
        return linkMusic;
    }

    public void setLinkMusic(String linkMusic) {
        this.linkMusic = linkMusic;
    }
}
