package com.albertpetrovindustries;

import java.util.Scanner;

/**
 * @author Christinica
 * @class NumberOfThePublicationHandlerAndReturnerContext processes our input of number of the publication and only returns it
 * @extends {@link NumberOfThePublicationHandlerContext}
 */
public class NumberOfThePublicationHandlerAndReturnerStrategy extends NumberOfThePublicationHandlerStrategy {
	
	/**
	 * @constructor NumberOfThePublicationHandlerAndReturnerContext gets implementations of {@link NumberOfThePublicationHandlerContext}
	 * and {@link NewSubscriptionInfoHandle} 
	 * @param numberOfThePublicationHandlerContext must take null
	 * @param newSubscriptionInfoHandler
	 */
	public NumberOfThePublicationHandlerAndReturnerStrategy(NumberOfThePublicationHandlerStrategy numberOfThePublicationHandlerStrategy, 
															NewSubscriptionInfoHandler newSubscriptionInfoHandler) {
		super(numberOfThePublicationHandlerStrategy, newSubscriptionInfoHandler);
	}
	
	/**
	 * @method handle processes our input
	 * @param scanner scans lines for our input
	 * @param line must get an empty string
	 * @return newLine if input is a number and number biggest then zero
	 */
	@Override
	public String handle(Scanner scanner, String line) {
		String newLine;
		while (true) {
			System.out.print("Введите номер публикации:");
			if (scanner.hasNextInt()) {
				newLine = scanner.nextLine().trim();
				if (Integer.parseInt(newLine) > 0) {
					return newLine;
				}
				System.out.println("Число не больше нуля");
			} else {
				System.out.println("Вы ввели не число");
				scanner.nextLine();
			}
		}		
	}
	
}
