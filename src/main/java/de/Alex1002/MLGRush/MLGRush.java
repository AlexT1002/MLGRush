package de.Alex1002.MLGRush;

import de.Alex1002.MLGRush.Commands.AgainCommand;
import de.Alex1002.MLGRush.Commands.SetupCommand;
import de.Alex1002.MLGRush.Commands.StartCommand;
import de.Alex1002.MLGRush.GameStates.LobbyState;
import de.Alex1002.MLGRush.Listener.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class MLGRush extends JavaPlugin {
    @Override
    public void onEnable() {
        init.setPlugin(this);
        init.getPlugin().saveDefaultConfig();
        registerListener();
        registerCommands();

        init.getPlugin().saveDefaultConfig();

        init.getGameStateManager().startState(new LobbyState());
    }


    private static void registerListener(){
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new JoinListener(), init.getPlugin());
        pluginManager.registerEvents(new QuitListener(), init.getPlugin());
        pluginManager.registerEvents(new BlockBreakListener(), init.getPlugin());
        pluginManager.registerEvents(new BlockPlaceListener(), init.getPlugin());
        pluginManager.registerEvents(new PlayerMoveListener(), init.getPlugin());
        pluginManager.registerEvents(new PlayerDeathListener(), init.getPlugin());
        pluginManager.registerEvents(new PlayerInteractListener(), init.getPlugin());
        pluginManager.registerEvents(new PlayerFoodListener(), init.getPlugin());
    }

    private void registerCommands(){
        getCommand("setup").setExecutor(new SetupCommand());
        getCommand("start").setExecutor(new StartCommand());
        getCommand("again").setExecutor(new AgainCommand());
    }
}