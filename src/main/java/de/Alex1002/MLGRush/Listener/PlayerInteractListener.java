package de.Alex1002.MLGRush.Listener;

import de.Alex1002.MLGRush.Utils.InventoryManager;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerInteractListener implements Listener {
    @EventHandler
    public static void playerInteract(PlayerInteractEvent event){
        Player player = event.getPlayer();
        InventoryManager inventoryManager = new InventoryManager();
        if(event.getAction().isRightClick()){
            try{
                if(event.getItem().getType().equals(Material.RED_BED) || event.getItem().getType().equals(Material.BLUE_BED)){
                    event.setCancelled(true);
                }else if(event.getItem().getType().equals(Material.COMPARATOR)) {
                    inventoryManager.openSettingsInventory(player);
                }
            }catch (Exception e){

            }
        }
    }
}
