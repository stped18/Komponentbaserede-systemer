/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.mmmi.cbse.gamestates;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import dk.sdu.mmmi.cbse.entities.Astroid;
import dk.sdu.mmmi.cbse.entities.Enemy;
import dk.sdu.mmmi.cbse.managers.GameStateManager;
import java.util.Random;

/**
 *
 * @author steff
 */
public class AstroidState extends GameState{
 private ShapeRenderer sr;

    private Astroid astroid;

    public AstroidState(GameStateManager gsm) {
        super(gsm);
    }

    public void init() {

        sr = new ShapeRenderer();
        astroid = new Astroid();

    }

    public void update(float dt) {
        handleInput();
        astroid.update(dt);

    }

    public void draw() {
        astroid.draw(sr);
    }

    public void handleInput() {
        Random rn = new Random();
        int min = 0;
        int max = 10;

        int action = rn.nextInt(max - min + 1) + min;
        if (action ==5 || action==1) {
            astroid.setLeft(true);
            astroid.setRight(false);
            astroid.setUp(false);
        }
        if (action == 3 || action ==7) {
            astroid.setLeft(false);
            astroid.setRight(true);
            astroid.setUp(false);
        }
        if (action%2==0) {
            astroid.setLeft(false);
            astroid.setRight(false);
            astroid.setUp(true);

        }

    }

    public void dispose() {
    }
}
