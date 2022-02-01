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
    /*
    This is the Map, declared private so other classes cannot access it

    The KEY is a Player, and the VALUE is a Location

    Maps are a common data structure used in different programming languages

     */
    private Map<Player, Location> theMap = new HashMap<>();

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (sender instanceof ConsoleCommandSender) {
            sender.sendMessage("Error: Player only command!");
            return true;
        }

        Player player = (Player) sender; // Cast the CommandSender to a Player

        /*
        We use the get() method to get the Location object in the map for the specified Player,
        if one exists. If one hasn't been put in the map, this will return NULL or something like that!

        Because in this case we determine it's null, we use the put() method to save data inside the map
         */
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