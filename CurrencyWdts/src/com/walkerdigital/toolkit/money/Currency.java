package com.walkerdigital.toolkit.money;

import java.util.Locale;

public class Currency {

	private java.util.Currency javaCurrency;
	private String numericCode;
	private String currencySymbolOverride; // use to override the currency code in java.util.Currency
	private String description;
	private int hashCode;
	private int scale; // the number of sub-units of the currency (e.g. US dollars have 100 sub-units, or pennies)

	/** default constructor was added to work with jaxb generation / conversion */
	public Currency() {
		javaCurrency = null;
		numericCode = null;
		currencySymbolOverride = null;
		description = null;
		hashCode = 0;
		scale = 0;
	}

	/**
	 * Constructor to use the currency code from java.util.Currency
	 * @param pCurrency
	 * @param pNumericCode
	 * @param pScale
	 * @param pDescription
	 */
	public Currency(java.util.Currency pCurrency, String pNumericCode, int pScale, String pDescription)
	{
		this(pCurrency, pNumericCode, pScale, pDescription, null);
	}

	/**
	 * Constructor to override the currency code in java.util.Currency
	 * @param pCurrency
	 * @param pNumericCode
	 * @param pScale
	 * @param pDescription
	 * @param pCurrencySymbolOverride
	 */
	public Currency(java.util.Currency pCurrency, String pNumericCode, int pScale, String pDescription, String pCurrencySymbolOverride)
	{
		javaCurrency = pCurrency;
		numericCode = pNumericCode;
		description = pDescription;
		hashCode = Integer.parseInt(numericCode);
		scale = pScale;
		currencySymbolOverride = pCurrencySymbolOverride;
	}

	public boolean equals(Object o)
	{
		if (this == o)
		{
			return true;
		}
		if (o == null || getClass() != o.getClass())
		{
			return false;
		}

		final Currency currencyModel = (Currency) o;

		if(numericCode.equals(currencyModel.numericCode) && currencySymbolOverride.equals(currencyModel.currencySymbolOverride)
				){
			return true;
		}else{
			return false;
		}

		//		return numericCode.equals(currency.numericCode);
	}

	public int hashCode()
	{
		return hashCode;
	}

	public java.util.Currency getJavaCurrency() {
		return javaCurrency;
	}

	public void setJavaCurrency(java.util.Currency javaCurrency) {
		this.javaCurrency = javaCurrency;
	}

	/**
	 * Gets the three-digit numeric code for this currency.
	 *
	 * @return the three-digit numeric code for this currency.
	 */
	public String getNumericCode() {
		return numericCode;
	}

	public void setNumericCode(String numericCode) {
		this.numericCode = numericCode;
	}

	public String getCurrencySymbolOverride() {
		return currencySymbolOverride;
	}

	public void setCurrencySymbolOverride(String currencySymbolOverride) {
		this.currencySymbolOverride = currencySymbolOverride;
	}

	/**
	 * Gets the description for this currency (i.e. "US dollar")
	 *
	 * @return the description for this currency.
	 */
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getHashCode() {
		return hashCode;
	}

	public void setHashCode(int hashCode) {
		this.hashCode = hashCode;
	}

	/**
	 * @return the number of sub-units of the base currency
	 */
	public int getScale() {
		return scale;
	}

	public void setScale(int scale) {
		this.scale = scale;
	}


	/**
	 * Gets the ISO 4217 currency code of this currency.
	 *
	 * @return the ISO 4217 currency code of this currency.
	 */
	public String getCurrencyCode()
	{
		return javaCurrency.getCurrencyCode();
	}


	/**
	 * Gets the symbol of this currency for the default locale.
	 * For example, for the US Dollar, the symbol is "$" if the default
	 * locale is the US, while for other locales it may be "US$". If no
	 * symbol can be determined, the ISO 4217 currency code is returned.
	 *
	 * @return the symbol of this currency for the default locale
	 */
	public String getSymbol()
	{
		return currencySymbolOverride == null ? javaCurrency.getSymbol() : currencySymbolOverride;
	}

	/**
	 * @return has the default currency symbol been overridden
	 */
	public boolean hasSymbolOverride()
	{
		return currencySymbolOverride != null;
	}

	/**
	 * Gets the symbol of this currency for the specified locale.
	 * For example, for the US Dollar, the symbol is "$" if the specified
	 * locale is the US, while for other locales it may be "US$". If no
	 * symbol can be determined, the ISO 4217 currency code is returned.
	 *
	 * @param locale the locale for which a display name for this currency is
	 *               needed
	 * @return the symbol of this currency for the specified locale
	 * @throws NullPointerException if <code>locale</code> is null
	 */
	public String getSymbol(Locale locale)
	{
		return javaCurrency.getSymbol(locale);
	}


	/**
	 * Gets the default number of fraction digits used with this currency.
	 * For example, the default number of fraction digits for the Euro is 2,
	 * while for the Japanese Yen it's 0.
	 * In the case of pseudo-currencies, such as IMF Special Drawing Rights,
	 * -1 is returned.
	 *
	 * @return the default number of fraction digits used with this currency
	 */
	public int getDefaultFractionDigits()
	{
		return javaCurrency.getDefaultFractionDigits();
	}

	/**
	 * Returns the ISO 4217 currency code of this currency.
	 *
	 * @return the ISO 4217 currency code of this currency
	 */
	public String toString()
	{
		return javaCurrency.toString();
	}


}
