 //take input from user on console.
//if input is in dictionary, give confirmation to user
                    //COOLER APPROACH : give some synonyms
//if not, give user some suggestions, numerated
    //let the user pick between all of that number.
                    //COOLER APPROACH : use AI to make a sentence out of the chosen word
//only stop the program if user says "EXIT"

//Program should still be able to check even if there are special characters
import java.util.Scanner;

public class Main_BEWS{

    private static final int MAX_WORDS = 5; //this program is limited to have at max 5 words each sentence entered
    private static iHashTable ht;
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        //INITIATE PROGRAM
        ht = new HashTable();
        System.out.println("Welcome to BEWS program (or- spell checker). Enter a word or a sentence that you would like to check for every prompt.\nType in 'EXIT' or 'exit' to terminate program.");

        String[] userInput;
        do{
            userInput = takeUserInput(scanner);
            processInput(userInput, scanner); 

            System.out.println("\n"); //console line break
        }while (userInput[0].equals("EXIT") || userInput[0].equals("exit"));

        System.out.println("Thank you for using Basic-English-Word-Suggestion!\nProgram terminated.");
    }

    /**
     * Takes and checks user input
     * User input is invalid if there is no sentence or word at all (or contains all numbers)
     * 
     * returns the valid user's input and continue program in main() method
     */
    private static String[] takeUserInput(Scanner scanner){
        boolean validInput = true;
        String[] inputs;
        do{
            System.out.print("Sentence/word>>>>> ");
            String userInput = scanner.nextLine();
            inputs = userInput.split("\s+"); //TODO check if this actually deletes any amount of spaces. if not, loop through and use .trim()

            //INPUT CHECKS
            validInput = userInput.length() != 0 || inputs.length > 5;
            //TODO check also if the whole sentence is a number (idea : use NFException somehow)

            if(!validInput){
                System.out.println("Please enter a word or a sentence. For sentence, please input no longer than 5 words.");
            }
        }while (!validInput);
        
        return inputs;
    }   

    private static void processInput(String[] userInput, Scanner scanner){
        //CHECKING EACH WORDS
        String[] wrongWords = new String[MAX_WORDS];
        int wrongWordsPos = 0;

        boolean allValid = false;

        for (int i = 0 ; i < userInput.length ; i++){
            allValid = ht.search(userInput[i]);

            if(!allValid) { //if not found, give suggestions
                wrongWords[wrongWordsPos++] = userInput[i];
            }
        }

        //FURTHER PROCESSING FOR RIGHT & WRONG WORDS
        if (allValid){

            if (userInput.length == 1){
                System.out.print(userInput[0] + " is correct. ");
            }else{
                System.out.print("The words that you entered is correct. ");
            }

            System.out.print("Would you like to get some synonyms of the word/sentence? ");
            if (wantsSynonyms(scanner)){
                System.out.println("\nHere's the suggestion synonym list of your word(s)");

                for (int i = 0 ; i <= userInput.length; i++){
                    System.out.printf("%d. %s : \n", i+1, userInput[i]);
    
                    int synonymLength = ht.synonyms(userInput[i]).length;
                    for (int j = 0; j < synonymLength; j++){
                        System.out.printf("\t%d. %s\n", j+1, ht.synonyms(userInput[i])[j]);
                    }
                }
            }//else : continue program

        }else{
            System.out.println("\nHere's the suggestion list of your incorrect word(s)");

            for (int i = 0 ; i <= wrongWordsPos; i++){
                System.out.printf("%d. %s : \n", i+1, wrongWords[i]);

                int suggestionsLength = ht.retrieve(wrongWords[i]).length;
                for (int j = 0; j < suggestionsLength; j++){
                    System.out.printf("\t%d. %s\n", j+1, ht.retrieve(wrongWords[i])[j]);
                }
            }
        }
    }

    private static boolean wantsSynonyms(Scanner scanner){
        String userInput;
        do{
            System.out.println("Please enter 'yes' or 'no'.");
            userInput = scanner.nextLine().trim().toLowerCase();
        }while (!userInput.equals("yes") || !userInput.equals("no"));

        return userInput.equals("yes");
    }
}