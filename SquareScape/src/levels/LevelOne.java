package levels;

import java.util.ArrayList;

import org.newdawn.slick.geom.Rectangle;

import game.GameParams;

public class LevelOne {

	
	private ArrayList<Rectangle> walls;
	
	private Rectangle rect, rect2, rect3;

	
	public LevelOne(){
		walls = new ArrayList<Rectangle>();
		
		rect	= new Rectangle (GameParams.mapScreenX(70),GameParams.mapScreenY(60),GameParams.screenX/10,GameParams.screenX/10);
		rect2	= new Rectangle (GameParams.mapScreenX(75),GameParams.mapScreenY(65),GameParams.screenX/10,GameParams.screenX/10);
		rect3	= new Rectangle (GameParams.mapScreenX(80),GameParams.mapScreenY(70),GameParams.screenX/10,GameParams.screenX/10);

		
		walls.add(rect);
		walls.add(rect2);
		walls.add(rect3);
	}
	
	public ArrayList<Rectangle> getWalls(){
		return walls;
	}
	
}
