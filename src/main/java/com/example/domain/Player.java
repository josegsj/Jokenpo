package com.example.domain;

import com.example.enumerator.JokenpoEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Player {
	
	private String name;
	private JokenpoEnum chooseJokenpo;
}
