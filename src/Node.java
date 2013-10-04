
public class Node implements Comparable<Node> {

	private int h; //variable used to store the heuristic evaluation of the current state
	private int g; //variable used to store the path cost of reaching this node so far
	private int f;  //variable used to store the total Value node
	private char[] currentPuzzle;
	
	
	public Node( char[] currentPuzzle, int g){
		this.currentPuzzle = currentPuzzle;
		this.g = g;
		this.h = currentPuzzle.EvaluateState(this.currentPuzzle);
		this.f = h + g;
		

		
	
}
}