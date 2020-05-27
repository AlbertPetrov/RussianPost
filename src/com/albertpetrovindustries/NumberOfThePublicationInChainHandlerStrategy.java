package com.albertpetrovindustries;

import java.util.Scanner;

/**
 * @author Christinica
 * NumberOfThePublicationInChainHandlerContext gets a line from a previous handling
 *   and sands it to following 
 * @extends {@link NumberOfThePublicationHandlerAndReturnerContext}
 */
public class NumberOfThePublicationInChainHandlerStrategy extends NumberOfThePublicationHandlerStrategy {

	/**
	 * NumberOfThePublicationInChainHandlerContext takes parameter of a number of the publication
	 *   handling context and parameter of a next handling
	 * @param numberOfThePublicationHandlerContext must take null
	 * @param newSubscriptionInfoHandler
	 */
	public NumberOfThePublicationInChainHandlerStrategy(NumberOfThePublicationHandlerStrategy numberOfThePublicationHandlerStrategy,
												  	    NewSubscriptionInfoHandler newSubscriptionInfoHandler) {
		super(numberOfThePublicationHandlerStrategy, newSubscriptionInfoHandler);
	}
	
	/**
	 *  handle a new string and concats it with an old string if line is
	 *    a number and number biggest than zero
	 *  @param scanner scans lines for our input
	 *  @param line is a string from an old handing
	 *  @return the all string after processing and invoker method of next handling
	 */
	@Override
	public String handle(Scanner scanner, String line) {
		String l;
		while (true) {
			System.out.print("Введите номер публикации:");
			if (scanner.hasNextInt()) {
				l = scanner.nextLine().trim();
				if (Integer.parseInt(l) > 0) {
					return newSubscriptionInfoHandler.handle(scanner, line + l + " ");
				}
				System.out.println("Введите номер публикации больше нуля");
			} else {
				System.out.println("Вы ввели не число");
				scanner.nextLine();
			}
		}		
	}
	
}
