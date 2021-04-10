package io.github.anishthewizard.hardcoreminecraft;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class StopGameCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Constants.isGameRun = false;
        Bukkit.broadcastMessage("Game " + ChatColor.RED + "Stopped!");
        return false;
    }
}
