package me.frontside.minetracker;

import com.mojang.brigadier.Command;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class DigBuffs {
    public void giveFastDigging(Player p){
        p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 200, 10));
    }
}
