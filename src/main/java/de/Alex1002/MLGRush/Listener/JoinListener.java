package de.Alex1002.MLGRush.Listener;

import de.Alex1002.MLGRush.Utils.InventoryManager;
import de.Alex1002.MLGRush.Utils.PlayerManager;
import de.Alex1002.MLGRush.init;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Objects;

public class JoinListener implements Listener {
    @EventHandler
    public static void playerJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        String joinMessage = init.getPlugin().getConfig().getString("Messages.JoinMessage").replace("%player%", player.getName());
        event.setJoinMessage(joinMessage);

        PlayerManager.setGameMode(player, GameMode.ADVENTURE);
        PlayerManager.setHealth(player, 20);
        InventoryManager.clearInventory(player);
        InventoryManager.giveSettingsItem(player);

        player.teleport(init.getLocation("lobbyspawn"));
        init.addPlayer(event.getPlayer());
    }
}
