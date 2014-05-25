package me.Krypton.CommandExecuters;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class IgniteExecuter implements CommandExecutor {
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if (cmd.getName().equalsIgnoreCase("Ignite")) {
			if (args.length != 1) {
				return false;
			}
			if (!(sender instanceof Player)) {
				sender.sendMessage("You must be a player to execute this command!");
				return true;
			}
			Player target = Bukkit.getServer().getPlayer(args[0]);
			if (target == null) {
				sender.sendMessage(ChatColor.RED + args[0] + " is not online!");
				return true;
			}
			target.setFireTicks(1000);
			target.getPlayer()
					.sendMessage(ChatColor.RED + " You Were Ignited!");
			return true;
		}
		return false;
	}
}