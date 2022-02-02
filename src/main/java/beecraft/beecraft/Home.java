package beecraft.beecraft;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Home {
    private final String name;
    private final Location homeLocation;
    private final Player owner;

    public Home(String name, Location location, Player owner) {
        this.name = name;
        this.homeLocation = location;
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public Location getLocation() {
        return homeLocation;
    }

    public Player getOwner() {
        return owner;
    }

    public String toString() {
        return homeLocation.getBlockX() + ", " + homeLocation.getBlockY()
                + ", " + homeLocation.getBlockZ();
    }

    public void teleportHome() {
        owner.teleport(homeLocation);
    }

}
