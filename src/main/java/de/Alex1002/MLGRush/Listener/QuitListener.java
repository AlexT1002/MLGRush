package de.Alex1002.MLGRush.Listener;

import de.Alex1002.MLGRush.init;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.Objects;

public class QuitListener implements Listener {
    @EventHandler
    public static void playerQuit(PlayerQuitEvent event){
        Player player = event.getPlayer();
        String quitMessage = init.getPlugin().getConfig().getString("Messages.QuitMessage").replace("%player%", player.getName());
        event.setQuitMessage(quitMessage);
        init.removePlayer(event.getPlayer());
        init.setTimerSeconds(5);
    }
}