/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.mmmi.cbse.enemy2;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
import java.util.Random;

/**
 *
 * @author Steffen Vitten
 */
public class EnemyPlugin implements IGamePluginService {
    
    
    private Entity[] enemies= new Entity[5];

    public EnemyPlugin() {
        
    }
    

    @Override
    public void start(GameData gameData, World world) { 
        for (Entity enemy : enemies) {
            enemy=createShip(gameData);
            world.addEntity(enemy);
        }
        
;
    }

    @Override
    public void stop(GameData gameData, World world) {
        for(Entity enemy: enemies){
            world.removeEntity(enemy);  
        }
              
    }
    private Entity createShip(GameData gameData) {
        Random rn = new Random();
        int startPositionX = rn.nextInt(5 - 1 + 1) + 1;
        int startPositionY = rn.nextInt(5 - 1 + 1) + 1;
                
        float deacceleration = 10;
        float acceleration = 200;
        float maxSpeed = 300;
        float rotationSpeed = 5;
        float x = gameData.getDisplayWidth() / startPositionX;
        float y = gameData.getDisplayHeight() / startPositionY;
        float radians = 3.1415f / 2;
        
        Entity enemyShip = new Enemy(Entity.TYPS.ENEMY);
        enemyShip.add(new MovingPart(deacceleration, acceleration, maxSpeed, rotationSpeed));
        enemyShip.add(new PositionPart(x, y, radians));
        
        return enemyShip;
    }
    
}
