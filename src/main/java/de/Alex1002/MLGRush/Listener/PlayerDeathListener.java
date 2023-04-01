package de.Alex1002.MLGRush.Listener;

import de.Alex1002.MLGRush.Utils.InventoryManager;
import de.Alex1002.MLGRush.Utils.PlayerManager;
import de.Alex1002.MLGRush.init;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeathListener implements Listener {
    @EventHandler
    public static void playerDeath(PlayerDeathEvent event){
        Player player = event.getPlayer();
        player.setBedSpawnLocation(null);
        Bukkit.getScheduler().runTask(init.getPlugin(), () -> player.spigot().respawn());
        if(init.getRedTeam().getPlayers().contains(player)){
            Bukkit.getScheduler().runTask(init.getPlugin(), () -> player.teleport(init.getLocation("redteam")));
        }else{
            Bukkit.getScheduler().runTask(init.getPlugin(), () -> player.teleport(init.getLocation("blueteam")));
        }
        PlayerManager.setHealth(player, 20);
        InventoryManager.clearInventory(player);
        InventoryManager.giveItems(player);
    }
}
