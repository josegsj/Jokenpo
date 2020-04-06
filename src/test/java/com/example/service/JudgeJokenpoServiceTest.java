package com.example.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.Player;
import com.example.domain.Player.PlayerBuilder;
import com.example.enumerator.JokenpoEnum;
import com.example.enumerator.PlayStatusEnum;
import com.example.factory.JokenpoFactory;
import com.example.mock.PlayResultMock;
import com.example.mock.PlayerMock;

@RunWith(SpringRunner.class)
public class JudgeJokenpoServiceTest {
	
	@InjectMocks
	private JudgeJokenpoService service;
	
	@Mock
	private JokenpoFactory jokenpoFactory;
	
	private PlayerBuilder playerOne;
	private PlayerBuilder playerTwo;
			
	@Before
	public void setUp() {
		playerOne=PlayerMock.getPlayer1();
		playerTwo=PlayerMock.getPlayer2();
	}
	
	@Test
	public void verifyWinnerWhenPlayerOneWin() {
		Player p1=playerOne.chooseJokenpo(JokenpoEnum.ROCK).build();
		Player p2=playerTwo.chooseJokenpo(JokenpoEnum.SCISSOR).build();
		String result="o vencedor foi Player1";
		Mockito.when(jokenpoFactory.verifyWinner(Mockito.any(), Mockito.any()))
		.thenReturn(PlayResultMock.getPlayResult().playerWin(p1).statusPlay(PlayStatusEnum.WIN).build());
		assertEquals(result, service.verifyWinner(p1, p2));;
	}
	
	@Test
	public void verifyWinnerWhenPlayerTwoWin() {
		Player p1=playerOne.chooseJokenpo(JokenpoEnum.ROCK).build();
		Player p2=playerTwo.chooseJokenpo(JokenpoEnum.PAPPER).build();
		String result="o vencedor foi Player2";
		Mockito.when(jokenpoFactory.verifyWinner(Mockito.any(), Mockito.any()))
		.thenReturn(PlayResultMock.getPlayResult().playerWin(p2).statusPlay(PlayStatusEnum.WIN).build());
		assertEquals(result, service.verifyWinner(p1, p2));;
	}
	
	@Test
	public void verifyWinnerWhenPlayersDraw() {
		Player p1=playerOne.chooseJokenpo(JokenpoEnum.ROCK).build();
		Player p2=playerTwo.chooseJokenpo(JokenpoEnum.ROCK).build();
		String result="Empate";
		Mockito.when(jokenpoFactory.verifyWinner(Mockito.any(), Mockito.any()))
		.thenReturn(PlayResultMock.getPlayResult().playerWin(null).statusPlay(PlayStatusEnum.DRAW).build());
		assertEquals(result, service.verifyWinner(p1, p2));;
	}

}
