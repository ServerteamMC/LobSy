package eu.server.lobbysystem.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;


public class EVENT_nodamage implements Listener {
	
	
	@EventHandler
	public void Damage(EntityDamageEvent e) {
		if (e.getEntity() instanceof Player) {
			Player p = (Player) e.getEntity();
			e.setCancelled(true);
		}
	}
}
