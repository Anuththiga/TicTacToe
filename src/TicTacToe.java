import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
	
	static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
	static ArrayList<Integer> computerPositions = new ArrayList<Integer>();


	public static void main(String[] args) {
		char[][] gameBoard = { { ' ', '|', ' ', '|', ' ' }, { '-', '+', '-', '+', '-' }, { ' ', '|', ' ', '|', ' ' },
				{ '-', '+', '-', '+', '-' }, { ' ', '|', ' ', '|', ' ' }, };
		printGameBoard(gameBoard);
		
		while(true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the Position(1-9): ");
			int playPosition = sc.nextInt();
			while(playerPositions.contains(playPosition) || computerPositions.contains(playerPositions)) {
				System.out.println("Position taken! Enter a new Position...");
				playPosition = sc.nextInt();
			}

			System.out.println(playPosition);
			
			piecePlace(gameBoard, playPosition, "Player");
			
			String win = checkWinning();
			if(win.length() > 0) {
				System.out.println(win);
			}
			
			Random random = new Random();
			int compPosition = random.nextInt(9) + 1;
			while(playerPositions.contains(compPosition) || computerPositions.contains(compPosition)) {
				compPosition = random.nextInt(9) + 1;
			}
			
			piecePlace(gameBoard, compPosition, "Computer");
			
			printGameBoard(gameBoard);
			
			
			win = checkWinning();
			if(win.length() > 0) {
				System.out.println(win);
			}
			
		}

		
	}

	public static void printGameBoard(char[][] gameBoard) {
		for (char[] row : gameBoard) {
			for (char c : row) {
				System.out.print(c);
			}
			System.out.println();
		}
	}

	public static void piecePlace(char[][] gameBoard, int position, String user) {
		char symbol = ' ';
		if(user.equals("Player")) {
			symbol = 'X';
			playerPositions.add(position);
		} else if(user.equals("Computer")) {
			symbol = 'O';
			computerPositions.add(position);
		}
		
		switch (position) {
		case 1:
			gameBoard[0][0] = symbol;
			break;
		case 2:
			gameBoard[0][2] = symbol;
			break;
		case 3:
			gameBoard[0][4] = symbol;
			break;
		case 4:
			gameBoard[2][0] = symbol;
			break;
		case 5:
			gameBoard[2][2] = symbol;
			break;
		case 6:
			gameBoard[2][4] = symbol;
			break;
		case 7:
			gameBoard[4][0] = symbol;
			break;
		case 8:
			gameBoard[4][2] = symbol;
			break;
		case 9:
			gameBoard[4][4] = symbol;
			break;
		default:
			break;
		}
	}
	
	public static String checkWinning() {
		
		List topRow = Arrays.asList(1,2,3);
		List middleRow = Arrays.asList(4,5,6);
		List bottomRow = Arrays.asList(7,8,9);
		List leftCol = Arrays.asList(1,4,7);
		List middleCol = Arrays.asList(2,5,8);
		List rightCol = Arrays.asList(3,6,9);
		List cross1 = Arrays.asList(1,5,9);
		List cross2 = Arrays.asList(3,5,7);
		
		List<List> winning = new ArrayList<List>();
		winning.add(topRow);
		winning.add(middleRow);
		winning.add(bottomRow);
		winning.add(leftCol);
		winning.add(middleCol);
		winning.add(rightCol);
		winning.add(cross1);
		winning.add(cross2);
		
		for(List l : winning) {
			if(playerPositions.containsAll(l)) {
				return "Congratulations you won!";
			} else if(computerPositions.containsAll(l)) {
				return "Computer wins :(";
			} else if(playerPositions.size() + computerPositions.size() == 9) {
				return "CAT";
			}
		}
		
	

		
		return "";
	}

}
