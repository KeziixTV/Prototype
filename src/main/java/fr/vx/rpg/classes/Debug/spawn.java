package fr.vx.rpg.classes.Debug;

import fr.vx.rpg.classes.mobs.impl.Evokers.Barbseeker;
import fr.vx.rpg.classes.mobs.impl.Spiders.Spiders;
import fr.vx.rpg.classes.mobs.impl.Zombies.ZombieAssassin;
import net.minecraft.server.v1_16_R3.WorldServer;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;
import org.bukkit.entity.Player;

public class spawn implements CommandExecutor
{

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
        Location location = player.getLocation();
        world.addEntity(new Spiders(location));
        Location location1 = location.add(0,0,1);
        world.addEntity(new ZombieAssassin(location1));
        Location location2 = location.add(0,0,1);
        world.addEntity(new Barbseeker(location2));
        return false;
    }
}