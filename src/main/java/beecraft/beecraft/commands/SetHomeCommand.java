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

public class SetHomeCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (sender instanceof ConsoleCommandSender) {
            sender.sendMessage("Error: Player only command!");
            return true;
        }

        Player player = (Player) sender; // Cast the CommandSender to a Player

        Home toCreate = new Home(player.getName() + "'s home", player.getLocation(), player);

        HomeCommand.theMap.put(player, toCreate);

        player.sendMessage("Created a new home at " + player.getLocation().getBlockX()
                + " " + player.getLocation().getZ() + ".");
        return false;
    }

}