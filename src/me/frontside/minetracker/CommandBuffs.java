package me.frontside.minetracker;

import com.mysql.fabric.xmlrpc.base.Array;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import sun.awt.image.BufImgSurfaceData;

import java.util.Arrays;

public class CommandBuffs implements Listener, CommandExecutor {
    private Inventory BuffInv;

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player){
            Player p = (Player) commandSender;
            createBuffsMenu(p);
            openBuffsMenu(p);
        }
        

        return true;
    }

    private void openBuffsMenu(Player p) {
        p.openInventory(BuffInv);
    }

    private void createBuffsMenu(Player p) {
        // create a new inventory with owner: player, size: 27, title: Buff Menu
        BuffInv = Bukkit.createInventory(p, 27, "Buff Menu");

        // put the items into the inventory
        initializeItems(p);
    }

    // can be called to put items into the inventory
    private void initializeItems(Player p) {
        
    }

    protected ItemStack createGUIItem(final Material material, final String name, final String... lore){

        ItemStack item = new ItemStack(material, 1);
        ItemMeta meta = item.getItemMeta();

        // set the name of the item
        meta.setLore(Arrays.asList(lore));
        meta.setDisplayName(name);

        item.setItemMeta(meta);

        return item;
    }

    // Check for clicks on items
    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        if (e.getInventory() != BuffInv) return;

        e.setCancelled(true);

        ItemStack clickedItem = e.getCurrentItem();

        // verify current item is not null
        if (clickedItem == null || clickedItem.getType() == Material.AIR) return;

        // get PDC
        Player p = (Player) e.getWhoClicked();
        PersistentDataContainer data = p.getPersistentDataContainer();
    }

    // Cancel dragging in our inventory
    @EventHandler
    public void onInventoryClick(InventoryDragEvent e) {
        if (e.getInventory() == BuffInv) {
            e.setCancelled(true);
        }
    }
}
