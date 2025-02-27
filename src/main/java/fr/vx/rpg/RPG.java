package fr.vx.rpg;

import fr.vx.rpg.classes.Crafting.CauldronCraft;
import fr.vx.rpg.classes.Debug.RpgCmd;
import fr.vx.rpg.classes.House.impl.Houses;

import fr.vx.rpg.classes.Jobs.JobRank;
import fr.vx.rpg.classes.Jobs.impl.jobs;
import fr.vx.rpg.classes.Npc.impl.citizens;
import fr.vx.rpg.classes.Npc.npc;
import fr.vx.rpg.classes.Player.playerconnection;
import fr.vx.rpg.classes.Quests.impl.quests;
import fr.vx.rpg.handlers.SpawnRunnable;
import fr.vx.rpg.utils.MySql;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import fr.vx.rpg.classes.Item.impl.Items;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class RPG extends JavaPlugin
{

    public MySql mySql = new MySql();

    @Override
    public void onEnable()
    {
        PluginManager pm = Bukkit.getPluginManager();
        mySql.connect();

    	Items.register();
        Houses.Register();
        quests.register();
        jobs.Register();
        citizens.register();
        
        //TODO tester
        new SpawnRunnable().runTaskTimer(this, 0, 200);
        CauldronCraft wtf = new CauldronCraft(new ItemStack(Items.test2.getItemStack()), JobRank.Novice);
        List<ItemStack> ingredients = new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Material.IRON_INGOT), new ItemStack(Material.STICK)));
        wtf.setIngredients(ingredients);
        wtf.register();

        pm.registerEvents(new playerconnection(), this);

        this.getCommand("rpg").setExecutor(new RpgCmd());
    }

    @Override
    public void onDisable()
    {
        mySql.disconnect();
        npc.RemoveAllNpc();
    }

}
