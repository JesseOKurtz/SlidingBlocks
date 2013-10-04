
//import java.util.List;
import java.util.ArrayList;



public class SlidingBlocks implements Comparable<SlidingBlocks>{
	
	//private char[] initialState = {'B', 'B', 'B',' ', 'W', 'W', 'W'};//may need to be removed later
	private char[] currentState;
	private char[] parentState;
	private char[]childState;
	static ArrayList<SlidingBlocks> allChildren = new ArrayList<>();
	private int heuristicValue;
	private int goalCounter;
	private int parentsG;
	private int childG;
	private char swap;
	private int f;// total value of function (hValue +gValue)
	private int g;//cost of getting to this node
	//private char[] currentNode;
	
	public SlidingBlocks(char[] currentPuzzle, int g)
	{
		this.heuristicValue = EvaluateState(currentPuzzle);
		this.g = g;
		this.f = heuristicValue + g;
		this.currentState = currentPuzzle;
	}
	public void printState(){
		System.out.println(currentState);
	}
	public char[] getState()
	{
		return this.currentState;
	}
	public int getHValue()
	{
		return this.heuristicValue;
	}
	
	public int getFValue()
	{
		return this.f;
	}
	
	
	public int getPathCost()
	{
		return this.g;
	}
	/*public String toString()
	{
		String StrPuzzle = currentState.toString();
		return StrPuzzle;
	}*/
	public int compareTo(SlidingBlocks newState)
	{
		
		return (this.f - newState.f);

	}
	
	private int EvaluateState(char[] currentState){
		heuristicValue = 0;
		//should also say if the goal isnt reached that h is at least 1;
		for (int i=0; i<currentState.length; i++){
			if (currentState[i] == 'B')
			{
				heuristicValue++;
			}
			else if (currentState[i] == 'W')
			{
				return heuristicValue;
			}
					
		}
		
		return heuristicValue;
	}


	public boolean isGoal(char[] test){
		goalCounter=0;  //initialize / reset the counter
		for(int g = 0; g<test.length; g++)
		{
			if (test[g] == 'W')
					goalCounter++;
			
			else if (test[g] == 'B')
				break;
		}
		if (goalCounter != 3)
			return false;
		else return true;
		
	}
	
	//All movement is considered in terms of moving the blank space rather than the 
	//tiles themselves.   This makes it easier to conceptualize the movement
	//The name, number, and letter indicate movement type, number of spaces, and direction
	//of the blank space.  
	public SlidingBlocks Slide1L()
	  {
		parentState = this.getState();
		childState = new char[parentState.length];
		parentsG = this.getPathCost();
		childG = parentsG+1;
		for (int a = 0; a<parentState.length; a++)
		{
			childState[a] = parentState[a];
		}
		
	  	for (int c = 0; c<childState.length; c++)
	  		{
	  			if (childState[c] == ' ')
	  			{
	 				swap = childState[c-1];
	  				childState[c-1] = childState[c];
	  				childState[c] = swap;
	  			}
	  
	 
	 		}
	  	
	  	SlidingBlocks copy = new SlidingBlocks(childState, childG);//creates a new sliding Block with a new g value
	  		return copy;
	 }

	
	public SlidingBlocks Slide1R()
	{
		parentState = this.getState();
		childState = new char[parentState.length];
		parentsG = this.getPathCost();
		childG = parentsG+1;
		for (int a = 0; a<parentState.length; a++)
		{
			childState[a] = parentState[a];
			//System.out.println(a);
			//System.out.println(childState[a]);
		}
		
	  	for (int q = (childState.length-1); q>=0 ; q--)
	  		{
	  		
	  			if (childState[q] == ' ')
	  			{
	 				swap = childState[q+1];
	  				childState[q+1] = childState[q];
	  				childState[q] = swap;
	  			}
	  
	 
	 		}
	  	
	  	SlidingBlocks copy = new SlidingBlocks(childState, childG);//creates a new sliding Block with a new g value
	  		return copy;
	}
	 public SlidingBlocks Hop1R()
	 {
		 parentState = this.getState();
			childState = new char[parentState.length];
			parentsG = this.getPathCost();
			childG = parentsG+1;//check
			for (int a = 0; a<parentState.length; a++)
			{
				childState[a] = parentState[a];
				//System.out.println(a);
				//System.out.println(childState[a]);
			}
			
		  	for (int q = (childState.length-1); q>=0 ; q--)
		  		{
		  		
		  			if (childState[q] == ' ')
		  			{
		 				swap = childState[q+2];
		  				childState[q+2] = childState[q];
		  				childState[q] = swap;
		  			}
		  
		 
		 		}
		  	
		  	SlidingBlocks copy = new SlidingBlocks(childState, childG);//creates a new sliding Block with a new g value
		  		return copy;
	 }
	 public SlidingBlocks Hop2R()
	 {
		 parentState = this.getState();
			childState = new char[parentState.length];
			parentsG = this.getPathCost();
			childG = parentsG+2;//check
			for (int a = 0; a<parentState.length; a++)
			{
				childState[a] = parentState[a];
				//System.out.println(a);
				//System.out.println(childState[a]);
			}
			
		  	for (int q = (childState.length-1); q>=0 ; q--)
		  		{
		  		
		  			if (childState[q] == ' ')
		  			{
		 				swap = childState[q+3];
		  				childState[q+3] = childState[q];
		  				childState[q] = swap;
		  			}
		  
		 
		 		}
		  	
		  	SlidingBlocks copy = new SlidingBlocks(childState, childG);//creates a new sliding Block with a new g value
		  		return copy;
	 }
	 
