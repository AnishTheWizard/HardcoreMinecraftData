package io.github.anishthewizard.hardcoreminecraft;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
        @Override
        public void onEnable() {
                System.out.println("HardCore Minecraft Plugin Enabled!");

                Bukkit.getPluginCommand("starthc").setExecutor(new StartGameCommand());
                Bukkit.getPluginCommand("stophc").setExecutor(new StopGameCommand());

                Bukkit.getPluginManager().registerEvents(new DataCollector(), this);
        }
        @Override
        public void onDisable() {
                //Constants.storage.export();
                System.out.println("HardCore Minecraft Plugin Disabled!");
        }
}