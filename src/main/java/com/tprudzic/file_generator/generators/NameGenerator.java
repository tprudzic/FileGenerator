package com.tprudzic.file_generator.generators;

import java.util.Random;

import org.apache.commons.lang3.NotImplementedException;
import org.apache.commons.lang3.RandomStringUtils;

import com.tprudzic.file_generator.enums.NameCases;

public class NameGenerator {
	private static int minLength = 1;
	private static int maxLength = 20;

	public static String generateName(NameCases nameCase, boolean encircledWhiteSpaces) {
		StringBuilder returnValue = new StringBuilder();

		if (nameCase == NameCases.EMPTY) {
			return "";
		} else if (nameCase == NameCases.WHITE_SPACE) {
			return " \t";
		} else if (nameCase == NameCases.VALID) {
			returnValue.append(RandomStringUtils.randomAlphabetic(minLength, maxLength + 1));
		} else if (nameCase == NameCases.INVALID) {
			returnValue.append(RandomStringUtils.randomGraph(minLength, maxLength + 1));
		} else if (nameCase == NameCases.VALID_ADDITIONAL) {
			Random r = new Random();
			int length = r.nextInt(maxLength + 1) + minLength;
			returnValue.append(RandomStringUtils.random(length));
		} else if (nameCase == NameCases.VERY_LONG) {
			returnValue.append(RandomStringUtils.randomAlphabetic(100));
			returnValue.append(RandomStringUtils.random(100));
		} else {
			throw new NotImplementedException("Not implemented Case!!!");
		}

		if (encircledWhiteSpaces) {
			returnValue.insert(0, "\t");
			returnValue.append("  ");
		}

		return returnValue.toString();
	}
}
