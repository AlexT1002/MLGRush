package de.Alex1002.MLGRush.Commands;

import de.Alex1002.MLGRush.init;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SetupCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(commandSender instanceof Player){
            Player player = ((Player) commandSender).getPlayer();
            double X = player.getLocation().getX();
            double Y = player.getLocation().getY();
            double Z = player.getLocation().getZ();
            double YAW = player.getLocation().getYaw();
            double PITCH = player.getLocation().getPitch();
            String WORLD = player.getLocation().getWorld().getName();
            if(strings.length == 1){
                if(strings[0].equalsIgnoreCase("lobbyspawn")){
                    init.getPlugin().getConfig().set("Setup.Lobby.X", X);
                    init.getPlugin().getConfig().set("Setup.Lobby.Y", Y);
                    init.getPlugin().getConfig().set("Setup.Lobby.Z", Z);
                    init.getPlugin().getConfig().set("Setup.Lobby.YAW", YAW);
                    init.getPlugin().getConfig().set("Setup.Lobby.PITCH", PITCH);
                    init.getPlugin().getConfig().set("Setup.Lobby.WORLD", WORLD);
                    init.getPlugin().saveConfig();
                }else if(strings[0].equalsIgnoreCase("redteamspawn")){
                    init.getPlugin().getConfig().set("Setup.Map.redTeam.X", X);
                    init.getPlugin().getConfig().set("Setup.Map.redTeam.Y", Y);
                    init.getPlugin().getConfig().set("Setup.Map.redTeam.Z", Z);
                    init.getPlugin().getConfig().set("Setup.Map.redTeam.YAW", YAW);
                    init.getPlugin().getConfig().set("Setup.Map.redTeam.PITCH", PITCH);
                    init.getPlugin().getConfig().set("Setup.Map.redTeam.WORLD", WORLD);
                    init.getPlugin().saveConfig();
                }else if(strings[0].equalsIgnoreCase("blueteamspawn")){
                    init.getPlugin().getConfig().set("Setup.Map.blueTeam.X", X);
                    init.getPlugin().getConfig().set("Setup.Map.blueTeam.Y", Y);
                    init.getPlugin().getConfig().set("Setup.Map.blueTeam.Z", Z);
                    init.getPlugin().getConfig().set("Setup.Map.blueTeam.YAW", YAW);
                    init.getPlugin().getConfig().set("Setup.Map.blueTeam.PITCH", PITCH);
                    init.getPlugin().getConfig().set("Setup.Map.blueTeam.WORLD", WORLD);
                    init.getPlugin().saveConfig();
                }else if(strings[0].equalsIgnoreCase("maxheight")){
                    init.getPlugin().getConfig().set("Setup.Map.maxHeight", Y);
                    init.getPlugin().saveConfig();
                }else if(strings[0].equalsIgnoreCase("minheight")){
                    init.getPlugin().getConfig().set("Setup.Map.minHeight", Y);
                    init.getPlugin().saveConfig();
                }
            }
        }
        return false;
    }
}
