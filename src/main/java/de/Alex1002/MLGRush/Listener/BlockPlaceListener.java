package de.Alex1002.MLGRush.Listener;

import de.Alex1002.MLGRush.init;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPlaceListener implements Listener {
    @EventHandler
    public static void onPlace(BlockPlaceEvent event){
        Block block = event.getBlock();
        init.addBlock(block);

        if(block.getLocation().getY() >= init.getPlugin().getConfig().getInt("Setup.Map.maxHeight")){
            event.setCancelled(true);
        }
    }
}
