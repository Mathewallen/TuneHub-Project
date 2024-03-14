package com.kodnest.TuneHub.Services;

import java.util.List;

import com.kodnest.TuneHub.Entities.Song;

public interface SongService {
	public String addSongs(Song song);
	public boolean nameExist(String name);
	public List<Song> viewSongs();
	public void updateSong(Song song);
}
