package me.frontside.minetracker;

import org.bukkit.plugin.java.JavaPlugin;

// Cross Cordosi MineTracker Repo
public class MineTracker extends JavaPlugin {

    private static MineTracker plugin;

    @Override
    public void onEnable() {
        plugin = this;

        BlockBreakListener blockBreakListener = new BlockBreakListener();
        getServer().getPluginManager().registerEvents(blockBreakListener, this);

        CommandJobs commandJobs = new CommandJobs();
        getCommand("jobs").setExecutor(commandJobs);
        getServer().getPluginManager().registerEvents(commandJobs, this);
    }

    public void onDisable() {
        // Plugin shutdown logic
    }

    public static MineTracker getPlugin() {
        return plugin;
    }
}
