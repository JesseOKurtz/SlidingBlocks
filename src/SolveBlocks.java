import java.util.PriorityQueue;
import java.util.Queue;
//import java.util.List;
import java.util.ArrayList;
//import java.util.Comparator;

public class SolveBlocks {
	int Infinity = Integer.MAX_VALUE;
	public static void main(String[] args) {
		char[] initialState = {'B', 'B', 'B',' ', 'W', 'W', 'W'}; //gets made into a sliding block node that is passed to the star search clas
		int initialG =0;
		ArrayList<SlidingBlocks> testChildren = new ArrayList<>();
		ArrayList<SlidingBlocks> testChildren2 = new ArrayList<>();
		//These may be better off, encapsulated in the Search Class
		Queue<SlidingBlocks> frontier = new PriorityQueue<>();//star search class
		ArrayList<SlidingBlocks> explored = new ArrayList<>();	//add to star search class
	
		ArrayList<SlidingBlocks> solutions = new ArrayList<>();  //leave here for star search to return the solutions as an arraylist
		//
		char[] testState = {'B', 'B', 'W', ' ', 'W','B', 'W'};//test code
		char[] goalState = {'W', ' ', 'W','W', 'B', 'B','B'}; //test code
			
		SlidingBlocks newPuzzle = new SlidingBlocks(initialState, initialG);// test code
		SlidingBlocks testPuzzle = new SlidingBlocks(testState, 4); // test code
		SlidingBlocks finalConfig = new SlidingBlocks(goalState, 8);// test code
		
		while (!frontier.isEmpty())
		{
		
		}
		/*Make this a checking function that should go in the Star Search Class
		 * 							if(!frontier.contains(firstChild) && !explored.contains(firstChild))
		 * 								frontier.add(firstChild)
		 * 							else if (frontier.contains(firstChild)
		 * 							{
		 * 								SlidingBlocks temp = frontier.peek();
		 * 									if(temp.getFValue() > firstChild.getFValue)
		 * 										{
		 * 											boolean removed = frontier.remove(temp);
		 * 											if (removed)
		 * 												frontier.add(firstChild);
		 * 										}
		 * 							}
		 */ 						/////End check function
	

		//Test code for toString function
		/*System.out.println(testPuzzle.toString());
		System.out.println(finalConfig.toString());
		*/
		System.out.println("The parent is:");
		System.out.println(testPuzzle.toString());
		
		//Test code for generating children.  It works correctly.
		testChildren = SlidingBlocks.generateChildren(testPuzzle);
		 //System.out.println("The children are:");
		for (SlidingBlocks each : testChildren)
		{
			frontier.add(each);
			System.out.println("In the testChildren:" + each.toString());
			
		}
		System.out.println("The frontier contains the following:");
		for (SlidingBlocks each: frontier)
		{
			
			System.out.println(each.toString());
			System.out.println("HValue: " + each.getHValue());
			System.out.println("GValue:" + each.getPathCost());	
			System.out.println("F Value: " + each.getFValue());
		}
		
		/*System.out.println("The parent (test)");
			System.out.println(testPuzzle.toString());
			
		testChildren2 = SlidingBlocks.generateChildren(testPuzzle);
		System.out.println("The Children are:");
		for (SlidingBlocks each: testChildren2)
			System.out.println(each.toString());//end test code for child generation
		
		
		
		
		//frontier.add(testPuzzle); //test code
		//frontier.add(newPuzzle);	//test code	
		//frontier.add(finalConfig);	//test code
		/*System.out.println("newPuzzle's State is first:");
		newPuzzle.printState();
		
		//SlnewPuzzle.Slide1L();
		
		System.out.println("newPuzzle's State is now:");
		newPuzzle.printState();


		SlidingBlocks childPuzzle = newPuzzle.Slide1L();
		
		System.out.println("The ChildPuzzleState is:");
		childPuzzle.printState();
		System.out.println("AND CHILD Puzzle's G value is :");
		System.out.println(childPuzzle.getPathCost());
		System.out.println("While newPuzzle is Still:");
		newPuzzle.printState();
		SlidingBlocks grandChildPuzzle = childPuzzle.Slide1L();
		
		System.out.println("The grandChildPuzzleState is:");
		grandChildPuzzle.printState();
		System.out.println("AND grandCHILD Puzzle's G value is :");
		System.out.println(grandChildPuzzle.getPathCost());
		
		
		SlidingBlocks greatGrandChildPuzzle = grandChildPuzzle.Slide1R();
		
		System.out.println("The greatGrandChildPuzzleState is:");
		greatGrandChildPuzzle.printState();
		System.out.println("AND greatGrandCHILD Puzzle's G value is :");
		System.out.println(greatGrandChildPuzzle.getPathCost());
		
		
		/*boolean goalFound = false;
		 * boolean searchFailed = false;
		 * GRAPH SEARCH FUNCTION
		 * returns an arraylist of solutions
		 * 
		 * while(goalFound == false && searchFailed == false)
		 * {
		 * 		if (frontier.isEmpty())
		 * 			{
		 * 				searchFailed = true;
		 * 				System.out.println("Search has failed due to empty frontier");
		 * 				break;
		 * 			}
		 * 		else
		 * 			{
		 * 				SlidingBlocks current = frontier.poll();
		 * 				if (current.isGoal(current.getState()))
		 * 					{
		 * 						solutions.add(current);
		 *						System.out.println("Goal Has been Reached");
		 *						goalFound = true;
		 *						return solutions;
		 * 					}
		 * 				else 
		 * 				{
		 * 					
		 * 					explored.add(current);
		 * 					solutions.add(current);
		 * 				ArrayList CurrentChildren = current.generateChildren();
		 * 				for each child in Current Children
		 * 					if(!frontier.contains(each))
		 * 						if(!explored.contains(each))
		 * 							frontier.add(each);
		 * 					
		 * 				}
		 * 			}
		 * }
		 */
		/*if (!frontier.isEmpty())
			System.out.println("Frontier is not yet empty");
		finalConfig.printState();
		boolean Goal3 = finalConfig.isGoal(finalConfig.getState());
		if (Goal3 == true){
			System.out.println("This is a goal state");
			finalConfig.printState();
		}
		else
			System.out.println("This is not a goal state");
		
		
		while (!frontier.isEmpty()){
			SlidingBlocks current = frontier.poll();
			if (current.isGoal(current.getState()))
			{
				solutions.add(current);	
				System.out.println(1);
			}
			else {
				explored.add(current);
				//GENERATE CHILDREN NODES and 
				//for each, check to see if contained infrontier/explored 
				// and if not then add to frontier
			}
		}
		
		
		
		if (solutions.isEmpty())
		{
			System.out.println("DIDNT WORK");
		}
		else
		{
			System.out.println("Solutions has some value:");
			while (!solutions.isEmpty())
			{
				SlidingBlocks now = solutions.remove(0);
				now.printState();
				
			}
		}
		System.out.println("Explored:");
		if (explored.isEmpty())
		{
			System.out.println("DINT WOR");
		}
		else
		{
			while (!explored.isEmpty())
			{
				SlidingBlocks again = explored.remove(0);
				again.printState();
			}
		}
		if (frontier.isEmpty())
			System.out.println("Frontier has been cleared");
		
		finalConfig.printState();
		System.out.println(goalState);
	*/
		//Below this line is all test code
		
		
		
		/*System.out.println("This is the Queue");
	
		System.out.println(frontier.toString());
		
		int compared = newPuzzle.compareTo(testPuzzle);
		if ( compared <0 )
			System.out.println(compared);
		newPuzzle.printState();
		int test = newPuzzle.getHValue();
		System.out.println("TEST EVALUATION:" + test);
		boolean Goal = newPuzzle.isGoal(initialState);
		if (Goal == true)
			System.out.println("This is a goal state");
		else
			System.out.println("This is not a goal state");
		//char[] tempState2 = {'W', ' ', 'W','W', 'B', 'B', 'B'};
		System.out.println(testState);
		int test2 = testPuzzle.getHValue();
		int fVal = testPuzzle.getFValue();
		System.out.println("TEST EVALUATION:" + test2);
		System.out.println("F Value:" + fVal);
		boolean Goal2 = SlidingBlocks.isGoal(testState);

		if (Goal2 == true)
			System.out.println("This is a goal state");
		else
			System.out.println("This is not a goal state");
		
		System.out.println(goalState);
		boolean Goal3 = SlidingBlocks.isGoal(finalConfig.getState());
		if (Goal3 == true)
			System.out.println("This is a goal state3");
		else
			System.out.println("This is not a goal state");*/
	/*	boolean Goal4 = finalConfig.isGoal(finalConfig.getState());
	
		if (Goal4 == true){
			System.out.println("This is a goal state4");
			finalConfig.printState();
		}
		else{
			System.out.println("This is not a goal state");
			finalConfig.printState();
		}
		
	}*/
	/*		
		public int beginSearch(SlidingBlocks Puzzle){
			return StarSearch(Puzzle, Puzzle.getState(), Infinity);
	
}
		private int StarSearch(SlidingBlocks testPuzzle, char[] testState, double inf){
		if (SlidingBlocks.isGoal(testState))
			return Solution- list of the steps taken*/
	}
}


