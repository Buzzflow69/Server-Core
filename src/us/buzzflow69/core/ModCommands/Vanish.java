package us.buzzflow69.core.ModCommands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Vanish implements CommandExecutor {

    public static ArrayList<Player> vanished = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(vanished.contains(p)){
                for(Player player : Bukkit.getOnlinePlayers()){
                    p.sendMessage(ChatColor.YELLOW + "You have " + ChatColor.GREEN "Enabled" ChatColor.YELLOW + " Vanish.");
                    player.showPlayer(p);
                }
                vanished.remove(p);
                p.sendMessage(ChatColor.YELLOW + "You have " + ChatColor.RED + "Disabled" + ChatColor.YELLOW + " Vanish.");
            } else {
                for(Player player : Bukkit.getOnlinePlayers()){
                    player.hidePlayer(p);
                }
                vanished.add(p);
                p.sendMessage("You have vanished");
            }

            return true;
        }
        return false;
    }

}