package cg.wbd.grandemonstration.repository;

import cg.wbd.grandemonstration.model.Music;

import java.util.List;

public interface MusicRepository {
    List<Music> findAll();

    void create(Music music);

    Music findById(int idSearch);

    void delete(int id);

    void update(Music music);

    List<Music> search(String nameSinger);
}
