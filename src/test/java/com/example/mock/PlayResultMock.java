package com.example.mock;

import com.example.domain.PlayResult;
import com.example.domain.PlayResult.PlayResultBuilder;

public class PlayResultMock {
	
	public static PlayResultBuilder getPlayResult() {
		return PlayResult.builder();
	}
}
