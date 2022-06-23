package com.example.validatemusic.repository;

import com.example.validatemusic.model.Music;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface MusicRepository extends JpaRepository<Music, Integer> {

    @Query(value = "select * from music where status = 0", nativeQuery = true)
    Page<Music> findAll(Pageable pageable);

    @Modifying
    @Query(value = "insert into music (name_music,singer,type_music) " +
            "values (:nameMusic,:singer,:typeMusic)", nativeQuery = true)
    void create(@Param("nameMusic") String nameMusic,
                @Param("singer") String singer,
                @Param("typeMusic") String typeMusic);

    @Query(value = "select * from music where id = :id", nativeQuery = true)
    Music findById(@Param("id") int id);

    @Modifying
    @Query(value = "update music set name_music = :nameMusic,singer = :singer, type_music = :typeMusic where id = :id", nativeQuery = true)
    void update(@Param("nameMusic") String nameMusic,
                @Param("singer") String singer,
                @Param("typeMusic") String typeMusic,
                @Param("id") int id);

}
