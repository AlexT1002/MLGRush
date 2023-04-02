package de.Alex1002.MLGRush.Listener;

import de.Alex1002.MLGRush.Utils.InventoryManager;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;

public class InventoryCloseListener implements Listener {
    @EventHandler
    public static void inventoryClose(InventoryCloseEvent event){
        int stickInt = 0;
        int pickaxeInt = 1;
        int blocksInt = 2;

        Player player = (Player) event.getPlayer();
        try{
            if(event.getInventory().equals(InventoryManager.getSettingsInv())){
                for(int i = 0; i < InventoryManager.getSettingsInv().getSize(); i++){
                    if(InventoryManager.getSettingsInv().getItem(i) != null){
                        if(InventoryManager.getSettingsInv().getItem(i).getType().equals(Material.STICK)){
                            stickInt = i;
                        }else if(InventoryManager.getSettingsInv().getItem(i).getType().equals(Material.WOODEN_PICKAXE)){
                            pickaxeInt = i;
                        }else if(InventoryManager.getSettingsInv().getItem(i).getType().equals(Material.SANDSTONE)){
                            blocksInt = i;
                        }
                    }
                    InventoryManager.getPlayerData().set(String.valueOf(player.getUniqueId()), stickInt + "," + pickaxeInt + "," + blocksInt);
                    InventoryManager.getPlayerData().save(InventoryManager.getPlayerDataFile());

                    InventoryManager.clearInventory(player);
                    InventoryManager.giveSettingsItem(player);
                }

            }
        }catch(Exception e){

        }
    }
}
