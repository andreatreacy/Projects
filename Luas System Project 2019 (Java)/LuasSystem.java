
import java.text.DecimalFormat;
import java.util.Scanner;

public class LuasSystem
{

	static Scanner input = new Scanner(System.in);
	static DecimalFormat currency = new DecimalFormat("0.00");
	
	static String priceCentral = "2.10"; // Declaring this variable as a String for now. It will be converted to a double later
	static double priceCentralZoneReturn = 3.70;
	
	// Declaring variables as an array
	static double[] priceRedZone = {2.50,4.40,3.00,5.40};
	
	static double[] priceChild = {1.00,1.80,1.20,2.30};

	
	// Declaring variables one at a time
	static double priceGreenZone1 = 2.50;
	static double priceGreenZone1Return = 4.40;
	static double priceGreenZone2 = 2.50;
	static double priceGreenZone2Return = 4.40;
	static double priceGreenZone3 = 3.00;
	static double priceGreenZone3Return = 5.40;
	static double priceGreenZone4 = 3.00;
	static double priceGreenZone4Return = 5.40;
	static double priceGreenZone5 = 3.30;
	static double priceGreenZone5Return = 5.90;
	
	static double totalFloat = 10;
	static int paper = 10;
	static double totalTakings =0;
	static int numberTransactions =0;
	static int numberTicketsSold =0;
	
	
	public static void main(String[] args)
	{
		
	
		menu();
		
	}
	
	public static void menu()
	{
		if(totalFloat<5)
			{
			System.out.println("Float too low. Terminal Closed.");
			System.exit(0);
			}
		
		if(paper==0)
			{
			System.out.println("No Paper. Terminal Closed.");
			System.exit(0);
			}
		
		System.out.println("Press 1 to Buy Tickets");
		System.out.println("Press x to exit");
		
		String choice = input.next();
		
		switch(choice)
		{
		case "1":
			{
			selectZone();
			break;
			}
			
		case"x":
			{
			System.exit(0);
			break;
			}
		
		case "a":
			{
			admin();
			break;
			}
			
		default:
			{
			System.out.println("Error. Please choose 1 or 2");
			break;
			}
		}
		
		menu();
			
	}

	private static void selectZone() 
	{
		System.out.println("Please Select Line");
		System.out.println("Press 1 for Central");
		System.out.println("Press 2 for the Red Line");
		System.out.println("Press 3 for the Green Line");
		
		String chosenLine = input.next();
		
		switch(chosenLine)
		{
			case "1":
				{
				System.out.println("You have selected the Central Line");
				String chosenZone = "Central";
				selectTicketTypeAndQuantity(chosenZone);
				break;
				}
			
			case "2":
				{
				System.out.println("You have selected the Red Line. Please Select Zone");
				System.out.println("Press 1 for Red 1");	
				System.out.println("Press 2 for Red 2");
				System.out.println("Press 3 for Red 3");
				System.out.println("Press 4 for Red 4");
				
				String chosenRedZone = input.next();
				
				switch(chosenRedZone)
					{
					case "1":
						{
						String chosenZone = "Red 1";
						selectTicketTypeAndQuantity(chosenZone);
						break;
						}
					
					case "2":
						{
						String chosenZone = "Red 2";
						selectTicketTypeAndQuantity(chosenZone);
						break;
						}
					
					case "3":
						{
						String chosenZone = "Red 3";
						selectTicketTypeAndQuantity(chosenZone);
						break;
						}
					
					case "4":
						{
						String chosenZone = "Red 4";
						selectTicketTypeAndQuantity(chosenZone);
						break;
						}
					
					default:
						{
						System.out.println("Invalid choice. Transaction cancelled");
						break;
						}
						
					}
				break;
				}
				
			case "3":
					{
					System.out.println("You have selected the Green Line. Please Select Zone");
					System.out.println("Press 1 for Green 1");	
					System.out.println("Press 2 for Green 2");
					System.out.println("Press 3 for Green 3");
					System.out.println("Press 4 for Green 4");
					System.out.println("Press 5 for Green 5");
					
					String chosenGreenZone = input.next();
					
					switch(chosenGreenZone)
						{
						case "1":
							{
							String chosenZone = "Green 1";
							selectTicketTypeAndQuantity(chosenZone);
							break;
							}
						
						case "2":
							{
							String chosenZone = "Green 2";
							selectTicketTypeAndQuantity(chosenZone);
							break;
							}
						
						case "3":
							{
							String chosenZone = "Green 3";
							selectTicketTypeAndQuantity(chosenZone);
							break;
							}
						
						case "4":
							{
							String chosenZone = "Green 4";
							selectTicketTypeAndQuantity(chosenZone);
							break;
							}
						
						case "5":
							{
							String chosenZone = "Green 5";
							selectTicketTypeAndQuantity(chosenZone);
							break;
							}
						
						default:
							{
							System.out.println("Invalid choice. Transaction cancelled");
							break;
							}
						
						}
					break;
					}
			
	
			default:
				{
				System.out.println("Invalid choice. Transaction cancelled");
				break;
				}
		}
	}
		
		
		
	
	


