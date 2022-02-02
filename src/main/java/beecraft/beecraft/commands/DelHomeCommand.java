package beecraft.beecraft.commands;

import beecraft.beecraft.Home;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import java.util.Map;

public class DelHomeCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (sender instanceof ConsoleCommandSender) {
            sender.sendMessage("Error: Player only command!");
            return true;
        }

        Player player = (Player) sender; // Cast the CommandSender to a Player

        Map<Player, Home> map = HomeCommand.theMap;

        if (map.get(player) == null) {
            player.sendMessage("You don't have a home you can delete!");
        } else {
            map.put(player, null);
            player.sendMessage("Home deleted successfully");
        }

        return false;
    }
}
