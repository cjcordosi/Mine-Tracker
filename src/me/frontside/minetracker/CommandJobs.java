package me.frontside.minetracker;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.Arrays;

public class CommandJobs implements CommandExecutor, Listener {
    private Inventory jobsMenu;

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] strings) {
        // If the command sender is a player, open the jobsMenu for that player
        if(commandSender instanceof Player) {
            Player p = (Player) commandSender;
            createJobsMenu(p);
            openJobsMenu(p);
        }

        return true;
    }

    // Create an empty inventory, owener of player, of size 27 named Jobs
    public void createJobsMenu(Player p){
        jobsMenu = Bukkit.createInventory(p, 27, "Jobs");

        initializeItems(p);
    }

    // Add static items to the Job Menu, items and item lore reflect job
    public void initializeItems(Player p){
        ItemStack filler = new ItemStack(Material.IRON_BARS, 1);
        ItemStack spacer = new ItemStack(Material.GLASS_PANE, 1);

        String currJob = p.getPersistentDataContainer().get(new NamespacedKey(MineTracker.getPlugin(), "current_job"), PersistentDataType.STRING);

        for(int i = 0; i < 9; i ++){
            jobsMenu.setItem(jobsMenu.firstEmpty(), filler);
        }
        jobsMenu.setItem(jobsMenu.firstEmpty(), spacer);
        jobsMenu.addItem(createGuiItem(Material.IRON_AXE, "Wood Cutter", "§aWood Cutters specialize", "§ain harvesting the full", "§avariety of the arboretum."));
        jobsMenu.addItem(createGuiItem(Material.DIAMOND_SHOVEL, "Digger", "§aDiggers specialize in", "§acollecting raw material", "§awith a shovel."));
        jobsMenu.addItem(createGuiItem(Material.STONE_PICKAXE, "Stone Miner", "§aStone Miners specialize", "§ain quarrying large", "§astone deposits."));
        jobsMenu.addItem(createGuiItem(Material.DIAMOND_PICKAXE, "Ore Miner", "§aOre Miners specialize", "§ain excavating precious", "§ametals and gems."));
        jobsMenu.addItem(createGuiItem(Material.NETHERITE_PICKAXE, "Nether Miner", "§aNether Miners specialize", "§ain collection and traversal", "§aof the Nether."));
        jobsMenu.addItem(createGuiItem(Material.GOLDEN_HOE, "Farmer", "§aFarmers specialize in", "§aharvesting all types", "§aof crops."));
        jobsMenu.addItem(createGuiItem(Material.ENCHANTED_BOOK, "Enchanter", "§aEnchanters specialize in", "§aharnessing the magical", "§aproperties of weapons, tools,", "§aand armor."));
        jobsMenu.setItem(jobsMenu.firstEmpty(), spacer);
        for(int i = 0; i < 4; i ++){
            jobsMenu.setItem(jobsMenu.firstEmpty(), filler);
        }

        jobsMenu.addItem(createGuiItem(Material.CRAFTING_TABLE, "&aCurrent Job", currJob));

        for(int i = 0; i < 4; i ++){
            jobsMenu.setItem(jobsMenu.firstEmpty(), filler);
        }
    }

    // Set up item names, descriptions, and lore from passed in parameters in initializeItems();
    protected ItemStack createGuiItem(final Material material, final String name, final String... lore){
        ItemStack item = new ItemStack(material, 1);
        ItemMeta meta = item.getItemMeta();

        // Set the name of the item
        meta.setDisplayName(name);
        // Set the lore of the item, each different piece of lore being a new lore line
        meta.setLore(Arrays.asList(lore));

        item.setItemMeta(meta);

        return item;
    }

    // Open the jobsMenu
    public void openJobsMenu(Player p){
        p.openInventory(jobsMenu);
    }

    // Handle clicking on items in the jobsMenu inventory only
    @EventHandler
    public void onInventoryClick(InventoryClickEvent e){
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
        PersistentDataContainer data = p.getPersistentDataContainer();

        // Here we add functionality for what happens when a certain item is clicked
        String currentJob = data.get(new NamespacedKey(MineTracker.getPlugin(), "current_job"), PersistentDataType.STRING);
        String selectedJob = e.getCurrentItem().getItemMeta().getDisplayName();
        if(selectedJob.equals(currentJob)){
            p.sendMessage("&aYou already have " + selectedJob + " selected.");
        }else{
            data.set(new NamespacedKey(MineTracker.getPlugin(), "current_job"), PersistentDataType.STRING, selectedJob);
        }
    }

    // Cancel the dragging of items from jobsMenu to player inventory
    @EventHandler
    public void onInventoryClick(InventoryDragEvent e){
        if(e.getInventory() == jobsMenu) e.setCancelled(true);
    }

    // Detect join event from player
    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        // Player object, player that joined
        Player p = e.getPlayer();

        // Check to see if the recently joined player does or does not have necessary job assignment value, if not, give them it.
        if(!p.getPersistentDataContainer().has(new NamespacedKey(MineTracker.getPlugin(), "current_job"), PersistentDataType.STRING)) {
            p.getPersistentDataContainer().set(new NamespacedKey(MineTracker.getPlugin(), "current_job"), PersistentDataType.STRING, "NULL");
        }
    }
}
