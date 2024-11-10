import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int sysNum = (int)(Math.random()*100);
        int usrNum;
        int count = 0;
        do{
            System.out.print("Guess any number (1-100): ");
            usrNum = input.nextInt();
            if(sysNum == usrNum){

                System.out.print("\033[H\033[2J");
                System.out.flush();

                System.out.println("yay! you guessed the number in " + count + " tries!");

                System.out.println("Do you want to play again ?");
                System.out.println("Press 'Y' to Continue or anykey then enter key to Exit !");
        
                char restart = input.next().charAt(0);
        
                if (restart == 'Y' || restart == 'y'){
                    continue;
                }
                else {
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
            
                    System.out.println("Thanks for playing the Number Guessing Game ! :) ");
                    break;
                }
            }

            else if(sysNum > usrNum){
                System.out.println("Your guess is too small! Try again, Haha!");
            }

            else{
                System.out.println("Your guess is too large! Try again, Haha!");
                }

            count ++;
        }while(usrNum >0);
    }

}