/*
Author: Mortimer Hedges
Version: 1
Last Updated: 25/10/2020
*/

package pontoonSimple;

import java.util.Scanner;
import java.util.Random;


public class Pontoon 
{
	//Global vars, random and scanner functionality
	static Random randomNum = new Random();
	static Scanner kb = new Scanner(System.in);
	static int hand = 0;
	static int dealerHand = 0;
	
	//Simple RNG (Random Number Generator), returns an int value from 2 to 11
	static int RNG()
	{
		int number = 0;
		
		int	temp = (randomNum.nextInt(11) + 1);			
		
		if (temp == 1)
		{
			temp = 2;
		}
			
		number = temp;
		
		return (number);
	}
	
	//All of the text menus for the program, put into a function to cut down on duped code
	static void menu(int menuType)
	{
		switch (menuType)
		{
		//Main menu
		case 1:
			System.out.println("\n---Pontoon: The terminal card game---");
			System.out.println("1. Play the game");
			System.out.println("2. See the rules");
			System.out.println("3. Quit");
			break;
		
		//Game menu
		case 2:
			System.out.println("\n---Pontoon: The terminal card game---");
			System.out.println("   Hand: "+hand);
			System.out.println("1. Twist");
			System.out.println("2. Stick");
			break;
		
		//Rules
		case 3:
			System.out.println("\n---Pontoon: The terminal card game---");
			System.out.println("   Rules:");
			System.out.println("1. The goal of the game is to get your hand as close to 21 as possible");
			System.out.println("2. If you go over 21, the round ends and the dealer wins");
			System.out.println("3. You can increase the value of your hand by twisting");
			System.out.println("4. If you like your hand you can stick, this end the round and puts your hand against the dealers");
			System.out.println("5. Have fun!\n");
			break;
		
		//Win screen
		case 4:
			System.out.println("\n---Pontoon: The terminal card game---");
			System.out.println("   You won, good job mate!");
			System.out.println("1. Play again?");
			System.out.println("2. See the rules");
			System.out.println("3. Quit");
			break;
		
		//Loss screen
		case 5:
			System.out.println("\n---Pontoon: The terminal card game---");
			System.out.println("   You lost, better luck next time...");
			System.out.println("1. Play again?");
			System.out.println("2. See the rules");
			System.out.println("3. Quit");
			break;
		
		//Draw screen
		case 6:
			System.out.println("\n---Pontoon: The terminal card game---");
			System.out.println("   Draw, what next?");
			System.out.println("1. Play again?");
			System.out.println("2. See the rules");
			System.out.println("3. Quit");
			break;
		
		//Just a default statement, shouldn't be triggered unless something really bad happens
		default:
			System.out.println("\n---Pontoon: The terminal card game---");
			System.out.println("Oh dear something bad happened");
			break;
		}
	}

	
	static void game()
	{
		int userInput = 0;
		
		//Initial hand values
		hand = (RNG() + RNG());
		dealerHand = (RNG() + RNG());
		
		//All of the game logic, quits out to the menu on a win or loss
		gameLoop:
		while (true)
		{
			//Prints out the game menu and takes the game input
			menu(2);
			userInput = kb.nextInt();
			
			//Menu selection code, has a little input validation
			switch (userInput)
			{
			
			//Twist 
			case 1:
				hand = (hand + RNG());
				break;
			
			//Stick
			case 2:
				if (hand > dealerHand)
				{
					menu(4);
				}
				
				if (hand < dealerHand)
				{
					menu(5);
				}
				
				if (hand == dealerHand)
				{
					menu(6);
				}
				break gameLoop;
				
			//Input validation
			default:
				System.out.println("Error: Invalid input, please try again");
				menu(2);
				userInput = kb.nextInt();
			}
			
			//Checks if the player has overdrawn, triggers a loss if so
			if (hand > 21)
			{
				menu(5);
				break;
			}
		}		
	}
	
	
	public static void main(String[] args) 
	{
		menu(1);
		int userInput = 0;
		
		
		//Menu selection code, has a little input validation
		menuLoop:
		while (true)
		{
			userInput = kb.nextInt();
			
			switch (userInput)
			{
			//Starts the game
			case 1:
				game();
				break;
			
			//Shows the rules then prints the menu back
			case 2:
				menu(3);
				menu(1);
				break;
			
			//Quits out of the game
			case 3:
				System.out.println("\nThanks for playing!");
				break menuLoop;
			
			//Input validation
			default:
				System.out.println("Error: Invalid input, please try again");
				menu(1);
				userInput = kb.nextInt();
				break;
			}	
		}
	}
}
