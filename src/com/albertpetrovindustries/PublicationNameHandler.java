package com.albertpetrovindustries;

import java.util.Scanner;

/**
 * @author Christinica
 * PublicationNameHandler processes the field publicationName
 * @extends {@link NewSubscriptionInfoHandler} 
 */
public class PublicationNameHandler extends NewSubscriptionInfoHandler {

	/**
	 * PublicationNameHandler takes a parameter which is an implementation of
	 *   newSubscriptionInfoHandler
	 * @param newSubscriptionInfoHandler
	 */
	public PublicationNameHandler(NewSubscriptionInfoHandler newSubscriptionInfoHandler) {
		super(newSubscriptionInfoHandler);
	}

	/**
	 *  handle a new string and concats it with an old string if entered data not an empty string
	 *  @param scanner scans lines for our input
	 *  @param line is an old string
	 *  @return the all string after processing and invoker method of next handling
	 */
	@Override
	public String handle(Scanner scanner, String line) {
		String l;
		while (true) {
			System.out.print("Введите имя публикации:");
			l = scanner.nextLine();
			if (l.length() > 0) {
				return newSubscriptionInfoHandler.handle(scanner, line + l + " ");
			}
			System.out.print("Вы ничего не ввели.");
		}		
	}

}
