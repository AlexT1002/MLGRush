package de.Alex1002.MLGRush.Utils;

import de.Alex1002.MLGRush.init;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class InventoryManager {
    private static ItemStack stick = new ItemStack(Material.STICK);
    private static ItemStack pickaxe = new ItemStack(Material.WOODEN_PICKAXE);
    private static ItemStack blocks = new ItemStack(Material.SANDSTONE);

    private static ItemMeta stickMeta = stick.getItemMeta();
    private static ItemMeta pickaxeMeta = pickaxe.getItemMeta();
    private static ItemMeta blocksMeta = blocks.getItemMeta();


    public static void giveItems(Player player){
        stickMeta.setDisplayName(init.getPlugin().getConfig().getString("Items.stickName"));
        stickMeta.addEnchant(Enchantment.KNOCKBACK, 2, true);
        pickaxeMeta.setDisplayName(init.getPlugin().getConfig().getString("Items.pickaxeName"));
        pickaxeMeta.addEnchant(Enchantment.DIG_SPEED, 3, true);
        pickaxeMeta.setUnbreakable(true);
        blocksMeta.setDisplayName(init.getPlugin().getConfig().getString("Items.blocksName"));
        blocks.setAmount(64);


        stick.setItemMeta(stickMeta);
        pickaxe.setItemMeta(pickaxeMeta);
        blocks.setItemMeta(blocksMeta);

        player.getInventory().setItem(0, stick);
        player.getInventory().setItem(1, blocks);
        player.getInventory().setItem(2, pickaxe);

    }


    public static void clearInventory(Player player){
        player.getInventory().clear();
    }
}
