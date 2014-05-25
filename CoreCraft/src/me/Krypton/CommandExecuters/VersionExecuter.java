package me.Krypton.CommandExecuters;

import me.Krypton.CoreCraft.CoreCraft;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VersionExecuter implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		Player player = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("ccversion")
				&& sender instanceof Player) {
			player.getPlayer().sendMessage(
					ChatColor.BLUE + "Server is Running CoreCraft "
							+ CoreCraft.plugin.getDescription().getVersion());
			return true;
		} else {
			player.getPlayer()
					.sendMessage(ChatColor.RED + "Invalid Arguments!");
		}
		return false;
	}
}
