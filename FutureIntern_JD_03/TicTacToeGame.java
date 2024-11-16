import java.util.*;

public class TicTacToeGame {
    public static void main(String[] args) {
        
        int playTime = 1;
        Scanner scanner = new Scanner(System.in);

        while(playTime >= 1) {
            ClearScreen();
            char[][] gridBoard = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
            System.out.println("Welcome to TicTacToe Game :D");

            System.out.println("Please Choose player --------> ");
            System.out.print("Player Vs CPU [Press 1] | Player Vs Player [Press 2] :");
            int choice = scanner.nextInt();

            switch(choice) {
                case 1:
                    ChoiceCPU(scanner, gridBoard);
                    break;
                case 2:
                    ChoicePlayers(scanner, gridBoard);
                    break;
                default:
                    System.out.println("Please give a valid input!");
            }

            System.out.println("Do you want to play again: ");
            System.out.print("Press 'Y' to Continue or anykey then enter key to Exit! :");
            char restart = scanner.next().charAt(0);

            if(restart == 'Y' || restart == 'y') {
                playTime++;
            } else {
                playTime = 0;
            }
        }

        scanner.close();
    }

    private static void ChoiceCPU(Scanner scanner, char[][] gridBoard) {
        ClearScreen();
        System.out.println("You Vs CPU !");
        printgridBoard(gridBoard);
        
        while (true) {
            playerTurn(gridBoard, scanner, 'X');
            if (isGameFinished(gridBoard)) {
                break;
            }
            printgridBoard(gridBoard);
            
            computerTurn(gridBoard);
            if (isGameFinished(gridBoard)) {
                break;
            }
            printgridBoard(gridBoard);
        }
    }

    private static void ChoicePlayers(Scanner scanner, char[][] gridBoard) {
        ClearScreen();

        System.out.print("Enter Player1 Name (Player 1 will get X ):");
        String player_Name1 = scanner.next();
        System.out.println();
        System.out.print("Enter Player2 Name (Player 2 will get O ):");
        String player_Name2 = scanner.next();

        System.out.println(player_Name1 + " Vs " + player_Name2 + " !");
        printgridBoard(gridBoard);
        
        while (true) {
            playerTurn(gridBoard, scanner, 'X', player_Name1);
            if (isGameFinished(gridBoard, player_Name1, player_Name2)) {
                break;
            }
            ClearScreen();
            printgridBoard(gridBoard);

            playerTurn(gridBoard, scanner, 'O', player_Name2);
            if (isGameFinished(gridBoard, player_Name1, player_Name2)) {
                break;
            }
            ClearScreen();
            printgridBoard(gridBoard);
        }
    }

    private static boolean isGameFinished(char[][] gridBoard) {
        if (hasContestantWon(gridBoard, 'X')) {  
            ClearScreen();
            printgridBoard(gridBoard);
            System.out.println("Player wins!");
            return true;
        }
        
        if (hasContestantWon(gridBoard, 'O')) {  
            ClearScreen();
            printgridBoard(gridBoard);
            System.out.println("CPU wins!");
            return true;
        }
        
        for (int i = 0; i < gridBoard.length; i++) {
            for (int j = 0; j < gridBoard[i].length; j++) {
                if (gridBoard[i][j] == ' ') {
                    return false;
                }
            }
        }
        ClearScreen();
        printgridBoard(gridBoard);
        System.out.println("Match draw between you and cpu!");
        return true;
    }

    private static boolean isGameFinished(char[][] gridBoard, String player_Name1, String player_Name2) {
        if (hasContestantWon(gridBoard, 'X')) {  
            ClearScreen();
            printgridBoard(gridBoard);
            System.out.println(player_Name1 + " wins!");
            return true;
        }
        
        if (hasContestantWon(gridBoard, 'O')) {  
            ClearScreen();
            printgridBoard(gridBoard);
            System.out.println(player_Name2 +" wins!");
            return true;
        }
        
        for (int i = 0; i < gridBoard.length; i++) {
            for (int j = 0; j < gridBoard[i].length; j++) {
                if (gridBoard[i][j] == ' ') {
                    return false;
                }
            }
        }
        ClearScreen();
        printgridBoard(gridBoard);
        System.out.println("Match Draw between "+ player_Name1 +" and "+ player_Name2);
        return true;
    }

