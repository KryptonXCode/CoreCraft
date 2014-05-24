package me.KaptainKrypton.CommandExecuters;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HideMeExecuter implements CommandExecutor {
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	    if (cmd.getName().equalsIgnoreCase("HideMe") && args.length == 1) {
	        if (!(sender instanceof Player)) {
	            sender.sendMessage("Only players can use this command!");
	            return true;
	        }
	        Player player = (Player) sender;
	        Player target = Bukkit.getServer().getPlayer(args[0]);
	        if (target == null) {
	            sender.sendMessage(ChatColor.RED + "Player " + args[0] + " is not online.");
	            return true;
	        }
	        // Hides a given Player (s) from someone (target).
	        target.hidePlayer(player);
	        player.getPlayer().sendMessage(ChatColor.GOLD + player.getDisplayName() + ChatColor.AQUA +", have been hidden from: " + ChatColor.RED + target.getDisplayName());
	        return true;
	    }
	    return false;
	}
}
