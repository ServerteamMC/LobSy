package eu.server.lobbysystem.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class EVENT_quit implements Listener {
	

	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		
		e.setQuitMessage(null);
	}
	
	
	@EventHandler
	public void onKick(PlayerKickEvent e) {
		
		e.setLeaveMessage(null);
	}
}
