package dk.sdu.mmmi.cbse.gamestates;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import dk.sdu.mmmi.cbse.entities.Player;
import dk.sdu.mmmi.cbse.managers.GameKeys;
import dk.sdu.mmmi.cbse.managers.GameStateManager;

public class PlayState extends GameState {
	
	private ShapeRenderer sr;
	
	private Player player;
        private GameStateManager gameStateManager;
	
	public PlayState(GameStateManager gsm) {
		super(gsm);
                this.gameStateManager=gsm;
	}
	
	public void init() {
		
		sr = new ShapeRenderer();
		
		player = new Player(this.gameStateManager);

        
                
		
	}
	
	public void update(float dt) {
		
		handleInput();
		
		player.update(dt);
		
	}
	
	public void draw() {
		player.draw(sr);

	}
	
	public void handleInput() {
		player.setLeft(GameKeys.isDown(GameKeys.LEFT));
		player.setRight(GameKeys.isDown(GameKeys.RIGHT));
		player.setUp(GameKeys.isDown(GameKeys.UP));
                player.setShoot(GameKeys.isPressed(GameKeys.SPACE));
	}
	
	public void dispose() {}
	
}









