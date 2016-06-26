package game;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.*;
import org.newdawn.slick.state.*;
import org.lwjgl.input.Mouse;

public class Menu extends BasicGameState{
	
	Rectangle rect;
	int mX, mY;
	
	boolean shouldFill = false;
	
	int mouseEvent;
	
	public Menu(int state){
	}

	@Override
	public void init(GameContainer gameContainer, StateBasedGame sbGame) throws SlickException {
		rect = new Rectangle(GameParams.mapScreenX(50),GameParams.mapScreenY(50),GameParams.screenY/10,GameParams.screenY/10);
	}
	

	@Override
	public void render(GameContainer gameContainer, StateBasedGame sbGame, Graphics graph) throws SlickException {
		graph.draw(rect);
		if(shouldFill)
			graph.fill(rect);
		
		graph.drawString("X: "+mX+"| Y: "+mY, GameParams.mapScreenX(10), GameParams.mapScreenY(10));
	}

	@Override
	public void update(GameContainer gameContainer, StateBasedGame sbGame, int delta) throws SlickException {
		mouseEvent = Mouse.getEventButton();

		mX = Mouse.getX();
		mY = GameParams.screenY-Mouse.getY();
		
		checkClick();
	}

	public void checkClick(){
		if(mouseEvent != -1){
			if(rect.contains(mX, mY)){
				if(mouseEvent==0){
					shouldFill = true;
				}else if(mouseEvent==1){
					shouldFill = false;
				}
			}
		}
	}
	
	@Override
	public int getID() {
		return 0;
	}
}