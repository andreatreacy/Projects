/* Program Description
Security authorisation program where the user selects from the menu:
(1) Enter/generate a code
    The user chooses either to enter their own 4 digit code or have one randomly generated
(2) Encrypt code
    The users code is encrypted using an incryption algorithm
(3) Check if the encrypted code matches the access code
    The users code is compared to the access code (4523) to check for a match
(4) Decrypt code
    The users code is decrypted using a decryption algorithm
(5) Display the number of times the encrypted code was right/wrong
    Display the ammount of times the user entered the right and wrong access code throughout the run of the program
(6) Display your code
    The user's code is displayed
(7) End program
    The program terminates
Author Name: Andrea Treacy
Compiler: Borland
Date: 13/05/2020
*/

#include <stdio.h>
#include <stdlib.h>

//symbolic names
#define SIZE 4
#define CHOICESIZE 10  


//structure template
struct code_counter 
{
    int correct_code;
    int wrong_code;
};


//function signatures
int enterCode(int[]);
int encryptCode(int[]);
void checkForMatch(int[], struct code_counter*);
void decryptCode(int[]);
void countRightWrong(struct code_counter*);
void displayUserCode(int[]);
int exit(void);


int main()
{
    int end = 0;
    
    //validation variables
    int codeAssigned = 0;
    int codeEncrypted = 0;
    int matchChecked = 0;
    
    //creating a structure variable and setting all it's members to 0
    struct code_counter stats =
    {
        0,
        0
    };
    
    
    // The program will keep returning to menu until the user ends the program
    do
    {
        int userCode[SIZE];
        char choice[CHOICESIZE]; //made to store 10 characters in case the user enters too many. Its better to have extra space for them
        int menuChoice;
        
        printf("\n\n__________Menu__________");
        printf("\n1. Enter/generate a code");
        printf("\n2. Encrypt code");
        printf("\n3. Check if the encrypted code matches the access code");
        printf("\n4. Decrypt code");
        printf("\n5. Display the number of times the encrypted code was right/wrong");
        printf("\n6. Display your code");
        printf("\n7. Exit the program");
        printf("\n________________________\n\n");
        
        // user input will be taken in as a string to allow for error checking
        scanf("%s", &choice);
        
        // converting choice to an int value (if the user has entered a character its value will be 0)
        menuChoice = atoi(choice);
        
        // Checking the number the user entered 
        switch(menuChoice)
        {
            case 1:
            {
                // user gets their code
                codeAssigned = enterCode(userCode); //the value of codeAssigned will be used to check if the user can select other menu options
                codeEncrypted = 0;  //every time the user gets a new code codeEncrypted will be set to 0 in order to access menu option 2 (encrypt)
                matchChecked = 0;   //every time the user gets a new code matchChecked will be reset to 0 until it is compared to the access code
                break;
            }// end case 1
        
            case 2:
            {
                // the user can only access this option if they have completed option 1 and they have not alreday encrypted their code
                if(codeAssigned == 1 && codeEncrypted == 0)
                {
                    // encrypt the users code
                    codeEncrypted = encryptCode(userCode);
                }
                else
                {
                    printf("\nYou must choose a new code before you can encrypt it");
                }
                break;
            }// end case 2
            
            case 3:
            {
                // if the user has not completed option 1 and 2 they can't access this option
                if(codeAssigned == 1 && codeEncrypted == 1)
                {
                    //if a code has already been checked it wont be checked again. The user must enter a new code to access this option again
                    if(matchChecked == 1)
                    {
                        printf("\nYou have already checked this code");
                    }
                    
                    else
                    {
                        // check if the user code matches the access code
                        checkForMatch(userCode, &stats);
                        matchChecked = 1;   //this value will prevent the user from accessing this option twice with the same code
                    }//end inner else
                    
                }//end outer if
                
                else
                {
                    printf("\nYou must choose your code and encrypt it before you can check if it matches the access code");
                }
                break;
            }// end case 3
            
            case 4:
            {
                // if the user has not completed option 1 and 2 they can't access this option
                if(codeAssigned == 1 && codeEncrypted == 1)
                {
                    // decrypt the user code
                    decryptCode(userCode);
                    codeEncrypted = 0;  //with this value the user can encrypt their code again if they wish
                }
                else
                {
                    printf("\nYou must choose your numbers and encrypt them before you can decrypt them");
                }
                break;
            }// end case 4
            
            case 5:
            {
                // if the user has not completed option 3 they can't access this option
                if(matchChecked == 1)
                {
                    // count the ammount of times the user got the access code right/wrong
                    countRightWrong(&stats);
                }
                else
                {
                    printf("\nYou must have compared your code to the access code at least once before you can see how many times it was right/wrong");
                }
                break;
            }// end case 5
            
            case 6:
            {
                // the user can only access this option if they have completed option 1
                if(codeAssigned == 1)
                {
                    // display the users code
                    displayUserCode(userCode);
                }
                else
                {
                    printf("\nYou must choose your code before you can display it");
                }
                break;
            }// end case 6
            
            case 7:
            {
                // end the program
                end = exit();   //after this function end will be equal to 1 and the do while loop will end
                break;
            }// end case 7
            
            default:
            {
                printf("\nError. Invalid number. You must choose 1 - 7");
            }
        
        }// end switch
        
    }// end do
    
    //if end == 1 the program will end
    while(end == 0);
    
    
    flushall();
    
    getchar();
    return 0;
    
} // end main





