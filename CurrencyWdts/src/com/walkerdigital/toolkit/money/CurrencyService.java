package com.walkerdigital.toolkit.money;

import java.io.Serializable;

public class CurrencyService implements Serializable
{
	private static final long serialVersionUID = 8228779577409316939L;

	// supported currency codes
	private static final String CURRENCY_CODE_USD = "USD";
	private static final String CURRENCY_CODE_HKD = "HKD";
	private static final String CURRENCY_CODE_MYR = "MYR";
	private static final String CURRENCY_SYMBOL_USD = "$";
	private static final String CURRENCY_SYMBOL_HKD = "HK$";
	private static final String CURRENCY_SYMBOL_RM = "RM";

	// supported currencies
	public final static Currency US_DOLLAR = new Currency(java.util.Currency.getInstance(CURRENCY_CODE_USD), "840", 100,"US dollar", CURRENCY_SYMBOL_USD);
	public final static Currency HK_DOLLAR = new Currency(java.util.Currency.getInstance(CURRENCY_CODE_HKD), "344", 100,"Hong Kong dollar", CURRENCY_SYMBOL_HKD);
	public final static Currency MALAYSIAN_RINGGIT = new Currency(java.util.Currency.getInstance(CURRENCY_CODE_MYR), "458", 100, "Malaysian ringgit", CURRENCY_SYMBOL_RM);


	/**
	 * Get a {@link CurrencyService} by its ISO 4217 code
	 * @param pCurrencyCode
	 * @return the currency for the given code, or null if the code is not supported
	 */
	public static Currency getByCurrencyCode(String pCurrencyCode)
	{
		if (CURRENCY_CODE_USD.equalsIgnoreCase(pCurrencyCode))
		{
			return US_DOLLAR;
		}

		if (CURRENCY_CODE_HKD.equalsIgnoreCase(pCurrencyCode))
		{
			return HK_DOLLAR;
		}

		if (CURRENCY_CODE_MYR.equalsIgnoreCase(pCurrencyCode))
		{
			return MALAYSIAN_RINGGIT;
		}

		return null;
	}

	/**
	 * This method get Currency by currency symbol 
	 * @param pCurrencyAbbreviationOrSymbol
	 * @return the currency for the given code, or null if the code is not supported
	 */
	public static Currency getByCurrencyAbbreviationOrSymbol(String pCurrencyAbbreviationOrSymbol)
	{
		if (CURRENCY_SYMBOL_USD.equalsIgnoreCase(pCurrencyAbbreviationOrSymbol))
		{
			return US_DOLLAR;
		}

		if (CURRENCY_SYMBOL_HKD.equalsIgnoreCase(pCurrencyAbbreviationOrSymbol))
		{
			return HK_DOLLAR;
		}

		if (CURRENCY_SYMBOL_RM.equalsIgnoreCase(pCurrencyAbbreviationOrSymbol))
		{
			return MALAYSIAN_RINGGIT;
		}

		return null;
	}

	/**
	 * Is the given currency code supported in the system?
	 * @param pCurrencyCode
	 * @return
	 */
	public static boolean isSupportedCurrencyCode(String pCurrencyCode)
	{
		return getByCurrencyCode(pCurrencyCode) != null;
	}


	/** Creates a new instance, will only be used by Jaxb. */
	public static CurrencyService newInstance() {
		return new CurrencyService();
	}

}
