package de.Alex1002.MLGRush.Listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

public class MobSpawnListener implements Listener {
    @EventHandler
    public static void mobSpawn(EntitySpawnEvent event){
        Player player = (Player) event.getEntity();
        if(event.getEntity().getType().equals(player)){

        }else{
            event.setCancelled(true);
        }
    }
}