	public static void selectTicketTypeAndQuantity(String chosenZone)
	{
		System.out.println("Please select ticket type for the " + chosenZone + " zone");
		System.out.println("Press 1 for Adult");
		System.out.println("Press 2 for Child");
		System.out.println("Press 3 for Adult & Child");
		
		String adultOrChild = input.next();
		
		switch(adultOrChild)
		{
			case "1":
				{
					String person = "Adult";
					System.out.println("You have Selected Adult Ticket. Please select Single or Return");
					System.out.println("Press 1 for Single");
					System.out.println("Press 2 for Return");
			
					String chosenTicketType = input.next();
		
				switch(chosenTicketType)
				{
				case "1":
					{
					String type = "Single";
				
					if(chosenZone.equals("Central"))
						{
						double priceCentralZone = Double.parseDouble(priceCentral); //Data conversion
						double price = priceCentralZone;
						System.out.println("You have selected an " + person + " " + type + " ticket for the " + chosenZone + " zone");
						System.out.println("Please choose quantity of tickets");
						String number = input.next(); //Declaring this variable as String for now. It will be converted to double in the next step
						int quantity = Integer.parseInt(number); //Data conversion
						
						if(quantity>paper)
						{
							System.out.println("Error. Not enough paper");
							menu();
						}
						
						price = price*quantity;
						
						payment(type, chosenZone, price, quantity, person);
						}
				
					else if(chosenZone.equals("Red 1"))
						{
						double price = priceRedZone[0];
						System.out.println("You have selected an " + person + " " + type + " ticket for the " + chosenZone + " zone");
						System.out.println("Please choose quantity of tickets");
						int quantity = input.nextInt();
						
						if(quantity>paper)
						{
							System.out.println("Error. Not enough paper");
							menu();
						}
						
						price = price*quantity;
						
						payment(type, chosenZone, price, quantity, person);
						}
				
					else if(chosenZone.equals("Red 2"))
						{
						double price = priceRedZone[0];	
						System.out.println("You have selected an " + person + " " + type + " ticket for the " + chosenZone + " zone");
						System.out.println("Please choose quantity of tickets");
						int quantity = input.nextInt();
						
						if(quantity>paper)
						{
							System.out.println("Error. Not enough paper");
							menu();
						}
						
						price = price*quantity;
						
						payment(type, chosenZone, price, quantity, person);
						}
				
					else if(chosenZone.equals("Red 3"))
						{
						double price = priceRedZone[2];
						System.out.println("You have selected an " + person + " " + type + " ticket for the " + chosenZone + " zone");
						System.out.println("Please choose quantity of tickets");
						int quantity = input.nextInt();
						
						if(quantity>paper)
						{
							System.out.println("Error. Not enough paper");
							menu();
						}
						
						price = price*quantity;
						
						payment(type, chosenZone, price, quantity, person);
						}
				
					else if(chosenZone.equals("Red 4"))
						{
						double price = priceRedZone[2];
						System.out.println("You have selected an " + person + " " + type + " ticket for the " + chosenZone + " zone");
						System.out.println("Please choose quantity of tickets");
						int quantity = input.nextInt();
						
						if(quantity>paper)
						{
							System.out.println("Error. Not enough paper");
							menu();
						}
						
						price = price*quantity;
						
						payment(type, chosenZone, price, quantity, person);
						}
				
					else if(chosenZone.equals("Green 1"))
						{
						double price = priceGreenZone1;	
						System.out.println("You have selected an " + person + " " + type + " ticket for the " + chosenZone + " zone");
						System.out.println("Please choose quantity of tickets");
						int quantity = input.nextInt();
						
						if(quantity>paper)
						{
							System.out.println("Error. Not enough paper");
							menu();
						}
						
						price = price*quantity;
						
						payment(type, chosenZone, price, quantity, person);
						}
				
					else if(chosenZone.equals("Green 2"))
						{
						double price = priceGreenZone2;	
						System.out.println("You have selected an " + person + " " + type + " ticket for the " + chosenZone + " zone");
						System.out.println("Please choose quantity of tickets");
						int quantity = input.nextInt();
						
						if(quantity>paper)
						{
							System.out.println("Error. Not enough paper");
							menu();
						}
						
						price = price*quantity;
						
						payment(type, chosenZone, price, quantity, person);
						}
				
					else if(chosenZone.equals("Green 3"))
						{
						double price = priceGreenZone3;	
						System.out.println("You have selected an " + person + " " + type + " ticket for the " + chosenZone + " zone");
						System.out.println("Please choose quantity of tickets");
						int quantity = input.nextInt();
						
						if(quantity>paper)
						{
							System.out.println("Error. Not enough paper");
							menu();
						}
						
						price = price*quantity;
						
						payment(type, chosenZone, price, quantity, person);
						}
				
					else if(chosenZone.equals("Green 4"))
						{
						double price = priceGreenZone4;
						System.out.println("You have selected an " + person + " " + type + " ticket for the " + chosenZone + " zone");
						System.out.println("Please choose quantity of tickets");
						int quantity = input.nextInt();
						
						if(quantity>paper)
						{
							System.out.println("Error. Not enough paper");
							menu();
						}
						
						price = price*quantity;
						
						payment(type, chosenZone, price, quantity, person);
						}
				
					else
						{
						double price = priceGreenZone5;	
						System.out.println("You have selected an " + person + " " + type + " ticket for the " + chosenZone + " zone");
						System.out.println("Please choose quantity of tickets");
						int quantity = input.nextInt();
						
						if(quantity>paper)
						{
							System.out.println("Error. Not enough paper");
							menu();
						}
						
						price = price*quantity;
						
						payment(type, chosenZone, price, quantity, person);
						}
				
					break;
					}
				
				
				case "2":
					{
					String type = "Return";
				
					if(chosenZone.equals("Central"))
						{
						double price = priceCentralZoneReturn;
						System.out.println("You have selected an " + person + " " + type + " ticket for the " + chosenZone + " zone");
						System.out.println("Please choose quantity of tickets");
						int quantity = input.nextInt();
						
						if(quantity>paper)
						{
							System.out.println("Error. Not enough paper");
							menu();
						}
						
						price = price*quantity;
						
						payment(type, chosenZone, price, quantity, person);
						}
			
					else if(chosenZone.equals("Red 1"))
						{
						double price = priceRedZone[1];
						System.out.println("You have selected an " + person + " " + type + " ticket for the " + chosenZone + " zone");
						System.out.println("Please choose quantity of tickets");
						int quantity = input.nextInt();
						
						if(quantity>paper)
						{
							System.out.println("Error. Not enough paper");
							menu();
						}
						
						price = price*quantity;
						
						payment(type, chosenZone, price, quantity, person);
						}
			
					else if(chosenZone.equals("Red 2"))
						{
						double price = priceRedZone[1];	
						System.out.println("You have selected an " + person + " " + type + " ticket for the " + chosenZone + " zone");
						System.out.println("Please choose quantity of tickets");
						int quantity = input.nextInt();
						
						if(quantity>paper)
						{
							System.out.println("Error. Not enough paper");
							menu();
						}
						
						price = price*quantity;
						
						payment(type, chosenZone, price, quantity, person);
						}
			
					else if(chosenZone.equals("Red 3"))
						{
						double price = priceRedZone[3];	
						System.out.println("You have selected an " + person + " " + type + " ticket for the " + chosenZone + " zone");
						System.out.println("Please choose quantity of tickets");
						int quantity = input.nextInt();
						
						if(quantity>paper)
						{
							System.out.println("Error. Not enough paper");
							menu();
						}
						
						price = price*quantity;
						
						payment(type, chosenZone, price, quantity, person);
						}
			
					else if(chosenZone.equals("Red 4"))
						{
						double price = priceRedZone[3];	
						System.out.println("You have selected an " + person + " " + type + " ticket for the " + chosenZone + " zone");
						System.out.println("Please choose quantity of tickets");
						int quantity = input.nextInt();
						
						if(quantity>paper)
						{
							System.out.println("Error. Not enough paper");
							menu();
						}
						
						price = price*quantity;
						
						payment(type, chosenZone, price, quantity, person);
						}
			
					else if(chosenZone.equals("Green 1"))
						{
						double price = priceGreenZone1Return;	
						System.out.println("You have selected an " + person + " " + type + " ticket for the " + chosenZone + " zone");
						System.out.println("Please choose quantity of tickets");
						int quantity = input.nextInt();
						
						if(quantity>paper)
						{
							System.out.println("Error. Not enough paper");
							menu();
						}
						
						price = price*quantity;
						
						payment(type, chosenZone, price, quantity, person);
						}
			
					else if(chosenZone.equals("Green 2"))
						{
						double price = priceGreenZone2Return;	
						System.out.println("You have selected an " + person + " " + type + " ticket for the " + chosenZone + " zone");
						System.out.println("Please choose quantity of tickets");
						int quantity = input.nextInt();
						
						if(quantity>paper)
						{
							System.out.println("Error. Not enough paper");
							menu();
						}
						
						price = price*quantity;
						
						payment(type, chosenZone, price, quantity, person);
						}
			
					else if(chosenZone.equals("Green 3"))
						{
						double price = priceGreenZone3Return;
						System.out.println("You have selected an " + person + " " + type + " ticket for the " + chosenZone + " zone");
						System.out.println("Please choose quantity of tickets");
						int quantity = input.nextInt();
						
						if(quantity>paper)
						{
							System.out.println("Error. Not enough paper");
							menu();
						}
						
						price = price*quantity;
						
						payment(type, chosenZone, price, quantity, person);
						}
			
					else if(chosenZone.equals("Green 4"))
						{
						double price = priceGreenZone4Return;	
						System.out.println("You have selected an " + person + " " + type + " ticket for the " + chosenZone + " zone");
						System.out.println("Please choose quantity of tickets");
						int quantity = input.nextInt();
						
						if(quantity>paper)
						{
							System.out.println("Error. Not enough paper");
							menu();
						}
						
						price = price*quantity;
						
						payment(type, chosenZone, price, quantity, person);
						}
				
					else
						{
						double price = priceGreenZone5Return;	
						System.out.println("You have selected an " + person + " " + type + " ticket for the " + chosenZone + " zone");
						System.out.println("Please choose quantity of tickets");
						int quantity = input.nextInt();
						
						if(quantity>paper)
						{
							System.out.println("Error. Not enough paper");
							menu();
						}
						
						price = price*quantity;
						
						payment(type, chosenZone, price, quantity, person);
						}
			
				break;
					}
				
				default:
					{
					System.out.println("Invalid choice. Transaction cancelled");
					break;
					}
		
					}// end switch
			
				break;
				}//end case 1
				
				
				
				
			case "2":
			{
				String person = "Child";
				System.out.println("You have Selected Child Ticket. Please select Single or Return");
				System.out.println("Press 1 for Single");
				System.out.println("Press 2 for Return");
		
				String chosenTicketType = input.next();
	
			switch(chosenTicketType)
			{
			case "1":
				{
				String type = "Single";
			
				if(chosenZone.equals("Central"))
					{
					double price = priceChild[0];
					System.out.println("You have selected a " + person + " " + type + " ticket for the " + chosenZone + " zone");
					System.out.println("Please choose quantity of tickets");
					int quantity = input.nextInt();
					
					if(quantity>paper)
					{
						System.out.println("Error. Not enough paper");
						menu();
					}
					
					price = price*quantity;
					
					payment(type, chosenZone, price, quantity, person);
					}
			
				else if(chosenZone.equals("Red 1"))
					{
					double price = priceChild[0];
					System.out.println("You have selected a " + person + " " + type + " ticket for the " + chosenZone + " zone");
					System.out.println("Please choose quantity of tickets");
					int quantity = input.nextInt();
					
					if(quantity>paper)
					{
						System.out.println("Error. Not enough paper");
						menu();
					}
					
					price = price*quantity;
					
					payment(type, chosenZone, price, quantity, person);
					}
			
				else if(chosenZone.equals("Red 2"))
					{
					double price = priceChild[0];
					System.out.println("You have selected a " + person + " " + type + " ticket for the " + chosenZone + " zone");
					System.out.println("Please choose quantity of tickets");
					int quantity = input.nextInt();
					
					if(quantity>paper)
					{
						System.out.println("Error. Not enough paper");
						menu();
					}
					
					price = price*quantity;
					
					payment(type, chosenZone, price, quantity, person);
					}
			
				else if(chosenZone.equals("Red 3"))
					{
					double price = priceChild[0];
					System.out.println("You have selected a " + person + " " + type + " ticket for the " + chosenZone + " zone");
					System.out.println("Please choose quantity of tickets");
					int quantity = input.nextInt();
					
					if(quantity>paper)
					{
						System.out.println("Error. Not enough paper");
						menu();
					}
					
					price = price*quantity;
					
					payment(type, chosenZone, price, quantity, person);
					}
			
				else if(chosenZone.equals("Red 4"))
					{
					double price = priceChild[2];
					System.out.println("You have selected a " + person + " " + type + " ticket for the " + chosenZone + " zone");
					System.out.println("Please choose quantity of tickets");
					int quantity = input.nextInt();
					
					if(quantity>paper)
					{
						System.out.println("Error. Not enough paper");
						menu();
					}
					
					price = price*quantity;
					
					payment(type, chosenZone, price, quantity, person);
					}
			
				else if(chosenZone.equals("Green 1"))
					{
					double price = priceChild[0];
					System.out.println("You have selected a " + person + " " + type + " ticket for the " + chosenZone + " zone");
					System.out.println("Please choose quantity of tickets");
					int quantity = input.nextInt();
					
					if(quantity>paper)
					{
						System.out.println("Error. Not enough paper");
						menu();
					}
					
					price = price*quantity;
					
					payment(type, chosenZone, price, quantity, person);
					}
			
				else if(chosenZone.equals("Green 2"))
					{
					double price = priceChild[0];
					System.out.println("You have selected a " + person + " " + type + " ticket for the " + chosenZone + " zone");
					System.out.println("Please choose quantity of tickets");
					int quantity = input.nextInt();
					
					if(quantity>paper)
					{
						System.out.println("Error. Not enough paper");
						menu();
					}
					
					price = price*quantity;
					
					payment(type, chosenZone, price, quantity, person);
					}
			
				else if(chosenZone.equals("Green 3"))
					{
					double price = priceChild[0];
					System.out.println("You have selected a " + person + " " + type + " ticket for the " + chosenZone + " zone");
					System.out.println("Please choose quantity of tickets");
					int quantity = input.nextInt();
					
					if(quantity>paper)
					{
						System.out.println("Error. Not enough paper");
						menu();
					}
					
					price = price*quantity;
					
					payment(type, chosenZone, price, quantity, person);
					}
			
				else if(chosenZone.equals("Green 4"))
					{
					double price = priceChild[2];
					System.out.println("You have selected a " + person + " " + type + " ticket for the " + chosenZone + " zone");
					System.out.println("Please choose quantity of tickets");
					int quantity = input.nextInt();
					
					if(quantity>paper)
					{
						System.out.println("Error. Not enough paper");
						menu();
					}
					
					price = price*quantity;
					
					payment(type, chosenZone, price, quantity, person);
					}
			
				else
					{
					double price = priceChild[2];
					System.out.println("You have selected a " + person + " " + type + " ticket for the " + chosenZone + " zone");
					System.out.println("Please choose quantity of tickets");
					int quantity = input.nextInt();
					
					if(quantity>paper)
					{
						System.out.println("Error. Not enough paper");
						menu();
					}
					
					price = price*quantity;
					
					payment(type, chosenZone, price, quantity, person);
					}
			
				break;
				}
			
			
			case "2":
				{
				String type = "Return";
			
				if(chosenZone.equals("Central"))
					{
					double price = priceChild[1];
					System.out.println("You have selected an " + person + " " + type + " ticket for the " + chosenZone + " zone");
					System.out.println("Please choose quantity of tickets");
					int quantity = input.nextInt();
					
					if(quantity>paper)
					{
						System.out.println("Error. Not enough paper");
						menu();
					}
					
					price = price*quantity;
					
					payment(type, chosenZone, price, quantity, person);
					}
		
				else if(chosenZone.equals("Red 1"))
					{
					double price = priceChild[1];
					System.out.println("You have selected a " + person + " " + type + " ticket for the " + chosenZone + " zone");
					System.out.println("Please choose quantity of tickets");
					int quantity = input.nextInt();
					
					if(quantity>paper)
					{
						System.out.println("Error. Not enough paper");
						menu();
					}
					
					price = price*quantity;
					
					payment(type, chosenZone, price, quantity, person);
					}
		
				else if(chosenZone.equals("Red 2"))
					{
					double price = priceChild[1];	
					System.out.println("You have selected a " + person + " " + type + " ticket for the " + chosenZone + " zone");
					System.out.println("Please choose quantity of tickets");
					int quantity = input.nextInt();
					
					if(quantity>paper)
					{
						System.out.println("Error. Not enough paper");
						menu();
					}
					
					price = price*quantity;
					
					payment(type, chosenZone, price, quantity, person);
					}
		
				else if(chosenZone.equals("Red 3"))
					{
					double price = priceChild[1];
					System.out.println("You have selected a " + person + " " + type + " ticket for the " + chosenZone + " zone");
					System.out.println("Please choose quantity of tickets");
					int quantity = input.nextInt();
					
					if(quantity>paper)
					{
						System.out.println("Error. Not enough paper");
						menu();
					}
					
					price = price*quantity;
					
					payment(type, chosenZone, price, quantity, person);
					}
		
				else if(chosenZone.equals("Red 4"))
					{
					double price = priceChild[3];
					System.out.println("You have selected a " + person + " " + type + " ticket for the " + chosenZone + " zone");
					System.out.println("Please choose quantity of tickets");
					int quantity = input.nextInt();
					
					if(quantity>paper)
					{
						System.out.println("Error. Not enough paper");
						menu();
					}
					
					price = price*quantity;
					
					payment(type, chosenZone, price, quantity, person);
					}
		
				else if(chosenZone.equals("Green 1"))
					{
					double price = priceChild[1];	
					System.out.println("You have selected a " + person + " " + type + " ticket for the " + chosenZone + " zone");
					System.out.println("Please choose quantity of tickets");
					int quantity = input.nextInt();
					
					if(quantity>paper)
					{
						System.out.println("Error. Not enough paper");
						menu();
					}
					
					price = price*quantity;
					
					payment(type, chosenZone, price, quantity, person);
					}
		
				else if(chosenZone.equals("Green 2"))
					{
					double price = priceChild[1];	
					System.out.println("You have selected a " + person + " " + type + " ticket for the " + chosenZone + " zone");
					System.out.println("Please choose quantity of tickets");
					int quantity = input.nextInt();
					
					if(quantity>paper)
					{
						System.out.println("Error. Not enough paper");
						menu();
					}
					
					price = price*quantity;
					
					payment(type, chosenZone, price, quantity, person);
					}
		
				else if(chosenZone.equals("Green 3"))
					{
					double price = priceChild[1];
					System.out.println("You have selected a " + person + " " + type + " ticket for the " + chosenZone + " zone");
					System.out.println("Please choose quantity of tickets");
					int quantity = input.nextInt();
					
					if(quantity>paper)
					{
						System.out.println("Error. Not enough paper");
						menu();
					}
					
					price = price*quantity;
					
					payment(type, chosenZone, price, quantity, person);
					}
		
				else if(chosenZone.equals("Green 4"))
					{
					double price = priceChild[3];
					System.out.println("You have selected a " + person + " " + type + " ticket for the " + chosenZone + " zone");
					System.out.println("Please choose quantity of tickets");
					int quantity = input.nextInt();
					
					if(quantity>paper)
					{
						System.out.println("Error. Not enough paper");
						menu();
					}
					
					price = price*quantity;
					
					payment(type, chosenZone, price, quantity, person);
					}
			
				else
					{
					double price = priceChild[3];	
					System.out.println("You have selected an " + person + " " + type + " ticket for the " + chosenZone + " zone");
					System.out.println("Please choose quantity of tickets");
					int quantity = input.nextInt();
					
					if(quantity>paper)
					{
						System.out.println("Error. Not enough paper");
						menu();
					}
					
					price = price*quantity;
					
					payment(type, chosenZone, price, quantity, person);
					}
		
			break;
				}
			
			default:
				{
				System.out.println("Invalid choice. Transaction cancelled");
				break;
				}
	
				}// end switch
				
				
				
				
			break;	
			}//end case 2
			
		case "3":
		{	
			String person = "Adult & Child";
			System.out.println("You have Selected Adult & Child ticket. Please select Single or Return");
			System.out.println("Press 1 for Single");
			System.out.println("Press 2 for Return");
			
			String chosenTicketType = input.next();
			
			switch(chosenTicketType)
			{
				
			case "1":
				{
				String type = "Single";
			
				if(chosenZone.equals("Central"))
					{
					double priceCentralZone = Double.parseDouble(priceCentral); //Data conversion
					double price1 = priceCentralZone;
					double price2 = priceChild[0];
					System.out.println("You have selected " + person + " " + type + " tickets for the " + chosenZone + " zone");
					
					System.out.println("Please choose quantity of tickets for Adult");
					int quantityAdult = input.nextInt();
					price1 = price1*quantityAdult;
					
					System.out.println("Please choose quantity of tickets for Child");
					int quantityChild = input.nextInt();
					price2 = price2*quantityChild;
					
					int quantity = quantityAdult + quantityChild;
					if(quantity>paper)
					{
						System.out.println("Error. Not enough paper");
						menu();
					}
					
					
					double price = price1 + price2;
					
					payment(type, chosenZone, price, quantity, person);
					}
			
				else if(chosenZone.equals("Red 1"))
					{
					double price1 = priceRedZone[0];
					double price2 = priceChild[0];
					System.out.println("You have selected " + person + " " + type + " tickets for the " + chosenZone + " zone");
					
					System.out.println("Please choose quantity of tickets for Adult");
					int quantityAdult = input.nextInt();
					price1 = price1*quantityAdult;
					
					System.out.println("Please choose quantity of tickets for Child");
					int quantityChild = input.nextInt();
					price2 = price2*quantityChild;
					
					int quantity = quantityAdult + quantityChild;
					if(quantity>paper)
					{
						System.out.println("Error. Not enough paper");
						menu();
					}
					
					
					double price = price1 + price2;
					
					payment(type, chosenZone, price, quantity, person);
					}
			
				else if(chosenZone.equals("Red 2"))
					{
					double price1 = priceRedZone[0];
					double price2 = priceChild[0];
					System.out.println("You have selected " + person + " " + type + " tickets for the " + chosenZone + " zone");
					
					System.out.println("Please choose quantity of tickets for Adult");
					int quantityAdult = input.nextInt();
					price1 = price1*quantityAdult;
					
					System.out.println("Please choose quantity of tickets for Child");
					int quantityChild = input.nextInt();
					price2 = price2*quantityChild;
					
					int quantity = quantityAdult + quantityChild;
					if(quantity>paper)
					{
						System.out.println("Error. Not enough paper");
						menu();
					}
					
					
					double price = price1 + price2;
					
					payment(type, chosenZone, price, quantity, person);
					}
			
				else if(chosenZone.equals("Red 3"))
					{
					double price1 = priceRedZone[2];
					double price2 = priceChild[0];
					System.out.println("You have selected " + person + " " + type + " tickets for the " + chosenZone + " zone");
					
					System.out.println("Please choose quantity of tickets for Adult");
					int quantityAdult = input.nextInt();
					price1 = price1*quantityAdult;
					
					System.out.println("Please choose quantity of tickets for Child");
					int quantityChild = input.nextInt();
					price2 = price2*quantityChild;
					
					int quantity = quantityAdult + quantityChild;
					if(quantity>paper)
					{
						System.out.println("Error. Not enough paper");
						menu();
					}
					
					
					double price = price1 + price2;
					
					payment(type, chosenZone, price, quantity, person);
					}
			
				else if(chosenZone.equals("Red 4"))
					{
					double price1 = priceRedZone[2];
					double price2 = priceChild[2];
					System.out.println("You have selected " + person + " " + type + " tickets for the " + chosenZone + " zone");
					
					System.out.println("Please choose quantity of tickets for Adult");
					int quantityAdult = input.nextInt();
					price1 = price1*quantityAdult;
					
					System.out.println("Please choose quantity of tickets for Child");
					int quantityChild = input.nextInt();
					price2 = price2*quantityChild;
					
					int quantity = quantityAdult + quantityChild;
					if(quantity>paper)
					{
						System.out.println("Error. Not enough paper");
						menu();
					}
					
					
					double price = price1 + price2;
					
					payment(type, chosenZone, price, quantity, person);
					}
			
				else if(chosenZone.equals("Green 1"))
					{
					double price1 = priceGreenZone1;
					double price2 = priceChild[0];
					System.out.println("You have selected " + person + " " + type + " tickets for the " + chosenZone + " zone");
					
					System.out.println("Please choose quantity of tickets for Adult");
					int quantityAdult = input.nextInt();
					price1 = price1*quantityAdult;
					
					System.out.println("Please choose quantity of tickets for Child");
					int quantityChild = input.nextInt();
					price2 = price2*quantityChild;
					
					int quantity = quantityAdult + quantityChild;
					if(quantity>paper)
					{
						System.out.println("Error. Not enough paper");
						menu();
					}
					
					
					double price = price1 + price2;
					
					payment(type, chosenZone, price, quantity, person);
					}
			
				else if(chosenZone.equals("Green 2"))
					{
					double price1 = priceGreenZone2;
					double price2 = priceChild[0];
					System.out.println("You have selected " + person + " " + type + " tickets for the " + chosenZone + " zone");
					
					System.out.println("Please choose quantity of tickets for Adult");
					int quantityAdult = input.nextInt();
					price1 = price1*quantityAdult;
					
					System.out.println("Please choose quantity of tickets for Child");
					int quantityChild = input.nextInt();
					price2 = price2*quantityChild;
					
					int quantity = quantityAdult + quantityChild;
					if(quantity>paper)
					{
						System.out.println("Error. Not enough paper");
						menu();
					}
					
					
					double price = price1 + price2;
					
					payment(type, chosenZone, price, quantity, person);
					}
			
				else if(chosenZone.equals("Green 3"))
					{
					double price1 = priceGreenZone3;	
					double price2 = priceChild[0];
					System.out.println("You have selected " + person + " " + type + " tickets for the " + chosenZone + " zone");
					
					System.out.println("Please choose quantity of tickets for Adult");
					int quantityAdult = input.nextInt();
					price1 = price1*quantityAdult;
					
					System.out.println("Please choose quantity of tickets for Child");
					int quantityChild = input.nextInt();
					price2 = price2*quantityChild;
					
					int quantity = quantityAdult + quantityChild;
					if(quantity>paper)
					{
						System.out.println("Error. Not enough paper");
						menu();
					}
					
					
					double price = price1 + price2;
					
					payment(type, chosenZone, price, quantity, person);
					}
			
				else if(chosenZone.equals("Green 4"))
					{
					double price1 = priceGreenZone4;
					double price2 = priceChild[2];
					System.out.println("You have selected " + person + " " + type + " tickets for the " + chosenZone + " zone");
					
					System.out.println("Please choose quantity of tickets for Adult");
					int quantityAdult = input.nextInt();
					price1 = price1*quantityAdult;
					
					System.out.println("Please choose quantity of tickets for Child");
					int quantityChild = input.nextInt();
					price2 = price2*quantityChild;
					
					int quantity = quantityAdult + quantityChild;
					if(quantity>paper)
					{
						System.out.println("Error. Not enough paper");
						menu();
					}
					
					
					double price = price1 + price2;
					
					payment(type, chosenZone, price, quantity, person);
					}
			
				else
					{
					double price1 = priceGreenZone5;
					double price2 = priceChild[2];
					System.out.println("You have selected " + person + " " + type + " tickets for the " + chosenZone + " zone");
					
					System.out.println("Please choose quantity of tickets for Adult");
					int quantityAdult = input.nextInt();
					price1 = price1*quantityAdult;
					
					System.out.println("Please choose quantity of tickets for Child");
					int quantityChild = input.nextInt();
					price2 = price2*quantityChild;
					
					int quantity = quantityAdult + quantityChild;
					if(quantity>paper)
					{
						System.out.println("Error. Not enough paper");
						menu();
					}
					
					
					double price = price1 + price2;
					
					payment(type, chosenZone, price, quantity, person);
					}
			
				break;
				}//end case 1
			
				
			case "2":
			{
				String type = "Return";
				
				if(chosenZone.equals("Central"))
					{
					double price1 = priceCentralZoneReturn;
					double price2 = priceChild[1];
					System.out.println("You have selected " + person + " " + type + " tickets for the " + chosenZone + " zone");
					
					System.out.println("Please choose quantity of tickets for Adult");
					int quantityAdult = input.nextInt();
					price1 = price1*quantityAdult;
					
					System.out.println("Please choose quantity of tickets for Child");
					int quantityChild = input.nextInt();
					price2 = price2*quantityChild;
					
					int quantity = quantityAdult + quantityChild;
					if(quantity>paper)
					{
						System.out.println("Error. Not enough paper");
						menu();
					}
					
					
					double price = price1 + price2;
					
					payment(type, chosenZone, price, quantity, person);
					}
		
				else if(chosenZone.equals("Red 1"))
					{
					double price1 = priceRedZone[1];
					double price2 = priceChild[1];
					System.out.println("You have selected " + person + " " + type + " tickets for the " + chosenZone + " zone");
					
					System.out.println("Please choose quantity of tickets for Adult");
					int quantityAdult = input.nextInt();
					price1 = price1*quantityAdult;
					
					System.out.println("Please choose quantity of tickets for Child");
					int quantityChild = input.nextInt();
					price2 = price2*quantityChild;
					
					int quantity = quantityAdult + quantityChild;
					if(quantity>paper)
					{
						System.out.println("Error. Not enough paper");
						menu();
					}
					
					
					double price = price1 + price2;
					
					payment(type, chosenZone, price, quantity, person);
					}
		
				else if(chosenZone.equals("Red 2"))
					{
					double price1 = priceRedZone[1];	
					double price2 = priceChild[1];
					System.out.println("You have selected " + person + " " + type + " tickets for the " + chosenZone + " zone");
					
					System.out.println("Please choose quantity of tickets for Adult");
					int quantityAdult = input.nextInt();
					price1 = price1*quantityAdult;
					
					System.out.println("Please choose quantity of tickets for Child");
					int quantityChild = input.nextInt();
					price2 = price2*quantityChild;
					
					int quantity = quantityAdult + quantityChild;
					if(quantity>paper)
					{
						System.out.println("Error. Not enough paper");
						menu();
					}
					
					
					double price = price1 + price2;
					
					payment(type, chosenZone, price, quantity, person);
					}
		
				else if(chosenZone.equals("Red 3"))
					{
					double price1 = priceRedZone[3];	
					double price2 = priceChild[1];
					System.out.println("You have selected " + person + " " + type + " tickets for the " + chosenZone + " zone");
					
					System.out.println("Please choose quantity of tickets for Adult");
					int quantityAdult = input.nextInt();
					price1 = price1*quantityAdult;
					
					System.out.println("Please choose quantity of tickets for Child");
					int quantityChild = input.nextInt();
					price2 = price2*quantityChild;
					
					int quantity = quantityAdult + quantityChild;
					if(quantity>paper)
					{
						System.out.println("Error. Not enough paper");
						menu();
					}
					
					
					double price = price1 + price2;
					
					payment(type, chosenZone, price, quantity, person);
					}
		
				else if(chosenZone.equals("Red 4"))
					{
					double price1 = priceRedZone[3];	
					double price2 = priceChild[3];
					System.out.println("You have selected " + person + " " + type + " tickets for the " + chosenZone + " zone");
					
					System.out.println("Please choose quantity of tickets for Adult");
					int quantityAdult = input.nextInt();
					price1 = price1*quantityAdult;
					
					System.out.println("Please choose quantity of tickets for Child");
					int quantityChild = input.nextInt();
					price2 = price2*quantityChild;
					
					int quantity = quantityAdult + quantityChild;
					if(quantity>paper)
					{
						System.out.println("Error. Not enough paper");
						menu();
					}
					
					
					double price = price1 + price2;
					
					payment(type, chosenZone, price, quantity, person);
					}
		
				else if(chosenZone.equals("Green 1"))
					{
					double price1 = priceGreenZone1Return;	
					double price2 = priceChild[1];
					System.out.println("You have selected " + person + " " + type + " tickets for the " + chosenZone + " zone");
					
					System.out.println("Please choose quantity of tickets for Adult");
					int quantityAdult = input.nextInt();
					price1 = price1*quantityAdult;
					
					System.out.println("Please choose quantity of tickets for Child");
					int quantityChild = input.nextInt();
					price2 = price2*quantityChild;
					
					int quantity = quantityAdult + quantityChild;
					if(quantity>paper)
					{
						System.out.println("Error. Not enough paper");
						menu();
					}
					
					
					double price = price1 + price2;
					
					payment(type, chosenZone, price, quantity, person);
					}
		
				else if(chosenZone.equals("Green 2"))
					{
					double price1 = priceGreenZone2Return;	
					double price2 = priceChild[1];
					System.out.println("You have selected " + person + " " + type + " tickets for the " + chosenZone + " zone");
					
					System.out.println("Please choose quantity of tickets for Adult");
					int quantityAdult = input.nextInt();
					price1 = price1*quantityAdult;
					
					System.out.println("Please choose quantity of tickets for Child");
					int quantityChild = input.nextInt();
					price2 = price2*quantityChild;
					
					int quantity = quantityAdult + quantityChild;
					if(quantity>paper)
					{
						System.out.println("Error. Not enough paper");
						menu();
					}
					
					
					double price = price1 + price2;
					
					payment(type, chosenZone, price, quantity, person);
					}
		
				else if(chosenZone.equals("Green 3"))
					{
					double price1 = priceGreenZone3Return;
					double price2 = priceChild[1];
					System.out.println("You have selected " + person + " " + type + " tickets for the " + chosenZone + " zone");
					
					System.out.println("Please choose quantity of tickets for Adult");
					int quantityAdult = input.nextInt();
					price1 = price1*quantityAdult;
					
					System.out.println("Please choose quantity of tickets for Child");
					int quantityChild = input.nextInt();
					price2 = price2*quantityChild;
					
					int quantity = quantityAdult + quantityChild;
					if(quantity>paper)
					{
						System.out.println("Error. Not enough paper");
						menu();
					}
					
					
					double price = price1 + price2;
					
					payment(type, chosenZone, price, quantity, person);
					}
		
				else if(chosenZone.equals("Green 4"))
					{
					double price1 = priceGreenZone4Return;	
					double price2 = priceChild[3];
					System.out.println("You have selected " + person + " " + type + " tickets for the " + chosenZone + " zone");
					
					System.out.println("Please choose quantity of tickets for Adult");
					int quantityAdult = input.nextInt();
					price1 = price1*quantityAdult;
					
					System.out.println("Please choose quantity of tickets for Child");
					int quantityChild = input.nextInt();
					price2 = price2*quantityChild;
					
					int quantity = quantityAdult + quantityChild;
					if(quantity>paper)
					{
						System.out.println("Error. Not enough paper");
						menu();
					}
					
					
					double price = price1 + price2;
					
					payment(type, chosenZone, price, quantity, person);
					}
			
				else
					{
					double price1 = priceGreenZone5Return;	
					double price2 = priceChild[3];
					System.out.println("You have selected " + person + " " + type + " tickets for the " + chosenZone + " zone");
					
					System.out.println("Please choose quantity of tickets for Adult");
					int quantityAdult = input.nextInt();
					price1 = price1*quantityAdult;
					
					System.out.println("Please choose quantity of tickets for Child");
					int quantityChild = input.nextInt();
					price2 = price2*quantityChild;
					
					int quantity = quantityAdult + quantityChild;
					if(quantity>paper)
					{
						System.out.println("Error. Not enough paper");
						menu();
					}
					
					
					double price = price1 + price2;
					
					payment(type, chosenZone, price, quantity, person);
					}
				
				break;
			}//end case 2
			
				
			default:
				{
				System.out.println("Invalid choice. Transaction cancelled");
				break;
				}
				
				
			}//end switch
			
			
			
			
		break;	
		}//end case 3	
			
		default:
			{
			System.out.println("Invalid choice. Transaction cancelled");
			break;
			}	
			
		}//end adult child switch
		
	}//end method
	
	
	
	
	
	
	
