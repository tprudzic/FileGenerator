package com.tprudzic.file_generator.generators;

import org.apache.commons.lang3.NotImplementedException;
import org.apache.commons.lang3.RandomStringUtils;

import com.tprudzic.file_generator.enums.PhoneNumberCases;

public class PhoneNumberGenerator {
	private static int minLength = 5;
	private static int maxLength = 15;

	public static String generatePhoneNumber(PhoneNumberCases phoneNumberCases, boolean encircledWhiteSpaces) {
		StringBuilder returnValue = new StringBuilder();

		if (phoneNumberCases == PhoneNumberCases.EMPTY) {
			return "";
		} else if (phoneNumberCases == PhoneNumberCases.WHITE_SPACE) {
			return "\t ";
		} else if (phoneNumberCases == PhoneNumberCases.VALID) {
			returnValue.append(RandomStringUtils.randomNumeric(minLength, maxLength + 1));
		} else if (phoneNumberCases == PhoneNumberCases.TOO_SHORT) {
			returnValue.append(RandomStringUtils.randomNumeric(1, minLength));
		} else if (phoneNumberCases == PhoneNumberCases.VERY_LONG) {
			returnValue.append(RandomStringUtils.randomNumeric(100));
		} else if (phoneNumberCases == PhoneNumberCases.INVALID_ALPHABETIC_CHARS) {
			returnValue.append(RandomStringUtils.randomAlphabetic(11));
		} else {
			throw new NotImplementedException("Not implemented Case!!!");
		}

		if (encircledWhiteSpaces) {
			returnValue.insert(0, " ");
			returnValue.append("  ");
		}

		return returnValue.toString();
	}
}