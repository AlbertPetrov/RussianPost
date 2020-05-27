package com.albertpetrovindustries;

/**
 * @author Christinica
 * Subscription is a pojo object
 */
public class Subscription {

	/**
	 *  surnameAndAbbreviated contains surname and abbreviated of reader
	 */
	private String surnameAndAbbreviated;
	/**
	 *  numberOfThePublication contains a number of the publication
	 */
	private int numberOfThePublication;
	/**
	 *  publicationName contains a publication name
	 */
	private String publicationName;
	/**
	 *  subscriptionCost contains a subscription cost 
	 */
	private int subscriptionCost;
	
	/**
	 * Subscription 
	 * @param surnameAndAbbreviated
	 * @param numberOfThePublication
	 * @param publicationName
	 * @param subscriptionCost
	 */
	public Subscription(String surnameAndAbbreviated, int numberOfThePublication,
						String publicationName, int subscriptionCost) 
	{
		this.surnameAndAbbreviated = surnameAndAbbreviated;
		this.numberOfThePublication = numberOfThePublication;
		this.publicationName = publicationName;
		this.subscriptionCost = subscriptionCost;
	}
	
	/**
	 * @return numberOfThePublication
	 */
	public int getNumberOfThePublication() {
		return numberOfThePublication;
	}
	
	/**
	 * @param numberOfThePublication
	 */
	public void setNumberOfThePublication(int numberOfThePublication) {
		this.numberOfThePublication = numberOfThePublication;
	}
	
	/**
	 * @return publicationName
	 */
	public String getPublicationName() {
		return publicationName;
	}
	
	/**
	 * @param publicationName
	 */
	public void setPublicationName(String publicationName) {
		this.publicationName = publicationName;
	}
	
	/**
	 * @return subscriptionCost
	 */
	public int getSubscriptionCost() {
		return subscriptionCost;
	}
	
	/**
	 * @param subscriptionCost
	 */
	public void setSubscriptionCost(int subscriptionCost) {
		this.subscriptionCost = subscriptionCost;
	}
	
	/**
	 * @return surnameAndAbbreviated
	 */
	public String getSurnameAndAbbreviated() {
		return surnameAndAbbreviated;
	}
	
	/**
	 * @param surnameAndAbbreviated
	 */
	public void setSurnameAndAbbreviated(String surnameAndAbbreviated) {
		this.surnameAndAbbreviated = surnameAndAbbreviated;
	}
	
}