package cg.wbd.grandemonstration.repository.impl;

import cg.wbd.grandemonstration.model.Music;
import cg.wbd.grandemonstration.repository.BaseRepository;
import cg.wbd.grandemonstration.repository.MusicRepository;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import java.util.List;

@Repository
public class MusicRepositoryImpl implements MusicRepository {

    @Override
    public List<Music> findAll() {
        List<Music> musicList = BaseRepository.entityManager.createQuery("select m from Music m where status = 0", Music.class).getResultList();
        return musicList;
    }

    @Override
    public void create(Music music) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(music);
        entityTransaction.commit();
    }

    @Override
    public Music findById(int idSearch) {
        Music music = BaseRepository.entityManager.createQuery("select m from Music m where m.id = ?1",
                Music.class).setParameter(1, idSearch).getSingleResult();
        return music;
    }

    @Override
    public void delete(int id) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        Music music = findById(id);
        music.setStatus(1);
        BaseRepository.entityManager.merge(music);
        entityTransaction.commit();
    }

    @Override
    public void update(Music music) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(music);
        entityTransaction.commit();
    }

    @Override
    public List<Music> search(String nameSinger) {
        List<Music> musicList = BaseRepository.entityManager.createQuery(
                "select m from Music m where m.singer like ?1 and m.status = 0", Music.class)
                .setParameter(1, "%" + nameSinger + "%").getResultList();
        return musicList;
    }
}
