package com.walkerdigital.main;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.walkerdigital.toolkit.money.CurrencyService;
import com.walkerdigital.toolkit.money.Currency;
import com.walkerdigital.toolkit.money.CSVReader;
import java.util.Scanner; 

/******************************
 * INSTRUCTIONS
 *
 * Steps:
 * 1. Add Unit tests for all public methods.
 * 2. All methods must have Javadoc comments.
 * 3. Fix the bug. Run the main method and you will see HKD and MYR are the same. This is not correct.
 * 4. New functionality: create and implement a public interface for adding new currencies at runtime
 * 5. Refactor the Currency class and explain why your refactors are improvements.
 * 
 * When the updates have been completed, zip up the project and email it back.
 * Use of 3rd-party software (e.g. frameworks like Maven) is encouraged where applicable, however please point out all instances where the code you used was not your own.
 * Provide information on how long you worked on it and explain your changes.
 ******************************/
public class Main {

	private static Currency currencyUSD = CurrencyService.getByCurrencyCode("USD");
	private static Currency currencyHKD = CurrencyService.getByCurrencyCode("HKD");
	private static Currency currencyMYR = CurrencyService.getByCurrencyCode("MYR");
	
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		
		checkCurrencies();
		
		System.out.println("Do you want to add new Currencies?(Y/N)");  
		String choice=sc.next();  
		if(choice.equalsIgnoreCase("Y")){
			System.out.println("Please provide the path to the currency csv file");
			String path = sc.next();
			try {
				addNewCurrency(path);
			} catch (IllegalArgumentException | IOException e) {
				System.out.println("Exception occured while reading the csv file");
			}	
		}else{
			 sc.close();  
		}

		
	}


/**
 * This method adds new currencies and checks it against HKD currency
 * 
 * @author rahil khan
 * @return HashMap<String,Currency>
 * @throws IOException 
 * @throws IllegalArgumentException 
 * @throws FileNotFoundException 
 */
public static HashMap<String,Currency> addNewCurrency(String path) throws FileNotFoundException, IllegalArgumentException, IOException{

	System.out.println("\t path : " + path);
	CSVReader csvReader = new CSVReader();
	HashMap<String,Currency> currencyMap = csvReader.readFile(path);

	for(Map.Entry<String,Currency> entry  : currencyMap.entrySet()){
//		System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
		
		boolean currenciesAreSame = entry.getValue().equals(currencyHKD);
		if (currenciesAreSame) {
			System.out.println(entry.getValue() + " and HKD currencies are the same.");
		}
		else {
			System.out.println(entry.getValue() + " and HKD currencies are different.");
		}
		
	}
	
	return currencyMap;
	
	
}

/**
 * This method check the uniqueness of currencies
 */
public static void checkCurrencies(){

//	Currency currencyUSD = CurrencyService.getByCurrencyCode("USD");
//	Currency currencyHKD = CurrencyService.getByCurrencyCode("HKD");
//	Currency currencyMYR = CurrencyService.getByCurrencyCode("MYR");

	boolean currenciesAreSame = currencyUSD.equals(currencyHKD);
	if (currenciesAreSame) {
		System.out.println("USD and HKD currencies are the same.");
	}
	else {
		System.out.println("USD and HKD currencies are different.");
	}

	currenciesAreSame = currencyUSD.equals(currencyMYR);
	if (currenciesAreSame) {
		System.out.println("USD and MYR currencies are the same.");
	}
	else {
		System.out.println("USD and MYR currencies are different.");
	}

	currenciesAreSame = currencyHKD.equals(currencyMYR);
	if (currenciesAreSame) {
		System.out.println("HKD and MYR currencies are the same.");
	}
	else {
		System.out.println("HKD and MYR currencies are different.");
	}

}

}
