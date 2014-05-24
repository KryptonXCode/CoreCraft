package me.KaptainKrypton.CommandExecuters;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VerifyExecuter implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		Player player = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("CoreCraft") &&  sender instanceof Player) {
			player.getPlayer().sendMessage(ChatColor.GREEN + "CoreCraft is Available!");
			return true;
		}else{
			player.getPlayer().sendMessage(ChatColor.RED + "Invalid Arguments!");
		}
		return false;
	}
}
