package com.cvgstudios.pokemonchrome.music;

import imr.media.Player;
import imr.media.SoundPlayer;

public class MP3MusicPlayer {
	Player player;

	public MP3MusicPlayer() {
		player = new SoundPlayer();
		player.play();
	}

//	public void set(String f) {
//		player.set(f);
//	}

	public void play() {
		player.play();
	}

	public void pause() {
		player.pause();
	}

	public void stop() {
		player.stop();
	}

}
