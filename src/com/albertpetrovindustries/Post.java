package com.albertpetrovindustries;

import java.util.Scanner;

/**
 * @author Christinica
 * Post provides interface for addition, removal, outputing of some element, outputing 
 *   of all elements or one element. Start this class from method run
 */
public class Post {

	/**
	 * subscriptions contains subscriptions on the magazines and newspapers 
	 */
	private Subscription[] subsctiptions = new Subscription[0];
	
	/**
	 * run adds, removes, prints, prints all subscriptions after your command inputing
	 */
	public void run() {
		boolean works = true;
		try (Scanner scanner = new Scanner(System.in)) {
			while (works) {
				System.out.print("-------------------------------\n" +
						         "Print a command,\n" +
						         "1 - add a new subscription,\n" +
						         "2 - remove a subscription by number of a publication,\n" +
						         "3 - print an information about a subsctiprion by number of publication,\n" +
						         "4 - print the all subscriptions.\n" +
						         "5 - exit from a program.\n" +
						         "------------------------------\n" +
						         "number:");
				switch (scanner.nextLine()) {
					case "1": addSubsctiption(scanner); break;
					case "2": remove(scanner); break;
					case "3": print(scanner); break;
					case "4": printAll(); break;
					case "5": works = false; break;
				    default: System.out.println("!WRONG COMMAND!");
				}
			}
		}
	}
	
	/**
	 * addSubsctiption gets information about a new {@link Subscription} and then adds
	 *   a new element to end of {@link subsctiptions} if not exists
	 * @param scanner scans lines for our input
	 */
	private void addSubsctiption(Scanner scanner) {	
		System.out.println("Let's input an information:");
		NewSubscriptionInfoHandler newSubscriptionInfoHandler =
			    new SurnameAndAbbreviatedHandler(new NumberOfThePublicationInChainHandlerStrategy(
			    		null, new PublicationNameHandler(new SubscriptionCostHandler(null))));
		String info = newSubscriptionInfoHandler.handle(scanner, "");
		String[] infoParts = info.split(" ");
		
		if (find(Integer.parseInt(infoParts[1])) != -1) {
			System.out.println("THE NUMBER OF THE PUBLICATION IS ALREADY EXISTS!!!");
			return;	
		}
		Subscription[] newSubscriptions = new Subscription[subsctiptions.length + 1];	
		for (int i = 0; i < subsctiptions.length; i++) {
			newSubscriptions[i] = subsctiptions[i];
		}
		newSubscriptions[subsctiptions.length] = new Subscription(infoParts[0], Integer.parseInt(infoParts[1]),
                	  						  infoParts[2], Integer.parseInt(infoParts[3]));
		subsctiptions = newSubscriptions;
	}  
	
	/**
	 *  remove - requests number of the publication and deletes subscriptions from array
	 *    with copying of array if element is present
	 *  @param scanner scans lines for our input
	 */
	private void remove(Scanner scanner) {
		NewSubscriptionInfoHandler newSubscriptionInfoHandler = 
				new NumberOfThePublicationHandlerAndReturnerStrategy(null, null);
		String numberOfThePublication = newSubscriptionInfoHandler.handle(scanner, "");
		
		int index = find(Integer.parseInt(numberOfThePublication));
		if (index == -1) {
			System.out.println("WE CAN'T FIND THE NUMBER OF THE PUBLICATION!!!");
			return;
		} 
           	Subscription[] newSubscriptions = new Subscription[subsctiptions.length - 1];
		for (int i = 0; i < index; i++) {
			newSubscriptions[i] = subsctiptions[i];
		}
		for (int i = index + 1; i < subsctiptions.length - 2; i++) {
			newSubscriptions[i] = subsctiptions[i];
		}
		subsctiptions = newSubscriptions;
		}
	}
	
	/**
	 * print - requests number of the publication and prints an info about necessary subscription
	 * @param scanner scans lines for our input 
	 */
	private void print(Scanner scanner) {
		NewSubscriptionInfoHandler newSubscriptionInfoHandler = 
				new NumberOfThePublicationHandlerAndReturnerStrategy(null, null);
		String numberOfThePublication = newSubscriptionInfoHandler.handle(scanner, "");
		
		int index = find(Integer.parseInt(numberOfThePublication));
		if (index == -1) {
			System.out.println("We can't find the element!!!");
			return;
		}
		Subscription subsctiption = subsctiptions[index];
		System.out.println("----------------------------------------------------------------" +
					   "\nsNumberOfThePublication: " + subsctiption.getNumberOfThePublication() +
					   "\nPublicationName: " + subsctiption.getPublicationName() + 
					   "\nSubscriptionCost: " + subsctiption.getSubscriptionCost() +
					   "\nSurnameAndAbbreviated: " + subsctiption.getSurnameAndAbbreviated() +
	                   		   "\n-----------------------------------------------------------------");
		}
	}
	
	/**
	 * find - sorts by TimSort and then finds index of an element by number of the publication 
	 *   by binary searching
	 * @param numberOfThePublication is a number of the publication
	 * @return position - it is if it is index of a necessary element
	 */
	private int find(int numberOfThePublication) {
		int first = 0; 
		int last = subsctiptions.length - 1; 
		int item = numberOfThePublication;
		int position;
        int comparisonCount = 1;    
        
        SubscriptionsTimSort.sort(subsctiptions, subsctiptions.length);
        if (subsctiptions.length == 0) {
        	return -1;
        }
        long t = System.currentTimeMillis();
        position = (first + last) / 2;
        while ((subsctiptions[position].getNumberOfThePublication() != item) && (first <= last)) {
            comparisonCount++;
            if (subsctiptions[position].getNumberOfThePublication() > item) {
                last = position - 1;
            } else {
                first = position + 1;  
            }
            position = (first + last) / 2;
        }
        System.out.println("--------------------------------------------" +
                           "\nSearching results:" +
        		           "\nSubscriptions: " + subsctiptions.length +
        				   "\nComparisona: " + comparisonCount +
        				   "\nTime in seconds: " + ((System.currentTimeMillis() - t) / 1000.d) +
        				   "\n--------------------------------------------");
        if (first <= last) {
        	return position;
        }
        return position = -1;
	}
	
    /**
	*  printAll prints all subscriptions with all info
	*/
	private void printAll() {
		System.out.println("All subscriptions:\n---------------------------------------------------");
		if (subsctiptions.length == 0) {
			return;
		}
		for (Subscription subsctiption: subsctiptions) {
			System.out.println("---------------------------------------------------------" +
		                       "\nNumberOfThePublication: " + subsctiption.getNumberOfThePublication() +
							   "\nPublicationName: " + subsctiption.getPublicationName() + 
			                   "\nSubscriptionCos: " + subsctiption.getSubscriptionCost() +
			                   "\nSurnameAndAbbreviated: " + subsctiption.getSurnameAndAbbreviated() +
			                   "\n-----------------------------------------------------------------");
		}
	}

}
