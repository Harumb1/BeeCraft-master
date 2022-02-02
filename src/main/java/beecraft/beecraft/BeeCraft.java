package beecraft.beecraft;

import beecraft.beecraft.commands.*;
import org.bukkit.plugin.java.JavaPlugin;

public class BeeCraft extends JavaPlugin {
    private final String VERSION = "1.0.0";

    /**
     * The below code runs every time the plugin starts up
     */
    @Override
    public void onEnable() {
        /*
        get the server logger and call the info() message, which takes in a String message
         */
        getLogger().info("Starting up BeeCraft version " + VERSION + "...");

        /*
        Tell Paper that we want the command "help" to execute the HelpCommand class
         */
        getCommand("help").setExecutor(new HelpCommand());

        getCommand("bees").setExecutor(new BeeCommand());

        getCommand("home").setExecutor(new HomeCommand());

        getCommand("sethome").setExecutor(new SetHomeCommand());

        getCommand("listhomes").setExecutor(new ListHomesCommand());
    }


    /**
     * The below code runs every time the plugin shuts down
     */
    @Override
    public void onDisable() {

    }

}





