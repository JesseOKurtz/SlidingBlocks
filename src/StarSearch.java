import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Iterator;


public class StarSearch {
	
	private static boolean goalFound = false;
	private static boolean searchFailed = false;
	private static int steps = 0;
	static PriorityQueue<SlidingBlocks> frontier = new PriorityQueue<>();//star search class
	private static ArrayList<SlidingBlocks> explored = new ArrayList<>();	//add to star search class
	private static ArrayList<SlidingBlocks> currentChildren = new ArrayList<>();
	private static ArrayList<SlidingBlocks> solutions = new ArrayList<>();
	
	
	public static ArrayList<SlidingBlocks> searchPuzzle(SlidingBlocks test)
			{
		
				frontier.clear();//clear at the beginning just in case there is some data in memory
				explored.clear();
				solutions.clear();
				
				frontier.add(test);
				System.out.println(frontier.toString());
				
				while(goalFound == false && searchFailed == false)
					{
					steps++;
						currentChildren.clear();//clear the current children list at beginning of each loop
						if (frontier.isEmpty())
							{
								searchFailed = true;
								System.out.println("Search has failed due to initially empty frontier");
								break;
							}
						else
							{
								SlidingBlocks current = frontier.poll();
								
								if (current.isGoal(current.getState()))
									{
										solutions.add(current);
										System.out.println("Goal Has been Reached");
										System.out.println("FINAL STATE: "+ current.toString() + " in " + steps + " steps with a path cost of:" + current.getPathCost() + " and an F value of " + current.getFValue());
										goalFound = true;
										return solutions;
									}
								else 
									{
										System.out.println(current.toString()+ " has been added to explored list with F Value: " +current.getFValue());
										explored.add(current);
										currentChildren = SlidingBlocks.generateChildren(current);
										
										for (SlidingBlocks each: currentChildren)
											{
											if(!frontier.contains(each) && !explored.contains(each))
												frontier.add(each);
											}
		   					
									}
							}
					}
				return solutions;
			}
}