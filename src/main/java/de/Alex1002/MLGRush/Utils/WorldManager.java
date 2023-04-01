package de.Alex1002.MLGRush.Utils;

import de.Alex1002.MLGRush.init;
import org.bukkit.Material;
import org.bukkit.block.Block;

public class WorldManager {
    public static void resetWorld(){
        for(Block block : init.getPlacedBlocks()){
            block.getWorld().getBlockAt(block.getLocation()).setType(Material.AIR);
        }
    }
}
