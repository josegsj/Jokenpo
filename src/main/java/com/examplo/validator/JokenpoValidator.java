package com.examplo.validator;

import java.util.Objects;

import org.springframework.stereotype.Component;

import com.example.domain.Player;

@Component
public class JokenpoValidator {
	
	public boolean verifyTypeIdJokenpo(int id) {
		if(id==0 || id==1 || id==2 ) {
			return true;
		}
		return false;
	}
	
	public boolean verifyTypeString(String value) {
		if(value.matches("[0-9]*")) {
			return true;
		}
		return false;
	}
	
	public boolean verifyPlayers(Player playerOne,Player PlayerTwo) {
		if(Objects.nonNull(playerOne) && Objects.nonNull(PlayerTwo)) {
			return true;
		}
		return false;
	}
	

}
