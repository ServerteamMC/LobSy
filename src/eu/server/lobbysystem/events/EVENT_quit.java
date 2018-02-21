package eu.server.lobbysystem.events;

import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class EVENT_quit implements Listener {

	public void onQuit(PlayerQuitEvent e) {
		
		e.setQuitMessage(null);
	}
	
	public void onKick(PlayerKickEvent e) {
		
		e.setLeaveMessage(null);
	}
}
