package eu.server.lobbysystem;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

import eu.server.lobbysystem.commands.CMD_lobby;
import eu.server.lobbysystem.commands.CMD_setlobby;
import eu.server.lobbysystem.events.EVENT_join;
import eu.server.lobbysystem.events.EVENT_quit;
import eu.server.lobbysystem.utils.LocationAPI;

public class LobbySystem extends JavaPlugin {
	
	public static LobbySystem instance;
	
	public static String prefix;
	
	public static String noperms;
	public static String lobbysuccessful;
	public static String lobbyfailed;
	public static String lobbyexists;
	public static String setlobbyhelp;
	public static String lobbyset;
	
	
	@Override
	public void onEnable() {	
		loadStrings();
		loadConfig();
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
	
	
	public void loadConfig() {
		getConfig().addDefault(prefix, "§7[§6Lobby§7] ");
		getConfig().addDefault(noperms,"§cDazu hast du keine Rechte!");
		getConfig().addDefault(lobbysuccessful, "§aDu bist nun in der Lobby!");
		getConfig().addDefault(lobbyfailed, "§cDu konntest nicht mit der Lobby verbunden werden!");
		getConfig().addDefault(lobbyexists, "§cDer Lobbyspawn existiert bereits!");
		getConfig().addDefault(setlobbyhelp, "§cUm den Lobbyspawn zu setzen, benutze /setlobby!");
		getConfig().addDefault(lobbyset, "§cDer Spawn wurde erfolgreich gesetzt!");
		
		getConfig().options().copyDefaults(true);
        saveConfig();
        reloadConfig();
	}
	
	
    public void loadStrings() {
    	
    	prefix = getConfig().getString("prefix").replaceAll("&", "§");
        noperms = prefix + getConfig().getString("noperms").replaceAll("&", "§").replaceAll("%prefix%", prefix);
        lobbysuccessful = prefix  + getConfig().getString("lobbysuccessfull").replaceAll("&", "§").replaceAll("%prefix%", prefix);
        lobbyfailed = prefix + getConfig().getString("lobbyfailed").replaceAll("&", "§").replaceAll("%prefix%", prefix);
        lobbyexists = prefix + getConfig().getString("lobbyexists").replaceAll("&", "§").replaceAll("%prefix%", prefix);
        setlobbyhelp = prefix + getConfig().getString("setlobbyhelp").replaceAll("&", "§").replaceAll("%prefix%", prefix);
        lobbyset = prefix + getConfig().getString("lobbyset").replaceAll("&", "§").replaceAll("%prefix%", prefix);
		
	}
    
    
    public void loadEvents() {
    	
    	Bukkit.getPluginManager().registerEvents(new EVENT_join(), this);
    	Bukkit.getPluginManager().registerEvents(new EVENT_quit(), this);
    	
    }
    
	
	public void loadCommands() {
		
		getCommand("lobby").setExecutor(new CMD_lobby());
		getCommand("setlobby").setExecutor(new CMD_setlobby());
		
	}
}
