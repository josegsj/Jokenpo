package com.example.enumerator;

public enum JokenpoEnum {
	
	PAPPER(0),ROCK(1),SCISSOR(2);

	private int id;
	
	JokenpoEnum(int id){
		this.id=id;
	}
	
	public static JokenpoEnum getJokenpoById(int id) {
		if(PAPPER.id==id) {
			return JokenpoEnum.PAPPER;
		}else if(ROCK.id==id) {
			return JokenpoEnum.ROCK;
		}else {
			return JokenpoEnum.SCISSOR;
		}
		
	}
	
	

}
