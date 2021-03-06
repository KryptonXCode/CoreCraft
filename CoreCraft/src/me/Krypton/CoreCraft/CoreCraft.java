package me.Krypton.CoreCraft;

import java.util.ArrayList;
import java.util.logging.Logger;

import me.Krypton.CommandExecuters.FeedExecuter;
import me.Krypton.CommandExecuters.HealExecuter;
import me.Krypton.CommandExecuters.HideMeExecuter;
import me.Krypton.CommandExecuters.IgniteExecuter;
import me.Krypton.CommandExecuters.KillExecuter;
import me.Krypton.CommandExecuters.ReloadExecuter;
import me.Krypton.CommandExecuters.VerifyExecuter;
import me.Krypton.CommandExecuters.VersionExecuter;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class CoreCraft extends JavaPlugin implements Listener {
	public static Logger logger = Logger.getLogger("Minecraft");
	public static CoreCraft plugin;
	ArrayList<String> players;

	@Override
	public void onDisable() {
		@SuppressWarnings("unused")
		PluginDescriptionFile pdffile = this.getDescription();
		this.getLogger().info(
				ChatColor.RED + this.getDescription().getFullName() + " v"
						+ this.getDescription().getVersion()
						+ " has been disabled!");
	}

	@Override
	public void onEnable() {
		@SuppressWarnings("unused")
		PluginDescriptionFile pdffile = this.getDescription();
		Bukkit.getPluginManager().registerEvents(this, this);
		this.getLogger().info(
				ChatColor.GREEN + this.getDescription().getFullName()
						+ " has been enabled!");
		this.getCommand("HideMe").setExecutor(new HideMeExecuter());
		this.getCommand("Ignite").setExecutor(new IgniteExecuter());
		this.getCommand("Heal").setExecutor(new HealExecuter());
		this.getCommand("Kill").setExecutor(new KillExecuter());
		this.getCommand("CCReload").setExecutor(new ReloadExecuter());
		this.getCommand("CoreCraft").setExecutor(new VerifyExecuter());
		this.getCommand("Feed").setExecutor(new FeedExecuter());
		this.getCommand("ccversion").setExecutor(new VersionExecuter());
		players = new ArrayList<String>();
		players = new ArrayList<String>();
		Bukkit.getPluginManager().registerEvents(this, this);
		this.saveDefaultConfig();
	}

	@EventHandler
	public void OnPlayerJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		event.setJoinMessage(this.getConfig().getString("message"));
		if (player.hasPlayedBefore() == false) {
			player.getInventory().addItem(
					new ItemStack(Material.STONE_SWORD, 1));
			player.getInventory().addItem(new ItemStack(Material.STONE_AXE, 1));
			player.getInventory().addItem(
					new ItemStack(Material.STONE_PICKAXE, 1));
			player.getInventory().addItem(
					new ItemStack(Material.STONE_SPADE, 1));
			player.getInventory().addItem(
					new ItemStack(Material.COOKED_BEEF, 10));
			player.getPlayer().sendMessage(
					ChatColor.BLUE + "Good Luck, " + ChatColor.GOLD
							+ player.getDisplayName() + ChatColor.BLUE + "!");
		} else {
			event.getPlayer().sendMessage(
					ChatColor.BLUE + "Welcome back, " + ChatColor.GOLD
							+ player.getDisplayName() + ChatColor.BLUE + "!");
		}
	}
}