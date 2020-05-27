package com.albertpetrovindustries;

import java.util.Scanner;

/**
 * @author Christinica
 * @class SurnameAndAbbreviatedHandler processes the surnameAndAbbreviated
 */
public class SurnameAndAbbreviatedHandler extends NewSubscriptionInfoHandler {

	public SurnameAndAbbreviatedHandler(NewSubscriptionInfoHandler newSubscriptionInfoHandler) {
		super(newSubscriptionInfoHandler);
	}

	/**
	 *  @method handle new string and concats it with an old string if entered date
	 *    if we can split it in 3 parts and it is a number
	 *  @param scanner scans lines for our input
	 *  @param line is an old string
	 *  @return  the all string after processing and invokes method of next handling
	 */
	@Override
	public String handle(Scanner scanner, String line) {
		String l;
		while (true) {
			System.out.print("Enter a surname and abbreviated without point:");
			l = scanner.nextLine();
			if (l.split(" ").length != 3) {
				System.out.println("SURNAME AND ABBREVIATED MUST HAVE A THREE PARTS!");
				continue;
			} else if (l.matches(".*[0-9]+.*")) {
				System.out.println("SURNAME AND ABBREVIATED CAN'T HAVE A NUMBERS");
				continue;
			}
			l = l.replaceAll(" ", ".");
			return newSubscriptionInfoHandler.handle(scanner, line + l + " ");
		}		
	}

}
