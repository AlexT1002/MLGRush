package de.Alex1002.MLGRush.Listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class PlayerFoodListener implements Listener {
    @EventHandler
    public static void foodLevelChange(FoodLevelChangeEvent event){
        event.setFoodLevel(20);
        event.setCancelled(true);
    }
}
