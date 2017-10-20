package com.walkerdigital.toolkit.money;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CSVReader {

	/**
	 * 
	 * @return
	 * @throws FileNotFoundException 
	 * @throws IOException 
	 */
	public HashMap<String, Currency> readFile(String path) throws FileNotFoundException,IOException, IllegalArgumentException  {
		System.out.println("CSVReader : readFile()");
		System.out.println("\t path : " + path);
		
		String csvFile = path;
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";

		HashMap<String,Currency> currencyMap = new HashMap<String,Currency>();

		try {

			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
				// use comma as separator
				String[] currency = line.split(cvsSplitBy);

				Currency newCurrency = new  Currency(java.util.Currency.getInstance(currency[0]), currency[1],Integer.parseInt(currency[2].trim()),currency[3], currency[4]);
				currencyMap.put(currency[0], newCurrency);
			}

		} catch (FileNotFoundException fnfe) {
			System.out.println("File not found. Either path is incorrect or File is missing.");
			throw fnfe;
		} catch (IOException ioe) {
			System.out.println("Exception occured while reading the file.");
			throw ioe;
		}catch (IllegalArgumentException iae) {
			System.out.println("Exception occured while reading the file. Do ensure there are no empty new lines in file.");
			throw iae;
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return currencyMap;
		
	}

}