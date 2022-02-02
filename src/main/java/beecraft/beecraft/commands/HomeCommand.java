package beecraft.beecraft.commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

/*
This is the PlayerHomeCommand class, represents a command
it implements the CommandExecutor interface: PlayerHomeCommand HAS A CommandExecutor
 */
public class HomeCommand implements CommandExecutor {
    public static Map<Player, Location> theMap = new HashMap<>();


    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (sender instanceof ConsoleCommandSender) {
            sender.sendMessage("Error: Player only command!");
            return true;
        }

        Player player = (Player) sender; // Cast the CommandSender to a Player


        if (theMap.get(player) == null) {
            theMap.put(player, player.getLocation());
            player.sendMessage("you didn't have a home, so we created one where you're standing now.");
            return true;
        }

        Location playerHome = theMap.get(player);

        player.teleport(playerHome);

        player.sendMessage(ChatColor.RED + "Teleported home!");
        return false;
    }

}