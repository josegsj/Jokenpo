package com.example.service;

import org.springframework.stereotype.Service;

import com.example.domain.PlayResult;
import com.example.domain.Player;
import com.example.enumerator.PlayStatusEnum;
import com.example.factory.JokenpoFactory;

@Service
public class JudgeJokenpoService {
	
	private JokenpoFactory jokenpoFactory;

	public JudgeJokenpoService() {
		this.jokenpoFactory=new JokenpoFactory();
	}

	
	public String verifyWinner(Player playerOne,Player playerTwo) {
		PlayResult playResult=jokenpoFactory.verifyWinner(playerOne, playerTwo);
		return makeResult(playResult);
	}
	
	private String makeResult(PlayResult playResult) {
		String result=null;
		if(playResult.getStatusPlay().equals(PlayStatusEnum.DRAW)) {
			result="Empate";
		}else {
			result="o vencedor foi "+playResult.getPlayerWin().getName();
		}
		return result;
	}
	
}
