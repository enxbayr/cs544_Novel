package edu.mum.utils;

import java.time.Instant;

public class NumberGenerator {
	public static String getTimeStamp() {
		Instant instant = Instant.now();
		long timeStampMillis = instant.toEpochMilli();
		return "OR" + timeStampMillis;
	}
}