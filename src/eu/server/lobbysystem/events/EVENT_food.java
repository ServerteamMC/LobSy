package eu.server.lobbysystem.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class EVENT_food implements Listener {
	
	@EventHandler
	public void Food(FoodLevelChangeEvent e) {
		e.setCancelled(true);
	}

}
