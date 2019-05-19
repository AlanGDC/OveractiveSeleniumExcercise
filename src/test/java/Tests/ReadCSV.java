package Tests;


import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import TestData.ParkingTestData;




public class ReadCSV {


	    public static ParkingTestData read() throws IOException {
	    	
	    	String 	dateEntry = null;
	        String 	timeEntry= null;
	        String 	dateLeave= null;
	        String 	timeLeave= null;
	        String 	costExpected= null;
	        String 	daysExpected= null;
	        String 	lotDrop= null;
	    	
	    	 
	    	
	    	Reader in = new FileReader("././././dataProvider.csv");
	    	
	    	Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(in);
	    	
	    	for (CSVRecord record : records) {
	    		dateEntry = record.get("Entry Date");
	    		timeEntry = record.get("Entry Time");
	    		dateLeave = record.get("Leave Date"); 
	    		timeLeave = record.get("Leave Time");
	    		costExpected = record.get("Cost Expected");	
	    		daysExpected = record.get("Days Expected");
	    		lotDrop = record.get("Lot Type");
	    		
	    	}
	  
	    	return new ParkingTestData
			(lotDrop, timeEntry, 
			dateEntry, timeLeave, 
			dateLeave, costExpected,
			daysExpected);
	    }

}
