package beecraft.beecraft.commands;

import beecraft.beecraft.Home;
import org.bukkit.Bukkit;
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
    The home map itself
     */
    public static Map<Player, Home> theMap = new HashMap<>();

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (sender instanceof ConsoleCommandSender) {
            sender.sendMessage("Error: Player only command!");
            return true;
        }

        Player player = (Player) sender;

        if (theMap.get(player) == null) {
            player.sendMessage("Error: You don't have a home. Use /sethome to create a new one.");
            return true;
        }

        Home playerHome = theMap.get(player);

        theMap.get(player).teleportHome();

        playerHome.teleportHome();
        player.sendMessage(ChatColor.RED + "Teleported home!");
        return false;
    }

}