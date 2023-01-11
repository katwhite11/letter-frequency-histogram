/*
author: Kathryn White
purpose:  This program receives input from the user and then displays it into a vertical histogram
displaying frequency of each alphabet letter in the sentence. It does not display non alphabetical characters.
*/

import java.util.Scanner;

class Histogram{
    //instance fields
    String text;
    
    Histogram(){
        text = "I love problem-solving."; //default statement
        text = text.toLowerCase();
    }
    
    //sets text to whatever the user inputs
    public void setText(String t){
        text = t;
    }
    
    //displays vertical histogram of alphabet frequency
    public void drawHistogram(){
        //instance fields
        int[] alphaCounter = new int[26];
        int max, temp;
        
        //stores num of instances of each letter in an array
        for(int i = 0; i<text.length();i++){
            temp = (int)text.charAt(i);
            temp = temp-97;
            if(temp>=0 && temp<=25){
                alphaCounter[temp] +=1;
            }
        }
        
        max = alphaCounter[0];
        
        //finds max number of instances in the array
        for(int j=1; j<alphaCounter.length;j++){
            if (max < alphaCounter[j])
                max = alphaCounter[j];
        }
        
        //sets height of histogram to max instances and prints a star for each instance
        for(int k = max; k >=1; k--){
            for(int l = 0; l<26; l++){
                if(alphaCounter[l] >= k)
                    System.out.print(" *");
                else
                    System.out.print("  ");
            }
            System.out.println();
        }
        System.out.println("----------------------------------------------------");
        System.out.println(" a b c d e f g h i j k l m n o p q r s t u v w x y z");
        
        
        
         
    }
}
public class Hw06 {

    public static void main(String[] args) {
        //TEST
        
        Scanner in = new Scanner(System.in);
        Histogram test = new Histogram();
        String userInput, secondInput;
        
        //main menu for user selection
        do{
            System.out.println("Please select from the following menu:");
            System.out.println("T: Enter a text");
            System.out.println("P: Plot frequencies");
            System.out.println("Q: Quit");
            System.out.println();
            System.out.println("Select: ");
            
            //receives user input
            userInput = in.nextLine();
            userInput = userInput.toLowerCase();
            
            switch(userInput.charAt(0)){
                case 't':
                    System.out.println("What text would you like to set?");
                    
                    //receives user input
                    secondInput = in.nextLine();
                    secondInput = secondInput.toLowerCase();
                    test.setText(secondInput);
                    
                    System.out.println("Text has been set.");
                    break;
                case 'p':
                    test.drawHistogram();
                    break;
                case 'q':
                    System.out.println("Goodbye.");
                    break;
                default:
                    System.out.println("Invalid response.");
                
            }
        //while loop checks if user has input 'q' to quit program, will continue to run until q is entered
        }while(userInput.charAt(0)!= 'q');

    }
    
}
