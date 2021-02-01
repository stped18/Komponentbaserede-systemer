/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.mmmi.cbse.gamestates;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import dk.sdu.mmmi.cbse.entities.Enemy;
import dk.sdu.mmmi.cbse.managers.GameStateManager;
import java.util.Random;

/**
 *
 * @author Steffen Vitten
 */
public class EnemyState extends GameState {

    private ShapeRenderer sr;

    private Enemy enemy;

    public EnemyState(GameStateManager gsm) {
        super(gsm);
    }

    public void init() {

        sr = new ShapeRenderer();
        enemy = new Enemy();

    }

    public void update(float dt) {
        handleInput();
        enemy.update(dt);

    }

    public void draw() {
        enemy.draw(sr);
    }

    public void handleInput() {
        Random rn = new Random();
        int min = 0;
        int max = 10;

        int action = rn.nextInt(max - min + 1) + min;
        if (action ==5 || action==1) {
            enemy.setLeft(true);
            enemy.setRight(false);
            enemy.setUp(false);
        }
        if (action == 3 || action ==7) {
            enemy.setLeft(false);
            enemy.setRight(true);
            enemy.setUp(false);
        }
        if (action%2==0) {
            enemy.setLeft(false);
            enemy.setRight(false);
            enemy.setUp(true);

        }

    }

    public void dispose() {
    }

}
