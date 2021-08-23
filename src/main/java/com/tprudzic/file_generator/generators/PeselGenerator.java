package com.tprudzic.file_generator.generators;

import org.apache.commons.lang3.NotImplementedException;
import org.apache.commons.lang3.RandomStringUtils;
/*
VALID, 
INVALID_CHARS, 


*/

import com.tprudzic.file_generator.enums.PeselCases;

public class PeselGenerator {
	public static String generatePesel(PeselCases peselCase, boolean encircledWhiteSpaces) {
		StringBuilder returnValue = new StringBuilder();
		
		if(peselCase == PeselCases.EMPTY) {
			return "";
		}else if(peselCase == PeselCases.WHITE_SPACE) {
			return "\t ";
		}else if(peselCase == PeselCases.VALID) {
			returnValue.append(RandomStringUtils.randomNumeric(11));//some more sophisticated generator could be implemented ;-)
		}else if(peselCase == PeselCases.TOO_LONG) {
			returnValue.append(RandomStringUtils.randomNumeric(12, 15));
		}else if(peselCase == PeselCases.TOO_SHORT) {
			returnValue.append(RandomStringUtils.randomNumeric(2, 10));
		}else if(peselCase == PeselCases.VERY_LONG) {
			returnValue.append(RandomStringUtils.randomNumeric(100));
		}else if(peselCase == PeselCases.INVALID_ALPHABETIC_CHARS) {
			returnValue.append(RandomStringUtils.randomAlphabetic(11));
		}else if(peselCase == PeselCases.INVALID_CHARS) {
			returnValue.append(RandomStringUtils.randomGraph(11));
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
