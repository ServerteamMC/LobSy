package eu.server.lobbysystem;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

import eu.server.lobbysystem.events.EVENT_join;
import eu.server.lobbysystem.events.EVENT_quit;
import eu.server.lobbysystem.utils.LocationAPI;

public class Main extends JavaPlugin {
	
	public static Main instance;
	
	public static String prefix = "[Lobby]";
	
	
	public void onEnable() {
		
		instance = this;
		
		loadConfig();
		loadCommands();
		loadStrings();
		loadEvents();
		
		this.getServer().getConsoleSender().sendMessage("[LobbySystem] Das Plugin wurde erfolgreich aktiviert!");
		
		if (LocationAPI.getLocation("spawn") != null) {
            Location spawn = LocationAPI.getLocation("spawn");

            spawn.getWorld().setTime(6000);
            spawn.getWorld().setGameRuleValue("doDaylightCircle", "false");
            spawn.getWorld().setGameRuleValue("doMobSpawning", "false");
		}
	}
	
	
	public void onDisable() {
		
		instance = null;
		
		this.getServer().getConsoleSender().sendMessage("[LobbySystem] Das Plugin wurde deaktiviert!");
	}
	
	
	public void loadConfig() {
		
		getConfig().options().copyDefaults(true);
        saveConfig();
        reloadConfig();
	}
	
	
    public void loadStrings() {
		
	}
    
    
    public void loadEvents() {
    	
    	Bukkit.getPluginManager().registerEvents(new EVENT_join(), this);
    	Bukkit.getPluginManager().registerEvents(new EVENT_quit(), this);
    	
    }
    
	
	public void loadCommands() {
		
	}
	
	
	public Main getInstance() {
		return getInstance();
	}

}