    private static boolean hasContestantWon(char[][] gridBoard, char symbol) {
        return (gridBoard[0][0] == symbol && gridBoard[0][1] == symbol && gridBoard[0][2] == symbol) ||
               (gridBoard[1][0] == symbol && gridBoard[1][1] == symbol && gridBoard[1][2] == symbol) ||
               (gridBoard[2][0] == symbol && gridBoard[2][1] == symbol && gridBoard[2][2] == symbol) ||
               (gridBoard[0][0] == symbol && gridBoard[1][0] == symbol && gridBoard[2][0] == symbol) ||
               (gridBoard[0][1] == symbol && gridBoard[1][1] == symbol && gridBoard[2][1] == symbol) ||
               (gridBoard[0][2] == symbol && gridBoard[1][2] == symbol && gridBoard[2][2] == symbol) ||
               (gridBoard[0][0] == symbol && gridBoard[1][1] == symbol && gridBoard[2][2] == symbol) ||
               (gridBoard[0][2] == symbol && gridBoard[1][1] == symbol && gridBoard[2][0] == symbol);
    }

    private static void computerTurn(char[][] gridBoard) {
        Random rand = new Random();
        int computerMove;
        ClearScreen();
        while (true) {
            computerMove = rand.nextInt(9) + 1;
            if (isValidMove(gridBoard, computerMove)) {
                break;
            }
        }
        System.out.println("CPU chose " + computerMove);
        placeMove(gridBoard, computerMove, 'O');
    }

    private static boolean isValidMove(char[][] gridBoard, int position) {
        switch(position) {
            case 1: return (gridBoard[0][0] == ' ');
            case 2: return (gridBoard[0][1] == ' ');
            case 3: return (gridBoard[0][2] == ' ');
            case 4: return (gridBoard[1][0] == ' ');
            case 5: return (gridBoard[1][1] == ' ');
            case 6: return (gridBoard[1][2] == ' ');
            case 7: return (gridBoard[2][0] == ' ');
            case 8: return (gridBoard[2][1] == ' ');
            case 9: return (gridBoard[2][2] == ' ');
            default: return false;
        }
    }

    public static void playerTurn(char[][] gridBoard, Scanner scanner, char symbol) {
		int userInput = 0; 
		while (true) {
			System.out.print("Where would you like to place? (Between 1 to 9):");
			
			try {
				userInput = scanner.nextInt();  
				if (userInput >= 1 && userInput <= 9) {
					if (isValidMove(gridBoard, userInput)) {
						break; 
					} else {
						System.out.println(userInput + " is not a valid move.");
					}
				} else {
					System.out.print(userInput + " is not a valid move, Please think and put proper value! ");
				}
			} catch (InputMismatchException e) {
				ClearScreen();
				System.out.println("Invalid input. Please enter a number between 1 and 9.");
				scanner.nextLine(); 
			}
		}
		placeMove(gridBoard, userInput, symbol);
    }


	public static void playerTurn(char[][] gridBoard, Scanner scanner, char symbol,String playerName) {
		int userInput = 0; 
		while (true) {
			System.out.print(playerName + " ,Where would you like to place? (Between 1 to 9):");
			
			try {
				userInput = scanner.nextInt();  
				if (userInput >= 1 && userInput <= 9) {
					if (isValidMove(gridBoard, userInput)) {
						break; 
					} else {
						System.out.println(userInput + " is not a valid move.");
					}
				} else {
					System.out.print(userInput + " is not a valid move, Please think and put proper value now ");
				}
			} catch (InputMismatchException e) {
				ClearScreen();
				System.out.println("Invalid input. Please enter a number between 1 and 9.");
				scanner.nextLine(); 
			}
		}
		placeMove(gridBoard, userInput, symbol);
	}
	

    private static void placeMove(char[][] gridBoard, int position, char symbol) {
        switch(position) {
            case 1: gridBoard[0][0] = symbol; break;
            case 2: gridBoard[0][1] = symbol; break;
            case 3: gridBoard[0][2] = symbol; break;
            case 4: gridBoard[1][0] = symbol; break;
            case 5: gridBoard[1][1] = symbol; break;
            case 6: gridBoard[1][2] = symbol; break;
            case 7: gridBoard[2][0] = symbol; break;
            case 8: gridBoard[2][1] = symbol; break;
            case 9: gridBoard[2][2] = symbol; break;
            default: System.out.println(":(");
        }
    }

    private static void printgridBoard(char[][] gridBoard) {
        System.out.println(gridBoard[0][0] + " | " + gridBoard[0][1] + " | " + gridBoard[0][2]);
        System.out.println("--+---+--");
        System.out.println(gridBoard[1][0] + " | " + gridBoard[1][1] + " | " + gridBoard[1][2]);
        System.out.println("--+---+--");
        System.out.println(gridBoard[2][0] + " | " + gridBoard[2][1] + " | " + gridBoard[2][2]);
    }

    public static void ClearScreen(){
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }
}

