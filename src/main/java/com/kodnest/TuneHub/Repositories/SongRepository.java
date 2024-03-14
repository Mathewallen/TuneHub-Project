package com.kodnest.TuneHub.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodnest.TuneHub.Entities.Song;

public interface SongRepository extends JpaRepository<Song, Integer>{
	public Song findByName(String name);
}
