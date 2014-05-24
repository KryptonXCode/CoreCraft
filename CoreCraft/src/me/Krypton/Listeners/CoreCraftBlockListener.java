package me.Krypton.Listeners;

import me.Krypton.CoreCraft.CoreCraft;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class CoreCraftBlockListener implements Listener{
	
	public CoreCraftBlockListener(CoreCraft coreCraft) {
	}

	@EventHandler
	public void onTNTPlace(final BlockPlaceEvent event){		
		Player player = event.getPlayer();
		if (event.getBlockPlaced().getType().equals(Material.TNT)){
			if(!player.isOp()){
				event.getPlayer().sendMessage(ChatColor.DARK_AQUA + player.getDisplayName() + ChatColor.RED + ": You have placed TNT, be aware, registered in log!");
				
			}
			else
				event.setCancelled(true);
		}
	}
}
