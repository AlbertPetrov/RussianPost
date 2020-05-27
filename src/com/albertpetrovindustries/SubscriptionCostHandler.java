package com.albertpetrovindustries;

import java.util.Scanner;

/**
 * @author Christinica
 * SubscriptionCostHandler process the subscriptionCost from {@link Subscription}
 */
public class SubscriptionCostHandler extends NewSubscriptionInfoHandler {

	/**
	 *  newSubscriptionInfoHandler takes a null, if it's a list handling
	 */
	public SubscriptionCostHandler(NewSubscriptionInfoHandler newSubscriptionInfoHandler) {
		super(newSubscriptionInfoHandler);
	}
	
	/**
	 *  handle new string and concats it with an old string if
	 *    entered data is a number and the number biggest than zero
	 *  @param scanner scans lines for our input
	 *  @param line is an old string
	 *  @return the all string after processing
	 */
	@Override
	public String handle(Scanner scanner, String line) {
		String l;
		while (true) {
			System.out.print("Enter a subscription number:");
			if (scanner.hasNextInt()) {
				l = scanner.nextLine().trim();
				if (Integer.parseInt(l) > 0) {
					return line + l;
				}
				System.out.println("NUMBER MUST BE BIGGEST THAN ZERO!");
			} else {
				System.out.println("IT HAS TO BE A NUMBER!");
				scanner.nextLine();
			}
		}
	}
	
}
