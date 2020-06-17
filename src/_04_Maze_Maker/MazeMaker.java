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
		int cellX = randGen.nextInt(maze.getWidth());
		int cellY = randGen.nextInt(maze.getHeight());
		
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
			int temp = randGen.nextInt(array.size());
			//C2. push it to the stack
			uncheckedCells.push(array.get(temp));
			//C3. remove the wall between the two cells
			removeWalls(currentCell, array.get(temp));
			//C4. make the new cell the current cell and mark it as visited
			currentCell = array.get(temp);
			array.remove(temp);
			currentCell.setBeenVisited(true);
			//C5. call the selectNextPath method with the current cell
			selectNextPath(currentCell);
		}
		//D. if all neighbors are visited
		if(array.size() == 0) {
			//D1. if the stack is not empty
			if(uncheckedCells.size() != 0) {
				// D1a. pop a cell from the stack
				// D1b. make that the current cell
				currentCell = uncheckedCells.pop();
				// D1c. call the selectNextPath method with the current cell
				selectNextPath(currentCell);
			}
		}
		
	}

	//7. Complete the remove walls method.
	//   This method will check if c1 and c2 are adjacent.
	//   If they are, the walls between them are removed.
	private static void removeWalls(Cell c1, Cell c2) {
		if(c1.getX() == c2.getX()-1) {
			c1.setEastWall(false);
			c2.setWestWall(false);
		}
		else if(c1.getX() == c2.getX()+1) {
			c1.setWestWall(false);
			c2.setEastWall(false);
		}
		else if(c1.getY() == c2.getY()-1) {
			c1.setSouthWall(false);
			c2.setNorthWall(false);
		}
		else if(c1.getY() == c2.getY()+1) {
			c1.setNorthWall(false);
			c2.setSouthWall(false);
		}
	}
	
	//8. Complete the getUnvisitedNeighbors method
	//   Any unvisited neighbor of the passed in cell gets added
	//   to the ArrayList
	private static ArrayList<Cell> getUnvisitedNeighbors(Cell c) {
		ArrayList<Cell> list = new ArrayList<Cell>();
		if(c.getX() != maze.getWidth()-1 && maze.getCell(c.getX()+1, c.getY()).hasBeenVisited() == false) {
			list.add(maze.getCell(c.getX()+1, c.getY()));
		}
		if(c.getX() != 0 && maze.getCell(c.getX()-1, c.getY()).hasBeenVisited() == false) {
			list.add(maze.getCell(c.getX()-1, c.getY()));
		}
		if(c.getY() != maze.getHeight()-1 && maze.getCell(c.getX(), c.getY()+1).hasBeenVisited() == false) {
			list.add(maze.getCell(c.getX(), c.getY()+1));
		}
		if(c.getY() != 0 && maze.getCell(c.getX(), c.getY()-1).hasBeenVisited() == false) {
			list.add(maze.getCell(c.getX(), c.getY()-1));
		}
		return list;
	}
}
