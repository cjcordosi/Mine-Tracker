package me.frontside.minetracker;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.Collection;
import java.util.Objects;

public class BlockBreakListener implements Listener {

    @EventHandler
    public void onBreak(BlockBreakEvent e){
        Player p = e.getPlayer();
        PersistentDataContainer data = p.getPersistentDataContainer();

        e.setCancelled(true);

        Block block = e.getBlock();

        ItemStack tool = e.getPlayer().getInventory().getItemInMainHand();
        Collection<ItemStack> drops = block.getDrops(tool);

        if(block.getType() == Material.DIRT || block.getType() == Material.GRASS_BLOCK){
            int dirtcount = data.get(new NamespacedKey(MineTracker.getPlugin(), "dirtcount"), PersistentDataType.INTEGER);
            dirtcount++;
            data.set(new NamespacedKey(MineTracker.getPlugin(), "dirtcount"), PersistentDataType.INTEGER, dirtcount);
        }else if(block.getType() == Material.STONE){
            int stonecount = data.get(new NamespacedKey(MineTracker.getPlugin(), "stonecount"), PersistentDataType.INTEGER);
            stonecount++;
            data.set(new NamespacedKey(MineTracker.getPlugin(), "stonecount"), PersistentDataType.INTEGER, stonecount);
        }else if(block.getType() == Material.GRAVEL){
            int gravelcount = data.get(new NamespacedKey(MineTracker.getPlugin(), "gravelcount"), PersistentDataType.INTEGER);
            gravelcount++;
            data.set(new NamespacedKey(MineTracker.getPlugin(), "gravelcount"), PersistentDataType.INTEGER, gravelcount);
        }else if(block.getType() == Material.SAND || block.getType() == Material.RED_SAND){
            int sandcount = data.get(new NamespacedKey(MineTracker.getPlugin(), "sandcount"), PersistentDataType.INTEGER);
            sandcount++;
            data.set(new NamespacedKey(MineTracker.getPlugin(), "sandcount"), PersistentDataType.INTEGER, sandcount);
        }else if(block.getType() == Material.CLAY){
            int claycount = data.get(new NamespacedKey(MineTracker.getPlugin(), "claycount"), PersistentDataType.INTEGER);
            claycount++;
            data.set(new NamespacedKey(MineTracker.getPlugin(), "claycount"), PersistentDataType.INTEGER, claycount);
        }else if(block.getType() == Material.GRANITE){
            int granitecount = data.get(new NamespacedKey(MineTracker.getPlugin(), "granitecount"), PersistentDataType.INTEGER);
            granitecount++;
            data.set(new NamespacedKey(MineTracker.getPlugin(), "granitecount"), PersistentDataType.INTEGER, granitecount);
        }else if(block.getType() == Material.DIORITE){
            int dioritecount = data.get(new NamespacedKey(MineTracker.getPlugin(), "dioritecount"), PersistentDataType.INTEGER);
            dioritecount++;
            data.set(new NamespacedKey(MineTracker.getPlugin(), "dioritecount"), PersistentDataType.INTEGER, dioritecount);
        }else if(block.getType() == Material.OBSIDIAN){
            int obsidiancount = data.get(new NamespacedKey(MineTracker.getPlugin(), "obsidiancount"), PersistentDataType.INTEGER);
            obsidiancount++;
            data.set(new NamespacedKey(MineTracker.getPlugin(), "obsidiancount"), PersistentDataType.INTEGER, obsidiancount);
        }else if(block.getType() == Material.ANDESITE) {
            int andesitecount = data.get(new NamespacedKey(MineTracker.getPlugin(), "andesitecount"), PersistentDataType.INTEGER);
            andesitecount++;
            data.set(new NamespacedKey(MineTracker.getPlugin(), "andesitecount"), PersistentDataType.INTEGER, andesitecount);
        }else if(block.getType() == Material.SANDSTONE || block.getType() == Material.RED_SANDSTONE){
            int sandstonecount = data.get(new NamespacedKey(MineTracker.getPlugin(), "sandstonecount"), PersistentDataType.INTEGER);
            sandstonecount++;
            data.set(new NamespacedKey(MineTracker.getPlugin(), "sandstonecount"), PersistentDataType.INTEGER, sandstonecount);
        }else if(block.getType() == Material.SNOW_BLOCK || block.getType() == Material.SNOW){
            int snowcount = data.get(new NamespacedKey(MineTracker.getPlugin(), "snowcount"), PersistentDataType.INTEGER);
            snowcount++;
            data.set(new NamespacedKey(MineTracker.getPlugin(), "snowcount"), PersistentDataType.INTEGER, snowcount);
        }else if(block.getType() == Material.ICE || block.getType() == Material.BLUE_ICE || block.getType() == Material.PACKED_ICE){
            int icecount = data.get(new NamespacedKey(MineTracker.getPlugin(), "icecount"), PersistentDataType.INTEGER);
            icecount++;
            data.set(new NamespacedKey(MineTracker.getPlugin(), "icecount"), PersistentDataType.INTEGER, icecount);
        }else if(block.getType() == Material.PRISMARINE || block.getType() == Material.PRISMARINE_BRICKS || block.getType() == Material.DARK_PRISMARINE){
            int prismarinecount = data.get(new NamespacedKey(MineTracker.getPlugin(), "prismarinecount"), PersistentDataType.INTEGER);
            prismarinecount++;
            data.set(new NamespacedKey(MineTracker.getPlugin(), "prismarinecount"), PersistentDataType.INTEGER, prismarinecount);
        }else if(block.getType() == Material.DIAMOND_ORE) {
            int diamondcount = data.get(new NamespacedKey(MineTracker.getPlugin(), "diamondcount"), PersistentDataType.INTEGER);
            diamondcount++;
            data.set(new NamespacedKey(MineTracker.getPlugin(), "diamondcount"), PersistentDataType.INTEGER, diamondcount);
        }else if(block.getType() == Material.COAL_ORE) {
            int coalcount = data.get(new NamespacedKey(MineTracker.getPlugin(), "coalcount"), PersistentDataType.INTEGER);
            coalcount++;
            data.set(new NamespacedKey(MineTracker.getPlugin(), "coalcount"), PersistentDataType.INTEGER, coalcount);
        }else if(block.getType() == Material.IRON_ORE) {
            int ironcount = data.get(new NamespacedKey(MineTracker.getPlugin(), "ironcount"), PersistentDataType.INTEGER);
            ironcount++;
            data.set(new NamespacedKey(MineTracker.getPlugin(), "ironcount"), PersistentDataType.INTEGER, ironcount);
        }else if(block.getType() == Material.GOLD_ORE) {
            int goldcount = data.get(new NamespacedKey(MineTracker.getPlugin(), "goldcount"), PersistentDataType.INTEGER);
            goldcount++;
            data.set(new NamespacedKey(MineTracker.getPlugin(), "goldcount"), PersistentDataType.INTEGER, goldcount);
        }else if(block.getType() == Material.EMERALD_ORE) {
            int emeraldcount = data.get(new NamespacedKey(MineTracker.getPlugin(), "emeraldcount"), PersistentDataType.INTEGER);
            emeraldcount++;
            data.set(new NamespacedKey(MineTracker.getPlugin(), "emeraldcount"), PersistentDataType.INTEGER, emeraldcount);
        }else if(block.getType() == Material.REDSTONE_ORE) {
            int redstonecount = data.get(new NamespacedKey(MineTracker.getPlugin(), "redstonecount"), PersistentDataType.INTEGER);
            redstonecount++;
            data.set(new NamespacedKey(MineTracker.getPlugin(), "redstonecount"), PersistentDataType.INTEGER, redstonecount);
        }else if(block.getType() == Material.LAPIS_ORE) {
            int lapiscount = data.get(new NamespacedKey(MineTracker.getPlugin(), "lapiscount"), PersistentDataType.INTEGER);
            lapiscount++;
            data.set(new NamespacedKey(MineTracker.getPlugin(), "lapiscount"), PersistentDataType.INTEGER, lapiscount);
        }

        block.setType(Material.AIR);

        drops.forEach(itemStack -> {
            int dropAmount = (int) (itemStack.getAmount());
            int maxDropAmount = itemStack.getMaxStackSize();

            while (dropAmount > 0) {
                itemStack.setAmount(Math.min(dropAmount, maxDropAmount));
                dropAmount -= itemStack.getAmount();
                Objects.requireNonNull(block.getLocation().getWorld()).dropItemNaturally(block.getLocation(), itemStack);
            }
        });
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();

        if(!p.getPersistentDataContainer().has(new NamespacedKey(MineTracker.getPlugin(), "dirtcount"), PersistentDataType.INTEGER)){
            p.getPersistentDataContainer().set(new NamespacedKey(MineTracker.getPlugin(), "dirtcount"), PersistentDataType.INTEGER, 0);
        }
        if(!p.getPersistentDataContainer().has(new NamespacedKey(MineTracker.getPlugin(), "stonecount"), PersistentDataType.INTEGER)){
            p.getPersistentDataContainer().set(new NamespacedKey(MineTracker.getPlugin(), "stonecount"), PersistentDataType.INTEGER, 0);
        }
        if(!p.getPersistentDataContainer().has(new NamespacedKey(MineTracker.getPlugin(), "gravelcount"), PersistentDataType.INTEGER)){
            p.getPersistentDataContainer().set(new NamespacedKey(MineTracker.getPlugin(), "gravelcount"), PersistentDataType.INTEGER, 0);
        }
        if(!p.getPersistentDataContainer().has(new NamespacedKey(MineTracker.getPlugin(), "sandcount"), PersistentDataType.INTEGER)){
            p.getPersistentDataContainer().set(new NamespacedKey(MineTracker.getPlugin(), "sandcount"), PersistentDataType.INTEGER, 0);
        }
        if(!p.getPersistentDataContainer().has(new NamespacedKey(MineTracker.getPlugin(), "claycount"), PersistentDataType.INTEGER)){
            p.getPersistentDataContainer().set(new NamespacedKey(MineTracker.getPlugin(), "claycount"), PersistentDataType.INTEGER, 0);
        }
        if(!p.getPersistentDataContainer().has(new NamespacedKey(MineTracker.getPlugin(), "granitecount"), PersistentDataType.INTEGER)){
            p.getPersistentDataContainer().set(new NamespacedKey(MineTracker.getPlugin(), "granitecount"), PersistentDataType.INTEGER, 0);
        }
        if(!p.getPersistentDataContainer().has(new NamespacedKey(MineTracker.getPlugin(), "dioritecount"), PersistentDataType.INTEGER)){
            p.getPersistentDataContainer().set(new NamespacedKey(MineTracker.getPlugin(), "dioritecount"), PersistentDataType.INTEGER, 0);
        }
        if(!p.getPersistentDataContainer().has(new NamespacedKey(MineTracker.getPlugin(), "obsidiancount"), PersistentDataType.INTEGER)){
            p.getPersistentDataContainer().set(new NamespacedKey(MineTracker.getPlugin(), "obsidiancount"), PersistentDataType.INTEGER, 0);
        }
        if(!p.getPersistentDataContainer().has(new NamespacedKey(MineTracker.getPlugin(), "andesitecount"), PersistentDataType.INTEGER)){
            p.getPersistentDataContainer().set(new NamespacedKey(MineTracker.getPlugin(), "andesitecount"), PersistentDataType.INTEGER, 0);
        }
        if(!p.getPersistentDataContainer().has(new NamespacedKey(MineTracker.getPlugin(), "sandstonecount"), PersistentDataType.INTEGER)){
            p.getPersistentDataContainer().set(new NamespacedKey(MineTracker.getPlugin(), "sandstonecount"), PersistentDataType.INTEGER, 0);
        }
        if(!p.getPersistentDataContainer().has(new NamespacedKey(MineTracker.getPlugin(), "snowcount"), PersistentDataType.INTEGER)){
            p.getPersistentDataContainer().set(new NamespacedKey(MineTracker.getPlugin(), "snowcount"), PersistentDataType.INTEGER, 0);
        }
        if(!p.getPersistentDataContainer().has(new NamespacedKey(MineTracker.getPlugin(), "icecount"), PersistentDataType.INTEGER)){
            p.getPersistentDataContainer().set(new NamespacedKey(MineTracker.getPlugin(), "icecount"), PersistentDataType.INTEGER, 0);
        }
        if(!p.getPersistentDataContainer().has(new NamespacedKey(MineTracker.getPlugin(), "prismarinecount"), PersistentDataType.INTEGER)){
            p.getPersistentDataContainer().set(new NamespacedKey(MineTracker.getPlugin(), "prismarinecount"), PersistentDataType.INTEGER, 0);
        }
        if(!p.getPersistentDataContainer().has(new NamespacedKey(MineTracker.getPlugin(), "diamondcount"), PersistentDataType.INTEGER)){
            p.getPersistentDataContainer().set(new NamespacedKey(MineTracker.getPlugin(), "diamondcount"), PersistentDataType.INTEGER, 0);
        }
        if(!p.getPersistentDataContainer().has(new NamespacedKey(MineTracker.getPlugin(), "coalcount"), PersistentDataType.INTEGER)){
            p.getPersistentDataContainer().set(new NamespacedKey(MineTracker.getPlugin(), "coalcount"), PersistentDataType.INTEGER, 0);
        }
        if(!p.getPersistentDataContainer().has(new NamespacedKey(MineTracker.getPlugin(), "ironcount"), PersistentDataType.INTEGER)){
            p.getPersistentDataContainer().set(new NamespacedKey(MineTracker.getPlugin(), "ironcount"), PersistentDataType.INTEGER, 0);
        }
        if(!p.getPersistentDataContainer().has(new NamespacedKey(MineTracker.getPlugin(), "goldcount"), PersistentDataType.INTEGER)){
            p.getPersistentDataContainer().set(new NamespacedKey(MineTracker.getPlugin(), "goldcount"), PersistentDataType.INTEGER, 0);
        }
        if(!p.getPersistentDataContainer().has(new NamespacedKey(MineTracker.getPlugin(), "emeraldcount"), PersistentDataType.INTEGER)){
            p.getPersistentDataContainer().set(new NamespacedKey(MineTracker.getPlugin(), "emeraldcount"), PersistentDataType.INTEGER, 0);
        }
        if(!p.getPersistentDataContainer().has(new NamespacedKey(MineTracker.getPlugin(), "redstonecount"), PersistentDataType.INTEGER)){
            p.getPersistentDataContainer().set(new NamespacedKey(MineTracker.getPlugin(), "redstonecount"), PersistentDataType.INTEGER, 0);
        }
        if(!p.getPersistentDataContainer().has(new NamespacedKey(MineTracker.getPlugin(), "lapiscount"), PersistentDataType.INTEGER)){
            p.getPersistentDataContainer().set(new NamespacedKey(MineTracker.getPlugin(), "lapiscount"), PersistentDataType.INTEGER, 0);
        }
        if(!p.getPersistentDataContainer().has(new NamespacedKey(MineTracker.getPlugin(), "ironcount"), PersistentDataType.INTEGER)){
            p.getPersistentDataContainer().set(new NamespacedKey(MineTracker.getPlugin(), "ironcount"), PersistentDataType.INTEGER, 0);
        }
    }
}
