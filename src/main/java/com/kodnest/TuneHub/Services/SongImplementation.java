package com.kodnest.TuneHub.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodnest.TuneHub.Entities.Song;
import com.kodnest.TuneHub.Repositories.SongRepository;

@Service
public class SongImplementation implements SongService {
	@Autowired
	SongRepository songrepo;

	@Override
	public String addSongs(Song song) {
		songrepo.save(song);
		return "Song is added";
	}

	@Override
	public boolean nameExist(String name) {
		if(songrepo.findByName(name)== null) {
			return false;
		}
		else 
		{
			return true;
		}
	}

	@Override
	public List<Song> viewSongs() {
		List<Song> lis=songrepo.findAll();
		return lis;
	}

	@Override
	public void updateSong(Song song) {
		songrepo.save(song);
		
	}

	
	
	
	

}
