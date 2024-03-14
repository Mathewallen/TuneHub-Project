package com.kodnest.TuneHub.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodnest.TuneHub.Entities.Playlist;
import com.kodnest.TuneHub.Repositories.PlaylistRepository;

@Service
public class PlaylistImplementation implements PlaylistServices{
	
	@Autowired
	PlaylistRepository playrepo;

	@Override
	public void addPlaylist(Playlist play) {
		playrepo.save(play);
	}

	@Override
	public List<Playlist> viewPlaylist() {
		return playrepo.findAll();
	}


}
