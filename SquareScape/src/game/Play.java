package game;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.*;



public class Play extends BasicGameState{

	private Rectangle rect;
	
	private Player player;
	
	public Play(int state){
	}

	@Override
	public void init(GameContainer gameContainer, StateBasedGame sbGame) throws SlickException {
		player	= new Player((int)GameParams.mapScreenX(50), (int)GameParams.mapScreenY(50));
		
		rect	= new Rectangle (GameParams.mapScreenX(70),GameParams.mapScreenY(60),GameParams.screenX/10,GameParams.screenX/10);
		
	}
	

	@Override
	public void render(GameContainer gameContainer, StateBasedGame sbGame, Graphics graph) throws SlickException {
		player.render(gameContainer, sbGame, graph);
		graph.draw(rect);
	}

	@Override
	public void update(GameContainer gameContainer, StateBasedGame sbGame, int delta) throws SlickException {
		player.update(gameContainer, sbGame, delta);
				
		getInput();
	}
	

	private void getInput(){
	
		if(Keyboard.isKeyDown(Keyboard.KEY_UP)){
			if(!rect.intersects(player.getFutureRect(Keyboard.KEY_UP))){
				player.move(Keyboard.KEY_UP);
			}			
		}	
		if(Keyboard.isKeyDown(Keyboard.KEY_DOWN)){	
			if(!rect.intersects(player.getFutureRect(Keyboard.KEY_DOWN)))
				player.move(Keyboard.KEY_DOWN);
		}		
		if(Keyboard.isKeyDown(Keyboard.KEY_LEFT)){
			if(!rect.intersects(player.getFutureRect(Keyboard.KEY_LEFT)))
				player.move(Keyboard.KEY_LEFT);
		}				
		if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT)){
			if(!rect.intersects(player.getFutureRect(Keyboard.KEY_RIGHT)))
				player.move(Keyboard.KEY_RIGHT);
		}
	}

	@Override
	public int getID() {
		return 1;
	}
}