// function that allows the user to enter their own 4 digit code or have one assigned to them
int enterCode(int user_code[])
{
    int code_assigned = 0;
    char choice[CHOICESIZE]; //made to store 10 characters in case the user enters too many. Its better to have extra space for them
    int menuChoice;
    int i;
    char temp[CHOICESIZE];
    int number;
    int errorCount;
    
    printf("\n1. Enter/generate a code\n");
    printf("\n________________________");
    printf("\n1. Enter a code");
    printf("\n2. Generate a random code");
    printf("\n________________________\n\n");
    
    // user input will be taken in as a string to allow for error checking
    scanf("%s", &choice);
        
    // converting choice to an int value (if the user has entered a character its value will be 0)
    menuChoice = atoi(choice);
        
    // Checking the number the user entered 
    switch(menuChoice)
    {
        case 1:
        {
            //this loop will run until the user correctly enters their 4 digit code
            do
            {
                errorCount = 0;
                
                //initialising all elements in the array to 0 (clearing any previously entered values)
                for(i=0; i<SIZE; i++)
                {
                    *(user_code + i) = 0;
                }
        
                printf("\nEnter your code\n");
                
                // take in the users numbers
                for(i=0; i<SIZE; i++)
                {
                    // user input will be taken in as a string to allow for error checking
                    scanf("%s", &temp); 
                    
                    // converting choice to an int value (if the user has entered a character its value will be 0)
                    number = atoi(temp);
                    
                    //check if the user's number is within the range 0-9
                    if(number<0 || number>9)
                    {
                        errorCount++;
                    }
                    else
                    {
                        *(user_code + i) = number;
                    }
                    
                }//end for
            
                
                
                if(errorCount>0)
                {
                    printf("\nError. Invalid code");
                }
                else
                {
                    code_assigned = 1;  //this will allow the do while loop to end
                }
                
            }//end do
            
            //when the user has entered their code correctly code_assigned will be equal to 1
            while(code_assigned == 0);
                
            //display the user's code
            printf("\nYour code is: ");
            for(i=0; i<SIZE; i++)
            {
                printf("%d ", *(user_code + i));
            }
            
            printf("\nCode stored successfully");
                
            break;    
        }//end case 1
        
        case 2:
        {
            printf("\nGenerating a random code");
            
            //assign the user a random code
            for(i=0; i<SIZE; i++)
            {
                // number is assigned a random number between 0 and 9
                number = rand() % 9 + 0;
                *(user_code + i) = number;
            }
            
            //display the user's code
            printf("\nYour code is: ");
            for(i=0; i<SIZE; i++)
            {
                printf("%d ", *(user_code + i));
            }
            
            printf("\nCode stored successfully");
            
            code_assigned = 1;
            
            break;
        }//end case 2
        
        default:
        {
            printf("\nError. Invalid number. You must choose 1 or 2");
        }
        
    }// end switch
        
    return code_assigned;   //this value will be needed in main for accessing other menu options
    
}//end input()






