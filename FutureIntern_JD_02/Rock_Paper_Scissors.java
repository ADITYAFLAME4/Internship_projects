import java.util.*;
public class Rock_Paper_Scissors {
    static int cpuScore = 0;
    static int playerScore = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //To repeat game or exit!

        int playTime = 1;
        

        do { 
            String humanPlayerTurn;
            String computerPlayerTurn;
            System.out.print("Enter any of the options, 'R' = Rock , 'P' = Paper , 'S' = Scissors :");
            char ch = sc.next().charAt(0);

            if(ch == 'R' || ch == 'r'){

                humanPlayerTurn = "Rock";
                System.out.println("--------------------------------------------------------------");
                System.out.println("YOU:   Rock!");
                computerPlayerTurn = ComputerPlayer();
                WinOrLoose( humanPlayerTurn ,computerPlayerTurn );
                System.out.println("[Your Score:  "+ Rock_Paper_Scissors.playerScore + "," + " CPU Score: "+ Rock_Paper_Scissors.cpuScore + " ]");
                playTime = Repeat();
            }

            else if(ch == 'P' || ch == 'p'){
                humanPlayerTurn = "Paper";
                System.out.println("--------------------------------------------------------------");
                System.out.println("YOU:   Paper!");
                computerPlayerTurn = ComputerPlayer();
                WinOrLoose( humanPlayerTurn ,computerPlayerTurn );
                System.out.println("[Your Score:  "+ Rock_Paper_Scissors.playerScore + "," + " CPU Score: "+ Rock_Paper_Scissors.cpuScore + " ]");
                playTime = Repeat();
            }

            else if(ch == 'S' || ch == 's'){
                humanPlayerTurn = "Seasors";
                System.out.println("--------------------------------------------------------------");
                System.out.println("YOU:   Scissors!");
                computerPlayerTurn = ComputerPlayer();
                WinOrLoose( humanPlayerTurn ,computerPlayerTurn );
                System.out.println("[Your Score:  "+ Rock_Paper_Scissors.playerScore + "," + " CPU Score: "+ Rock_Paper_Scissors.cpuScore + " ]");
                playTime = Repeat();
            }

            else{
                System.out.println("Please give valid input------->");
                System.out.println("[Your Score:  "+ Rock_Paper_Scissors.playerScore + "," + " CPU Score: "+ Rock_Paper_Scissors.cpuScore + " ]");
                continue;
            }
        } while (playTime > 0);
    }

    //Repeat
    public static int Repeat(){
        Scanner input = new Scanner(System.in);
        System.out.println("Do you want to play again ?");
        System.out.print("Press 'Y' to Continue or anykey then enter key to Exit ! :");

        char restart = input.next().charAt(0);
        
                if (restart == 'Y' || restart == 'y'){

                    System.out.print("\033[H\033[2J");
                    System.out.flush();
        
                    System.out.println("[Your Score:  "+ Rock_Paper_Scissors.playerScore + "," + " CPU Score: "+ Rock_Paper_Scissors.cpuScore + " ]");
                    return 1;
                }
                else {
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
        
                    System.out.println("[Your Score:  "+ Rock_Paper_Scissors.playerScore + "," + " CPU Score: "+ Rock_Paper_Scissors.cpuScore + " ]");
                    System.out.println("--------------------------------------------------------------");
                    
                    if(Rock_Paper_Scissors.playerScore == Rock_Paper_Scissors.cpuScore )
                        System.out.println("Match Draw ! :) ");
                    else if (Rock_Paper_Scissors.playerScore > Rock_Paper_Scissors.cpuScore )
                        System.out.println("Congratulations ! , you have won the match! :D ");
                    else 
                        System.out.println("Better luck next time ! , CPU have won the match. :( ");

                    System.out.println("Thanks for playing the Rock-Paper-Scissors Game ! :) ");

                    return 0;
                }

    }
    //Defining the Computer Player

    public static String ComputerPlayer(){
        // Define the string containing the characters
        String s = "rRpPsS";

        // Create an instance of the Random class
        Random random = new Random();

        // Generate a random index based on the length of the string
        int randomIndex = random.nextInt(s.length());

        // Get the character at the randomly generated index
        char randomChar = s.charAt(randomIndex);

        if(randomChar == 'R' || randomChar == 'r' ){

            System.out.println("CPU:   Rock!");

            return "Rock";

        }
        else if(randomChar == 'P' || randomChar == 'p' ){
            System.out.println("CPU:   Paper!");

            return "Paper";
           
        }
        else{
            System.out.println("CPU:   Scissors!");

            return "Scissors";
           
        }
    }

    //To Check if the player scored or not

    public static void WinOrLoose(String humanTurn, String cpuTurn){

        if (humanTurn == cpuTurn){
            System.out.println("--------------No score changed ! --------------");
            return;
        }
        else if(humanTurn == "Rock" &&  cpuTurn == "Paper")
        {
            System.out.println("-------------- CPU won ! --------------");
            Rock_Paper_Scissors.cpuScore ++;
            return;
        }
        else if (humanTurn == "Paper" && cpuTurn == "Rock"){
            System.out.println("-------------- You won ! --------------");
            Rock_Paper_Scissors.playerScore ++;
            return;
        }
        else if(humanTurn == "Rock" && cpuTurn == "Scissors"){
            System.out.println("-------------- You won ! --------------");
            Rock_Paper_Scissors.playerScore ++;
            return;
        }
        else if(humanTurn == "Scissors" && cpuTurn == "Rock"){
            System.out.println("-------------- CPU won ! --------------");
            Rock_Paper_Scissors.cpuScore ++;
            return;
        }
        else if(humanTurn == "Scissors" && cpuTurn == "Paper"){
            System.out.println("-------------- You won ! --------------");
            Rock_Paper_Scissors.playerScore ++;
            return;
        }
        else{
            System.out.println("-------------- CPU won ! --------------");
            Rock_Paper_Scissors.cpuScore ++;
            return;
        }


    }
}
