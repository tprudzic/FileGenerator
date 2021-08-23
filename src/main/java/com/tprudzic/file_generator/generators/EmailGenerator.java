package com.tprudzic.file_generator.generators;

import org.apache.commons.lang3.NotImplementedException;
import org.apache.commons.lang3.RandomStringUtils;

import com.tprudzic.file_generator.enums.EmailCases;

public class EmailGenerator {
	private static int minLoginLength = 1;
	private static int maxLoginLength = 20;
	
	
	public static String generateEmail(EmailCases emailCase, boolean encircledWhiteSpaces) {
		StringBuilder returnValue = new StringBuilder();
		
		if(emailCase == EmailCases.EMPTY) {
			return "";
		}else if(emailCase == EmailCases.WHITE_SPACE) {
			return "\t ";
		}else if(emailCase == EmailCases.VALID) {
			returnValue.append(RandomStringUtils.randomAlphabetic(minLoginLength, maxLoginLength));
			returnValue.append("@");
			returnValue.append(RandomStringUtils.randomAlphabetic(2, 20).toLowerCase());
			returnValue.append(".");
			returnValue.append(RandomStringUtils.randomAlphabetic(2, 5).toLowerCase());
		}else if(emailCase == EmailCases.INVALID) {
			returnValue.append(RandomStringUtils.randomAlphabetic(11));
		}else {
			throw new NotImplementedException("Not implemented Case!!!");
		}

		if(encircledWhiteSpaces) {
			returnValue.insert(0, "  ");
			returnValue.append("\t");
		}
		
		return returnValue.toString();
	}
}
