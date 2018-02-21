package eu.server.lobbysystem.utils;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class LocationAPI {

	public static File file = new File("plugins/LobbySys", "locations.yml");
	public static FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

	public static void setLocation(Location loc, String name) {

		String world = loc.getWorld().getName();
		double x = loc.getX();
		double y = loc.getY();
		double z = loc.getZ();
		double yaw = loc.getYaw();
		double pitch = loc.getPitch();

		cfg.set(name + ".world", world);
		cfg.set(name + ".x", x);
		cfg.set(name + ".y", y);
		cfg.set(name + ".z", z);
		cfg.set(name + ".yaw", yaw);
		cfg.set(name + ".pitch", pitch);

		try {
			cfg.save(file);
		} catch (IOException e) {
			System.err.println("Die Location " + name + " konnte nicht gespeichert werden.");
			e.printStackTrace();
		}
	}


	

	public static Location getLocation(String name) {

		String world = cfg.getString(name + ".world");
		double x = cfg.getDouble(name + ".x");
		double y = cfg.getDouble(name + ".y");
		double z = cfg.getDouble(name + ".z");
		double yaw = cfg.getDouble(name + ".yaw");
		double pitch = cfg.getDouble(name + ".pitch");

		Location loc = new Location(Bukkit.getWorld(world), x, y, z);
		loc.setYaw((float) yaw);
		;
		loc.setPitch((float) pitch);

		return loc;
	}

	public static Boolean locationExists(String name) {

		if (cfg.contains(name)) {
			return true;
		} else {
			return false;
		}

	}

}
