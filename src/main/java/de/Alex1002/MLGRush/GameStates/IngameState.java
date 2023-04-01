package de.Alex1002.MLGRush.GameStates;

import de.Alex1002.MLGRush.Listener.BlockBreakListener;
import de.Alex1002.MLGRush.Utils.InventoryManager;
import de.Alex1002.MLGRush.Utils.PlayerManager;
import de.Alex1002.MLGRush.Utils.ScoreBoard;
import de.Alex1002.MLGRush.init;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;

public class IngameState implements GameStates{
    @Override
    public void start() {
        init.setRedTeamPoints(0);
        init.setBlueTeamPoints(0);

        for(Player all : init.getPlayerList()){
            ScoreBoard.setScoreboard(all);
            ScoreBoard.addToTeam(all);

            InventoryManager.clearInventory(all);
            InventoryManager.giveItems(all);
            PlayerManager.setHealth(all, 20);
            PlayerManager.setGameMode(all, GameMode.SURVIVAL);
        }
        Bukkit.getScheduler().runTask(init.getPlugin(), new Runnable() {
            @Override
            public void run() {
                for(Player all : init.getRedTeamList()){
                    all.teleport(init.getLocation("redteam"));
                }
                for(Player all : init.getBlueTeamList()){
                    all.teleport(init.getLocation("blueteam"));
                }
            }
        });
    }

    @Override
    public void stop() {

    }
}
