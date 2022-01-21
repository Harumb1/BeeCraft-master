package beecraft.beecraft.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * The /help command
 *  implements CommandExecutor
 *  the implements keyword means HAS A
 *  therefore: Helpcommand HAS A command executor
 */
public class HelpCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        sender.sendMessage("-------" + ChatColor.YELLOW + "BeeCraft Help" + ChatColor.RESET + "--------");
        sender.sendMessage("> /help - Display this menu");
        sender.sendMessage("> /bees - Spawn bees into the world");
        return false;
    }

}
