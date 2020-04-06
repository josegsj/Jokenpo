package com.example.mock;

import com.example.domain.Player;
import com.example.domain.Player.PlayerBuilder;

public class PlayerMock {
	
	public static  PlayerBuilder getPlayer1() {
		return Player.builder().name("Player1");
	}
	
	public static  PlayerBuilder getPlayer2() {
		return Player.builder().name("Player2");
	}

}
