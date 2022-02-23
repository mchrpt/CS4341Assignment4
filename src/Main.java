import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
	static Integer[][] boardFile;
	static int boardHeight, boardWidth;
	public static void main(String[] args) throws FileNotFoundException {


		if(Objects.equals(args[0], "board.txt")) {
			try {
				File board = new File("C:\\Users\\Josh\\Documents\\CS4341Assignment4\\Boards\\board.txt");
				BoardGenerator board1 = new BoardGenerator();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		String fileName = "C:\\Users\\Josh\\Documents\\CS4341Assignment4\\Boards\\sample.txt";
		//float timeToRun = Float.parseFloat(args[1]);
		//float probDesiredDirection = Float.parseFloat(args[2]);
		//float constantReward = Float.parseFloat(args[3]);
		openFile(fileName);
		printBoard(boardFile);
		Board b = new Board(boardHeight,boardWidth,boardFile);
		
		
	}
	
	
	private static void openFile(String fileName) throws FileNotFoundException {
	
		File myObj = new File(fileName);
		Scanner myReader = new Scanner(myObj);
		ArrayList<Integer[]> rows = new ArrayList<Integer[]>();
		while (myReader.hasNextLine()) {
			String data = myReader.nextLine();
			String[] boardRowStr = data.split("\\t");
			Integer[] boardRow = new Integer[boardRowStr.length];
			boardWidth = boardRowStr.length;

			for(int i = 0;i < boardRowStr.length;i++)
			{
				boardRow[i] = Integer.parseInt(boardRowStr[i]);
			}
			boardHeight = rows.size();
			rows.add(boardRow);
			boardFile = new Integer[rows.size()][boardRow.length];
			int i = 0;
			for(Integer[] row : rows) {
				boardFile[i] = row;
				i++;
			}
			
			
		}
		
		myReader.close();
	}
	private static void printBoard(Integer[][] boardFile) {
		for(int i = 0; i < boardFile.length; i++) {
			for(int j = 0; j < boardFile[i].length; j++) {
				System.out.print(boardFile[i][j] + ", ");
			}
			System.out.println();
		}
	}


}
