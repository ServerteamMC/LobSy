
package eu.server.lobbysystem.events;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class EVENT_join implements Listener {
	
	
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();

        e.setJoinMessage(null);
        
        p.setMaxHealth(10);
        p.setLevel(0);
        p.setExp(0);
        p.setHealth(10);
        p.setFoodLevel(20);
        p.setGameMode(GameMode.ADVENTURE);
        p.getInventory().clear();
        if(p.hasPermission("lobby.fly")){
            p.setAllowFlight(true);
        }
    }
}
