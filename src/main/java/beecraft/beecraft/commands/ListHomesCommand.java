package beecraft.beecraft.commands;

import beecraft.beecraft.Home;
import org.bukkit.ChatColor;
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
public class ListHomesCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (!sender.isOp()) {
            sender.sendMessage(ChatColor.RED + "Only admins can use that command!");
            return true;
        }

        Map<Player, Home> map = HomeCommand.theMap;

        map.forEach((player, theHome) -> {

            sender.sendMessage("- " + ChatColor.AQUA + theHome.getName() + " \n"
            + theHome.getOwner() + "\n" + theHome);

        });
        return false;
    }

}