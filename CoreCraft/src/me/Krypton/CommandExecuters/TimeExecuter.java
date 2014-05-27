package me.Krypton.CommandExecuters;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TimeExecuter implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		Player player = (Player) sender;
		World world = player.getWorld();
		if (cmd.getName().equalsIgnoreCase("time")) {
			if (args[0].equalsIgnoreCase("day")) {
				world.setTime(0);
				Bukkit.broadcastMessage(ChatColor.DARK_RED + "[CoreCraft]"
						+ ChatColor.DARK_GREEN + " Time Was Set To Day!");
				return true;
			} else if (args[0].equalsIgnoreCase("night")) {
				world.setTime(14000);
				Bukkit.broadcastMessage(ChatColor.DARK_RED + "[CoreCraft]"
						+ ChatColor.DARK_GREEN + " Time Was Set To Night!");
				return true;
			}
		}
		return false;
	}
}