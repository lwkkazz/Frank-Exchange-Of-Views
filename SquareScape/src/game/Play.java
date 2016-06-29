package game;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.*;



public class Play extends BasicGameState{

	private Rectangle rect, rect2, rect3;
	
	private Player player;
	
	public Play(int state){
	}

	@Override
	public void init(GameContainer gameContainer, StateBasedGame sbGame) throws SlickException {
		player	= new Player((int)GameParams.mapScreenX(50), (int)GameParams.mapScreenY(50));
		
		rect	= new Rectangle (GameParams.mapScreenX(70),GameParams.mapScreenY(60),GameParams.screenX/10,GameParams.screenX/10);
		rect2	= new Rectangle (GameParams.mapScreenX(75),GameParams.mapScreenY(65),GameParams.screenX/10,GameParams.screenX/10);
		rect3	= new Rectangle (GameParams.mapScreenX(80),GameParams.mapScreenY(70),GameParams.screenX/10,GameParams.screenX/10);

		
	}
	

	@Override
	public void render(GameContainer gameContainer, StateBasedGame sbGame, Graphics graph) throws SlickException {
		player.render(gameContainer, sbGame, graph);
		graph.draw(rect);
		graph.fill(rect);
		
		graph.draw(rect2);
		graph.fill(rect2);

		graph.draw(rect3);
		graph.fill(rect3);


	}

	@Override
	public void update(GameContainer gameContainer, StateBasedGame sbGame, int delta) throws SlickException {
		player.update(gameContainer, sbGame, delta);
				
		getInput();
	}
	

	private void getInput(){
	
		if(Keyboard.isKeyDown(Keyboard.KEY_UP)){
			if(!checkWalls(Keyboard.KEY_UP))
				player.move(Keyboard.KEY_UP);
				
		}	
		if(Keyboard.isKeyDown(Keyboard.KEY_DOWN)){	
			if(!checkWalls(Keyboard.KEY_DOWN))
				player.move(Keyboard.KEY_DOWN);
		}		
		if(Keyboard.isKeyDown(Keyboard.KEY_LEFT)){
			if(!checkWalls(Keyboard.KEY_LEFT))
				player.move(Keyboard.KEY_LEFT);
		}				
		if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT)){
			if(!checkWalls(Keyboard.KEY_RIGHT))
				player.move(Keyboard.KEY_RIGHT);
		}
	}

	
	private boolean checkWalls(int direction){
		if(rect.intersects(player.getFutureRect(direction))){
			return true;
		}else if(rect2.intersects(player.getFutureRect(direction))){
			return true;
		}else if(rect3.intersects(player.getFutureRect(direction))){
			return true;
		}
			return false;
		
	}
	@Override
	public int getID() {
		return 1;
	}
}