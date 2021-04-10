package io.github.anishthewizard.hardcoreminecraft;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class HardcoreMinecraft {
    private World world;


    public HardcoreMinecraft(ArrayList<Player> pList) {
        Constants.pList = pList;
        this.world = pList.get(0).getWorld();
    }

    public void switchWorld(Player p) {
        ConsoleCommandSender console = Bukkit.getConsoleSender();
        Bukkit.dispatchCommand(console, "mvcreate world" + Constants.worldNumber + " normal");

        p.performCommand("mvtp world" + Constants.worldNumber);

        for(Player pl : Constants.pList) {
            pl.teleport(p.getLocation());
        }

        Constants.worldNumber++;
    }
}
