package de.Alex1002.MLGRush.Commands;

import de.Alex1002.MLGRush.GameStates.IngameState;
import de.Alex1002.MLGRush.GameStates.LobbyState;
import de.Alex1002.MLGRush.init;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class AgainCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(commandSender instanceof Player){
            Player player = ((Player) commandSender).getPlayer();
            if(player.hasPermission("MLGRush.restart")){
                init.getGameStateManager().startState(new IngameState());
            }
        }
        return false;
    }
}
