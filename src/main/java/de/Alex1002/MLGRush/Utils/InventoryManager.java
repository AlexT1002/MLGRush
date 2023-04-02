package de.Alex1002.MLGRush.Utils;

import de.Alex1002.MLGRush.init;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.File;
import java.io.IOException;

public class InventoryManager {
    private static File playerDataFile = new File("plugins/MLGRush/playerdata.yml");
    private static YamlConfiguration playerData = YamlConfiguration.loadConfiguration(playerDataFile);

    private static Inventory settingsInv = Bukkit.createInventory(null, 9, "§6§lSettings");


    private static ItemStack settings = new ItemStack(Material.COMPARATOR);


    private static ItemStack stick = new ItemStack(Material.STICK);
    private static ItemMeta stickMeta = stick.getItemMeta();

    private static ItemStack pickaxe = new ItemStack(Material.WOODEN_PICKAXE);


    private static ItemStack blocks = new ItemStack(Material.SANDSTONE);

    private static ItemMeta pickaxeMeta = pickaxe.getItemMeta();
    private static ItemMeta blocksMeta = blocks.getItemMeta();
    private static ItemMeta settingsMeta = settings.getItemMeta();

    public InventoryManager(){
        stickMeta.setDisplayName(init.getPlugin().getConfig().getString("Items.stickName"));
        stickMeta.addEnchant(Enchantment.KNOCKBACK, 2, true);
        pickaxeMeta.setDisplayName(init.getPlugin().getConfig().getString("Items.pickaxeName"));
        pickaxeMeta.addEnchant(Enchantment.DIG_SPEED, 3, true);
        pickaxeMeta.setUnbreakable(true);
        blocksMeta.setDisplayName(init.getPlugin().getConfig().getString("Items.blocksName"));
        blocks.setAmount(64);

    }

    public static void giveItems(Player player) {
        player.getInventory().setItem(getPlayersSettingsSlot(player, "stick"), stick);
        player.getInventory().setItem(getPlayersSettingsSlot(player, "blocks"), blocks);
        player.getInventory().setItem(getPlayersSettingsSlot(player, "pickaxe"), pickaxe);

    }

    public static void giveSettingsItem(Player player) {
        settingsMeta.setDisplayName(init.getPlugin().getConfig().getString("Items.settingsName"));
        settings.setItemMeta(settingsMeta);
        try {
            if (playerDataFile.exists()) {
                if (playerData.contains(String.valueOf(player.getUniqueId()))) {

                } else {
                    playerData.set(String.valueOf(player.getUniqueId()), "0,1,2");
                    playerData.save(playerDataFile);
                }
            } else {
                if (playerDataFile.createNewFile()) {
                    if (playerData.contains(String.valueOf(player.getUniqueId()))) {

                    } else {
                        playerData.set(String.valueOf(player.getUniqueId()), "0,1,2");
                        playerData.save(playerDataFile);
                    }
                }
            }
        } catch (Exception e) {

        }

        player.getInventory().setItem(8, settings);
    }

    public void openSettingsInventory(Player player) {
        settingsInv.clear();
        stickMeta.setDisplayName(init.getPlugin().getConfig().getString("Items.stickName"));
        stickMeta.addEnchant(Enchantment.KNOCKBACK, 2, true);
        pickaxeMeta.setDisplayName(init.getPlugin().getConfig().getString("Items.pickaxeName"));
        pickaxeMeta.addEnchant(Enchantment.DIG_SPEED, 3, true);
        pickaxeMeta.setUnbreakable(true);
        blocksMeta.setDisplayName(init.getPlugin().getConfig().getString("Items.blocksName"));

        if (playerData.contains(String.valueOf(player.getUniqueId()))) {
            String playerSettings = playerData.getString(String.valueOf(player.getUniqueId()));
            String[] splitted = playerSettings.split(",");
            settingsInv.setItem(Integer.parseInt(splitted[0]), stick);
            settingsInv.setItem(Integer.parseInt(splitted[1]), pickaxe);
            settingsInv.setItem(Integer.parseInt(splitted[2]), blocks);


            player.openInventory(settingsInv);
        }
    }


    public static void clearInventory (Player player){
        player.getInventory().clear();
    }


    public static int getPlayersSettingsSlot(Player player, String item){
        String playerSettings = playerData.getString(String.valueOf(player.getUniqueId()));
        String[] splitted = playerSettings.split(",");
        if(item.equalsIgnoreCase("stick")){
            return Integer.parseInt(splitted[0]);
        }else if(item.equalsIgnoreCase("pickaxe")){
            return Integer.parseInt(splitted[1]);
        }else if(item.equalsIgnoreCase("blocks")){
            return Integer.parseInt(splitted[2]);
        }
        return 0;
    }

    public static Inventory getSettingsInv(){
        return settingsInv;
    }

    public static File getPlayerDataFile() {
        return playerDataFile;
    }
    public static YamlConfiguration getPlayerData() {
        return playerData;
    }
}
