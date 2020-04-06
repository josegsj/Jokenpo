package com.example.jokenpo;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.domain.Player;
import com.example.enumerator.JokenpoEnum;
import com.example.service.JudgeJokenpoService;
import com.examplo.validator.JokenpoValidator;

@SpringBootApplication
public class JokenpoApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(JokenpoApplication.class, args);
		JudgeJokenpoService judgeJokenpoService=new JudgeJokenpoService();
		JokenpoValidator jokenpoValidator=new JokenpoValidator();
		Scanner read = new Scanner(System.in); 
		int valueToExit=0;
		String value=null;
		String result="";
		writeMessage();
		Player playerOne=null;
		Player playerTwo=null;
		while (valueToExit==0) {
			
			while(playerOne==null){
				System.out.println("Digite o id para a escolha do Jokenpo do Player1 ?");
				value=read.nextLine();
				 playerOne=choicePlayer("Player1",value);
			}
			while(playerTwo==null){
				System.out.println("Digite o id para a escolha do Jokenpo do Player2 ?");
				value=read.nextLine();
				playerTwo=choicePlayer("Player2",value);
			}
			if(jokenpoValidator.verifyPlayers(playerOne, playerTwo)) {
				result=judgeJokenpoService.verifyWinner(playerOne, playerTwo);
			}
			System.out.println(result);
			System.out.println("Fim da Partida!!");
			valueToExit=1;
		}
		read.close();
	}
	
	public static Player choicePlayer(String namePlayer,String value){
		JokenpoValidator jokenpoValidator=new JokenpoValidator();
		Player player=null;
		int id=0;
		if(jokenpoValidator.verifyTypeString(value)) {
			id=Integer.parseInt(value);
			if(jokenpoValidator.verifyTypeIdJokenpo(id)) {
				 player=makePLayer(namePlayer,id); 
			}else {
				System.out.println("codigo nâo foi valido");
			}
		}else {
			System.out.println("Voce não digitou um numero");
		}
		return player;
	}
	
	private  static  Player makePLayer(String name,int id) {
		Player player=new Player(); 
		player.setName(name);
		player.setChooseJokenpo(JokenpoEnum.getJokenpoById(id));
		return player;
	}
	
	private static void writeMessage() {
		System.out.println("Jokenpo Game ");
		System.out.println("ID referente as escolhas dos jogadores ");
		System.out.println("0-Papel ");
		System.out.println("1-Pedra ");
		System.out.println("2-Tesoura");
	}
	
}
