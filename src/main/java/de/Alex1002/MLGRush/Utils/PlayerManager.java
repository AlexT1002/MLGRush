package de.Alex1002.MLGRush.Utils;

import de.Alex1002.MLGRush.init;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

public class PlayerManager {
    public static void setGameMode(Player player, GameMode gameMode){
        Bukkit.getScheduler().runTask(init.getPlugin(), () -> player.setGameMode(gameMode));
    }
    public static void setHealth(Player player, double health){
        int food = (int) health;
        Bukkit.getScheduler().runTask(init.getPlugin(), () -> player.setHealth(health));
        Bukkit.getScheduler().runTask(init.getPlugin(), () -> player.setFoodLevel(food));
    }
}
