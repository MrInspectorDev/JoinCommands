package com.mrinspector.joincommands;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class JoinCommands extends JavaPlugin implements Listener {

	public void onEnable(){
		Bukkit.getPluginManager().registerEvents(this, this);
                getConfig().options().copyDefaults(true);
	        saveConfig();
	    }

	@EventHandler
	public void onJoinCommand(PlayerJoinEvent e){
		for(String s : this.getConfig().getStringList("joincommands")) {
			e.getPlayer().performCommand(s);
			//TODO: add console join commands
		}
	}
	
	@EventHandler
	public void onLeaveCommand(PlayerQuitEvent e){
		for(String s : this.getConfig().getStringList("leavecommands")) {
			e.getPlayer().performCommand(s);
			//TODO: add console leave commands
		}
	}
	
}
