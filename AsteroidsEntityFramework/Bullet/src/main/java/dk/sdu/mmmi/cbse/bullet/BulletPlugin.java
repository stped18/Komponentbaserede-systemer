/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.mmmi.cbse.bullet;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.ShootingPart;
import dk.sdu.mmmi.cbse.common.events.Event;
import dk.sdu.mmmi.cbse.common.events.ShootingEvent;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
import java.util.Random;
import org.graalvm.compiler.replacements.nodes.PluginFactory_ZeroMemoryNode;

/**
 *
 * @author Steffen Vitten
 */
public class BulletPlugin implements IGamePluginService{
    
    private Entity bullet;

    public BulletPlugin() {
    }

    
    

    @Override
    public void start(GameData gameData, World world) { 
            for (Event event : gameData.getEvents()) {
                ShootingPart sh = event.getSource().getPart(ShootingPart.class);
                if(sh.isIsShooting()){
                    bullet=CreateBulletFigur(gameData, world);
                    world.addEntity(bullet);
                }
            
        }

           
        
       
;
    }

    @Override
    public void stop(GameData gameData, World world) {
       
            world.removeEntity(bullet);  
        
              
    }
    private Entity CreateBulletFigur(GameData gameData, World world) {
        for (Entity entity : world.getEntities()) {
            if(entity.getType()==Entity.TYPS.PLAYER){
                float deacceleration = 10;
                float acceleration = 200;
                float maxSpeed = 300;
                float rotationSpeed = 5; 
                Entity bullet = new Bullet(Entity.TYPS.BULLET);
                bullet.add(new MovingPart(deacceleration, acceleration, maxSpeed, rotationSpeed));
                bullet.add(entity.getPart(PositionPart.class));
      
                return bullet;
            }
        }
        return null;
    }
    
}
