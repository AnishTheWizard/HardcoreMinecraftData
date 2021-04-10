package io.github.anishthewizard.hardcoreminecraft;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.json.simple.JSONObject;

public class DataCollector implements Listener {
    //All DataCollection methods will be placed here

    @EventHandler
    public void onEntityDeath(EntityDeathEvent e) {
        if(e.getEntity() instanceof Player) {
            //get player who died
            Player p = (Player) e.getEntity();
            Player pl = Constants.pList.get(0);
            //use player to run the switch world command
            Constants.game.switchWorld(pl);
            Bukkit.broadcastMessage("CHANGING WORLD");
            //        //write into the death portion
            //        JSONObject playerStat = Constants.storage.players.get(p.getName());
            //        playerStat.put("Death", ((int)playerStat.get("Death"))+1);
            //        //reset data collection vars
            //        Constants.storage.reset();
            //        Constants.storage.export();
        }
    }
}
