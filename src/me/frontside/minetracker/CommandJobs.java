package me.frontside.minetracker;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class CommandJobs implements CommandExecutor, Listener {
    private Inventory jobsMenu;

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        // If the command sender is a player, open the jobsMenu for that player
        if(commandSender instanceof Player) {
            HumanEntity sender = (HumanEntity) commandSender;
            openJobsMenu(sender);
        }

        return true;
    }

    // Create an empty inventory, without an owner, of size 27 named Jobs
    public void createJobsMenu(){
        jobsMenu = Bukkit.createInventory(null, 27, "Jobs");

        initializeItems();
    }

    // Add items to the inventory (These are custom items, but will later consist of the actual jobs"
    public void initializeItems(){
        jobsMenu.addItem(createGuiItem(Material.GREEN_STAINED_GLASS_PANE, "FINISHED", "§a100/100", "§bMine 100 stone."));
        jobsMenu.addItem(createGuiItem(Material.YELLOW_STAINED_GLASS_PANE, "IN PROGRESS", "§a50/75", "§bCut 75 wood logs."));
        jobsMenu.addItem(createGuiItem(Material.RED_STAINED_GLASS_PANE, "§bNOT STARTED", "§a0/350", "§bMine 350 netherrack."));
    }

    // Set up item names, descriptions, and lore from passed in parameters in initializeItems();
    protected ItemStack createGuiItem(final Material material, final String name, final String... lore){
        final ItemStack item = new ItemStack(material, 1);
        final ItemMeta meta = item.getItemMeta();

        // Set the name of the item
        meta.setDisplayName(name);
        // Set the lore of the item, each different piece of lore being a new lore line
        meta.setLore(Arrays.asList(lore));

        item.setItemMeta(meta);

        return item;
    }

    // Open the jobsMenu
    public void openJobsMenu(final HumanEntity humanEntity){
        humanEntity.openInventory(jobsMenu);
    }

    // Handle clicking on items in the jobsMenu inventory only
    @EventHandler
    public void onInventoryClick(final InventoryClickEvent e){
        // If not in the jobsMenu inventory, return
        if(e.getInventory() != jobsMenu) return;

        // Cancel the normal click event
        e.setCancelled(true);

        // Get the item that was clicked
        final ItemStack clickedItem = e.getCurrentItem();

        // If the item is NULL or the inventory space is empty, return
        if(clickedItem == null || clickedItem.getType() == Material.AIR) return;

        // See who clicked the item
        final Player p = (Player) e.getWhoClicked();

        // Here we add functionality for what happens when a certain item is clicked
    }

    // Cancel the dragging of items from jobsMenu to player inventory
    @EventHandler
    public void onInventoryClick(final InventoryDragEvent e){
        if(e.getInventory() == jobsMenu) e.setCancelled(true);
    }
}
