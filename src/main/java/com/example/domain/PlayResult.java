package com.example.domain;

import com.example.enumerator.PlayStatusEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlayResult {
	
	private Player playerWin;
	private PlayStatusEnum statusPlay;

}
