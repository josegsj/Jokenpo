package com.example.factory;

import org.springframework.stereotype.Component;

import com.example.domain.PlayResult;
import com.example.domain.Player;
import com.example.enumerator.JokenpoEnum;
import com.example.enumerator.PlayStatusEnum;

@Component
public class JokenpoFactory {
	
	public PlayResult  verifyWinner(Player playerOne,Player playerTwo){
		
	  if(playerOne.getChooseJokenpo().equals(JokenpoEnum.PAPPER) && playerTwo.getChooseJokenpo().equals(JokenpoEnum.ROCK)){       
		  return getPlayResult(playerOne,PlayStatusEnum.WIN);
      }else if(playerOne.getChooseJokenpo().equals(JokenpoEnum.ROCK) && playerTwo.getChooseJokenpo().equals(JokenpoEnum.PAPPER)){
          return getPlayResult(playerTwo,PlayStatusEnum.WIN);
      }else if(playerOne.getChooseJokenpo().equals(JokenpoEnum.ROCK) && playerTwo.getChooseJokenpo().equals(JokenpoEnum.SCISSOR)){
    	  return getPlayResult(playerOne,PlayStatusEnum.WIN);
      }else if(playerOne.getChooseJokenpo().equals(JokenpoEnum.SCISSOR) && playerTwo.getChooseJokenpo().equals(JokenpoEnum.ROCK)){  
    	  return getPlayResult(playerTwo,PlayStatusEnum.WIN);
      }else if(playerOne.getChooseJokenpo().equals(JokenpoEnum.SCISSOR) && playerTwo.getChooseJokenpo().equals(JokenpoEnum.PAPPER)){
    	  return getPlayResult(playerOne,PlayStatusEnum.WIN);
      }else if(playerOne.getChooseJokenpo().equals(JokenpoEnum.PAPPER) && playerTwo.getChooseJokenpo().equals(JokenpoEnum.SCISSOR)){
    	  return getPlayResult(playerTwo,PlayStatusEnum.WIN);
      }else{     
   	   return getPlayResult(null,PlayStatusEnum.DRAW);
      }
	  
	}
	
	
	private PlayResult  getPlayResult(Player player,PlayStatusEnum playstatus) {
		 PlayResult playResult= new PlayResult();
		 playResult.setPlayerWin(player);
		 playResult.setStatusPlay(playstatus);
		return playResult;
	}

}
