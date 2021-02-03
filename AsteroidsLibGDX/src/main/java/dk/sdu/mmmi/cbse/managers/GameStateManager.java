package dk.sdu.mmmi.cbse.managers;

import dk.sdu.mmmi.cbse.gamestates.AstroidState;
import dk.sdu.mmmi.cbse.gamestates.EnemyState;
import dk.sdu.mmmi.cbse.gamestates.GameState;
import dk.sdu.mmmi.cbse.gamestates.PlayState;
import java.util.ArrayList;
import java.util.List;

public class GameStateManager {

    // current game state
    private List<GameState> gameState = new ArrayList<>();

    public static final int MENU = 0;
    public static final int PLAY = 893746;

    public GameStateManager() {
        setState(PLAY);
    }

    public void setState(int state) {
        for (GameState gameState1 : gameState) {
            if (gameState1 != null) {
                gameState1.dispose();

            }

        }

        if (state == MENU) {
            // gameState = new MenuState(this);
        }
        if (state == PLAY) {
            
            gameState.add(new PlayState(this));
            gameState.add(new EnemyState(this));
            gameState.add(new AstroidState(this));
            
            
                
               
            

        }
    }
    public void add_state(GameState gameobject){
        gameState.add(gameobject);
    }

    public void update(float dt) {
        for (GameState gameState1 : gameState) {
                gameState1.update(dt);

        }

    }

    public void draw() {
        for (GameState gameState1 : gameState) {
            gameState1.draw();

        }

    }

}
