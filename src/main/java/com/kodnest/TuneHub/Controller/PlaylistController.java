package com.kodnest.TuneHub.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kodnest.TuneHub.Entities.Playlist;
import com.kodnest.TuneHub.Entities.Song;
import com.kodnest.TuneHub.Services.PlaylistServices;
import com.kodnest.TuneHub.Services.SongService;

@Controller
public class PlaylistController {
	
	@Autowired
	SongService songserv;
	
	@Autowired
	PlaylistServices playserv;
	
	@GetMapping("/mapCreatePlaylist")
	public String createPlaylist(Model model) {
		List<Song> lists = songserv.viewSongs();
		model.addAttribute("song", lists);
		return "createplaylist";
	}
	
	@PostMapping("/addPlaylist")
	public String addPlaylist(@ModelAttribute Playlist play) {
		
     	playserv.addPlaylist(play);
     	
     	List<Song> songslist = play.getSong();
     	for(Song song : songslist) {
     		song.getPlaylist().add(play);
     		songserv.updateSong(song);
     	}
		return "playlistsuccess";
	}
	
	@GetMapping("/mapViewPlaylist")
	public String viewPlaylist(Model model) {
		List<Playlist> play=playserv.viewPlaylist();
		model.addAttribute("plistview", play);
		return "viewplaylist";
	}
	
}
