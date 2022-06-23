package com.example.validatemusic.service;

import com.example.validatemusic.model.Music;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MusicService {
    Page<Music> findAll(Pageable pageable);

    void create(String nameMusic,String singer,String typeMusic);

    Music findById(int idSearch);

    void update(String nameMusic,String singer,String typeMusic,int id);

}
