/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.mmmi.cbse.common.data.entityparts;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;

/**
 *
 * @author steff
 */
public class LifeTime implements EntityPart{
    
    int time;

    public LifeTime(int time ) {
       this.time=time;
    }

    public int getTime() {
        return time;
    }
    
    
    
    @Override
    public void process(GameData gameData, Entity entity) {
        this.time -=1;
    }
    
    
}
