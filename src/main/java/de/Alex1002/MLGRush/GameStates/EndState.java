package de.Alex1002.MLGRush.GameStates;

import de.Alex1002.MLGRush.init;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class EndState implements GameStates{
    @Override
    public void start() {
        for(Player all : init.getPlayerList()){
            Bukkit.getScheduler().runTask(init.getPlugin(), () -> all.teleport(init.getLocation("lobbyspawn")));
            all.sendTitle("§1§l"+init.getWinnerTeam(), "§6hat Gewonnen!");
        }
    }

    @Override
    public void stop() {

    }
}
