/* Program Description
Program that generates a random number between 1 and 10. Then it asks the user to enter a number between 1 and 10 and checks if the numbers are the same. It goes for 5 rounds before ending
Author Name: Andrea Treacy
Compiler: Borland
Date: 22/10/2019
*/

#include <stdio.h>
#include <stdlib.h> // this header file is required for the rand() function
int main()
{
    int num = 0;
    int input = 0;
    
    int sameCounter = 0;
    int differentCounter = 0;
    
	// the game will have 5 rounds
    for(int i=0; i<5; i++)
    {// start for loop
        
        printf("Enter a number between 1 and 10\n");
        
        // Putting the value the user entered into input
        scanf("%d", &input);
        
        flushall();
        
        //Checking if the user enter a number less than 1 or greater than 10
        if(input < 1 || input > 10)
        {
            printf("Error. Invalid number\n");
        }
        else
        {// start else
            printf("You have entered %d\n", input);
            
            printf("Generating a random number between 1 - 10\n");
        
            //num is assigned a random number between 1 and 10
            num = rand() % 10 + 1;
            
            //Display the random number generated
            printf("%d\n", num);

            
            // Checking if the numbers are the same
            if(num == input)
            {
                printf("Same numbers\n");
                
                sameCounter++; // Adding 1 to sameCounter
            }
            else
            {
                printf("Different numbers\n");
                
                differentCounter++; // Adding 1 to differentCounter
            }
        } // end else
       
    } //end for loop
    
    // Displaying the results of the counters
    printf("The numbers were the same %d time(s)\n", sameCounter);
    
    printf("The numbers were different %d time(s)", differentCounter);
     
    
    getchar();
    return 0;
    
} // end main