	public SlidingBlocks Hop1L()
	{
		parentState = this.getState();
		childState = new char[parentState.length];
		parentsG = this.getPathCost();
		childG = parentsG+1;//check
		for (int a = 0; a<parentState.length; a++)
		{
			childState[a] = parentState[a];
		}
		
	  	for (int c = 0; c<childState.length; c++)
	  		{
	  			if (childState[c] == ' ')
	  			{
	  				
	 				swap = childState[c-2];
	  				childState[c-2] = childState[c];
	  				childState[c] = swap;
	  			}
	  
	 
	 		}
	  	
	  	SlidingBlocks copy = new SlidingBlocks(childState, childG);//creates a new sliding Block with a new g value
	  		return copy;
	}
	public SlidingBlocks Hop2L()
	{
		parentState = this.getState();
		childState = new char[parentState.length];
		parentsG = this.getPathCost();
		childG = parentsG+2;//check
		for (int a = 0; a<parentState.length; a++)
		{
			childState[a] = parentState[a];
		}
		
	  	for (int c = 0; c<childState.length; c++)
	  		{
	  			if (childState[c] == ' ')
	  			{
	  			
	 				swap = childState[c-3];
	  				childState[c-3] = childState[c];
	  				childState[c] = swap;
	  			}
	  
	 
	 		}
	  	
	  	SlidingBlocks copy = new SlidingBlocks(childState, childG);//creates a new sliding Block with a new g value
	  		return copy;
	}	 //Hop2R();
	 
	public String toString()
	{
		String printString = "This Puzzle Looks like this:" + new String(this.currentState);
		return printString;
	}
	 public static ArrayList<SlidingBlocks> generateChildren(SlidingBlocks test)
	  {
	  		allChildren.clear(); //clear the list of any possible data just in case
	 		char[] currentNode = test.getState();
	 		
	  		for(int k=0;k<currentNode.length;k++)
	 			{
	  				if (currentNode[k] == ' ')
	  				{
	 					if (k==3)  //In the middle it can perform all 6 moves
	  					{
	 						
	  						SlidingBlocks firstChild = test.Slide1L();
	  							allChildren.add(firstChild);
	  						SlidingBlocks secondChild = test.Slide1R();
	  							allChildren.add(secondChild);
	  						SlidingBlocks thirdChild = test.Hop1L();
	  							allChildren.add(thirdChild);
	  						SlidingBlocks fourthChild = test.Hop1R();
	  							allChildren.add(fourthChild);
	  						SlidingBlocks fifthChild = test.Hop2L();
	  							allChildren.add(fifthChild);
	  						SlidingBlocks sixthChild = test.Hop2R();
	  							allChildren.add(sixthChild);
	  							
	  					}
	  					else if(k==0)//If the blank space is that the beginning or end of the 
	  					{			//array it may only move in one direction
	  						SlidingBlocks firstChild = test.Slide1R();
  							allChildren.add(firstChild);
  							SlidingBlocks secondChild = test.Hop1R();
  							allChildren.add(secondChild);
  							SlidingBlocks thirdChild = test.Hop2R();
  							allChildren.add(thirdChild);
	  					}
	  					else if (k==1)//now it may make 4 movements
	  					{
	  						SlidingBlocks firstChild = test.Slide1R();
  							allChildren.add(firstChild);
  							SlidingBlocks secondChild = test.Hop1R();
  							allChildren.add(secondChild);
  							SlidingBlocks thirdChild = test.Hop2R();
  							allChildren.add(thirdChild);
  							SlidingBlocks fourthChild = test.Slide1L();
  							allChildren.add(fourthChild);
	  					}
	  					else if (k==2)//now it may make 5 movements, 2 to the left, 3 to the right
	  					{
	  						SlidingBlocks firstChild = test.Slide1R();
  							allChildren.add(firstChild);
  							SlidingBlocks secondChild = test.Hop1R();
  							allChildren.add(secondChild);
  							SlidingBlocks thirdChild = test.Hop2R();
  							allChildren.add(thirdChild);
  							SlidingBlocks fourthChild = test.Slide1L();
  							allChildren.add(fourthChild);
  							SlidingBlocks fifthChild = test.Hop1L();
  							allChildren.add(fifthChild);
  							
	  					}
	 					else if(k==4)//5 moves available again, this time 3 to the left and 2 to the right
	  					{
	 						SlidingBlocks firstChild = test.Slide1R();
  							allChildren.add(firstChild);
  							SlidingBlocks secondChild = test.Hop1R();
  							allChildren.add(secondChild);
  							SlidingBlocks thirdChild = test.Hop2L();
  							allChildren.add(thirdChild);
  							SlidingBlocks fourthChild = test.Slide1L();
  							allChildren.add(fourthChild);
  							SlidingBlocks fifthChild = test.Hop1L();
  							allChildren.add(fifthChild);
	  					}
	  					else if (k==5)//4 moves 3 to the left, 1 to the right
	 					{
	  						SlidingBlocks firstChild = test.Slide1R();
  							allChildren.add(firstChild);
  							SlidingBlocks secondChild = test.Hop1L();
  							allChildren.add(secondChild);
  							SlidingBlocks thirdChild = test.Hop2L();
  							allChildren.add(thirdChild);
  							SlidingBlocks fourthChild = test.Slide1L();
  							allChildren.add(fourthChild);
	 			
	  					}
	  					else if (k==6)//only 3 moves to the left available
	  					{
	  						SlidingBlocks firstChild = test.Slide1L();
  							allChildren.add(firstChild);
  							SlidingBlocks secondChild = test.Hop1L();
  							allChildren.add(secondChild);
  							SlidingBlocks thirdChild = test.Hop2L();
  							allChildren.add(thirdChild);
	  
	  					}
	  				}
	  			}
	  		return allChildren;
	  }
	 
}
