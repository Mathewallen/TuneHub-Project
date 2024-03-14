package com.kodnest.TuneHub.Services;

import java.util.List;

import com.kodnest.TuneHub.Entities.Playlist;

public interface PlaylistServices {
	
	public void addPlaylist(Playlist play);

	public List<Playlist> viewPlaylist();
}
