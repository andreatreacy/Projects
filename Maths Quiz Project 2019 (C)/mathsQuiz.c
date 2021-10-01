/* Program Description
Maths quiz program where the user chooses from the menu:
(1) How many questions are in the quiz
    The user picks how many questions they want to answer (between 1 and 5)
(2) Start the quiz
    The user plays the maths quiz
(3) Display the quiz results
    The results for the round are displayed
(4) End program
    The program terminates
Author Name: Andrea Treacy
Compiler: Borland
Date: 10/11/2019
*/

#include <stdio.h>
#include <stdlib.h> // this header file is required for the rand() function
int main()
{
    int end = 0;
    int numQuestions = 0;
    int correctCounter = 0;
    int wrongCounter = 0;
    
    // The program will keep returning to menu until the user ends the program
    do
    {
        int choice, question, answer;
        
        printf("\n__________Menu__________");
        printf("\nPress 1 to choose how many questions are in the quiz");
        printf("\nPress 2 to start the quiz");
        printf("\nPress 3 to display the quiz results");
        printf("\nPress 4 to end the program");
        printf("\n________________________\n");
        
        scanf("%d", &choice);
        
        // Checking the number the user entered 
        switch(choice)
        {
            case 1:
            {
                printf("\nYou have selected: Choose how many questions are in the quiz");
                printf("\nHow many questions would you like to answer? (Between 1 and 5) \n");
                scanf("%d", &numQuestions);
                
                // checking if the user has entered a valid number
                if(numQuestions < 1 || numQuestions > 5)
                {
                    printf("The quiz must contain between 1 and 5 questions");
                    //reseting numQuestions to 0
                    numQuestions = 0;
                }
                else
                {
                    printf("\nThere will be %d question(s) in the quiz", numQuestions);
                }
            
                break;
            }// end case 1
        
            case 2:
            {
                printf("\nStarting Quiz");
                
                // Checking if the user has selected how many questions are in the quiz first
                if(numQuestions == 0)
                {
                    printf("\nBefore you start the quiz you must first choose how many questions you would like to answer");
                }
                else
                {
                    // Counters must reset to 0 for each round
                    correctCounter = 0;
                    wrongCounter = 0;
                    
                    // The loop will repeat for as many questions as the user selected
                    for(int i=0; i<numQuestions; i++)
                    {
                        printf("\nGenerating random question");
            
                        // question is assigned a random number between 1 and 8
                        question = rand() % 8 + 1;
                        
                        // Checking the number the random function has chosen
                        switch(question)
                        {
                            case 1:
                            {
                                printf("\n2 + 2 = ?\n");
                                scanf("%d", &answer);
                                printf("\nYou have entered %d. The correct answer is 4", answer);
                                
                                // Checking if the user's answer is correct
                                if(answer == 4)
                                {
                                    printf("\nWell Done!");
                                    // Adding 1 to correctCounter
                                    correctCounter++;
                                }
                                else
                                {
                                    printf("\nWrong Answer!");
                                    // Adding 1 to wrongCounter
                                    wrongCounter++;
                                }
                                break;
                            }// end case 1
                            
                            case 2:
                            {
                                printf("\n9 * 3 = ?\n");
                                scanf("%d", &answer);
                                printf("\nYou have entered %d. The correct answer is 27", answer);
                                
                                // Checking if the user's answer is correct
                                if(answer == 27)
                                {
                                    printf("\nWell Done!");
                                    // Adding 1 to correctCounter
                                    correctCounter++;
                                }
                                else
                                {
                                    printf("\nWrong Answer!");
                                    // Adding 1 to wrongCounter
                                    wrongCounter++;
                                }
                                break;
                            }// end case 2
                            
                            case 3:
                            {
                                printf("\n20 / 4 = ?\n");
                                scanf("%d", &answer);
                                printf("\nYou have entered %d. The correct answer is 5", answer);
                                
                                // Checking if the user's answer is correct
                                if(answer == 5)
                                {
                                    printf("\nWell Done!");
                                    // Adding 1 to correctCounter
                                    correctCounter++;
                                }
                                else
                                {
                                    printf("\nWrong Answer!");
                                    // Adding 1 to wrongCounter
                                    wrongCounter++;
                                }
                                break;
                            }// end case 3
                            
                            case 4:
                            {
                                printf("\n26 - 4 = ?\n");
                                scanf("%d", &answer);
                                printf("\nYou have entered %d. The correct answer is 22", answer);
                                
                                // Checking if the user's answer is correct
                                if(answer == 22)
                                {
                                    printf("\nWell Done!");
                                    // Adding 1 to correctCounter
                                    correctCounter++;
                                }
                                else
                                {
                                    printf("\nWrong Answer!");
                                    // Adding 1 to wrongCounter
                                    wrongCounter++;
                                }
                                break;
                            }// end case 4
                            
                            case 5:
                            {
                                printf("\n5 + 5 + 5 = ?\n");
                                scanf("%d", &answer);
                                printf("\nYou have entered %d. The correct answer is 15", answer);
                                
                                // Checking if the user's answer is correct
                                if(answer == 15)
                                {
                                    printf("\nWell Done!");
                                    // Adding 1 to correctCounter
                                    correctCounter++;
                                }
                                else
                                {
                                    printf("\nWrong Answer!");
                                    // Adding 1 to wrongCounter
                                    wrongCounter++;
                                }
                                break;
                            }// end case 5
                            
                            case 6:
                            {
                                printf("\n(7 * 3) - 12 = ?\n");
                                scanf("%d", &answer);
                                printf("\nYou have entered %d. The correct answer is 9", answer);
                                
                                // Checking if the user's answer is correct
                                if(answer == 9)
                                {
                                    printf("\nWell Done!");
                                    // Adding 1 to correctCounter
                                    correctCounter++;
                                }
                                else
                                {
                                    printf("\nWrong Answer!");
                                    // Adding 1 to wrongCounter
                                    wrongCounter++;
                                }
                                break;
                            }// end case 6
                            
                            case 7:
                            {
                                printf("\n23 - 7 - 5 = ?\n");
                                scanf("%d", &answer);
                                printf("\nYou have entered %d. The correct answer is 11", answer);
                                
                                // Checking if the user's answer is correct
                                if(answer == 11)
                                {
                                    printf("\nWell Done!");
                                    // Adding 1 to correctCounter
                                    correctCounter++;
                                }
                                else
                                {
                                    printf("\nWrong Answer!");
                                    // Adding 1 to wrongCounter
                                    wrongCounter++;
                                }
                                break;
                            }// end case 7
                            
                            case 8:
                            {
                                printf("\n24 + 10 - 16 = ?\n");
                                scanf("%d", &answer);
                                printf("\nYou have entered %d. The correct answer is 18", answer);
                                
                                // Checking if the user's answer is correct
                                if(answer == 18)
                                {
                                    printf("\nWell Done!");
                                    // Adding 1 to correctCounter
                                    correctCounter++;
                                }
                                else
                                {
                                    printf("\nWrong Answer!");
                                    // Adding 1 to wrongCounter
                                    wrongCounter++;
                                }
                                break;
                            }// end case 8
                            
                            default:
                            {
                                printf("Error. Invalid number");
                            }
                            
                        }// end switch
                        
                    }// end for loop
                    
                    // Reseting numQuestions to 0
                    numQuestions = 0;
					
                    printf("\nQuiz finished. Returning to Menu");

                }// end else
                
                break;
            }// end case 2
            
            case 3:
            {
                printf("\nYou have selected: Display the quiz results");
                
                // Checking if the user has done the quiz yet
                if(correctCounter == 0 && wrongCounter == 0)
                {
                    printf("\nYou must attempt the quiz before you can display the results");
                }
                else
                {
                    printf("\nIn this round the player got:");
                    
                    // Displaying the results of the counters
                    printf("\n%d question(s) right", correctCounter);
                    printf("\n%d question(s) wrong", wrongCounter);
                }
                
                break;
            }// end case 3
            
            case 4:
            {
                printf("\nYou have selected: End the program");
                printf("\nAre you sure you want to end the program?");
                printf("\nPress 1 for Yes or 0 for No\n");
                
                scanf("%d", &end);
                
                // Checking if the user ended the program
                if(end == 1)
                {
                    printf("Program is shutting down");
                }
                else
                {
                    printf("Returning to Menu");
                }
                
                break;
            }// end case 4
            
            default:
            {
                printf("\nError. Invalid number. You must choose 1 - 4");
            }
        
        
        }// end switch
        
    }// end do
    
    // if end == 1 the program will end
    while(end != 1);
    
    flushall();
    
    getchar();
    return 0;
    
} // end main