	public static void payment(String type, String chosenZone, double price, int quantity, String person)
	{
		if(person.equals("Adult & Child"))
			{
			System.out.println("You have selected " + quantity + " " + type + " ticket(s) for " + person + " for the " + chosenZone + " zone");
			}
		else
			{
			System.out.println("You have selected " + quantity + " " + person + " " + type + " ticket(s) for the " + chosenZone + " zone");
			}
		
		System.out.println("Transaction Cost: " + currency.format(price));
		
		System.out.println("Please select payment method");
		System.out.println("Press 1 for Cash");
		System.out.println("Press 2 for Card");
		System.out.println("Press 3 for Leap Card");
		
		String chosenPaymentMethod = input.next();
		
		switch(chosenPaymentMethod)
		{
		case "1":
				{
				System.out.println("Please enter cash");
				double moneyEntered = input.nextDouble();
				
				while(moneyEntered<price)
					{
					System.out.println("Balance remaining: " + currency.format((price-moneyEntered)));
					moneyEntered = moneyEntered + input.nextDouble();
					
					}
				//at this point in the method the user must have successfully paid for transaction
				
				if(moneyEntered-price>totalFloat)
					{
					System.out.println("Error. Float too low. Refund in progress");
					menu();
					}
				
				System.out.println("Transaction successful. Change is " + currency.format((moneyEntered-price)));
				//(moneyEntered-transactionCost) is in brackets so the program will do this first
				totalTakings = totalTakings + price; //record value of all transactions
				totalFloat = (totalFloat + price - (moneyEntered - price));
				paper = paper - quantity;
				numberTicketsSold = numberTicketsSold + quantity;
				numberTransactions++; // record number of transactions
				
				printTickets();
				break;
				}
		
		case "2":
				{
				System.out.println("Please enter card");
				System.out.println("Please enter pin");
				int pin = input.nextInt();
				System.out.println("Transaction successful");
				totalTakings = totalTakings + price;
				totalFloat = (totalFloat + price);
				paper = paper - quantity;
				numberTicketsSold = numberTicketsSold + quantity;
				numberTransactions++;
				
				printTickets();
				break;
				}
		
		case "3":
				{
				System.out.println("Please scan Leap Card");
				System.out.println("Transaction successful");
				totalTakings = totalTakings + price;
				totalFloat = (totalFloat + price);
				paper = paper - quantity;
				numberTicketsSold = numberTicketsSold + quantity;
				numberTransactions++;
				
				printTickets();
				break;
				}
		
		default:
				{
				System.out.println("Invalid choice. Transaction cancelled");
				break;
				}
	
		}
		
		

	}
	
	
	public static void printTickets()
	{
		
		System.out.println("Tickets are printing");
		menu();
	}
	
	
	
	private static void admin() 
	{
		System.out.println("Press 1 for Stats");
		System.out.println("Press 2 to top up float");
		System.out.println("Press 3 to top up paper");
		System.out.println("Press 4 to Exit admin mode");
		
		String adminChoice = input.next();
		
		switch(adminChoice)
		{
		case "1":
			{
			System.out.println("Total Takings: " + currency.format(totalTakings));
			System.out.println("Number of transactions: " + numberTransactions);
			System.out.println("Number of tickets sold: " + numberTicketsSold);
			System.out.println("Average Value: " + currency.format((totalTakings/numberTransactions)));
			System.out.println("Remaining float: " + currency.format(totalFloat));
			System.out.println("Remaining paper: " + paper);
			break;
			}
			
		case "2":
			{
			totalFloat = 10;
			break;
			}
		
		case "3":
			{
			paper = 10;
			break;
			}
		
		case "4":
			{
			System.out.println("Exiting admin mode");
			menu();
			break;
			}
		
		default:
			{
			System.out.println("Invalid choice. Choose 1 - 4");
			break;
			}
		
		
		}
		
		
		
		admin();
	}
	
	
	
	
	
}


