package de.Alex1002.MLGRush.Listener;

import de.Alex1002.MLGRush.GameStates.EndState;
import de.Alex1002.MLGRush.MLGRush;
import de.Alex1002.MLGRush.Utils.InventoryManager;
import de.Alex1002.MLGRush.Utils.PlayerManager;
import de.Alex1002.MLGRush.Utils.ScoreBoard;
import de.Alex1002.MLGRush.Utils.WorldManager;
import de.Alex1002.MLGRush.init;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.scoreboard.Team;

public class BlockBreakListener implements Listener {
    @EventHandler
    public static void onDestroy(BlockBreakEvent event) {
        Player player = event.getPlayer();
        Block block = event.getBlock();

        if(block.getType().equals(Material.RED_BED)){
            if(init.getBlueTeam().getPlayers().contains(player)){
                ScoreBoard.addPoints(init.getBlueTeamCount());
                for(Player all : init.getPlayerList()){
                    if(init.getRedTeam().getPlayers().contains(all)){
                        Bukkit.getScheduler().runTask(init.getPlugin(), () -> all.teleport(init.getLocation("redteam")));
                    }else{
                        Bukkit.getScheduler().runTask(init.getPlugin(), () -> all.teleport(init.getLocation("blueteam")));
                    }
                    PlayerManager.setHealth(all, 20);
                    InventoryManager.clearInventory(all);
                    InventoryManager.giveItems(all);
                }

                WorldManager.resetWorld();

                if(init.getBlueTeamPoints() == init.getPlugin().getConfig().getInt("Settings.pointsForWin")){
                    init.setWinnerTeam("Team Blau");
                    init.getGameStateManager().startState(new EndState());
                }

                event.setCancelled(true);
            }
            event.setCancelled(true);
        }

        if(block.getType().equals(Material.BLUE_BED)){
            if(init.getRedTeam().getPlayers().contains(player)){
                ScoreBoard.addPoints(init.getRedTeamCount());
                for(Player all : init.getPlayerList()){
                    if(init.getRedTeam().getPlayers().contains(all)){
                        Bukkit.getScheduler().runTask(init.getPlugin(), () -> all.teleport(init.getLocation("redteam")));
                    }else{
                        Bukkit.getScheduler().runTask(init.getPlugin(), () -> all.teleport(init.getLocation("blueteam")));
                    }
                    PlayerManager.setHealth(all, 20);
                    InventoryManager.clearInventory(all);
                    InventoryManager.giveItems(all);
                }

                WorldManager.resetWorld();

                if(init.getRedTeamPoints() == init.getPlugin().getConfig().getInt("Settings.pointsForWin")){
                    init.setWinnerTeam("Team Rot");
                    init.getGameStateManager().startState(new EndState());
                }

                event.setCancelled(true);
            }
            event.setCancelled(true);
        }
    }
}
