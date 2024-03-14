package com.kodnest.TuneHub.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodnest.TuneHub.Entities.Playlist;

public interface PlaylistRepository extends JpaRepository<Playlist, Integer>{

}
