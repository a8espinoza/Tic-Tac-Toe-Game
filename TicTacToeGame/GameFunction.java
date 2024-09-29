
/*
 * This class is designed to contain the functionality portion of the tic tac toe game, ie it
 * has the code which holds the rules and actual game board data while GameMenu is only visuals and input
 */
public class GameFunction {
	int[][] functionalBoard = new int[3][3];
	int[] players = new int[2];
	int player1, player2;
 	
	public GameFunction() {
		player1 = 0;
		player2 = 1;
		
		players[0] = player1;
		players[1] = player2;
	}
	
	//return true if game over
	boolean nextTurn(int givenPlayer, int xPos, int yPos) {
		//add given players piece to the board
		functionalBoard[xPos][yPos] = givenPlayer;
		
		//if given player won: end game
		return checkForWinner(givenPlayer);
		
		
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
				}
			}
			//after iterating through one row: check if its a winner
			if(count >= 3) {
				return true;
			}else {
				count = 0;
			}
		}
		//check columns
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(functionalBoard[j][i] == givenPlayer) {
						count++;
				}
			}
			//after iterating through one column: check if its a winner
			if(count >= 3) {
				return true;
			}else {
				count = 0;
			}
		}

		//check diagonals
		//do this part later because its hurting my brain
		
		//if no winner found:
		return false;
	}
}
