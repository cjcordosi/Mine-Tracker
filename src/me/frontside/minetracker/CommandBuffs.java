package me.frontside.minetracker;

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
import java.util.Arrays;

public class CommandBuffs extends DigBuffs implements Listener, CommandExecutor {
    // create inventories for all jobs
    private Inventory BuffInv;
    private Inventory WoodBuffsInv;
    private Inventory DigBuffsInv;
    private Inventory StoneBuffsInv;
    private Inventory OreBuffsInv;
    private Inventory NetherBuffsInv;
    private Inventory FarmBuffsInv;
    private Inventory EnchantBuffsInv;
    private final DigBuffs digBuffs = new DigBuffs();

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player){
            Player p = (Player) commandSender;
            createBuffsMenu(p);
            openBuffsMenu(p);
        }

        return true;
    }
    // opens main GUI
    private void openBuffsMenu(Player p) {
        p.openInventory(BuffInv);
    }
    // creates main GUI
    private void createBuffsMenu(Player p) {
        // create a new inventory with owner: player, size: 27, title: Buff Menu
        BuffInv = Bukkit.createInventory(p, 27, "Buffs Menu");

        // put the items into the inventory
        initializeItems(p);
    }

    // initializes main GUI
    private void initializeItems(Player p) {
        // create iron bars with a blank name attr
        ItemStack noNameIronBars = new ItemStack(Material.IRON_BARS, 1);
        ItemMeta ironMeta = noNameIronBars.getItemMeta();
        ironMeta.setDisplayName(" ");
        noNameIronBars.setItemMeta(ironMeta);

        // create glass panes with a blank name attr
        ItemStack noNameGlassPanes = new ItemStack(Material.GLASS_PANE, 1);
        ItemMeta glassMeta = noNameGlassPanes.getItemMeta();
        glassMeta.setDisplayName(" ");
        noNameGlassPanes.setItemMeta(glassMeta);

        // BuffInv.setItem(index, item)
        // fill top and bottom row with iron bars with one for loop
        for (int i = 0; i < 27; i++){
            if (i == 8){ // when reaching end of the first row, set that item then increment i to skip the middle row
                BuffInv.setItem(i, noNameIronBars);
                i = 18;
            }
            BuffInv.setItem(i, noNameIronBars);
        }

        // set middle row of inventory
        BuffInv.setItem(9, noNameGlassPanes);
        BuffInv.setItem(10, createGUIItem(Material.DARK_OAK_LOG, "Woodcutter Buffs", "§bView available Woodcutter buffs"));
        BuffInv.setItem(11, createGUIItem(Material.SAND, "Digger Buffs", "§bView available Digger buffs"));
        BuffInv.setItem(12, createGUIItem(Material.COBBLESTONE, "Stone Miner Buffs", "§bView available Stone Miner buffs"));
        BuffInv.setItem(13, createGUIItem(Material.IRON_ORE, "Ore Miner Buffs", "§bView available Ore Miner buffs"));
        BuffInv.setItem(14, createGUIItem(Material.NETHERRACK, "Nether Miner Buffs", "§bView available Nether Miner buffs"));
        BuffInv.setItem(15, createGUIItem(Material.WHEAT, "Farmer Buffs", "§bView available Farmer buffs"));
        BuffInv.setItem(16, createGUIItem(Material.ENCHANTING_TABLE, "Enchanter Buffs", "§bView available Enchanter buffs"));
        BuffInv.setItem(17, noNameGlassPanes);
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
        if (e.getInventory() != BuffInv && e.getInventory() != WoodBuffsInv && e.getInventory() != DigBuffsInv &&
                e.getInventory() != StoneBuffsInv && e.getInventory() != OreBuffsInv &&
                e.getInventory() != NetherBuffsInv && e.getInventory() != FarmBuffsInv &&
                e.getInventory() != EnchantBuffsInv){
            return;
        }

        e.setCancelled(true);

        ItemStack clickedItem = e.getCurrentItem();

        // verify current item is not null
        if (clickedItem == null || clickedItem.getType() == Material.AIR) return;

        // get PDC
        Player p = (Player) e.getWhoClicked();
        PersistentDataContainer data = p.getPersistentDataContainer();

        // open separate gui for job specific buffs based upon what block is clicked
        if (clickedItem.getType() == Material.DARK_OAK_LOG){
            createWoodBuffs(p);
            openWoodBuffs(p);
        }
        else if (clickedItem.getType() == Material.SAND){
            createDigBuffs(p);
            openDigBuffs(p);
        }
        else if(clickedItem.getType() == Material.COBBLESTONE){
            createStoneBuffs(p);
            openStoneBuffs(p);
        }
        else if(clickedItem.getType() == Material.IRON_ORE){
            createOreBuffs(p);
            openOreBuffs(p);
        }
        else if(clickedItem.getType() == Material.NETHERRACK){
            createNetherBuffs(p);
            openNetherBuffs(p);
        }
        else if(clickedItem.getType() == Material.WHEAT){
            createFarmerBuffs(p);
            openFarmerBuffs(p);
        }
        else if(clickedItem.getType() == Material.ENCHANTING_TABLE){
            createEnchanterBuffs(p);
            openEnchanterBuffs(p);
        }

        // implement a back button but opening the main gui if the barrier block is clicked
        if (clickedItem.getType() == Material.BARRIER){
            openBuffsMenu(p);
        }

        // TEST for adding a buff to a player
        if (clickedItem.getType() == Material.DIAMOND_SHOVEL){
            digBuffs.giveFastDigging(p);
        }
    }

    // Cancel dragging in our main inventory
    @EventHandler
    public void onInventoryClick(InventoryDragEvent e) {
        if (e.getInventory() == BuffInv || e.getInventory() == WoodBuffsInv || e.getInventory() == DigBuffsInv ||
                e.getInventory() == StoneBuffsInv || e.getInventory() == OreBuffsInv ||
                e.getInventory() == NetherBuffsInv || e.getInventory() == FarmBuffsInv ||
                e.getInventory() == EnchantBuffsInv) {
            e.setCancelled(true);
        }
    }

    private void openWoodBuffs(Player p) {
        p.openInventory(WoodBuffsInv);
    }

    private void createWoodBuffs(Player p){
        // create a new inventory with owner: player, size: 27, title: Buff Menu
        WoodBuffsInv = Bukkit.createInventory(p, 27, "Wood Cutter Buffs Menu");

        // put the items into the inventory
        initializeWoodBuffs(p);
    }

    private void initializeWoodBuffs(Player p) {
        // create iron bars with a blank name attr
        ItemStack noNameIronBars = new ItemStack(Material.IRON_BARS, 1);
        ItemMeta ironMeta = noNameIronBars.getItemMeta();
        ironMeta.setDisplayName(" ");
        noNameIronBars.setItemMeta(ironMeta);

        // create glass panes with a blank name attr
        ItemStack noNameGlassPanes = new ItemStack(Material.GLASS_PANE, 1);
        ItemMeta glassMeta = noNameGlassPanes.getItemMeta();
        glassMeta.setDisplayName(" ");
        noNameGlassPanes.setItemMeta(glassMeta);

        // fill top and bottom row with iron bars with one for loop
        for (int i = 0; i < 27; i++){
            if (i == 22){
                continue;
            }
            else if (i == 8){ // when reaching end of the first row, set that item then increment i to skip the middle row
                WoodBuffsInv.setItem(i, noNameIronBars);
                i = 18;
            }
            WoodBuffsInv.setItem(i, noNameIronBars);
        }

        // add a barrier block to act as a back button
        ItemStack noNameBarrier = new ItemStack(Material.BARRIER, 1);
        ItemMeta barrierMeta = noNameBarrier.getItemMeta();
        barrierMeta.setDisplayName("Back");
        noNameBarrier.setItemMeta(barrierMeta);
        WoodBuffsInv.setItem(22, noNameBarrier);
    }

    private void openDigBuffs(Player p) {
        p.openInventory(DigBuffsInv);
    }

    private void createDigBuffs(Player p){
        // create a new inventory with owner: player, size: 27, title: Buff Menu
        DigBuffsInv = Bukkit.createInventory(p, 27, "Digger Buffs Menu");

        // put the items into the inventory
        initializeDigBuffs(p);
    }

    private void initializeDigBuffs(Player p) {
        // create iron bars with a blank name attr
        ItemStack noNameIronBars = new ItemStack(Material.IRON_BARS, 1);
        ItemMeta ironMeta = noNameIronBars.getItemMeta();
        ironMeta.setDisplayName(" ");
        noNameIronBars.setItemMeta(ironMeta);

        // create glass panes with a blank name attr
        ItemStack noNameGlassPanes = new ItemStack(Material.GLASS_PANE, 1);
        ItemMeta glassMeta = noNameGlassPanes.getItemMeta();
        glassMeta.setDisplayName(" ");
        noNameGlassPanes.setItemMeta(glassMeta);

        // fill top and bottom row with iron bars with one for loop
        for (int i = 0; i < 27; i++){
            if (i == 22){
                continue;
            }
            else if (i == 8){ // when reaching end of the first row, set that item then increment i to skip the middle row
                DigBuffsInv.setItem(i, noNameIronBars);
                i = 18;
            }
            DigBuffsInv.setItem(i, noNameIronBars);
        }

        // add a barrier block to act as a back button
        ItemStack noNameBarrier = new ItemStack(Material.BARRIER, 1);
        ItemMeta barrierMeta = noNameBarrier.getItemMeta();
        barrierMeta.setDisplayName("Back");
        noNameBarrier.setItemMeta(barrierMeta);
        DigBuffsInv.setItem(22, noNameBarrier);

        // TEST item for adding a player buff
        DigBuffsInv.setItem(9, createGUIItem(Material.DIAMOND_SHOVEL, "Fast Digging", "§Allows Player to dig faster"));
    }

    private void openStoneBuffs(Player p) {
        p.openInventory(StoneBuffsInv);
    }

    private void createStoneBuffs(Player p){
        // create a new inventory with owner: player, size: 27, title: Buff Menu
        StoneBuffsInv = Bukkit.createInventory(p, 27, "Stone Miner Buffs Menu");

        // put the items into the inventory
        initializeStoneBuffs(p);
    }

    private void initializeStoneBuffs(Player p) {
        // create iron bars with a blank name attr
        ItemStack noNameIronBars = new ItemStack(Material.IRON_BARS, 1);
        ItemMeta ironMeta = noNameIronBars.getItemMeta();
        ironMeta.setDisplayName(" ");
        noNameIronBars.setItemMeta(ironMeta);

        // create glass panes with a blank name attr
        ItemStack noNameGlassPanes = new ItemStack(Material.GLASS_PANE, 1);
        ItemMeta glassMeta = noNameGlassPanes.getItemMeta();
        glassMeta.setDisplayName(" ");
        noNameGlassPanes.setItemMeta(glassMeta);

        // fill top and bottom row with iron bars with one for loop
        for (int i = 0; i < 27; i++){
            if (i == 22){
                continue;
            }
            else if (i == 8){ // when reaching end of the first row, set that item then increment i to skip the middle row
                StoneBuffsInv.setItem(i, noNameIronBars);
                i = 18;
            }
            StoneBuffsInv.setItem(i, noNameIronBars);
        }

        // add a barrier block to act as a back button
        ItemStack noNameBarrier = new ItemStack(Material.BARRIER, 1);
        ItemMeta barrierMeta = noNameBarrier.getItemMeta();
        barrierMeta.setDisplayName("Back");
        noNameBarrier.setItemMeta(barrierMeta);
        StoneBuffsInv.setItem(22, noNameBarrier);
    }

    private void openOreBuffs(Player p) {
        p.openInventory(OreBuffsInv);
    }

    private void createOreBuffs(Player p){
        // create a new inventory with owner: player, size: 27, title: Buff Menu
        OreBuffsInv = Bukkit.createInventory(p, 27, "Ore Miner Buffs Menu");

        // put the items into the inventory
        initializeOreBuffs(p);
    }

    private void initializeOreBuffs(Player p) {
        // create iron bars with a blank name attr
        ItemStack noNameIronBars = new ItemStack(Material.IRON_BARS, 1);
        ItemMeta ironMeta = noNameIronBars.getItemMeta();
        ironMeta.setDisplayName(" ");
        noNameIronBars.setItemMeta(ironMeta);

        // create glass panes with a blank name attr
        ItemStack noNameGlassPanes = new ItemStack(Material.GLASS_PANE, 1);
        ItemMeta glassMeta = noNameGlassPanes.getItemMeta();
        glassMeta.setDisplayName(" ");
        noNameGlassPanes.setItemMeta(glassMeta);

        // fill top and bottom row with iron bars with one for loop
        for (int i = 0; i < 27; i++){
            if (i == 22){
                continue;
            }
            else if (i == 8){ // when reaching end of the first row, set that item then increment i to skip the middle row
                OreBuffsInv.setItem(i, noNameIronBars);
                i = 18;
            }
            OreBuffsInv.setItem(i, noNameIronBars);
        }

        // add a barrier block to act as a back button
        ItemStack noNameBarrier = new ItemStack(Material.BARRIER, 1);
        ItemMeta barrierMeta = noNameBarrier.getItemMeta();
        barrierMeta.setDisplayName("Back");
        noNameBarrier.setItemMeta(barrierMeta);
        OreBuffsInv.setItem(22, noNameBarrier);
    }

    private void openNetherBuffs(Player p) {
        p.openInventory(NetherBuffsInv);
    }

    private void createNetherBuffs(Player p){
        // create a new inventory with owner: player, size: 27, title: Buff Menu
        NetherBuffsInv = Bukkit.createInventory(p, 27, "Nether Miner Buffs Menu");

        // put the items into the inventory
        initializeNetherBuffs(p);
    }

    private void initializeNetherBuffs(Player p) {
        // create iron bars with a blank name attr
        ItemStack noNameIronBars = new ItemStack(Material.IRON_BARS, 1);
        ItemMeta ironMeta = noNameIronBars.getItemMeta();
        ironMeta.setDisplayName(" ");
        noNameIronBars.setItemMeta(ironMeta);

        // create glass panes with a blank name attr
        ItemStack noNameGlassPanes = new ItemStack(Material.GLASS_PANE, 1);
        ItemMeta glassMeta = noNameGlassPanes.getItemMeta();
        glassMeta.setDisplayName(" ");
        noNameGlassPanes.setItemMeta(glassMeta);

        // fill top and bottom row with iron bars with one for loop
        for (int i = 0; i < 27; i++){
            if (i == 22){
                continue;
            }
            else if (i == 8){ // when reaching end of the first row, set that item then increment i to skip the middle row
                NetherBuffsInv.setItem(i, noNameIronBars);
                i = 18;
            }
            NetherBuffsInv.setItem(i, noNameIronBars);
        }

        // add a barrier block to act as a back button
        ItemStack noNameBarrier = new ItemStack(Material.BARRIER, 1);
        ItemMeta barrierMeta = noNameBarrier.getItemMeta();
        barrierMeta.setDisplayName("Back");
        noNameBarrier.setItemMeta(barrierMeta);
        NetherBuffsInv.setItem(22, noNameBarrier);
    }

    private void openFarmerBuffs(Player p) {
        p.openInventory(FarmBuffsInv);
    }

    private void createFarmerBuffs(Player p){
        // create a new inventory with owner: player, size: 27, title: Buff Menu
        FarmBuffsInv = Bukkit.createInventory(p, 27, "Farmer Buffs Menu");

        // put the items into the inventory
        initializeFarmerBuffs(p);
    }

    private void initializeFarmerBuffs(Player p) {
        // create iron bars with a blank name attr
        ItemStack noNameIronBars = new ItemStack(Material.IRON_BARS, 1);
        ItemMeta ironMeta = noNameIronBars.getItemMeta();
        ironMeta.setDisplayName(" ");
        noNameIronBars.setItemMeta(ironMeta);

        // create glass panes with a blank name attr
        ItemStack noNameGlassPanes = new ItemStack(Material.GLASS_PANE, 1);
        ItemMeta glassMeta = noNameGlassPanes.getItemMeta();
        glassMeta.setDisplayName(" ");
        noNameGlassPanes.setItemMeta(glassMeta);

        // fill top and bottom row with iron bars with one for loop
        for (int i = 0; i < 27; i++){
            if (i == 22){
                continue;
            }
            else if (i == 8){ // when reaching end of the first row, set that item then increment i to skip the middle row
                FarmBuffsInv.setItem(i, noNameIronBars);
                i = 18;
            }
            FarmBuffsInv.setItem(i, noNameIronBars);
        }

        // add a barrier block to act as a back button
        ItemStack noNameBarrier = new ItemStack(Material.BARRIER, 1);
        ItemMeta barrierMeta = noNameBarrier.getItemMeta();
        barrierMeta.setDisplayName("Back");
        noNameBarrier.setItemMeta(barrierMeta);
        FarmBuffsInv.setItem(22, noNameBarrier);
    }

    private void openEnchanterBuffs(Player p) {
        p.openInventory(EnchantBuffsInv);
    }

    private void createEnchanterBuffs(Player p){
        // create a new inventory with owner: player, size: 27, title: Buff Menu
        EnchantBuffsInv = Bukkit.createInventory(p, 27, "Enchanter Buffs Menu");

        // put the items into the inventory
        initializeEnchanterBuffs(p);
    }

    private void initializeEnchanterBuffs(Player p) {
        // create iron bars with a blank name attr
        ItemStack noNameIronBars = new ItemStack(Material.IRON_BARS, 1);
        ItemMeta ironMeta = noNameIronBars.getItemMeta();
        ironMeta.setDisplayName(" ");
        noNameIronBars.setItemMeta(ironMeta);

        // create glass panes with a blank name attr
        ItemStack noNameGlassPanes = new ItemStack(Material.GLASS_PANE, 1);
        ItemMeta glassMeta = noNameGlassPanes.getItemMeta();
        glassMeta.setDisplayName(" ");
        noNameGlassPanes.setItemMeta(glassMeta);

        // fill top and bottom row with iron bars with one for loop
        for (int i = 0; i < 27; i++){
            if (i == 22){
                continue;
            }
            else if (i == 8){ // when reaching end of the first row, set that item then increment i to skip the middle row
                EnchantBuffsInv.setItem(i, noNameIronBars);
                i = 18;
            }
            EnchantBuffsInv.setItem(i, noNameIronBars);
        }

        // add a barrier block to act as a back button
        ItemStack noNameBarrier = new ItemStack(Material.BARRIER, 1);
        ItemMeta barrierMeta = noNameBarrier.getItemMeta();
        barrierMeta.setDisplayName("Back");
        noNameBarrier.setItemMeta(barrierMeta);
        EnchantBuffsInv.setItem(22, noNameBarrier);
    }
}
