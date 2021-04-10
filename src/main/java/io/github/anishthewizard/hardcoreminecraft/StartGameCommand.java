package io.github.anishthewizard.hardcoreminecraft;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class StartGameCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player) {
            Player p = (Player) commandSender;
            Constants.isGameRun = true;
            Bukkit.broadcastMessage("Game " + ChatColor.GREEN + "Started!");
            Constants.game = new HardcoreMinecraft((ArrayList<Player>) p.getWorld().getPlayers());
            Constants.storage = new DataStorage(); //TODO fix when constructor added
        }
        return false;
    }
}
