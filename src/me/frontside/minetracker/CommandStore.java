package me.frontside.minetracker;

import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import javax.xml.stream.events.Namespace;

public class CommandStore implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (commandSender instanceof Player){
            Player p = (Player) commandSender;

            if(args.length > 0){
                StringBuilder message = new StringBuilder();
                for (String arg : args){
                    message.append(arg + " ");
                }

                ItemStack item = p.getInventory().getItemInMainHand();
                ItemMeta meta = item.getItemMeta();
                PersistentDataContainer data = meta.getPersistentDataContainer();

                if(data.has(new NamespacedKey(MineTracker.getPlugin(), "message"), PersistentDataType.STRING)){
                    p.sendMessage(ChatColor.GRAY + "There is already a message stored in this item");
                    p.sendMessage(ChatColor.GRAY + "Message: " + ChatColor.GREEN + data.get(new NamespacedKey(MineTracker.getPlugin(), "message"), PersistentDataType.STRING));
                }else{
                    data.set(new NamespacedKey(MineTracker.getPlugin(), "message"), PersistentDataType.STRING, message.toString());
                    item.setItemMeta(meta);
                    p.sendMessage(ChatColor.GREEN + "Message stored!");
                }
            }else{
                p.sendMessage(ChatColor.RED + "Provide a message to store.");
            }
        }

        return true;
    }
}
