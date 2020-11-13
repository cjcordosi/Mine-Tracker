package me.frontside.minetracker;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;

// MAX MOLDEN repository
public class MineTracker extends JavaPlugin {

    private static MineTracker plugin;
    public HashMap<UUID, JobPointsManager> jobPointsManagerHashMap;

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

        // set up for currencyManagerHashMap
        this.jobPointsManagerHashMap = new HashMap<>();
        this.getConfig().options().copyDefaults(true);
        this.saveConfig();


    }

    public void onDisable() {
        // Plugin shutdown logic

        // closing currencyManagerHashMap
        this.jobPointsManagerHashMap.clear();
    }

    public static MineTracker getPlugin() {
        return plugin;
    }
}
