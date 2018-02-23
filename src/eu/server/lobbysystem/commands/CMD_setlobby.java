package eu.server.lobbysystem.commands;

import eu.server.lobbysystem.LobbySystem;
import eu.server.lobbysystem.utils.LocationAPI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMD_setlobby implements CommandExecutor {

	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player)sender;

        if(p.hasPermission("lobby.setlobby")) {
            if(args.length == 0) {
                if(LocationAPI.locationExists("lobby")){
                    p.sendMessage(LobbySystem.prefix + "&aDie Lobby wurde bereits gesetzt!");
                    return false;
                }
                LocationAPI.setLocation(p.getLocation(), "lobby");
                p.sendMessage(LobbySystem.prefix + "&cDer Spawn wurde erfolgreich gesetzt!");

            } else {
             p.sendMessage(LobbySystem.prefix + "&cUm den Lobbyspawn zu setzen, benutze /setlobby!");
            }
        }else {
            p.sendMessage(LobbySystem.prefix + "&cDazu hast du keine Rechte!");
        }

        return true;
    }
}
