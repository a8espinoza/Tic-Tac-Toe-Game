import java.util.ArrayList;
import java.util.Random;

/*
 * This class is designed to contain the functionality portion of the tic tac toe game, ie it
 * has the code which holds the rules and actual game board data while GameMenu is only visuals and input
 */
public class GameFunction {
	int[][] functionalBoard = new int[3][3];
	int[] players = new int[2];
	int player1, player2;
	
	public GameFunction() {
		player1 = 1;
		player2 = 2;
		
		players[0] = player1;
		players[1] = player2;
	}
	
	//return true if game over
	boolean nextTurn(int givenPlayer, int xPos, int yPos) {
		//add given players piece to the board
		functionalBoard[xPos][yPos] = givenPlayer;
		
		//if given player won: end game
		boolean someoneWon = checkForWinner(givenPlayer);
		//boolean checkForTie = checkForTie(someoneWon);
		
		return someoneWon;
		
	}
	/* This method checks the board for if the given player won. Returns true if won */
	boolean checkForWinner(int givenPlayer) {
		//boolean rowsGood = true, columnsGood = true, diagonalsGood = true;
		int count = 0;
		
		//check rows
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(functionalBoard[i][j] == givenPlayer) {
						count++;
						System.out.println("Count: " + count);
				}
				//else break;
			}
			//after iterating through one row: check if its a winner
			if(count >= 3) {
				return true;
			}else {
				count = 0;
				System.out.println("Count: " + count);

			}
		}
		//check columns
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(functionalBoard[j][i] == givenPlayer) {
						count++;
						System.out.println("Count: " + count);

				}
				//else break;
			}
			//after iterating through one column: check if its a winner
			if(count >= 3) {
				return true;
			}else {
				count = 0;
				//System.out.println("Count: " + count);

			}
		}

		//check top down  diagonal
		if(functionalBoard[0][0] == givenPlayer) {
			if(functionalBoard[1][1] == givenPlayer) {
				if(functionalBoard[2][2] == givenPlayer) {
					return true;
				}
			}
		}
		//check bottom up  diagonal
		if(functionalBoard[0][2] == givenPlayer) {
			if(functionalBoard[1][1] == givenPlayer) {
				if(functionalBoard[2][0] == givenPlayer) {
					return true;
				}
			}
		}
		
		
		//if no winner found:
		return false;
	}
	
	//check if board is full and no winner found
	boolean checkForTie(boolean someoneWon) {

		boolean allSpacesFull = false;
		//check if board is full
		for(int i = 0; i<3; i++) {
			for(int j = 0; j<3; j++) {
				if(functionalBoard[i][j] == 0) {
					allSpacesFull = false;
				}
			}
		}
		//if the board is full and no winner: return tie
		if(allSpacesFull && !someoneWon) {
			return true;
		}
		return false;
	}

	/** Moves the bot (player 2) */
	int pos, pos1, pos2;
	Random random = new Random();
	ArrayList<int[]> emptySpaces = new ArrayList<int[]>();
	boolean positionFound = false;
	int[] movePlayer2Bot(){
		//add all empty spaces to a list
		boolean hasEmptySpace = false;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if(functionalBoard[i][j] == 0) {
					hasEmptySpace = true;
					emptySpaces.add(new int[]{i, j});
					System.out.println("Empty Space: " + i + " " + j);
				}
			}

			// If no empty space is found, return failedPosition
			if(!hasEmptySpace) {
				int[] failedPosition = {-1, -1};
				System.out.println("failedPosition: " + failedPosition[0]
											    + " " + failedPosition[1]);
				return failedPosition;
			}
		}
		//generate random position (knowing its not empty)
		while(!positionFound){
			pos = random.nextInt(emptySpaces.size());
			pos1 = emptySpaces.get(pos)[0];
			pos2 = emptySpaces.get(pos)[1];
			System.out.println("Position1: "+ pos1 +" Position2: "+ pos2);
	
			//obtain randomly generated position and return 
			if(functionalBoard[pos1][pos2] == 0){
				functionalBoard[pos1][pos2] = 2;
				positionFound = true;
				int[] position = {pos1, pos2};
				System.out.println("Position: "+position[0] +" "+ position[1]);
				return position;
			}
			printBoard();
		}

		//fallback (should never happen)
		int[] failedPosition = {-1, -1};
		System.out.println("failedPosition: "+ failedPosition);
		return failedPosition;
	}

	//print board for debugging
	void printBoard() {
		for(int i = 0; i<3; i++) {
			for(int j = 0; j<3; j++) {
				System.out.print(functionalBoard[i][j] + " ");
			}
			System.out.println();
		}
	}
		
}
