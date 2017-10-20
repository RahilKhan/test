package com.walkerdigital.toolkit.money.test;

import org.junit.Test;

import com.walkerdigital.toolkit.money.CSVReader;
import com.walkerdigital.toolkit.money.Currency;
import com.walkerdigital.toolkit.money.CurrencyService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

public class CurrencyTest {

	private static final String VALID_CURRENCY_CODE_USD = "USD";
	private static final String INVALID_CURRENCY_CODE_USD = "XYZ";

	private static final String VALID_CURRENCY_SYMBOL_USD = "$";
	private static final String INVALID_CURRENCY_SYMBOL_USD = "XYZ";
	
	private static final String VALID_CURRENCY_CSV_PATH = "src\\SampleCurrencyCsvFile.csv";
	private static final String INVALID_CURRENCY_CSV_PATH = "src\\fileMissing.csv";
	
	/**
	 * Testcase to check for negative scenario for getByCurrencyCode() method.
	 * 
	 * @author Rahil Khan
	 * @expected : pass
	 */
	@Test
	public void negativeCheckFor_getByCurrencyCode(){
		System.out.println("Testing negativeCheckFor_getByCurrencyCode for " + INVALID_CURRENCY_CODE_USD);
		assertEquals(null,CurrencyService.getByCurrencyCode(INVALID_CURRENCY_CODE_USD));
	}

	/**
	 * Testcase to check for positive scenario for getByCurrencyCode() method.
	 * 
	 * @author Rahil Khan
	 * @expected : pass
	 */
	@Test
	public void positiveCheckFor_getByCurrencyCode(){
		System.out.println("Testing positiveCheckFor_getByCurrencyCode for " + VALID_CURRENCY_CODE_USD);
		assertEquals(CurrencyService.US_DOLLAR,CurrencyService.getByCurrencyCode(VALID_CURRENCY_CODE_USD));
	}

	/**
	 * Testcase to check for negative scenario for getByCurrencyAbbreviationOrSymbol() method.
	 * 
	 * @author Rahil Khan
	 * @expected : pass
	 */
	@Test
	public void negativeCheckFor_getByCurrencyAbbreviationOrSymbol(){
		System.out.println("Testing negativeCheckFor_getByCurrencyAbbreviationOrSymbol for " + INVALID_CURRENCY_SYMBOL_USD);
		assertEquals(null,CurrencyService.getByCurrencyAbbreviationOrSymbol(INVALID_CURRENCY_SYMBOL_USD));
	}

	/**
	 * Testcase to check for positive scenario for getByCurrencyAbbreviationOrSymbol() method.
	 * 
	 * @author Rahil Khan
	 * @expected : pass
	 */
	@Test
	public void positiveCheckFor_getByCurrencyAbbreviationOrSymbol(){
		System.out.println("Testing positiveCheckFor_getByCurrencyAbbreviationOrSymbol for " + VALID_CURRENCY_SYMBOL_USD);
		assertEquals(CurrencyService.US_DOLLAR,CurrencyService.getByCurrencyAbbreviationOrSymbol(VALID_CURRENCY_SYMBOL_USD));
	}


	/**
	 * Testcase to check for negative scenario for isSupportedCurrencyCode() method.
	 * 
	 * @author Rahil Khan
	 * @expected : pass
	 */
	@Test
	public void negativeCheckFor_isSupportedCurrencyCode(){
		System.out.println("Testing negativeCheckFor_isSupportedCurrencyCode for " + INVALID_CURRENCY_CODE_USD);
		assertEquals(false,CurrencyService.isSupportedCurrencyCode(INVALID_CURRENCY_CODE_USD));
	}

	/**
	 * Testcase to check for positive scenario for isSupportedCurrencyCode() method.
	 * 
	 * @author Rahil Khan
	 * @expected : pass
	 */
	@Test
	public void positiveCheckFor_isSupportedCurrencyCode(){
		System.out.println("Testing positiveCheckFor_isSupportedCurrencyCode for " + VALID_CURRENCY_CODE_USD);
		assertEquals(true,CurrencyService.isSupportedCurrencyCode(VALID_CURRENCY_CODE_USD));
	}

	
	/**
	 * Testcase to check for negative scenario for addNewCurrency() method.
	 * 
	 * @author Rahil Khan
	 * @throws IOException 
	 * @throws IllegalArgumentException 
	 * @throws FileNotFoundException 
	 * @expected : pass
	 */
	@Test(expected = FileNotFoundException.class)
	public void negativeCheckFor_addNewCurrency() throws FileNotFoundException, IllegalArgumentException, IOException{
		System.out.println("Testing negativeCheckFor_addNewCurrency() method ");
		
		 String basePath = new File("").getAbsolutePath();
		 String path = new File(INVALID_CURRENCY_CSV_PATH).getAbsolutePath();
		 
		CSVReader csvReader = new CSVReader();
		assertEquals(false,csvReader.readFile(INVALID_CURRENCY_CSV_PATH));
		
	}

	/**
	 * Testcase to check for positive scenario for addNewCurrency() method.
	 * 
	 * @author Rahil Khan
	 * @throws IOException 
	 * @throws IllegalArgumentException 
	 * @expected : pass
	 */
	@Test
	public void positiveCheckFor_addNewCurrency()  {
		System.out.println("Testing positiveCheckFor_addNewCurrency() method ");
		
		 String basePath = new File("").getAbsolutePath();
		 String path = new File(VALID_CURRENCY_CSV_PATH).getAbsolutePath();
		
		CSVReader csvReader = new CSVReader();
		try {
			boolean currencyMap= csvReader.readFile(VALID_CURRENCY_CSV_PATH).isEmpty();
			assertEquals(false,currencyMap);
		} catch (IllegalArgumentException | IOException e) {
			e.printStackTrace();
		}
		
		
	}	
	
}
