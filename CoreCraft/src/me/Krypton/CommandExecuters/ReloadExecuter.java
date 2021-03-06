package me.Krypton.CommandExecuters;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReloadExecuter implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		Player player = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("CCReload")
				&& sender instanceof Player) {
			player.getPlayer().sendMessage(
					ChatColor.BLUE + "CoreCraft is Reloading!");
			player.sendMessage(ChatColor.GREEN + "CoreCraft has been Reloaded!");
			return true;
		} else {
			player.getPlayer()
					.sendMessage(ChatColor.RED + "Invalid Arguments!");
		}
		return false;
	}
}
