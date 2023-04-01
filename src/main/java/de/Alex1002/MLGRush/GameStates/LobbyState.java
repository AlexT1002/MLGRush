package de.Alex1002.MLGRush.GameStates;

import de.Alex1002.MLGRush.init;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class LobbyState implements GameStates{
    @Override
    public void start() {
        Bukkit.getScheduler().runTaskTimerAsynchronously(init.getPlugin(), new Runnable() {
            int timerSeconds = init.getTimerSeconds();
            @Override
            public void run() {
                if(init.getPlayerList().size() == init.getPlugin().getConfig().getInt("Settings.minPlayers")){
                    switch(timerSeconds) {
                        case 5:
                            for (Player all : init.getPlayerList()) {
                                all.sendMessage(init.getPlugin().getConfig().getString("Messages.Timer.5seconds"));
                            }
                            break;
                        case 3:
                            for (Player all : init.getPlayerList()) {
                                all.sendMessage(init.getPlugin().getConfig().getString("Messages.Timer.3seconds"));
                            }
                            break;
                        case 2:
                            for (Player all : init.getPlayerList()) {
                                all.sendMessage(init.getPlugin().getConfig().getString("Messages.Timer.2seconds"));
                            }
                            break;
                        case 1:
                            for (Player all : init.getPlayerList()) {
                                all.sendMessage(init.getPlugin().getConfig().getString("Messages.Timer.1seconds"));
                                Bukkit.getScheduler().cancelTasks(init.getPlugin());
                                init.getGameStateManager().startState(new IngameState());
                            }
                            break;
                    }
                    timerSeconds = timerSeconds -1;
                }else{
                    timerSeconds = init.getTimerSeconds();
                }
            }
        }, 0, 20);
    }

    @Override
    public void stop() {

    }
}
