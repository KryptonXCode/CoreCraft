package me.Krypton.CommandExecuters;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FeedExecuter implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {

		if (cmd.getName().equalsIgnoreCase("Feed") && sender instanceof Player) {
			Player player = (Player) sender;

			int length = args.length;

			if (length == 1) {

				boolean playerFound = false;

				for (Player target : Bukkit.getServer().getOnlinePlayers()) {
					if (target.getName().equalsIgnoreCase(args[0])) {
						target.setFoodLevel(20);
						target.sendMessage(ChatColor.BLUE
								+ target.getDisplayName() + ", "
								+ ChatColor.DARK_AQUA + "You Were Fed By: "
								+ ChatColor.GOLD + player.getDisplayName());
						player.sendMessage(ChatColor.GREEN + "You Have Fed: "
								+ ChatColor.BLUE + target.getDisplayName());
						playerFound = true;
						break;
					}
					return true;
				}
				if (playerFound == false) {
					player.sendMessage(ChatColor.RED + args[0] + ChatColor.RED
							+ " was not found!");
				}
			} else
				player.sendMessage(ChatColor.RED + "Invalid Arguments");
		}
		return false;
	}
}