package game;

import org.newdawn.slick.geom.*;

public final class GameParams {
	public static final String	gameName 	= "Game Example";
	
	public static final int		menu		= 0;
	public static final int 	play		= 1;
	
	public static final int		headingNorth	= 361;
	public static final int		headingSouth	= 362;
	public static final int		headingWest	= 363;
	public static final int		headingEast	= 364;

	public static final int 	screenX		= 1280;
	public static final int 	screenY		= 720;
	
	public static final int		shootRate	= 200;
	
	public static final int		moveSpeed	= (GameParams.screenY/720);
	//public static float	factor;
	
	public static float mapScreenY(int value){
		if((value>=0)&&(value<=100))
			return screenY/100 * value;
		else 
			return -1;
	}
	
	public static float mapScreenX(int value){
		if((value>=0)&&(value<=100))
			return screenX/100 * value;
		else 
			return -1;
	}

	
	public static int trigger(Rectangle player, Rectangle wall){
		int playerNorth, playerSouth, playerWest, playerEast;
		int wallNorth, wallSouth, wallWest, wallEast;
		
		playerNorth = (int) player.getY();
		playerSouth = (int) player.getY()+(int)player.getHeight();
		playerWest  = (int) player.getX();
		playerEast	= (int) player.getX()+(int)player.getWidth();
		
		wallNorth	= (int) wall.getY();
		wallSouth	= (int) wall.getY()+(int)wall.getHeight();
		wallWest	= (int) wall.getX();
		wallEast	= (int) wall.getX()+(int)wall.getWidth();
		
		
		if(playerNorth<wallSouth){
			return headingNorth;
		}else if(playerSouth>wallNorth){
			return headingSouth;
		}else if(playerWest>wallEast){
			return headingWest;
		}else if(playerEast<wallWest){
			return headingEast;
		}else
			return -1;
	}	
}