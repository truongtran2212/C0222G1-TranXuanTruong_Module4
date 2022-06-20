package cg.wbd.grandemonstration.service.impl;

import cg.wbd.grandemonstration.model.Music;
import cg.wbd.grandemonstration.repository.MusicRepository;
import cg.wbd.grandemonstration.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicServiceImpl implements MusicService {
    @Autowired
    private MusicRepository musicRepository;

    @Override
    public List<Music> findAll() {
        return musicRepository.findAll();
    }

    @Override
    public void create(Music music) {
        musicRepository.create(music);
    }

    @Override
    public Music findById(int idSearch) {
        return musicRepository.findById(idSearch);
    }

    @Override
    public void delete(int id) {
        musicRepository.delete(id);
    }

    @Override
    public void update(Music music) {
        musicRepository.update(music);
    }

    @Override
    public List<Music> search(String nameSinger) {
        return musicRepository.search(nameSinger);
    }

}
