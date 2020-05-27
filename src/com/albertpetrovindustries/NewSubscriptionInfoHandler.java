package com.albertpetrovindustries;

import java.util.Scanner;

/**
 *  @author Christinica
 *  abstract class NewSubscriptionInfoHandler and his subclasses is a chain of responsibility pattern
 */
public abstract class NewSubscriptionInfoHandler {
    
    /**
     * field newSubscriptionInfoHandler invokes {@link handle} methods of implementations 
     *   of abstract class NewSubscriptionInfoHandler
     */
	public NewSubscriptionInfoHandler newSubscriptionInfoHandler;
	
	/**
	 * contractor NewSubscriptionInfoHandler takes an implementation of this abstract class
	 *   from constructors of implemented classes
	 * @param newSubscriptionInfoHandler
	 */
	public NewSubscriptionInfoHandler(NewSubscriptionInfoHandler newSubscriptionInfoHandler) {
		this.newSubscriptionInfoHandler = newSubscriptionInfoHandler;
	}

	/**
	 * method handle - process our new line with scanner
	 * @param line gets a line of a string after scanner using
	 * @param line is a line from an old line
	 * @return returns a processed string and send it to other handler 
	 *   with a new processing
	 */
	public abstract String handle(Scanner scanner, String line);
	
}
