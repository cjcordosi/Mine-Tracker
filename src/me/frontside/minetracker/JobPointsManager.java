package me.frontside.minetracker;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class JobPointsManager extends CommandBuffs implements Listener {
    private int jobPointsAmount = 0;

    public void currencyManager(int amount){
        this.jobPointsAmount = amount;
    }

    public int getJobPointsAmount(){
        return this.jobPointsAmount;
    }
    public void setJobPointsAmount(int amount){
        this.jobPointsAmount += amount;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e){
        if (e.getInventory() != BuffInv && e.getInventory() != WoodBuffsInv && e.getInventory() != DigBuffsInv &&
                e.getInventory() != StoneBuffsInv && e.getInventory() != OreBuffsInv &&
                e.getInventory() != NetherBuffsInv && e.getInventory() != FarmBuffsInv &&
                e.getInventory() != EnchantBuffsInv){
            return;
        }
    }


}
