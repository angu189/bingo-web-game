import java.util.Random;
import java.util.ArrayList;

public class BingoGame {
	
	public static void main(String[] args) {
		ArrayList<String> calledNums = new ArrayList<>();
		String[][] board = createBoard();
		String result = null;
		
		printBoard(board);
		while(calledNums.size() < 75 && result == null) {
			callNum(calledNums, board);
			printBoard(board);
			
			while (calledNums.size() < 75 && result == null) {
			    callNum(calledNums, board);
			    printBoard(board);

			    if (winRow(board) != null) {
			        result = "BINGO! (Row)";
			    } else if (winCol(board) != null) {
			        result = "BINGO! (Column)";
			    } else if (winDiag(board) != null) {
			        result = "BINGO! (Diagonal)";
			    }
			}

		}
		
		System.out.print("\n" + result);
		System.exit(0);
	}
	
	public static String[][] createBoard() {
		String[][] board = new String[5][5];
		
		//Get Columns
		String[] B = setB();
		String[] I = setI();
		String[] N = setN();
		String[] G = setG();
		String[] O = setO();
		
		//Set Columns into Board
		for(int i = 0; i < 5; i++) {
			board[i][0] = B[i];
		}
		
		for(int i = 0; i < 5; i++) {
			board[i][1] = I[i];
		}
		
		for(int i = 0; i < 5; i++) {
			board[i][2] = N[i];
		}
		
		for(int i = 0; i < 5; i++) {
			board[i][3] = G[i];
		}
		
		for(int i = 0; i < 5; i++) {
			board[i][4] = O[i];
		}
		return board;
	}
	
	public static void printBoard(String[][] arr) {
		System.out.println("B\tI\tN\tG\tO\n");
		for(int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[row].length; col++) {
				System.out.print(arr[row][col] + "\t");
			}
			System.out.println();
		}
	}
	
	public static void callNum(ArrayList<String> arrL, String[][] arr) {
		Random rand = new Random();
		String value = Integer.toString(rand.nextInt(75) + 1);
		System.out.print("\nCalled Number: ");
		
		while (arrL.contains(value)) {
			value = Integer.toString(rand.nextInt(75) + 1);
		}
		
		arrL.add(value);
		System.out.println(value + "\n");
		
		for(int row = 0; row < arr.length; row++) {
			for(int col = 0; col < arr[row].length; col++) {
				if (arr[row][col].equals(value)) {
					arr[row][col] = "X";
				}
			}
		}
	}
	
	public static String winCol(String[][] arr) {
		for (int col = 0; col < 5; col++) {
			int count = 0;
			for (int row = 0; row < 5; row++) {
				if (arr[row][col].equals("X")) {
					count++;
				}
			}
			if (count == 5) {
				return "BINGO!";
			} 
		}
		return null;
	}
	
	public static String winRow(String[][] arr) {
		for (int row = 0; row < 5; row++) {
			int count = 0;
			for (int col = 0; col < 5; col++) {
				if (arr[row][col].equals("X")) {
					count++;
				}
			}
			if (count == 5) {
				return "BINGO!";
			} 
		}
		return null;
	}
	
	public static String winDiag(String[][] arr) {
		boolean diag1 = true;
		boolean diag2 = true;
		
		for(int i = 0; i < 5; i++) {
			if (!arr[i][i].equals("X")) {
				diag1 = false;
			}
			if (!arr[i][4 - i].equals("X")) {
				diag2 = false;
			}
		}
		
		if (diag1 || diag2) {
			return "BINGO!";
		}
		
		return null;
	}
	
	public static String[] setB() {
		Random rand = new Random();
		String[] BCol = new String[5];
		
		for(int i = 0; i < BCol.length; i++) {
			String value = Integer.toString(rand.nextInt(15) + 1);
			while (contains(BCol, value)) {
				value = Integer.toString(rand.nextInt(15) + 1);
			}
			BCol[i] = value;
		}
		return BCol;
	}
	
	public static String[] setI() {
		Random rand = new Random();
		String[] ICol = new String[5];
		
		for(int i = 0; i < ICol.length; i++) {
			String value = Integer.toString(rand.nextInt(15) + 16);
			while (contains(ICol, value)) {
				value = Integer.toString(rand.nextInt(15) + 16);
			}
			ICol[i] = value;
		}
		return ICol;
	}
	
	public static String[] setN() {
		Random rand = new Random();
		String[] NCol = new String[5];
		
		for(int i = 0; i < NCol.length; i++) {
			if (i == 2) {
				NCol[i] = "X";
			} else {
				String value = Integer.toString(rand.nextInt(15) + 31);
				while (contains(NCol, value)) {
					value = Integer.toString(rand.nextInt(15) + 31);
				}
				NCol[i] = value;
			}
		}
		return NCol;
	}
	
	public static String[] setG() {
		Random rand = new Random();
		String[] GCol = new String[5];
		
		for(int i = 0; i < GCol.length; i++) {
			String value = Integer.toString(rand.nextInt(15) + 46);
			while (contains(GCol, value)) {
				value = Integer.toString(rand.nextInt(15) + 46);
			}
			GCol[i] = value;
		}
		return GCol;
	}
	
	public static String[] setO() {
		Random rand = new Random();
		String[] OCol = new String[5];
		
		for(int i = 0; i < OCol.length; i++) {
			String value = Integer.toString(rand.nextInt(15) + 61);
			while (contains(OCol, value)) {
				value = Integer.toString(rand.nextInt(15) + 61);
			}
			OCol[i] = value;
		}
		return OCol;
	}
	
	public static boolean contains(String[] arr, String value) {
		for(String s: arr) {
			if (value.equals(s)) {
				return true;
			}
		}
		return false;
	}
	
}
