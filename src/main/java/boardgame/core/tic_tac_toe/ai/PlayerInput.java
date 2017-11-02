package boardgame.core.tic_tac_toe.ai;

import boardgame.core.Board;
import boardgame.core.Point;
import boardgame.core.tic_tac_toe.TicTacToeBoard;

import java.util.Scanner;

public class PlayerInput extends BaseAI{

	@Override
	protected Point getNextMoveImpl(TicTacToeBoard board) {
		Scanner in = new Scanner(System.in);
		Point result = null;
		do {
			System.out.println("Please enter your move in the form: X,Y\n");
			String line = in.nextLine();
			if(!line.trim().matches("[0-2],[0-2]")) {
				System.out.println("Invalid response. Try again.\n");
				continue;
			}

			String[] tokens = line.split(",");
			int x = Integer.parseInt(tokens[0]);
			int y = Integer.parseInt(tokens[1]);

			Point p = new Point(x, y);

			if(board.isOccupied(p)) {
				System.out.println("That spot is occupied. Try again.");
				continue;
			}

			result = p;
		}while(result == null);

		return result;
	}
}
