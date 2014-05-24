package me.KaptainKrypton.CommandExecuters;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealExecuter implements CommandExecutor{
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		
		if (cmd.getName().equalsIgnoreCase("Heal") && sender instanceof Player) {
			Player player = (Player) sender;
			
			int lenght = args.length;
			
			if(lenght == 1){
				
				boolean playerFound = false;
				
				for (Player target : Bukkit.getServer().getOnlinePlayers()){
					if(target.getName().equalsIgnoreCase(args[0])){
						target.setHealth(20.0);
						target.sendMessage(ChatColor.BLUE + target.getDisplayName() + ": " + ChatColor.DARK_AQUA + "You were healed by: " + ChatColor.RED + player.getDisplayName());
						player.sendMessage(ChatColor.GREEN + "You have successfuly healed: " + ChatColor.DARK_AQUA + target.getDisplayName());
						playerFound = true;
						break;
					}
				}
				if (playerFound == false){
					player.sendMessage(ChatColor.RED + args[0] + ChatColor.RED + " was not found!");
				}
			} else player.sendMessage(ChatColor.RED + "Invalid Arguments");
		}
		return false;
	}
}
