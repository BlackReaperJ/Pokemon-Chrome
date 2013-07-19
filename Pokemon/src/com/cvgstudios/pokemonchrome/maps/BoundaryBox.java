package com.cvgstudios.pokemonchrome.maps;

public class BoundaryBox{

	public static int pixelsMovedPerMoveAction = 8;

	private int x1;
	private int x2;
	private int y1;
	private int y2;
	
	private boolean boundaryPreventsMovement;

	Direction directionPassable;
	
	
	private static boolean encountersEnabled = true;
	private static boolean encounterTriggered;
	
	
	private float encounterChance;
	
	public BoundaryBox(int xBound1, int xBound2, int yBound1, int yBound2){
		this(xBound1, xBound2, yBound1, yBound2, true, null, 0.0f);
		
	}
	
	public BoundaryBox(int xBound1, int xBound2, int yBound1, int yBound2, float chanceOfEncounter){
		this(xBound1, xBound2, yBound1, yBound2, false, null, chanceOfEncounter);
		
	}
	
	public BoundaryBox(int xBound1, int xBound2, int yBound1, int yBound2, Direction oneWayDirection){
		this(xBound1, xBound2, yBound1, yBound2, true, oneWayDirection, 0.0f);
	}
	
	public BoundaryBox(int xBound1, int xBound2, int yBound1, int yBound2, boolean preventsMovement){
		this(xBound1, xBound2, yBound1, yBound2, preventsMovement, null, 0.0f);

	}
	
	public BoundaryBox(int xBound1, int xBound2, int yBound1, int yBound2, boolean preventsMovement, float chanceOfEncounter){
		this(xBound1, xBound2, yBound1, yBound2, preventsMovement, null, chanceOfEncounter);

	}
	
	public BoundaryBox(int xBound1, int xBound2, int yBound1, int yBound2, boolean preventsMovement, Direction oneWayDirection){
		
		this(xBound1, xBound2, yBound1, yBound2, preventsMovement, oneWayDirection, 0.0f);
		
	}
	
public BoundaryBox(int xBound1, int xBound2, int yBound1, int yBound2, boolean preventsMovement, Direction oneWayDirection, float chanceOfEncounter){
		
		x1 = Math.min(xBound1, xBound2);
		x2 = Math.max(xBound1, xBound2);
		y1 = Math.min(yBound1, yBound2);
		y2 = Math.max(yBound1, yBound2);

		boundaryPreventsMovement = preventsMovement;
		directionPassable = oneWayDirection;
		encounterChance = chanceOfEncounter;
		
	}

	public boolean isMovePossible(int currentX, int currentY, Direction directionOfMovement){
		
		if (!boundaryPreventsMovement){
			if (encounterChance > 0.0f){
				if (isIntBetween(currentX, x1, x2) && isIntBetween(currentY, y1, y2)){
					if (Math.random() < encounterChance){
						encounterTriggered = true;
					}
				}
			}
				
			
			return true;
		}
		
		if (directionOfMovement == directionPassable){
			return true;
		}
		
		if (directionOfMovement == Direction.RIGHT){
			if (isIntBetween(currentY, y1, y2)){
				if (isIntBetween(x1, currentX - pixelsMovedPerMoveAction, currentX)){
					return false;
				}
				if (isIntBetween(x2, currentX - pixelsMovedPerMoveAction, currentX)){
					return false;
				}
				if (isIntBetween(currentX, x1, x2)){
					return false;
				}
				if (isIntBetween(currentX - pixelsMovedPerMoveAction, x1, x2)){
					return false;
				}
				return true;
			}
		} else if (directionOfMovement == Direction.LEFT){

			if (isIntBetween(currentY, y1, y2)){
				if (isIntBetween(x1, currentX, currentX + pixelsMovedPerMoveAction)){
					return false;
				}
				if (isIntBetween(x2, currentX, currentX + pixelsMovedPerMoveAction)){
					return false;
				}
				if (isIntBetween(currentX, x1, x2)){
					return false;
				}
				if (isIntBetween(currentX + pixelsMovedPerMoveAction, x1, x2)){
					return false;
				}
				return true;
			}

		} else if (directionOfMovement == Direction.DOWN){

			if (isIntBetween(currentX, x1, x2)){
				if (isIntBetween(y1, currentY - pixelsMovedPerMoveAction, currentY)){
					return false;
				}
				if (isIntBetween(y2, currentY - pixelsMovedPerMoveAction, currentY)){
					return false;
				}
				if (isIntBetween(currentY, y1, y2)){
					return false;
				}
				if (isIntBetween(currentY - pixelsMovedPerMoveAction, y1, y2)){
					return false;
				}
				return true;
			}

		} else if (directionOfMovement == Direction.UP){

			if (isIntBetween(currentX, x1, x2)){
				if (isIntBetween(y1, currentY, currentY + pixelsMovedPerMoveAction)){
					return false;
				}
				if (isIntBetween(y2, currentY, currentY + pixelsMovedPerMoveAction)){
					return false;
				}
				if (isIntBetween(currentY, y1, y2)){
					return false;
				}
				if (isIntBetween(currentY + pixelsMovedPerMoveAction, y1 , y2)){
					return false;
				}

			}
			return true;

		}

		return true;

	}
	
	
	
	public void setBoundaryPrevention(boolean preventsMovement){
		boundaryPreventsMovement = preventsMovement;
	}
	
	private static boolean isIntBetween(int theInt, int lesserNum, int greaterNum){
		return (theInt >= lesserNum && theInt <= greaterNum);
	}
	
	public static boolean isMovePossible(int currentX, int currentY, Direction directionOfMovement, BoundaryBox[] boundaries){
		
		for (BoundaryBox theBoundary : boundaries){
			if (!theBoundary.isMovePossible(currentX, currentY, directionOfMovement)){
				return false;
			}
		}
		return true;
		
	}
	
	public static boolean isEncountering(){
		
		if (encounterTriggered){
			encounterTriggered = false;
			return true;
		}
		
		return false;
		
	}
	
	public static boolean areEncountersEnabled(){
		return encountersEnabled;
	}
	public static void setEncountersEnabled(boolean enabled){
		encountersEnabled = enabled;
	}
	
}

enum Direction{
	LEFT,
	RIGHT,
	UP,
	DOWN;
}
