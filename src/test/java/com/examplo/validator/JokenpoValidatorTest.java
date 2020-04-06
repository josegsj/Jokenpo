package com.examplo.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.Player.PlayerBuilder;
import com.example.mock.PlayerMock;

@RunWith(SpringRunner.class)
public class JokenpoValidatorTest {
	
	@InjectMocks
	private JokenpoValidator jokenpoValidator;
	
	private PlayerBuilder playerOne;
	private PlayerBuilder playerTwo;
			
	@Before
	public void setUp() {
		playerOne=PlayerMock.getPlayer1();
		playerTwo=PlayerMock.getPlayer2();
	}
	
	@Test
	public void verifyTypeIdJokenpoWhenReceiveidCorrect() {
		assertTrue(jokenpoValidator.verifyTypeIdJokenpo(1));
	}
	
	@Test
	public void verifyTypeIdJokenpoWhenReceiveidInCorrect() {
		assertFalse(jokenpoValidator.verifyTypeIdJokenpo(5));
	}
	
	@Test
	public void verifyTypeStringWhenReceiveValeuCorrect() {
		assertTrue(jokenpoValidator.verifyTypeString("2"));
	}
	
	@Test
	public void verifyTypeStringWhenReceiveValeuInCorrect() {
		assertFalse(jokenpoValidator.verifyTypeString("a"));
	}
	
	@Test
	public void verifyPlayersWhenPlayerOneIsnull() {
		assertFalse(jokenpoValidator.verifyPlayers(null, playerTwo.build()));
	}
	
	@Test
	public void verifyPlayersWhenPlayerTwoIsnull() {
		assertFalse(jokenpoValidator.verifyPlayers(playerOne.build(), null));
	}
	
	@Test
	public void verifyPlayersWhenBothPlayersIsnull() {
		assertFalse(jokenpoValidator.verifyPlayers(null, null));
	}
	
	
	@Test
	public void verifyPlayersWhenBothPlayersNotIsnull() {
		assertTrue(jokenpoValidator.verifyPlayers(playerOne.build(), playerTwo.build()));
	}
	

}
