package eu.server.lobbysystem;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

import eu.server.lobbysystem.commands.CMD_lobby;
import eu.server.lobbysystem.commands.CMD_setlobby;
import eu.server.lobbysystem.events.EVENT_food;
import eu.server.lobbysystem.events.EVENT_join;
import eu.server.lobbysystem.events.EVENT_nodamage;
import eu.server.lobbysystem.events.EVENT_quit;
import eu.server.lobbysystem.utils.LocationAPI;

public class LobbySystem extends JavaPlugin {
	
	
	public static String prefix = "§7[§6Lobby§7] ";
	
	
	@Override
	public void onEnable() {	
		
	     loadCommands();
	     loadEvents();

		
		this.getServer().getConsoleSender().sendMessage("[LobbySystem] Das Plugin wurde erfolgreich aktiviert!");
		
		if (LocationAPI.getLocation("lobby") != null) {
            Location spawn = LocationAPI.getLocation("lobby");

            spawn.getWorld().setTime(6000);
            spawn.getWorld().setGameRuleValue("doDaylightCircle", "false");
            spawn.getWorld().setGameRuleValue("doMobSpawning", "false");
		}
	}
	
	
	@Override
	public void onDisable() {
		
		this.getServer().getConsoleSender().sendMessage("[LobbySystem] Das Plugin wurde deaktiviert!");
	}
	    
    
    public void loadEvents() {
    	
    	Bukkit.getPluginManager().registerEvents(new EVENT_join(), this);
    	Bukkit.getPluginManager().registerEvents(new EVENT_quit(), this);
    	Bukkit.getPluginManager().registerEvents(new EVENT_nodamage(), this);
    	Bukkit.getPluginManager().registerEvents(new EVENT_food(), this);
    }
    
	
	public void loadCommands() {
		
		getCommand("lobby").setExecutor(new CMD_lobby());
		getCommand("setlobby").setExecutor(new CMD_setlobby());
		
	}
	
}
