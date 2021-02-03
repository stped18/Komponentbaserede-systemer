/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.mmmi.cbse.gamestates;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import dk.sdu.mmmi.cbse.entities.Bullet;
import dk.sdu.mmmi.cbse.managers.GameStateManager;

/**
 *
 * @author steff
 */
public class BulletState  extends GameState{

  private ShapeRenderer sr;

    private Bullet bullet;

    public BulletState(GameStateManager gsm) {
        super(gsm);
    }

    public void init() {

        sr = new ShapeRenderer();
        bullet = new Bullet();
        

    }

    public void update(float dt) {
        
        handleInput();
        bullet.update(dt);

    }

    public void draw() {
        bullet.draw(sr);
    }

    

    public void dispose() {
    }

    @Override
    public void handleInput() {
       bullet.setUp(true);
    }

}
