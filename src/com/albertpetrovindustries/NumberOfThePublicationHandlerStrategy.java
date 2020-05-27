package com.albertpetrovindustries;

import java.util.Scanner;

/**
 *  @author Christinica
 *  class NumberOfThePublicationHandlerStrategy is an interface like of Strategy design pattern of handling of a number 
 *    of the publication
 *  @extends {@link NewSubscriptionInfoHandler} 
 */
public abstract class NumberOfThePublicationHandlerStrategy extends NewSubscriptionInfoHandler {

	/**
	 * numberOfThePublicationHandlerContext invokes method {@link handle} from implementations
	 *   of this class
	 */
	public NumberOfThePublicationHandlerStrategy numberOfThePublicationHandlerStrategy;
	
	/**
	 * NumberOfThePublicationHandlerContext takes parameter of implementations of this class
	 *   and parameter of realization of superclass 
	 * @param numberOfThePublicationHandlerContext
	 * @param newSubscriptionInfoHandler
	 */
	public NumberOfThePublicationHandlerStrategy(NumberOfThePublicationHandlerStrategy numberOfThePublicationHandlerStrategy,
												NewSubscriptionInfoHandler newSubscriptionInfoHandler) {
	    super(newSubscriptionInfoHandler);
		this.numberOfThePublicationHandlerStrategy = numberOfThePublicationHandlerStrategy;
	}
	
	/**
	 *  handle - process new string and gets an old string
	 *  @param scanner scans lines for our input
	 *  @param line is just a line of an old handling if context is match
	 *  @return a string after processing
	 */
	public abstract String handle(Scanner scanner, String line);
	
}
