package me.frontside.minetracker;

import org.bukkit.plugin.java.JavaPlugin;

// MAX MOLDEN repository
public class MineTracker extends JavaPlugin {

    private static MineTracker plugin;

    @Override
    public void onEnable() {
        plugin = this;

        // create object for later reusability
        BlockBreakListener blockBreakListener = new BlockBreakListener();
        getServer().getPluginManager().registerEvents(blockBreakListener, this);

        // adding commandBuffs
        CommandBuffs commandBuffs = new CommandBuffs();
        getCommand("buffs").setExecutor(commandBuffs);
        getServer().getPluginManager().registerEvents(commandBuffs, this);
    }

    public void onDisable() {
        // Plugin shutdown logic
        // testing
        
    }

    public static MineTracker getPlugin() {
        return plugin;
    }
}
