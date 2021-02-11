
import java.util.*;

public class  TicTacToe {

	static Scanner sc = new Scanner(System.in);
	static String board[];
	static String turn;
	public static int playerPosition;
	public static int computerPosition;
	public static String playerLetter;
	public static String computerLetter;
	//public static int flag=0;

    	//Display the board
	static void showBoard() {

		System.out.println("  " + board[0] + " | " + board[1] + " | " + board[2]);
		System.out.println("_______________");
		System.out.println("  " + board[3] + " | " + board[4] + " | " + board[5]);
		System.out.println("_______________");
		System.out.println("  " + board[6] + " | " + board[7] + " | " + board[8]);

	}
	
	String choosePlayer() 
	{
		int toss = (int) (Math.floor(Math.random() * 10) % 2);

		if(toss==1)
		{
			playerLetter = "X";
			computerLetter = "O";
			turn=playerLetter;
			System.out.println("Player Starts the game \n Player Letter = X \n Computer Letter = O");
			//flag=1;
		}
		else
		{
			playerLetter = "O";
			computerLetter = "X";
			turn=computerLetter;
			System.out.println("Player Starts the game \n Player Letter = O \n Computer Letter = X");
			//flag=1;		
		}
		return turn;
	}
 	
		
	static void updateBoard() {
		for (int index = 0; index < 9; index++) {
			board[index] = String.valueOf(index + 1);
		}
	}
	
	
	String checkWinner() {

		for (int index = 0; index < 8; index++) {
			String line = null;
			switch (index) {
			case 0:
				line = board[0] + board[1] + board[2];
				break;
			case 1:
				line = board[3] + board[4] + board[5];
				break;
			case 2:
				line = board[6] + board[7] + board[8];
				break;
			case 3:
				line = board[0] + board[3] + board[6];
				break;
			case 4:
				line = board[1] + board[4] + board[7];
				break;
			case 5:
				line = board[2] + board[5] + board[8];
				break;
			case 6:
				line = board[0] + board[4] + board[8];
				break;
			case 7:
				line = board[2] + board[4] + board[6];
				break;
			}
			if (line.equals("XXX")) {
				return "X";
			} else if (line.equals("OOO")) {
				return "O";
			}
		}
        	 //For Checking draw values
		for (int index = 0; index < 9; index++) {
			if (Arrays.asList(board).contains(String.valueOf(index + 1))) {
				break;
			} else if ( index == 8) {
				return "Draw";
			}
		}
		return null;
	}
	
	public void isPlay() {
		//if(flag==0){
			turn = new  TicTacToe().choosePlayer();
		//}
		//else
		//	turn = new  TicTacToe().shiftPlayer();
		updateBoard();
		
		System.out.println("Welcome to Tic Tac Toe game \n");
		showBoard();


		String winner = null;
		while (winner == null) {

			// Computer's Move
			if (turn == computerLetter) {
				System.out.println("It's Computer turn");
				int computerPosition = (int) (Math.floor(Math.random() * 10) % 9);
				System.out.println(computerPosition);
				
			try
			{
				if (!(computerPosition > 0 && computerPosition <= 9))
				{
					System.out.println("Invalid input; re-enter slot number:");
					continue;
				}
			}
			catch (InputMismatchException e)
			{
				System.out.println("Invalid input; re-enter slot number:");
				continue;
			}

				if (board[computerPosition - 1].equals(String.valueOf(computerPosition))) {
					board[computerPosition - 1] = turn;
					if (turn.equals(computerLetter)) {
						turn = playerLetter;
					} 
					else {
						turn = computerLetter;
					}
					showBoard();
					winner = new  TicTacToe().checkWinner();
					System.out.println(winner);
					showBoard();

				}

				else {
					System.out.println("Slot already taken!! Re-enter slot number:");
					computerPosition = (int) (Math.floor(Math.random() * 10) % 9);
					System.out.println(computerPosition);
					continue;
				}
			}

			// Player's Move
			else {
				System.out.println("Player's turn. Enter Slot number to place :  ");
				try {
					playerPosition = sc.nextInt();
					if (!(playerPosition > 0 && playerPosition <= 9)) {
						System.out.println("Invalid input!! Re-enter slot number:");
						continue;
					}
				}

				catch (InputMismatchException e) {
					System.out.println("Invalid input!! Re-enter slot number:");
					continue;
				}

				if (board[playerPosition - 1].equals(String.valueOf(playerPosition))) {
					board[playerPosition - 1] = turn;
					if (turn.equals(playerLetter)) {
						turn = computerLetter;
					} else {
						turn = playerLetter;
					}
					showBoard();
					winner = new  TicTacToe().checkWinner();
					System.out.println(winner);
					showBoard();

				}

				else {
					System.out.println("Slot already taken!! Re-enter slot number : ");
					continue;
				}
			}

		}
		if (winner.equalsIgnoreCase("Draw")) {
			System.out.println("It's a draw! \"Better Luck Next Time\" Thank You");
		}

		else {
			if(playerLetter == winner)		
				System.out.println("Congratulations! Player's Won the Game, Thank You");
			else
				System.out.println("Computer's Won. \"Better Luck Next Time\", Thank You");
		}


	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		board = new String[9];
		updateBoard();
		
		new  TicTacToe().isPlay();
	}

}