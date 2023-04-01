package de.Alex1002.MLGRush.Listener;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerInteractListener implements Listener {
    @EventHandler
    public static void playerInteract(PlayerInteractEvent event){
        Player player = event.getPlayer();
        if(event.getAction().isRightClick()){
            try{
                if(event.getItem().getType().equals(Material.RED_BED) || event.getItem().getType().equals(Material.BLUE_BED)){
                    event.setCancelled(true);
                }
            }catch (Exception e){

            }
        }
    }
}
