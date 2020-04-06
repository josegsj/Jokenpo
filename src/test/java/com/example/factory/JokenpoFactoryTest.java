package com.example.factory;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.Player;
import com.example.domain.Player.PlayerBuilder;
import com.example.enumerator.JokenpoEnum;
import com.example.enumerator.PlayStatusEnum;
import com.example.mock.PlayResultMock;
import com.example.mock.PlayerMock;

@RunWith(SpringRunner.class)
public class JokenpoFactoryTest {
	
	@InjectMocks
	private JokenpoFactory jokenpoFactory;
	
	private PlayerBuilder playerOne;
	private PlayerBuilder playerTwo;
			
	@Before
	public void setUp() {
		playerOne=PlayerMock.getPlayer1();
		playerTwo=PlayerMock.getPlayer2();
	}
	
	
	@Test
	public void rockWinScissor() {
		Player p1=playerOne.chooseJokenpo(JokenpoEnum.ROCK).build();
		Player p2=playerTwo.chooseJokenpo(JokenpoEnum.SCISSOR).build();
		assertEquals(PlayResultMock.getPlayResult().playerWin(p1).statusPlay(PlayStatusEnum.WIN).build(), jokenpoFactory.verifyWinner(p1, p2));
	}
	
	@Test
	public void rockDrawRock() {
		Player p1=playerOne.chooseJokenpo(JokenpoEnum.ROCK).build();
		Player p2=playerTwo.chooseJokenpo(JokenpoEnum.ROCK).build();
		assertEquals(PlayResultMock.getPlayResult().playerWin(null).statusPlay(PlayStatusEnum.DRAW).build(), jokenpoFactory.verifyWinner(p1, p2));
	}
	
	@Test
	public void rockLosePapper() {
		Player p1=playerOne.chooseJokenpo(JokenpoEnum.ROCK).build();
		Player p2=playerTwo.chooseJokenpo(JokenpoEnum.PAPPER).build();
		assertEquals(PlayResultMock.getPlayResult().playerWin(p2).statusPlay(PlayStatusEnum.WIN).build(), jokenpoFactory.verifyWinner(p1, p2));
	}
	
	@Test
	public void papperWinRock() {
		Player p1=playerOne.chooseJokenpo(JokenpoEnum.PAPPER).build();
		Player p2=playerTwo.chooseJokenpo(JokenpoEnum.ROCK).build();
		assertEquals(PlayResultMock.getPlayResult().playerWin(p1).statusPlay(PlayStatusEnum.WIN).build(), jokenpoFactory.verifyWinner(p1, p2));
	}
	
	@Test
	public void papperDrawPapper() {
		Player p1=playerOne.chooseJokenpo(JokenpoEnum.PAPPER).build();
		Player p2=playerTwo.chooseJokenpo(JokenpoEnum.PAPPER).build();
		assertEquals(PlayResultMock.getPlayResult().playerWin(null).statusPlay(PlayStatusEnum.DRAW).build(), jokenpoFactory.verifyWinner(p1, p2));
	}
	
	@Test
	public void papperLoseScissor() {
		Player p1=playerOne.chooseJokenpo(JokenpoEnum.PAPPER).build();
		Player p2=playerTwo.chooseJokenpo(JokenpoEnum.SCISSOR).build();
		assertEquals(PlayResultMock.getPlayResult().playerWin(p2).statusPlay(PlayStatusEnum.WIN).build(), jokenpoFactory.verifyWinner(p1, p2));
	}
	
	@Test
	public void scissorWinPapper() {
		Player p1=playerOne.chooseJokenpo(JokenpoEnum.SCISSOR).build();
		Player p2=playerTwo.chooseJokenpo(JokenpoEnum.PAPPER).build();
		assertEquals(PlayResultMock.getPlayResult().playerWin(p1).statusPlay(PlayStatusEnum.WIN).build(), jokenpoFactory.verifyWinner(p1, p2));
	}
	
	@Test
	public void scissorDrawScissor() {
		Player p1=playerOne.chooseJokenpo(JokenpoEnum.SCISSOR).build();
		Player p2=playerTwo.chooseJokenpo(JokenpoEnum.SCISSOR).build();
		assertEquals(PlayResultMock.getPlayResult().playerWin(null).statusPlay(PlayStatusEnum.DRAW).build(), jokenpoFactory.verifyWinner(p1, p2));
	}
	
	@Test
	public void scissorloseRock() {
		Player p1=playerOne.chooseJokenpo(JokenpoEnum.SCISSOR).build();
		Player p2=playerTwo.chooseJokenpo(JokenpoEnum.ROCK).build();
		assertEquals(PlayResultMock.getPlayResult().playerWin(p2).statusPlay(PlayStatusEnum.WIN).build(), jokenpoFactory.verifyWinner(p1, p2));
	}
	
	
	
	
	

}
