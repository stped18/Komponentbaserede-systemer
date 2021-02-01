/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.mmmi.cbse.gamestates;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import dk.sdu.mmmi.cbse.entities.Enimy;
import dk.sdu.mmmi.cbse.managers.GameStateManager;
import java.util.Random;

/**
 *
 * @author Steffen Vitten
 */
public class EnemyState extends GameState {

    private ShapeRenderer sr;

    private Enimy enimys;

    public EnemyState(GameStateManager gsm) {
        super(gsm);
    }

    public void init() {

        sr = new ShapeRenderer();
        enimys = new Enimy();

    }

    public void update(float dt) {
        handleInput();
        enimys.update(dt);

    }

    public void draw() {
        enimys.draw(sr);
    }

    public void handleInput() {
        Random rn = new Random();
        int min = 0;
        int max = 10;

        int action = rn.nextInt(max - min + 1) + min;
        if (action ==5 || action==1) {
            enimys.setLeft(true);
            enimys.setRight(false);
            enimys.setUp(false);
        }
        if (action == 3 || action ==7) {
            enimys.setLeft(false);
            enimys.setRight(true);
            enimys.setUp(false);
        }
        if (action%2==0) {
            enimys.setLeft(false);
            enimys.setRight(false);
            enimys.setUp(true);

        }

    }

    public void dispose() {
    }

}
