/*
Author: Mortimer Hedges
Version: 1
Last Updated: 08/11/2020
*/

package pythagoras;

import java.util.Scanner;
public class Pythagoras {
	static Scanner kb = new Scanner(System.in);
	
	//Initial user input, takes a char value as an argument
	static int getInput(char side)
	{
		int userInput = 0;
		
		System.out.println("Please enter side "+side+":");
		userInput = kb.nextInt();
		return userInput;
	}
	
	//Squares and displays the given number, takes a char and an int as arguments
	static int square( char side, int num) 
	{
		num = num * num;
		System.out.println("The value of "+side+" squared is "+num);
		return num;
	}

	
	public static void main(String[] args) 
	{
		int[] sides = {0,0,0};
		int[] sidesSq = {0,0,0};
		
		sides[0] = getInput('A');
		sides[1] = getInput('B');
		sides[2] = getInput('C');
		
		sidesSq[0] = square('A',sides[0]);
		sidesSq[1] = square('B',sides[1]);
		sidesSq[2] = square('C',sides[2]);
		
		//Uses the pythagoras theorem to determine if the given sides belong to a right angle triangle
		if ((sidesSq[0] + sidesSq[1]) == sidesSq[2])
		{
			System.out.println("That's a right angle triangle");
		}
		
		else
		{
			System.out.println("That's not a right angle triangle");
		}
		
		kb.close();
	}
}
