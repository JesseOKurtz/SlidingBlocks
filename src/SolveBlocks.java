import java.util.ArrayList;
//import java.util.PriorityQueue;
//import java.util.Queue;


public class SolveBlocks {
	int Infinity = Integer.MAX_VALUE;
	public static void main(String[] args) {
		char[] initialState = {'B', 'B', 'B',' ', 'W', 'W', 'W'}; //gets made into a sliding block node that is passed to the star search clas
		int initialG =0;

		
		ArrayList<SlidingBlocks> solutions = new ArrayList<>();  //leave here for star search to return the solutions as an arraylist
		//
		char[] testState = {'B', 'B', 'W', ' ', 'W','B', 'W'};//test code
		char[] goalState = {'W', ' ', 'W','W', 'B', 'B','B'}; //test code
			
		SlidingBlocks newPuzzle = new SlidingBlocks(initialState, initialG);// test code
		SlidingBlocks testPuzzle = new SlidingBlocks(testState, 4); // test code
		SlidingBlocks finalConfig = new SlidingBlocks(goalState, 8);// test code
		
		solutions = StarSearch.searchPuzzle(newPuzzle);
		
	}
}


