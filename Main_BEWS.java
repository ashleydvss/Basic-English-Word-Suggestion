 //take input from user on console.
//if input is in dictionary, give confirmation to user
                    //COOLER APPROACH : give some synonyms
//if not, give user some suggestions, numerated
    //let the user pick between all of that number.
                    //COOLER APPROACH : use AI to make a sentence out of the chosen word
//only stop the program if user says "EXIT"
import java.util.Scanner;;

public class Main_BEWS{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;

        initiateProgram();
        System.out.println("Welcome to BEWS program (or- spell checker). Enter a word or a sentence that you would like to check for every prompt.");
        do{
            exit = takeUserInput(scanner);
        }while (!exit);

        System.out.println("Thank you for using Basic-English-Word-Suggestion!\nProgram terminated.");
    }

    private static void initiateProgram(){
        iHashTable ht = new HashTable();
    }

    private static boolean takeUserInput(Scanner scanner){
        boolean userExit = false;

        System.out.print("Sentece/word>>>>> ");
        scanner jd
    
        return userExit;
    }   
}