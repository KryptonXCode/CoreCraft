package me.Krypton.CommandExecuters;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class KillExecuter implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {

		if (cmd.getName().equalsIgnoreCase("Kill") && sender instanceof Player) {
			Player player = (Player) sender;

			int lenght = args.length;

			if (lenght == 1) {

				boolean playerFound = false;

				for (Player target : Bukkit.getServer().getOnlinePlayers()) {
					if (target.getName().equalsIgnoreCase(args[0])) {
						target.setHealth(0.0);
						target.sendMessage(ChatColor.BLUE
								+ target.getDisplayName() + ", "
								+ ChatColor.RED + "You were killed by: "
								+ ChatColor.DARK_AQUA + player.getDisplayName());
						player.sendMessage(ChatColor.GREEN
								+ "You have successfuly killed: "
								+ ChatColor.BLUE + target.getDisplayName());
						playerFound = true;
						break;
					}
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