// function for using an encyption algorithm to encrypt the users code
int encryptCode(int u_code[])
{
    int tmp;
    int i;
    int encrypted = 1;
    
    printf("\n2. Encrypt code\n");
    
    //Swap the 1st number with the 3rd number
    tmp = *(u_code + 0);
    *(u_code + 0) = *(u_code + 2);
    *(u_code + 2) = tmp;
   
    
    //Swap the 2nd number with the 4th number
    tmp = *(u_code + 1);
    *(u_code + 1) = *(u_code + 3);
    *(u_code + 3) = tmp;
    
    
    //Add 1 to each number
    for(i=0; i<SIZE; i++)
    {
        *(u_code + i) = *(u_code + i) + 1;
        
        //If any number has a value equal to 10, change this value to 0
        if(*(u_code + i)==10)
        {
            *(u_code + i) = 0;
        }//end if
    }//end for
    
    
    //display the user's encrypted code
    printf("\nYour encrypted code is: ");
    for(i=0; i<SIZE; i++)
    {
        printf("%d ", *(u_code + i));
    }
    
    return encrypted;   //ths value will be needed in main for accessing other menu options
      
}//end encryptCode()







// function to compare the user's code to the access code to check for a match. It also records if the code was right or wrong
void checkForMatch(int code_user[], struct code_counter *statistics)
{
    const int access_code[SIZE] = {4,5,2,3};    //this array is constant meaning its values cant be changed
    int match = 0;
    int i;
    
    printf("\n3. Check if the encrypted code matches the access code\n");
    
    //display the user's code
    printf("\nYour code is: ");
    for(i=0; i<SIZE; i++)
    {
        printf("%d ", *(code_user + i));
    }
    
    //check if the arrays match
    for(i=0; i<SIZE; i++)
    {
        //check if each corresponding element matches
        if(*(code_user + i) == *(access_code + i))
        {
            match++;    //increment match
        }//end if
        
    }//end for
    
    
    //there must be 4 matches to get the code right
     if(match==4)
    {
        printf("\nCorrect Code entered");
        (statistics->correct_code)++;   //increment the number in correct_code in the struct
    }
    else
    {
        printf("\nWrong Code entered");
        (statistics->wrong_code)++;   //increment the number in wrong_code in the struct
    }
    
}//end checkForMatch()






// function for using a decyption algorithm to decrypt the users code
void decryptCode(int uCode[])
{
    int tmp;
    int i;
    
    printf("\n4. Decrypt code\n");
    
    //Subtract 1 from each number
    for(i=0; i<SIZE; i++)
    {
        *(uCode + i) = *(uCode + i) - 1;
        
        //If any number has a value equal to -1, change this value to 9
        if(*(uCode + i)==-1)
        {
            *(uCode + i) = 9;
        }//end if
        
    }//end for
    
    
    //Swap the 1st number with the 3rd number
    tmp = *(uCode + 0);
    *(uCode + 0) = *(uCode + 2);
    *(uCode + 2) = tmp;
    
    
    //Swap the 2nd number with the 4th number
    tmp = *(uCode + 1);
    *(uCode + 1) = *(uCode + 3);
    *(uCode + 3) = tmp;
    
    
    //display the decrypted code
    printf("\nYour decrypted code is: ");
    for(i=0; i<SIZE; i++)
    {
        printf("%d ", *(uCode + i));
    }
    
}//end decryptCode()





//function that displays the ammount of times the user got the access code right and wrong throughout the run of the program
void countRightWrong(struct code_counter *statist)
{
    printf("\n5. Display the number of times the encrypted code was right/wrong\n");
    
    printf("\nAccess code was entered right %d time(s)",statist->correct_code);
    printf("\nAccess code was entered wrong %d time(s)",statist->wrong_code);
    
}//end countRightWrong()





// function to display the users code
void displayUserCode(int code[])
{
    printf("\n6. Display user's code\n");
    
    int i;
    
    printf("\nUser's code: ");
    
    // display the user's code
    for(i=0; i<SIZE; i++)
    {
        printf("%d ", *(code + i));
    }
    
}//end displayUserCode()





// function that will end the program by returning 1 to main
int exit()
{
    printf("\n7. Exit program\n");
    
    int shutDown = 1;
    printf("\nSystem is shutting down...");
    printf("\nPress enter to exit");
    
    // passing shutDown back to main() which wll end the program
    return shutDown;
    
}//end exit()







