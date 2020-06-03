package _04_Maze_Maker;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;


public class MazeMaker{
	
	private static int width;
	private static int height;
	
	private static Maze maze;
	
	private static Random randGen = new Random();
	private static Stack<Cell> uncheckedCells = new Stack<Cell>();
	
	
	public static Maze generateMaze(int w, int h){
		width = w;
		height = h;
		maze = new Maze(width, height);
		
		//4. select a random cell to start
		int cellX = randGen.nextInt(width);
		int cellY = randGen.nextInt(height);
		
		//5. call selectNextPath method with the randomly selected cell
		selectNextPath(maze.getCell(cellX,cellY));
		
		return maze;
	}

	//6. Complete the selectNextPathMethod
	private static void selectNextPath(Cell currentCell) {
		//A. mark cell as visited
		currentCell.setBeenVisited(true);
		//B. Get an ArrayList of unvisited neighbors using the current cell and the method below
		ArrayList<Cell> array = new ArrayList<Cell>();
		array = getUnvisitedNeighbors(currentCell);
		//C. if has unvisited neighbors,
		if(array.size() != 0) {
			//C1. select one at random.
			int temp = randGen.nextInt(array.size()-1);
			//C2. push it to the stack
			uncheckedCells.push(array.get(temp));
			//C3. remove the wall between the two cells
			removeWalls(currentCell, array.get(temp));
			//C4. make the new cell the current cell and mark it as visited
			currentCell = array.get(temp);
			currentCell.setBeenVisited(true);
			//C5. call the selectNextPath method with the current cell
			selectNextPath(currentCell);
		}
		//D. if all neighbors are visited
		
			//D1. if the stack is not empty
			
				// D1a. pop a cell from the stack
		
				// D1b. make that the current cell
		
				// D1c. call the selectNextPath method with the current cell
				
			
		
	}

	//7. Complete the remove walls method.
	//   This method will check if c1 and c2 are adjacent.
	//   If they are, the walls between them are removed.
	private static void removeWalls(Cell c1, Cell c2) {
		
	}
	
	//8. Complete the getUnvisitedNeighbors method
	//   Any unvisited neighbor of the passed in cell gets added
	//   to the ArrayList
	private static ArrayList<Cell> getUnvisitedNeighbors(Cell c) {
		return null;
	}
}
