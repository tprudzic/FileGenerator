package com.tprudzic.file_generator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.tprudzic.file_generator.enums.EmailCases;
import com.tprudzic.file_generator.enums.NameCases;
import com.tprudzic.file_generator.enums.PeselCases;
import com.tprudzic.file_generator.enums.PhoneNumberCases;
import com.tprudzic.file_generator.generators.EmailGenerator;
import com.tprudzic.file_generator.generators.NameGenerator;
import com.tprudzic.file_generator.generators.PeselGenerator;
import com.tprudzic.file_generator.generators.PhoneNumberGenerator;


public class AppFileGenerator{
	private static int maxRowsNumber = 10;
	
	
	private static String fileName = System.currentTimeMillis() + "_output.txt";
	private static List<List<String>> csvRows = new ArrayList<List<String>>();
	private static List<String> columnNames = new ArrayList<String>();
	private static String columnSeparator = ";";
    private static List<NameCases> allNameCases = new ArrayList<NameCases>();
    private static List<PeselCases> allPeselCases = new ArrayList<PeselCases>();
    private static List<PhoneNumberCases> allPhoneNumberCases = new ArrayList<PhoneNumberCases>();
    private static List<EmailCases> allEmailCases = new ArrayList<EmailCases>();
	
    
    
	public static void main( String[] args ){
		
		
		columnNames.add("Name");
		columnNames.add("Pesel");
		columnNames.add("Email");
		columnNames.add("Phone Number");
		csvRows.add(columnNames);
		
		for(NameCases nc: NameCases.values()) {
			allNameCases.add(nc);
		}
		for(PeselCases pc: PeselCases.values()) {
			allPeselCases.add(pc);
		}
		for(PhoneNumberCases pnc: PhoneNumberCases.values()) {
			allPhoneNumberCases.add(pnc);
		}
		for(EmailCases ec: EmailCases.values()) {
			allEmailCases.add(ec);
		}
		
		int maxCasesNumber = allNameCases.size();
		if(allPeselCases.size() > maxCasesNumber) {
			maxCasesNumber = allPeselCases.size();
		}
		if(allPhoneNumberCases.size() > maxCasesNumber) {
			maxCasesNumber = allPhoneNumberCases.size();
		}
		if(allEmailCases.size() > maxCasesNumber) {
			maxCasesNumber = allEmailCases.size();
		}
		List<String> row = new ArrayList<String>();
		for(int i = 0 ; i < maxCasesNumber ; ++i) {
			String name = NameGenerator.generateName(NameCases.values()[i%NameCases.values().length], true);
			String pesel = PeselGenerator.generatePesel(PeselCases.values()[i%PeselCases.values().length], true);
			String phoneNumber = PhoneNumberGenerator.generatePhoneNumber(PhoneNumberCases.values()[i%PhoneNumberCases.values().length], true);
			String email = EmailGenerator.generateEmail(EmailCases.values()[i%EmailCases.values().length], true);
			row = new ArrayList<String>();
			row.add(name);
			row.add(pesel);
			row.add(email);
			row.add(phoneNumber);
			csvRows.add(row);
		}

		
		for(int i = csvRows.size() - 1 ; i < maxRowsNumber ; ++i) {
			row = new ArrayList<String>();
			row.add(NameGenerator.generateName(NameCases.VALID, false));
			row.add(PeselGenerator.generatePesel(PeselCases.VALID, false));
			row.add(EmailGenerator.generateEmail(EmailCases.VALID, false));
			row.add(PhoneNumberGenerator.generatePhoneNumber(PhoneNumberCases.VALID, false));
			csvRows.add(row);
		}
		
		FileWriter outputWriter = null;
		PrintWriter printerStrem = null;
		try {
			outputWriter = new FileWriter(fileName, true);
			printerStrem = new PrintWriter(outputWriter);
		for(List<String> r: csvRows) {
			StringBuilder stringRow = new StringBuilder();
			for(String entry : r) {
				stringRow.append(entry).append(columnSeparator);
			}
			String line = stringRow.substring(0, stringRow.length()-columnSeparator.length());
			printerStrem.println(line);
		}
		
		printerStrem.close();
		outputWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Output has been written to file:\n" + (new File(fileName)).getAbsolutePath());
        
    }

}




