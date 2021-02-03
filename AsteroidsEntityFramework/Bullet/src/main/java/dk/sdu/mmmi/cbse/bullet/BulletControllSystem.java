/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.mmmi.cbse.bullet;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.LifePart;
import dk.sdu.mmmi.cbse.common.data.entityparts.LifeTime;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.ShootingPart;
import dk.sdu.mmmi.cbse.common.events.Event;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;

/**
 *
 * @author steff
 */
public class BulletControllSystem implements IEntityProcessingService{
    
    
    private Entity bullet;
    

    @Override
    public void process(GameData gameData, World world) {
         for (Event event : gameData.getEvents()) {
            if (((ShootingPart) event.getSource().getPart(ShootingPart.class)).isIsShooting()) {
                bullet = CreateBulletFigur(gameData, world, event.getSource());
                world.addEntity(bullet);
                gameData.removeEvent(event);
                 
            }

        }
        
        
         
        for (Entity bullet : world.getEntities(Bullet.class)) {
            MovingPart movingPart = bullet.getPart(MovingPart.class);
            movingPart.setUp(true);
            
            PositionPart positionPart = bullet.getPart(PositionPart.class);
            LifeTime lifeTime= bullet.getPart(LifeTime.class);
            
            movingPart.process(gameData, bullet);
            positionPart.process(gameData, bullet);
            lifeTime.process(gameData, bullet);
            if (lifeTime.getTime()<=0){
                world.removeEntity(bullet);
            }else{
               updateShape(bullet); 
            }        
            
        }
        
       

        
    }
    private void updateShape(Entity entity) {
        float[] shapex = entity.getShapeX();
        float[] shapey = entity.getShapeY();
        PositionPart positionPart = entity.getPart(PositionPart.class);
        float x = positionPart.getX();
        float y = positionPart.getY();
        float radians = positionPart.getRadians();

        shapex[0] = (float) (x + Math.cos(radians) * 2);
        shapey[0] = (float) (y + Math.sin(radians) * 2);
        
        shapex[1] = (float) (x + Math.cos(radians - 4 * 3.1415f / 5) * 2);
        shapey[1] = (float) (y + Math.sin(radians - 4 * 3.1145f / 5) * 2);

        shapex[2] = (float) (x + Math.cos(radians + 3.1415f) * 5);
        shapey[2] = (float) (y + Math.sin(radians + 3.1415f) * 5);

        shapex[3] = (float) (x + Math.cos(radians + 4 * 3.1415f / 5) * 2);
        shapey[3] = (float) (y + Math.sin(radians + 4 * 3.1415f / 5) * 2);

        entity.setShapeX(shapex);
        entity.setShapeY(shapey);
    }
    private Entity CreateBulletFigur(GameData gameData, World world, Entity entity) {

        float deacceleration = 20;
        float acceleration = 10000;
        float maxSpeed = 10000;
        float rotationSpeed = 5;
        float x =((PositionPart)entity.getPart(PositionPart.class)).getX();
        float y = ((PositionPart)entity.getPart(PositionPart.class)).getY();
        float radians = ((PositionPart)entity.getPart(PositionPart.class)).getRadians();
        Entity bullet = new Bullet();
        bullet.add(new MovingPart(deacceleration, acceleration, maxSpeed, rotationSpeed));
        bullet.add(new PositionPart(x, y, radians));
        bullet.add(new LifeTime(10));

        return bullet;
    }
}
