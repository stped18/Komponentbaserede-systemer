/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.mmmi.cbse.common.data.entityparts;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.events.Event;


/**
 *
 * @author Steffen Vitten
 */
public class ShootingPart implements EntityPart{
    
    private boolean isShooting=false;

    public ShootingPart() {
    }

    public boolean isIsShooting() {
        return isShooting;
    }

    public void setIsShooting(boolean isShooting) {
        this.isShooting = isShooting;
    }

    
    @Override
    public void process(GameData gameData, Entity entity) {
            gameData.addEvent(new Event(entity));
        
        
    }
    
}
