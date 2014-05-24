package me.KaptainKrypton.CoreCraft;

import java.util.logging.Logger;

import me.KaptainKrypton.CommandExecuters.FeedExecuter;
import me.KaptainKrypton.CommandExecuters.HealExecuter;
import me.KaptainKrypton.CommandExecuters.HideMeExecuter;
import me.KaptainKrypton.CommandExecuters.IgniteExecuter;
import me.KaptainKrypton.CommandExecuters.KillExecuter;
import me.KaptainKrypton.CommandExecuters.ReloadExecuter;
import me.KaptainKrypton.CommandExecuters.VerifyExecuter;
import me.KaptainKrypton.Listeners.CoreCraftBlockListener;

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

public class CoreCraft extends JavaPlugin implements Listener{
	public static Logger logger = Logger.getLogger("Minecraft");
	public static CoreCraft plugin;
	
	public void onDisable(){
		@SuppressWarnings("unused")
		PluginDescriptionFile pdffile = this.getDescription();
		this.getLogger().info(ChatColor.RED + this.getDescription().getFullName() + " v" + this.getDescription().getVersion() + " has been disabled!");
	}
	public void onEnable(){
		@SuppressWarnings("unused")
		PluginDescriptionFile pdffile = this.getDescription();
		Bukkit.getPluginManager().registerEvents(this, this);
		this.getLogger().info(ChatColor.GREEN + this.getDescription().getFullName() + " has been enabled!");
		this.getServer().getPluginManager().registerEvents(new CoreCraftBlockListener(this), this);
		this.getCommand("HideMe").setExecutor(new HideMeExecuter());
		this.getCommand("Ignite").setExecutor(new IgniteExecuter());
		this.getCommand("Heal").setExecutor(new HealExecuter());
		this.getCommand("Kill").setExecutor(new KillExecuter());
		this.getCommand("CCReload").setExecutor(new ReloadExecuter());
		this.getCommand("CoreCraft").setExecutor(new VerifyExecuter());
		this.getCommand("Feed").setExecutor(new FeedExecuter());
		this.saveDefaultConfig();
	}
	@EventHandler
	public void OnPlayerJoin(PlayerJoinEvent event){
		Player player = event.getPlayer();
		event.setJoinMessage(this.getConfig().getString("message"));
		
		if(player.hasPlayedBefore() == false){
			player.getInventory().addItem(new ItemStack(Material.STONE_SWORD, 1));
			player.getInventory().addItem(new ItemStack(Material.STONE_AXE, 1));
			player.getInventory().addItem(new ItemStack(Material.STONE_PICKAXE, 1));
			player.getInventory().addItem(new ItemStack(Material.STONE_SPADE, 1));
			player.getInventory().addItem(new ItemStack(Material.COOKED_BEEF, 10));
			player.getPlayer().sendMessage(ChatColor.BLUE + "Good Luck, " + ChatColor.AQUA + player.getDisplayName() + ChatColor.BLUE + "!");
		}
	}
}