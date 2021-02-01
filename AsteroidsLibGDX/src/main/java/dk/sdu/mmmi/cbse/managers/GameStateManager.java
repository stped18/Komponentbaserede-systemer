package dk.sdu.mmmi.cbse.managers;

import dk.sdu.mmmi.cbse.gamestates.EnemyState;
import dk.sdu.mmmi.cbse.gamestates.GameState;
import dk.sdu.mmmi.cbse.gamestates.PlayState;

public class GameStateManager {

    // current game state
    private GameState[] gameState = new GameState[10];

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
            for (int i = 0; i < gameState.length; i++) {
                if (i == 0) {
                    gameState[i] = new PlayState(this);
                } else {
                    gameState[i] = new EnemyState(this);

                }

            }

        }
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
