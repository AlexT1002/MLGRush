package de.Alex1002.MLGRush.Listener;

import de.Alex1002.MLGRush.Utils.InventoryManager;
import de.Alex1002.MLGRush.Utils.PlayerManager;
import de.Alex1002.MLGRush.init;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMoveListener implements Listener {
    @EventHandler
    public static void playerMove(PlayerMoveEvent event){
        Player player = event.getPlayer();
        if(player.getLocation().getY() <= init.getPlugin().getConfig().getInt("Setup.Map.minHeight")){
            PlayerManager.setHealth(player, 20);
            InventoryManager.clearInventory(player);
            InventoryManager.giveItems(player);
            if(init.getRedTeam().getPlayers().contains(player)){
                player.teleport(init.getLocation("redteam"));
            }else{
                player.teleport(init.getLocation("blueteam"));
            }
            player.setFallDistance(0);
        }
    }
}
