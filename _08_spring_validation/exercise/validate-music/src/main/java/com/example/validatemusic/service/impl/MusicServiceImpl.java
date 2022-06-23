package com.example.validatemusic.service.impl;
import com.example.validatemusic.model.Music;
import com.example.validatemusic.repository.MusicRepository;
import com.example.validatemusic.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicServiceImpl implements MusicService {
    @Autowired
    private MusicRepository musicRepository;

    @Override
    public Page<Music> findAll(Pageable pageable) {
        return musicRepository.findAll(pageable);
    }

    @Override
    public void create(String nameMusic, String singer, String typeMusic) {
        musicRepository.create(nameMusic,singer,typeMusic);
    }

    @Override
    public Music findById(int idSearch) {
        return musicRepository.findById(idSearch);
    }

    @Override
    public void update(String nameMusic, String singer, String typeMusic, int id) {
        musicRepository.update(nameMusic,singer,typeMusic, id);
    }

}
