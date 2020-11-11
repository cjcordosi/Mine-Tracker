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

    // Detect block break event from player
    @EventHandler
    public void onBreak(BlockBreakEvent e){

        // Player object, player that broke the block
        Player p = e.getPlayer();

        // Persistent data container for break event player
        PersistentDataContainer data = p.getPersistentDataContainer();

        // Cancel normal break event
        e.setCancelled(true);

        // Identify what block was broken
        Block block = e.getBlock();

        /*
        Get the tool in the players main hand (tool used to break block) and identify what drops would have been
        after breaking said block with the identified tool.
        */
        ItemStack tool = e.getPlayer().getInventory().getItemInMainHand();
        Collection<ItemStack> drops = block.getDrops(tool);

        // Check what type of material was broken, increment the corresponding block counter in players persist. data container
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
        }else if(block.getType() == Material.PUMPKIN) {
            int pumpkincount = data.get(new NamespacedKey(MineTracker.getPlugin(), "pumpkincount"), PersistentDataType.INTEGER);
            pumpkincount++;
            data.set(new NamespacedKey(MineTracker.getPlugin(), "pumpkincount"), PersistentDataType.INTEGER, pumpkincount);
        }else if(block.getType() == Material.MELON) {
            int meloncount = data.get(new NamespacedKey(MineTracker.getPlugin(), "meloncount"), PersistentDataType.INTEGER);
            meloncount++;
            data.set(new NamespacedKey(MineTracker.getPlugin(), "meloncount"), PersistentDataType.INTEGER, meloncount);
        }else if(block.getType() == Material.WHEAT) {
            int wheatcount = data.get(new NamespacedKey(MineTracker.getPlugin(), "wheatcount"), PersistentDataType.INTEGER);
            wheatcount++;
            data.set(new NamespacedKey(MineTracker.getPlugin(), "wheatcount"), PersistentDataType.INTEGER, wheatcount);
        }else if(block.getType() == Material.CACTUS) {
            int cactuscount = data.get(new NamespacedKey(MineTracker.getPlugin(), "cactuscount"), PersistentDataType.INTEGER);
            cactuscount++;
            data.set(new NamespacedKey(MineTracker.getPlugin(), "cactuscount"), PersistentDataType.INTEGER, cactuscount);
        }else if(block.getType() == Material.ACACIA_WOOD || block.getType() == Material.BIRCH_WOOD || block.getType() == Material.DARK_OAK_WOOD
                || block.getType() == Material.JUNGLE_WOOD || block.getType() == Material.OAK_WOOD  || block.getType() == Material.SPRUCE_WOOD) {
            int woodcount = data.get(new NamespacedKey(MineTracker.getPlugin(), "woodcount"), PersistentDataType.INTEGER);
            woodcount++;
            data.set(new NamespacedKey(MineTracker.getPlugin(), "woodcount"), PersistentDataType.INTEGER, woodcount);
        }else if(block.getType() == Material.NETHERRACK) {
            int netherrackcount = data.get(new NamespacedKey(MineTracker.getPlugin(), "netherrackcount"), PersistentDataType.INTEGER);
            netherrackcount++;
            data.set(new NamespacedKey(MineTracker.getPlugin(), "netherrackcount"), PersistentDataType.INTEGER, netherrackcount);
        }else if(block.getType() == Material.NETHER_QUARTZ_ORE) {
            int netherquartzcount = data.get(new NamespacedKey(MineTracker.getPlugin(), "netherquartzcount"), PersistentDataType.INTEGER);
            netherquartzcount++;
            data.set(new NamespacedKey(MineTracker.getPlugin(), "netherquartzcount"), PersistentDataType.INTEGER, netherquartzcount);
        }else if(block.getType() == Material.MAGMA_BLOCK) {
            int magmacount = data.get(new NamespacedKey(MineTracker.getPlugin(), "magmacount"), PersistentDataType.INTEGER);
            magmacount++;
            data.set(new NamespacedKey(MineTracker.getPlugin(), "magmacount"), PersistentDataType.INTEGER, magmacount);
        }else if(block.getType() == Material.SOUL_SAND) {
            int soulsandcount = data.get(new NamespacedKey(MineTracker.getPlugin(), "soulsandcount"), PersistentDataType.INTEGER);
            soulsandcount++;
            data.set(new NamespacedKey(MineTracker.getPlugin(), "soulsandcount"), PersistentDataType.INTEGER, soulsandcount);
        }else if(block.getType() == Material.BLACKSTONE) {
            int blackstonecount = data.get(new NamespacedKey(MineTracker.getPlugin(), "blackstonecount"), PersistentDataType.INTEGER);
            blackstonecount++;
            data.set(new NamespacedKey(MineTracker.getPlugin(), "blackstonecount"), PersistentDataType.INTEGER, blackstonecount);
        }else if(block.getType() == Material.END_STONE) {
            int endstonecount = data.get(new NamespacedKey(MineTracker.getPlugin(), "endstonecount"), PersistentDataType.INTEGER);
            endstonecount++;
            data.set(new NamespacedKey(MineTracker.getPlugin(), "endstonecount"), PersistentDataType.INTEGER, endstonecount);
        }

        // Set the block broken to air block
        block.setType(Material.AIR);

        /*
        Get the number of items that should have been dropped after breaking specified block with main hand tool (ie 4 diamonds),
        set the max stack size for that item type (ie 64), while we have not dropped all specified drops yet, decide the minimum of
        max stack size vs. total drop amount (max stack size if total drop amount greater than stack size), decrement from total drop
        amount and drop on ground where block was broken.
         */
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

    // Detect join event from player
    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        // Player object, player that joined
        Player p = e.getPlayer();

        /*
        Check to see if the recently joined player does or does not have necessary counter values in their persist. data container,
        if not create the value and set it to default of zero.
         */
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
        if(!p.getPersistentDataContainer().has(new NamespacedKey(MineTracker.getPlugin(), "pumpkincount"), PersistentDataType.INTEGER)){
            p.getPersistentDataContainer().set(new NamespacedKey(MineTracker.getPlugin(), "pumpkincount"), PersistentDataType.INTEGER, 0);
        }
        if(!p.getPersistentDataContainer().has(new NamespacedKey(MineTracker.getPlugin(), "meloncount"), PersistentDataType.INTEGER)){
            p.getPersistentDataContainer().set(new NamespacedKey(MineTracker.getPlugin(), "meloncount"), PersistentDataType.INTEGER, 0);
        }
        if(!p.getPersistentDataContainer().has(new NamespacedKey(MineTracker.getPlugin(), "wheatcount"), PersistentDataType.INTEGER)){
            p.getPersistentDataContainer().set(new NamespacedKey(MineTracker.getPlugin(), "wheatcount"), PersistentDataType.INTEGER, 0);
        }
        if(!p.getPersistentDataContainer().has(new NamespacedKey(MineTracker.getPlugin(), "cactuscount"), PersistentDataType.INTEGER)){
            p.getPersistentDataContainer().set(new NamespacedKey(MineTracker.getPlugin(), "cactuscount"), PersistentDataType.INTEGER, 0);
        }
        if(!p.getPersistentDataContainer().has(new NamespacedKey(MineTracker.getPlugin(), "woodcount"), PersistentDataType.INTEGER)){
            p.getPersistentDataContainer().set(new NamespacedKey(MineTracker.getPlugin(), "woodcount"), PersistentDataType.INTEGER, 0);
        }
        if(!p.getPersistentDataContainer().has(new NamespacedKey(MineTracker.getPlugin(), "netherrackcount"), PersistentDataType.INTEGER)){
            p.getPersistentDataContainer().set(new NamespacedKey(MineTracker.getPlugin(), "netherrackcount"), PersistentDataType.INTEGER, 0);
        }
        if(!p.getPersistentDataContainer().has(new NamespacedKey(MineTracker.getPlugin(), "netherquartzcount"), PersistentDataType.INTEGER)){
            p.getPersistentDataContainer().set(new NamespacedKey(MineTracker.getPlugin(), "netherquartzcount"), PersistentDataType.INTEGER, 0);
        }
        if(!p.getPersistentDataContainer().has(new NamespacedKey(MineTracker.getPlugin(), "magmacount"), PersistentDataType.INTEGER)){
            p.getPersistentDataContainer().set(new NamespacedKey(MineTracker.getPlugin(), "magmacount"), PersistentDataType.INTEGER, 0);
        }
        if(!p.getPersistentDataContainer().has(new NamespacedKey(MineTracker.getPlugin(), "soulsandcount"), PersistentDataType.INTEGER)){
            p.getPersistentDataContainer().set(new NamespacedKey(MineTracker.getPlugin(), "soulsandcount"), PersistentDataType.INTEGER, 0);
        }
        if(!p.getPersistentDataContainer().has(new NamespacedKey(MineTracker.getPlugin(), "blackstonecount"), PersistentDataType.INTEGER)){
            p.getPersistentDataContainer().set(new NamespacedKey(MineTracker.getPlugin(), "blackstonecount"), PersistentDataType.INTEGER, 0);
        }
        if(!p.getPersistentDataContainer().has(new NamespacedKey(MineTracker.getPlugin(), "endstonecount"), PersistentDataType.INTEGER)){
            p.getPersistentDataContainer().set(new NamespacedKey(MineTracker.getPlugin(), "endstonecount"), PersistentDataType.INTEGER, 0);
        }
    }
}
