package eu.server.lobbysystem.commands;

import eu.server.lobbysystem.LobbySystem;
import eu.server.lobbysystem.utils.LocationAPI;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMD_lobby implements CommandExecutor {
	
	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player)sender;

        if(args.length == 0) {
            if(LocationAPI.locationExists("lobby")) {
                Location loc = LocationAPI.getLocation("lobby");

                p.teleport(loc);
                p.sendMessage(LobbySystem.lobbysuccessful);
                p.playSound(loc, Sound.FIREWORK_BLAST, 1, 1);

            } else {
                p.sendMessage(LobbySystem.lobbyfailed);
                p.closeInventory();
            }

        } else {
            p.sendMessage(LobbySystem.prefix + "§cBenutze /lobby um zur Lobby zu gelangen!");
        }

        return true;
    }
}
