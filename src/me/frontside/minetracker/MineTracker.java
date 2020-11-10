package me.frontside.minetracker;

import org.bukkit.plugin.java.JavaPlugin;

// MAX MOLDEN repository
public class MineTracker extends JavaPlugin {

    private static MineTracker plugin;

    @Override
    public void onEnable() {
        plugin = this;

        CommandMultiply commandMultiply = new CommandMultiply();
        this.getCommand("drops").setExecutor(commandMultiply);
        getServer().getPluginManager().registerEvents(commandMultiply, this);


        getCommand("store").setExecutor(new CommandStore());
        getServer().getPluginManager().registerEvents(new BlockBreakListener(), this);
    }

    public void onDisable() {
        // Plugin shutdown logic
    }

    public static MineTracker getPlugin() {
        return plugin;
    }
}
