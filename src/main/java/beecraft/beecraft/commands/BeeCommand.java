package beecraft.beecraft.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;


public class BeeCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("This is a player only command!");
            return true;
        }

        Player player = (Player) sender;

        player.getWorld().spawnEntity(player.getLocation(), EntityType.BEE);


        //spawnEntity(location, entity)


        return false;
    }

}
