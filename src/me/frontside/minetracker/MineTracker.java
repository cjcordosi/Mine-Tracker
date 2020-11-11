package me.frontside.minetracker;

import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.java.JavaPlugin;
import sun.jvm.hotspot.opto.Block;

// MASTER MineTracker Repo
public class MineTracker extends JavaPlugin {

    private static MineTracker plugin;

    @Override
    public void onEnable() {
        plugin = this;

        BlockBreakListener blockBreakListener = new BlockBreakListener();
        getServer().getPluginManager().registerEvents(blockBreakListener, this);
    }

    public void onDisable() {
        // Plugin shutdown logic
    }

    public static MineTracker getPlugin() {
        return plugin;
    }
}
